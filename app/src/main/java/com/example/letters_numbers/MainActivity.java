package com.example.letters_numbers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Fragment visibleLayout;

    TextView tvLetter;
    LetterViewModel viewModel;
    private Frag_Letter letterFrag = new Frag_Letter();
    private Frag_Number numberFrag = new Frag_Number();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visibleLayout = letterFrag;
        Button switchBtn = findViewById(R.id.switchBtn);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragLayout, visibleLayout)
                .commit();

        switchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(visibleLayout == letterFrag){
                    visibleLayout = numberFrag;

                }
                else{
                    visibleLayout = letterFrag;
                }

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragLayout, visibleLayout)
                        .commit();

            }
        });
    }
}