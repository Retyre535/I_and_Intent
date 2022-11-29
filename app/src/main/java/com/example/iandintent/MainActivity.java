package com.example.iandintent;

import static com.example.iandintent.Constants.CorrectMail;
import static com.example.iandintent.Constants.CorrectPassword;
import static com.example.iandintent.Constants.LOGIN;
import static com.example.iandintent.Constants.LoginTAG;
import static com.example.iandintent.Constants.LoginTAG;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.iandintent.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                String login = binding.login.getText().toString();
                String password = binding.password.getText().toString();
                Log.i(LoginTAG, "mail: " + login + " password: "+ password);
                if (login.equals(CorrectMail) && password.equals(CorrectPassword)) {
                    Log.i(LoginTAG, "Регистрация пройдена");
                    Intent intent = new Intent(MainActivity.this, MainScreen.class);
                    intent.putExtra(LOGIN,login);
                    startActivity(intent);
                    finish();
                }
                else if(login.contains("@"))
                    if(password.length()>8){
                        if (login.equals(CorrectMail)) {
                            if (password.contains(" ")){
                                Toast.makeText(this, "Пароль вводится без пробелов!", Toast.LENGTH_LONG).show();
                                Log.e(LoginTAG, "Пароль сожержит пробел");
                            } else {
                                Toast.makeText(this, "Неверный пароль", Toast.LENGTH_LONG).show();
                                Log.e(LoginTAG, "Неверный пароль");
                            }
                        }
                        else{
                            if (login.contains(" ")){
                                Toast.makeText(this, "Логин вводится без пробелов!", Toast.LENGTH_LONG).show();
                                Log.e(LoginTAG, "Логин содержит пробел");

                            } else {
                                Toast.makeText(this, "Неверный логин", Toast.LENGTH_LONG).show();
                                Log.e(LoginTAG, "Неверный логин");
                            }
                        }
                    }
                    else {
                        Toast.makeText(this, "Пароль должен быть больше 8 символов", Toast.LENGTH_LONG).show();
                        Log.e(LoginTAG, "Пароль должен быть больше 8 символов");
                    }
                else {
                    Toast.makeText(this, "Почта должна содержать символ: @", Toast.LENGTH_LONG).show();
                    Log.e(LoginTAG, "Почта должна содержать символ: @");
                }
                break;
        }
    }
}