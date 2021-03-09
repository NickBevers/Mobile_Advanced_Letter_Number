package com.example.letters_numbers;

import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<Character> letter;

    ArrayList<Character> letterArray = new ArrayList<Character>(6);
    ArrayList<Integer> numberArray = new ArrayList<Integer>(6);

    public MutableLiveData <Character> getLetter(){
        if (letter == null){
            letter= new MutableLiveData <Character>();
        }
        return letter;
    }

    /*public void setArray(char input, int num){
        switch (num){
            case 0:
                letterArray.add(input);
                break;

            //case 1:
                //numberArray.add()
        }
    }*/

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

    public void pickNumber() {
        int a = 53;
        setLetter((char) a);
    }
}
