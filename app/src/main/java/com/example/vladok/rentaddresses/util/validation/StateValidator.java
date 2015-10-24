package com.example.vladok.rentaddresses.util.validation;

import android.content.res.Resources;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;


public class StateValidator extends TextValidator {
    public StateValidator(TextView textView) {
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
        String state = textView.getText().toString();
        if (state == null || state.length() < 3 || state.length() > 20) {
            textView.setError(MyContext.getContext().getResources().getString(R.string.state_validation_msg));
        } else {
            isValid = true;
        }
        return isValid;
    }
}
