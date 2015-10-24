package com.example.vladok.rentaddresses.util.validation;

import android.content.res.Resources;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;


public class StreetValidator extends TextValidator {

    public StreetValidator(TextView textView) {
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
        String street = textView.getText().toString();
        if (street == null || street.length() < 3 || street.length() > 20) {
            textView.setError(MyContext.getContext().getResources().getString(R.string.street_validation_msg));
        } else {
            isValid = true;
        }
        return isValid;
    }
}

