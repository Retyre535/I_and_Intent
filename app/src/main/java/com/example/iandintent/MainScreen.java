package com.example.iandintent;

import static com.example.iandintent.Constants.CAMERA_REQUEST_CODE;
import static com.example.iandintent.Constants.LOGIN;
import static com.example.iandintent.Constants.PhotoTAG;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.iandintent.databinding.ActivityMainScreenBinding;

public class MainScreen extends AppCompatActivity implements View.OnClickListener{

    ActivityMainScreenBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainScreenBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Intent intent = getIntent();
        String login = intent.getStringExtra(LOGIN);
        binding.mail.setText(login);
        binding.camera.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.camera:
                Log.i(PhotoTAG, "Камера открыта");
                Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
                break;
        }
    }
}