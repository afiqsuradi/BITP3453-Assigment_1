package com.example.assigment1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.assigment1.bmi.BmiCalculator;

public class BmiResultActivity extends AppCompatActivity {
    String name;
    int age;
    double bmi;
    TextView weightText, heightText, bmiResult;
    ImageView bmiResultImage;
Button logoutBtn, backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_bmi_result);

        name = getIntent().getStringExtra("NAME");
        age = Integer.parseInt(getIntent().getStringExtra("AGE"));
        float weight = Float.parseFloat(getIntent().getStringExtra("WEIGHT"));
        float height = Float.parseFloat(getIntent().getStringExtra("HEIGHT"));
        bmi = (new BmiCalculator(height,weight)).calculateBmi();

        Fragment fragment = GreetFragment.newInstance(name,age);
        loadFragment(fragment);

        weightText = findViewById(R.id.weightText);
        heightText = findViewById(R.id.heightText);
        bmiResult = findViewById(R.id.bmiResult);
        backBtn = findViewById(R.id.backBtn);
        logoutBtn = findViewById(R.id.logoutBtn);
        bmiResultImage = findViewById(R.id.bmiResultImage);

        weightText.setText(String.valueOf(weight));
        heightText.setText(String.valueOf(height));
        bmiResult.setText(BmiCalculator.formatBmi(bmi));
        if (bmi < 18.5){
            bmiResultImage.setImageResource(R.drawable.underweight_icon);
        } else if (bmi > 18.5 && bmi < 25){
            bmiResultImage.setImageResource(R.drawable.normalweight_icon);
        } else{
            bmiResultImage.setImageResource(R.drawable.overweight_icon);
        }
        logoutBtn.setOnClickListener(v-> goToMainActivity());
        backBtn.setOnClickListener(v -> goToBmiFormActivity());
    }

    private void loadFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment);
        fragmentTransaction.commit();
    }

    private void goToBmiFormActivity(){
        Intent intent = new Intent(BmiResultActivity.this, BmiFormActivity.class);
        intent.putExtra("NAME", name);
        intent.putExtra("AGE", age);
        startActivity(intent);
    }
    private void goToMainActivity(){
        Intent intent = new Intent(BmiResultActivity.this, MainActivity.class);
        startActivity(intent);
    }
}