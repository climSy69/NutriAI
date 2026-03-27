package com.example.advancedcomputersciencecn6008_1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize buttons
        Button btnAddMeal = findViewById(R.id.btnAddMeal);
        Button btnViewSummary = findViewById(R.id.btnViewSummary);
        Button btnAIAssistant = findViewById(R.id.btnAIAssistant);
        Button btnProfile = findViewById(R.id.btnProfile);

        // Update: Now opening AddMealActivity
        btnAddMeal.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddMealActivity.class);
            startActivity(intent);
        });

        btnViewSummary.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Daily Summary Clicked", Toast.LENGTH_SHORT).show());

        btnAIAssistant.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "AI Assistant Clicked", Toast.LENGTH_SHORT).show());

        btnProfile.setOnClickListener(v -> 
            Toast.makeText(MainActivity.this, "Profile Clicked", Toast.LENGTH_SHORT).show());
    }
}
