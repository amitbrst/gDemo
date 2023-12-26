package com.example.gamedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        DocumentReference myCollection = db.collection("SpinnerTimerBools").document("TeenPatti");
        Map<String, Object> data = new HashMap<>();
        data.put("A1", false);  // Replace true with the actual value you want
        data.put("A2", false); // Replace false with the actual value you want
        data.put("A3", false);  // Replace true with the actual value you want

// Add the document to the collection
        myCollection.update(data);

    }
}