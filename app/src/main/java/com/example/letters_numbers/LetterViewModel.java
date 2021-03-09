package com.example.letters_numbers;

import android.app.AlertDialog;
import android.util.Log;
import android.view.View;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Random;

import static android.content.ContentValues.TAG;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<String> letter;
    private MutableLiveData<Character> number;

    public String listString = "";

    ArrayList<Character> letterArray = new ArrayList<Character>(6);
    ArrayList<Integer> numberArray = new ArrayList<Integer>(6);

    public MutableLiveData<String> getLetter(){
        if (letter == null){
            letter= new MutableLiveData<String>();
        }
        return letter;
    }

    public void setLetter(String c){
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
        if (letterArray.size() == 0){
            char c;
            do {
                c = pickALetter();
            } while (!isVowel(c));

            addToArray(c, 0);
            listString +=  String.valueOf(c);
            setLetter(listString);
        }

        else if (letterArray.size() < 6){
            char c;
            do {
                c = pickALetter();
            } while (!isVowel(c));

            addToArray(c, 0);
            listString +=  ", " + String.valueOf(c);
            setLetter(listString);
        }

    }

    public void pickConsonant() {
        if (letterArray.size() == 0){
            char c;
            do {
                c = pickALetter();
            } while (!isConsonant(c));

            addToArray(c, 0);
            listString +=  String.valueOf(c);
            setLetter(listString);
        }

        else if (letterArray.size() < 6){
            char c;
            do {
                c = pickALetter();
            } while (!isConsonant(c));

            addToArray(c, 0);
            listString +=  ", " + String.valueOf(c);
            setLetter(listString);
        }
    }

    public void pickNumber() {
        int a = 53;
        setLetter(String.valueOf(a));
    }

    public void addToArray(char input, int num){
        if (num == 0){
            letterArray.add(input);
        }
    }

    public void clearLetter(){
        letterArray.clear();
        listString = "";
        setLetter(listString);
    }

    public void clearNumber(){
        numberArray.clear();
        listString = "";
        setLetter(listString);
    }

}
