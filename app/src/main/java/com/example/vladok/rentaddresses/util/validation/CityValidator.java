package com.example.vladok.rentaddresses.util.validation;

import android.app.Application;
import android.content.res.Resources;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;

public class CityValidator extends TextValidator {
    public CityValidator(TextView textView) {
        super(textView);
    }

    @Override
    public void validate(TextView textView) {
        vaildateBase(textView);
    }


    @Override
    public boolean onBackValidate(TextView textView) {
        return vaildateBase(textView);
    }

    private boolean vaildateBase(TextView textView) {
        boolean isValid = false;
        String city = textView.getText().toString();
        if (city == null || city.length() < 3 || city.length() > 20) {
            textView.setError(MyContext.getContext().getResources().getString(R.string.city_validation_msg));
        } else {
            isValid = true;
        }
        return isValid;
    }
}

