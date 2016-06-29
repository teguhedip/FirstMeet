package com.teguhediprasetyo.www.firstmeet;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.teguhediprasetyo.www.firstmeet.models.User;
import com.teguhediprasetyo.www.firstmeet.utility.PreferencesUtil;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText etUsername;
    private EditText etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        if(PreferencesUtil.readBoleanData(this,PreferencesUtil.KEY_USER_IS_LOGIN,false)){
            startActivity(new Intent(this,HomeActivity.class));
            finish();
        }

//        2. Inisialisasi
        etUsername = (EditText) findViewById(R.id.input_username);
        etPassword = (EditText) findViewById(R.id.input_password);
        btnLogin = (Button) findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                User user = new User(etUsername.getText().toString(), etPassword.getText().toString());

                if(user.getUsername().equals("root") && user.getPassword().equals("toor")){
//                    4. Tampilkan Login Berhasil
                    Toast.makeText(LoginActivity.this,"Login Berhasil", Toast.LENGTH_LONG).show();

                    PreferencesUtil.writeBooleanData(LoginActivity.this, PreferencesUtil.KEY_USER_IS_LOGIN, true);

                    Intent intent = new Intent(LoginActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
//                    5. Tampilkan Login Gagal
                    Toast.makeText(LoginActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }


}
