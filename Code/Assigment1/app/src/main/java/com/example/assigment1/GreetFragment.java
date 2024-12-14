package com.example.assigment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class GreetFragment extends Fragment {

    private static final String ARG_NAME = "NAME";
    private static final String ARG_AGE = "AGE";
    private String name;
    private int age;


    public GreetFragment() {
        // Required empty public constructor
    }

    public static GreetFragment newInstance(String param1, int param2) {
        GreetFragment fragment = new GreetFragment();
        Bundle args = new Bundle();
        args.putString(ARG_NAME, param1);
        args.putInt(ARG_AGE, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_NAME);
            age = getArguments().getInt(ARG_AGE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_greet, container, false);
        TextView greetText= view.findViewById(R.id.greetText);
        TextView ageText = view.findViewById(R.id.ageText);
        greetText.setText(String.format("Welcome, %s!", this.name));
        ageText.setText(String.format("%s years Old", String.valueOf(this.age)));
       return view;
    }
}