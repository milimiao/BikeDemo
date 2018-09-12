package com.example.a91319.bikedemo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.a91319.bikedemo.R;
import com.example.a91319.bikedemo.net.requests.UserRegisterRequest;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.ConfirmPassword;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 * 使用的表单验证框架 android-saripaar
 */
public class UserRegisterFragment extends Fragment implements Validator.ValidationListener, View.OnClickListener {


    @NotEmpty(trim = true,messageResId = R.string.error_username_empty)
    @BindView(R.id.user_usernameTextEdit)
    EditText userUsernameTextEdit;

    @Password(min = 6,messageResId = R.string.error_password_len)
    @BindView(R.id.user_passwordTextEdit)
    EditText userPasswordTextEdit;

    @ConfirmPassword(messageResId = R.string.error_password_confirm)
    @BindView(R.id.user_password_confirmation_TextEdit)
    EditText userPasswordConfirmationTextEdit;
    @BindView(R.id.doRegisterButton)
    Button doRegisterButton;
    Unbinder unbinder;

    //验证
    Validator validator=null;
    UserRegisterRequest userregisterrequest=null;

    public UserRegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_register, container, false);
        unbinder = ButterKnife.bind(this, view);
        initLayout();
        return view;
    }



    private void initLayout() {

        validator = new Validator(this);
        validator.setValidationListener(this);
        doRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    //验证成功回调方法
    @Override
    public void onValidationSucceeded() {
        userregisterrequest = new UserRegisterRequest();
        userregisterrequest.setName(userUsernameTextEdit.getText().toString().trim());
        userregisterrequest.setPassword(userPasswordTextEdit.getText().toString().trim());
        userregisterrequest.setPassword_confirmation(userPasswordConfirmationTextEdit.getText().toString().trim());
    }

    //验证失败回调方法
    @Override
    public void onValidationFailed(List<ValidationError> errors) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.doRegisterButton:
                //启动验证
                validator.validate();
                break;
        }
    }
}
