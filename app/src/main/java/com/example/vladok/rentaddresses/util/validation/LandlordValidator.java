package com.example.vladok.rentaddresses.util.validation;


import android.content.res.Resources;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;

public class LandlordValidator extends TextValidator {

    public LandlordValidator(TextView textView) {
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
        String landlord = textView.getText().toString();
        if (landlord == null || landlord.length() < 2 || landlord.length() > 20) {
            textView.setError(MyContext.getContext().getResources().getString(R.string.lanlord_validation_msg));
        } else {
            isValid = true;
        }
        return isValid;
    }
}
