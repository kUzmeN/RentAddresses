package com.example.vladok.rentaddresses.activity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.exception.DbQueryException;
import com.example.vladok.rentaddresses.listener.ResponseListener;
import com.example.vladok.rentaddresses.notificationService.contract.NotificationServiceApi;
import com.example.vladok.rentaddresses.notificationService.impl.NotificationServiseApiImpl;
import com.example.vladok.rentaddresses.repository.contract.RentAddressRepository;
import com.example.vladok.rentaddresses.repository.impl.RentAddressRepositoryImpl;
import com.example.vladok.rentaddresses.util.Config;
import com.example.vladok.rentaddresses.util.DoubleDatePicker;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.CityValidator;
import com.example.vladok.rentaddresses.util.validation.LandlordValidator;
import com.example.vladok.rentaddresses.util.validation.PayValidator;
import com.example.vladok.rentaddresses.util.validation.StateValidator;
import com.example.vladok.rentaddresses.util.validation.StreetValidator;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;


@EActivity(R.layout.activity_card_details)
public class CardActivity extends AppCompatActivity implements ResponseListener {


    @Bean(RentAddressRepositoryImpl.class)
    RentAddressRepository repository;
    @Bean(NotificationServiseApiImpl.class)
    NotificationServiceApi service;
    @Bean
    RentAddress card;
    @ViewById(R.id.tvTitle)
    TextView tvTitle;
    @ViewById(R.id.edtStreet)
    EditText edtStreet;
    @ViewById(R.id.edtCity)
    EditText edtCity;
    @ViewById(R.id.edtState)
    EditText edtState;
    @ViewById(R.id.edtWhatIPay)
    EditText edtPay;
    @ViewById(R.id.edtCompany)
    EditText edtLandlord;
    @ViewById(R.id.btnMoveIn)
    Button btnMoveIn;
    @ViewById(R.id.btnMoveOut)
    Button btnMoveOut;

    private final int DIALOG_EXIT = 1;
    private long id;
    private DoubleDatePicker datePicker;
    private TextValidator streetValidator;
    private TextValidator stateValidator;
    private TextValidator cityValidator;
    private TextValidator landlotdValidator;
    private TextValidator payValidator;


    @AfterViews
    protected void oncreate() {
        Intent intent = getIntent();
        getExtrasFromIntent(intent);
        initViews();
        initValidation();
        service.setResponseListener(this);
        repository.open();

        tvTitle.setOnLongClickListener(new View.OnLongClickListener() {

            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(getApplicationContext(), repository.readResponse(id),
                        Toast.LENGTH_LONG).show();
                return true;
            }
        });
    }
    DialogInterface.OnClickListener myClickListener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case Dialog.BUTTON_POSITIVE:
                    finish();
                    break;
                case Dialog.BUTTON_NEUTRAL:
                    break;
            }
        }
    };

    @Override
    public void onBackPressed() {
        if (checkValidation()) {
            super.onBackPressed();
            card = getRentAddressObjFromViews();
            try {
                saveCard(card, this.id);
                Toast.makeText(this, R.string.saved, Toast.LENGTH_LONG).show();
            } catch (DbQueryException e) {
                e.printStackTrace();
                Log.e(Config.LOG_TAG_ERROR, e.toString());
                Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show();
            }
        } else {
            showDialog(DIALOG_EXIT);
        }
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_EXIT) {
            AlertDialog.Builder adb = new AlertDialog.Builder(this);
            adb.setTitle(R.string.exit);
            adb.setMessage(R.string.save_data);
            adb.setIcon(android.R.drawable.ic_dialog_info);
            adb.setPositiveButton(R.string.ok, myClickListener);
            adb.setNeutralButton(R.string.cancel, myClickListener);
            return adb.create();
        }
        return super.onCreateDialog(id);
    }

    private RentAddress getRentAddressObjFromViews() {

        RentAddress card = new RentAddress();
        card.setCity(this.edtCity.getText().toString());
        card.setState(this.edtState.getText().toString());
        card.setStreet(this.edtStreet.getText().toString());
        card.setMonthlyRent(Integer.parseInt(this.edtPay.getText().toString()));
        card.setLandLord(this.edtLandlord.getText().toString());
        card.setMoveIn(this.btnMoveIn.getText().toString());
        card.setMoveOut(this.btnMoveOut.getText().toString());
        return card;
    }

    private void getExtrasFromIntent(Intent intent) {
        card = new RentAddress();
        card.setCity(intent.getStringExtra(Config.CITY));
        card.setStreet(intent.getStringExtra(Config.STREET));
        card.setState(intent.getStringExtra(Config.STATE));
        card.setMonthlyRent(intent.getIntExtra(Config.MONTHLY_RENT, 0));
        card.setLandLord(intent.getStringExtra(Config.LAND_LORD));
        card.setMoveIn(intent.getStringExtra(Config.MOVE_IN));
        card.setMoveOut(intent.getStringExtra(Config.MOVE_OUT));
        card.setResponse(intent.getStringExtra(Config.RESPONSE));
        this.id = (intent.getLongExtra(Config.ID, 0));
    }

    private void initViews() {
        this.edtStreet.setText(card.getStreet());
        this.edtCity.setText(card.getCity());
        this.edtState.setText(card.getState());
        this.edtPay.setText(String.valueOf(card.getMonthlyRent()));
        this.edtLandlord.setText(card.getLandLord());
        if (card.getMoveIn() == null) {
            card.setMoveIn(MyContext.getContext().getResources().getString(R.string.move_in));
            card.setMoveOut(MyContext.getContext().getResources().getString(R.string.move_out));
        }
        this.btnMoveIn.setText(card.getMoveIn());
        this.btnMoveOut.setText(card.getMoveOut());

        datePicker = new DoubleDatePicker(this, R.id.btnMoveIn, R.id.btnMoveOut);


    }

    private void initValidation() {
        streetValidator = new StreetValidator(edtStreet);
        edtStreet.addTextChangedListener(streetValidator);

        cityValidator = new CityValidator(edtCity);
        edtCity.addTextChangedListener(cityValidator);

        stateValidator = new StateValidator(edtState);
        edtState.addTextChangedListener(stateValidator);

        landlotdValidator = new LandlordValidator(edtLandlord);
        edtLandlord.addTextChangedListener(landlotdValidator);

        payValidator = new PayValidator(edtPay);
        edtPay.addTextChangedListener(payValidator);
    }

    private boolean checkValidation() {
        boolean isValid = true;
        if (!(streetValidator.onBackValidate(edtStreet)) ||
                !(stateValidator.onBackValidate(edtState)) ||
                !(cityValidator.onBackValidate(edtCity)) ||
                !(payValidator.onBackValidate(edtPay)) ||
                !(landlotdValidator.onBackValidate(edtLandlord)) ||
                !(datePicker.onBackValidate())) {
            isValid = false;
        }
        return isValid;
    }

    private void saveCard(RentAddress card, long id) throws DbQueryException {
        if (id > 0) {
            repository.update(card, id);
        } else {
            this.id = repository.create(card);
        }
        service.sendNotification(this, card);
    }

    @Override
    public void onResponse(String response) throws DbQueryException {
        this.card.setResponse(response);
        repository.update(this.card, this.id);

        Toast.makeText(getApplicationContext(), R.string.response + response,
                Toast.LENGTH_LONG).show();
        repository.close();

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(Config.MOVE_IN, btnMoveIn.getText().toString());
        outState.putString(Config.MOVE_OUT, btnMoveOut.getText().toString());
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        btnMoveIn.setText(savedInstanceState.getString(Config.MOVE_IN));
        btnMoveOut.setText(savedInstanceState.getString(Config.MOVE_OUT));
    }

}
