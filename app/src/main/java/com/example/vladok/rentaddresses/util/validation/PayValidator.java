package com.example.vladok.rentaddresses.util.validation;


import android.content.res.Resources;
import android.widget.TextView;

import com.example.vladok.rentaddresses.R;
import com.example.vladok.rentaddresses.util.MyContext;
import com.example.vladok.rentaddresses.util.validation.base.TextValidator;

public class PayValidator extends TextValidator {
    public PayValidator(TextView textView) {
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
        int pay;
        try {
            pay = Integer.parseInt(textView.getText().toString());
            isValid = true;
        } catch (NumberFormatException ex) {
            pay = 0;
            textView.setError(MyContext.getContext().getResources().getString(R.string.pay_validation_msg));
        }
        if (pay < 1) {
            textView.setError(MyContext.getContext().getResources().getString(R.string.pay_validation_msg));
        }
        return isValid;

    }
}
