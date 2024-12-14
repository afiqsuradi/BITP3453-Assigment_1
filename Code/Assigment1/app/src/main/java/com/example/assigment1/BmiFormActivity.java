package com.example.assigment1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.textfield.TextInputEditText;

public class BmiFormActivity extends AppCompatActivity {

    private String name;
    private int age;
    private Button calculateBtn, logoutBtn;
    private EditText weightTextInput, heightTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi_form);

        name = getIntent().getStringExtra("NAME");
        age = Integer.parseInt(getIntent().getStringExtra("AGE"));

        Fragment fragment = GreetFragment.newInstance(name,age );
        loadFragment(fragment);

        weightTextInput = findViewById(R.id.weightTextInput);
        heightTextInput = findViewById(R.id.heightTextInput);

        calculateBtn = findViewById(R.id.calculateBtn);
        logoutBtn = findViewById(R.id.logoutBtn);

        calculateBtn.setOnClickListener(v -> validateForm());
        logoutBtn.setOnClickListener(v -> goToMainActivity());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
    }

    private void validateForm() {
        String weight = weightTextInput.getText().toString().trim();
        String height = heightTextInput.getText().toString().trim();

        if (weight.isEmpty() || height.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(BmiFormActivity.this, BmiResultActivity.class);
            intent.putExtra("NAME", name);
            intent.putExtra("AGE", String.valueOf(age));
            intent.putExtra("WEIGHT", weight);
            intent.putExtra("HEIGHT", height);
            startActivity(intent);
        }
    }

    private void goToMainActivity(){
        Intent intent = new Intent(BmiFormActivity.this, MainActivity.class);
        startActivity(intent);
    }
}