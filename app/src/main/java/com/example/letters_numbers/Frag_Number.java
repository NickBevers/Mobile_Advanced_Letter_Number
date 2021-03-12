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
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;


public class Frag_Number extends Fragment {

    LetterViewModel viewModel;
    private TextView editLetter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.frag_number, container, false);

        editLetter = v.findViewById(R.id.tv_letter);

        Button lowButton = v.findViewById(R.id.btn_low_number);
        Button highButton = v.findViewById(R.id.btn_high_number);
        Button clear = v.findViewById(R.id.btn_number_reset);

        lowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.pickLowNumber();
            }
        });

        highButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.pickHighNumber();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewModel.clearNumber();
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
        viewModel.clearNumber();
    }
}
