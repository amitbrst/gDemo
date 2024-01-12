package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;

import com.example.gamedemo.databinding.ActivityHomeBinding;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.liveLoginUserid.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                binding.liveLoginName.getEditText().setText(s + "_" + Build.MANUFACTURER.toLowerCase());
            }
        });

        binding.liveLoginBtn.setOnClickListener(v -> {
            String userID = binding.liveLoginUserid.getEditText().getText().toString();
            String userName = binding.liveLoginName.getEditText().getText().toString();
            if (TextUtils.isEmpty(userID) || TextUtils.isEmpty(userName)) {
                if (TextUtils.isEmpty(userID)) {
                    binding.liveLoginUserid.setError("please input userID");
                } else if (TextUtils.isEmpty(userName)) {
                    binding.liveLoginName.setError("please input username");
                }
                return;
            }
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            intent.putExtra("userId",userID);
            intent.putExtra("username",userName);
            startActivity(intent);

        });

    }
}