package com.example.letters_numbers;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


public class Frag_Letter extends Fragment {

    LetterViewModel viewModel;
    private TextView editLetter;
    public Object ViewModelProvider;
    private Object fragment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag_letter, container, false);

        editLetter = v.findViewById(R.id.tv_letter);

        Button vowelBtn = v.findViewById(R.id.btn_vowel);
        Button consonantBtn = v.findViewById(R.id.btn_consonant);
        Button clearBtn = v.findViewById(R.id.btn_letter_reset);

        vowelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.pickVowel();
            }
        });

        consonantBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.pickConsonant();
            }
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clearLetter();
            }
        });


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        viewModel = new ViewModelProvider(getActivity()).get(LetterViewModel.class);
        viewModel.getLetter().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                editLetter.setText(charSequence.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        viewModel.clearLetter();
    }
}
