package com.example.assigment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private Button startBtn;
    private TextInputEditText nameTextInput, ageTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        startBtn = findViewById(R.id.startBtn);
        nameTextInput = findViewById(R.id.nameTextInput);
        ageTextInput = findViewById(R.id.ageTextInput);
        startBtn.setOnClickListener(v -> validateForm());
    }

    private void validateForm() {
        String name = nameTextInput.getText().toString().trim();
        String age = ageTextInput.getText().toString().trim();

        if (name.isEmpty() || age.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MainActivity.this, BmiFormActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("AGE", age);
            startActivity(intent);
        }
    }
}