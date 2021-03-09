package com.example.letters_numbers;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Random;

public class LetterViewModel extends ViewModel {
    private MutableLiveData<String> letter;
    private MutableLiveData<Integer> number;

    public String listString = "";
    public String numberString = "";

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

            letterArray.add(c);
            listString +=  String.valueOf(c);
            setLetter(listString);
        }

        else if (letterArray.size() < 6){
            char c;
            do {
                c = pickALetter();
            } while (!isVowel(c));

            letterArray.add(c);
            listString +=  " " + c;
            setLetter(listString);
        }

    }

    public void pickConsonant() {
        if (letterArray.size() == 0){
            char c;
            do {
                c = pickALetter();
            } while (!isConsonant(c));

            letterArray.add(c);;
            listString +=  String.valueOf(c);
            setLetter(listString);
        }

        else if (letterArray.size() < 6){
            char c;
            do {
                c = pickALetter();
            } while (!isConsonant(c));

            letterArray.add(c);
            listString +=  " " + c;
            setLetter(listString);
        }
    }

    public void pickLowNumber() {
        if (numberArray.size() < 6) {
            Random lowr = new Random();
            int low = lowr.nextInt(9) + 1;
            numberArray.add(low);
            numberString += " " + low;
            setLetter(numberString);
        }
    }

    public void pickHighNumber() {
        if (numberArray.size() < 6){
            Random highr = new Random();
            int high = highr.nextInt(5);
            switch (high){
                case 0:
                    high = 10;
                    break;

                case 1:
                    high = 25;
                    break;

                case 2:
                    high = 50;
                    break;

                case 3:
                    high = 75;
                    break;

                case 4:
                    high = 100;
                    break;
            }
            numberArray.add(high);
            numberString += " " + high;
            setLetter(numberString);
        }
    }


    public void clearLetter(){
        letterArray.clear();
        listString = "";
        setLetter(listString);
    }

    public void clearNumber(){
        numberArray.clear();
        numberString = "";
        setLetter(listString);
    }

}
