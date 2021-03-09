package com.example.letters_numbers;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<Character> letter;

    public MutableLiveData <Character> getLetter(){
        if (letter == null){
            letter= new MutableLiveData <Character>();
        }
        return letter;
    }

    public void setLetter(char c){
        letter.setValue(c);
    }

    public char pickALetter() {
        Random random = new Random();
        int ascii = random.nextInt(26) + 97;; // lowercase 'a'
        return (char)ascii;
    }

    public boolean isVowel (char c) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char v: vowels) {
            if (v == c) return true;
        }
        return false;
    }

    public boolean isConsonant (char c) {
        return !isVowel(c);
    }

    public void pickVowel() {
        char c;
        do {
            c = pickALetter();
        } while (!isVowel(c));
        setLetter(c);
    }

    public void pickConsonant() {
        char c;
        do {
            c = pickALetter();
        } while (!isConsonant(c));
        setLetter(c);
    }
}
