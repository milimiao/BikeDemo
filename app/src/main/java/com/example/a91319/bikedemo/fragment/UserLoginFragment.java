package com.example.a91319.bikedemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.a91319.bikedemo.R;
import com.example.a91319.bikedemo.activity.MainActivity;
import com.example.a91319.bikedemo.activity.UserRegisterActivity;
import com.example.a91319.bikedemo.contract.AuthContract;
import com.example.a91319.bikedemo.net.requests.LoginRequest;
import com.example.a91319.bikedemo.presenter.AuthPresenter;
import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserLoginFragment extends Fragment implements Validator.ValidationListener, View.OnClickListener, AuthContract.View {

    @NotEmpty(trim = true, message = "必须填写用户名")
    @BindView(R.id.usernameTextEdit)
    EditText usernameTextEdit;

    @Password(min = 6, message = "必须填写密码 且长度大于6")
    @BindView(R.id.passwordTextEdit)
    EditText passwordTextEdit;
    @BindView(R.id.doLoginButton)
    Button doLoginButton;
    Unbinder unbinder;

    Validator validator = null;

    LoginRequest loginRequest = null;

    AuthPresenter authPresenter = null;
    @BindView(R.id.goRegisterButton)
    Button goRegisterButton;

    public UserLoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user_login, container, false);
        unbinder = ButterKnife.bind(this, view);
        initLayout();
        return view;
    }

    private void initLayout() {
        validator = new Validator(this);
        validator.setValidationListener(this);
        doLoginButton.setOnClickListener(this);
        goRegisterButton.setOnClickListener(this);
        authPresenter = new AuthPresenter(this);
        loginRequest = new LoginRequest();


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onValidationSucceeded() {
        loginRequest.setUsername(usernameTextEdit.getText().toString().trim());
        loginRequest.setPassword(passwordTextEdit.getText().toString().trim());
        authPresenter.doLoginUser(loginRequest);
    }

    @Override
    public void onValidationFailed(List<ValidationError> errors) {
        Toast.makeText(getContext(), errors.get(0).getCollatedErrorMessage(getContext()), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.doLoginButton:
                validator.validate();
                break;
            case R.id.goRegisterButton:
                getActivity().startActivity(new Intent(getActivity(), UserRegisterActivity.class));
                break;
        }

    }

    @Override
    public void onRegisterSuccess() {

    }

    @Override
    public void showErrorMessahe(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onLoginSuccess() {
        //// TODO: 2018/9/13 跳转到首页
        getActivity().startActivity(new Intent(getActivity(), MainActivity.class));
    }
}
