package com.example.vladok.rentaddresses.activity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.adapter.AddressesAdapter;
import com.example.vladok.rentaddresses.domain.RentAddress;
import com.example.vladok.rentaddresses.exception.DbQueryException;
import com.example.vladok.rentaddresses.loader.RentAddressCursorLoader;
import com.example.vladok.rentaddresses.repository.contract.RentAddressRepository;
import com.example.vladok.rentaddresses.repository.impl.RentAddressRepositoryImpl;
import com.example.vladok.rentaddresses.util.Config;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;

@EActivity(R.layout.activity_addresses_list)
public class MainActivity extends AppCompatActivity implements android.support.v4.app.LoaderManager.LoaderCallbacks<Cursor> {
    private static final int CM_DELETE_ID = 1;
    @Bean
    AddressesAdapter adapter;
    @Bean(RentAddressRepositoryImpl.class)
    RentAddressRepository repository;
    @ViewById(R.id.lvAddressesList)
    ListView addressesListView;
    private ArrayList<RentAddress> addressArrayList;

    @AfterViews
    void init() {
        repository.open();
        addressesListView.setAdapter(adapter);
        getSupportLoaderManager().initLoader(0, null, this);

        addressesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View clickView, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), CardActivity_.class);
                intent = setExtrasByPosition(intent, position);
                startActivity(intent);
            }
        });

        registerForContextMenu(addressesListView);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new RentAddressCursorLoader(this, repository);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        this.addressArrayList = getRentAddressArrayListFromCursor(data);
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    private ArrayList<RentAddress> getRentAddressArrayListFromCursor(Cursor data) {
        ArrayList<RentAddress> addressArrayList = new ArrayList<>();
        RentAddress rentAddress;
        if (data.moveToFirst()) {
            do {
                rentAddress = new RentAddress();
                rentAddress.setState(data.getString(data.getColumnIndex(Config.STATE)));
                rentAddress.setCity(data.getString(data.getColumnIndex(Config.CITY)));
                rentAddress.setStreet(data.getString(data.getColumnIndex(Config.STREET)));
                rentAddress.setMonthlyRent(data.getInt(data.getColumnIndex(Config.MONTHLY_RENT)));
                rentAddress.setLandLord(data.getString(data.getColumnIndex(Config.LAND_LORD)));
                rentAddress.setMoveIn(data.getString(data.getColumnIndex(Config.MOVE_IN)));
                rentAddress.setMoveOut(data.getString(data.getColumnIndex(Config.MOVE_OUT)));
                rentAddress.setResponse(data.getString(data.getColumnIndex(Config.RESPONSE)));
                rentAddress.setId(data.getInt(data.getColumnIndex(Config.ID)));
                addressArrayList.add(rentAddress);
            } while (data.moveToNext());
        }
        return addressArrayList;
    }

    private Intent setExtrasByPosition(Intent intent, int position) {
        RentAddress rentAddress = addressArrayList.get(position);
        intent.putExtra(Config.STATE, rentAddress.getState());
        intent.putExtra(Config.CITY, rentAddress.getCity());
        intent.putExtra(Config.STREET, rentAddress.getStreet());
        intent.putExtra(Config.MONTHLY_RENT, rentAddress.getMonthlyRent());
        intent.putExtra(Config.LAND_LORD, rentAddress.getLandLord());
        intent.putExtra(Config.MOVE_IN, rentAddress.getMoveIn());
        intent.putExtra(Config.MOVE_OUT, rentAddress.getMoveOut());
        intent.putExtra(Config.RESPONSE, rentAddress.getResponse());
        intent.putExtra(Config.ID, rentAddress.getId());

        return intent;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        getSupportLoaderManager().getLoader(0).forceLoad();
    }

    public void onAddCardButtonClick(View view) {
        Intent intent = new Intent(getApplicationContext(), CardActivity_.class);
        startActivity(intent);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0, CM_DELETE_ID, 0, R.string.delete);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == CM_DELETE_ID) {
            AdapterView.AdapterContextMenuInfo acmi = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
            try {
                repository.delete(acmi.id);
            } catch (DbQueryException e) {
                e.printStackTrace();
            }
            getSupportLoaderManager().getLoader(0).forceLoad();
            return true;
        }
        return super.onContextItemSelected(item);
    }

}
