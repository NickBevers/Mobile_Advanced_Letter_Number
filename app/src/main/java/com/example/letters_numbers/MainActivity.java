package com.example.letters_numbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tvLetter;
    LetterViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = new ViewModelProvider(this).get(LetterViewModel.class);

        tvLetter = findViewById(R.id.tv_letter);

        viewModel.getLetter().observe(this, new Observer<Character>() {
            @Override
            public void onChanged(Character character) {
                tvLetter.setText(character.toString());

            }
        });
    }

    public void pickVowel(View v) {
        viewModel.pickVowel();
    }

    public void pickConsonant(View v) {
        viewModel.pickConsonant();
    }



}