package com.swarawan.yacretofit.view.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.swarawan.yacretofit.R;
import com.swarawan.yacretofit.model.request.LoginRequestModel;
import com.swarawan.yacretofit.presenter.LoginPresenter;
import com.swarawan.yacretofit.view.main.ThreadActivity;

public class LoginActivity extends AppCompatActivity implements ILoginView {

    private Button btnLogin;
    private EditText edUsername;
    private EditText edPassword;

    private LoginPresenter presenter = new LoginPresenter(this);
    private LoginRequestModel requestModel = new LoginRequestModel();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = (Button) findViewById(R.id.btn_login);
        edUsername = (EditText) findViewById(R.id.ed_username);
        edPassword = (EditText) findViewById(R.id.ed_password);

        presenter.attachView(this);
        btnLogin.setOnClickListener(onClickListener);
    }

    private View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (!validate()) {
                Toast.makeText(LoginActivity.this, "Username and password cannot be empty", Toast.LENGTH_SHORT).show();
                return;
            }
            presenter.login(requestModel);
        }
    };

    private boolean validate() {
        if (edUsername.getText().toString().equals(""))
            return false;
        if (edUsername.getText().toString().equals(""))
            return false;
        requestModel.setUsername(edUsername.getText().toString());
        requestModel.setPassword(edPassword.getText().toString());
        requestModel.setPushbotsToken("random-token");
        return true;
    }

    @Override
    public void onLoginSuccess() {
        startActivity(new Intent(this, ThreadActivity.class));
    }

    @Override
    public void onLoginFailed(String message) {
        Toast.makeText(LoginActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
