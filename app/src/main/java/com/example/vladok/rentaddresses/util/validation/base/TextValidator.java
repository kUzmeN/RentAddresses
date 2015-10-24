package com.example.vladok.rentaddresses.util.validation.base;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.TextView;

import com.example.vladok.rentaddresses.util.Config;

public abstract class TextValidator implements TextWatcher {
    private TextView textView;

    public TextValidator(TextView textView) {
        this.textView = textView;
    }

    private void beforeValidate() {
        if (textView == null) {
            throw new NullPointerException(Config.ERROR_BEFORE_VALIDATE);
        }
    }


    @Override
    final public void afterTextChanged(Editable s) {
        Log.e(Config.LOG_TAG_ERROR ,Config.ERROR_AFTER_TXT_CHANGED);
        beforeValidate();
        validate(textView);
    }

    public abstract void validate(TextView textView);

    public abstract boolean onBackValidate(TextView textView);

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {
    }
}
