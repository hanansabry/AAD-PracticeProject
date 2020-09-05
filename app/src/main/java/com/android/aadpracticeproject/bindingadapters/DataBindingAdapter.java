package com.android.aadpracticeproject.bindingadapters;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;

import androidx.databinding.BindingAdapter;

public class DataBindingAdapter {

    @BindingAdapter("emailValidator")
    public static void emailValidator(EditText editText, String email) {
        if (TextUtils.isEmpty(email)) {
            editText.setError(null);
            return;
        }
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            editText.setError(null);
        } else {
            editText.setError("invalid e-mail address");
        }
    }
}
