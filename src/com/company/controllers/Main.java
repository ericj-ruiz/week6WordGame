package com.company.controllers;

import com.company.models.WordList;
import com.company.views.CmdLineView;

import java.util.ArrayList;
import java.util.Objects;

public class Main {

    public static String[] letters;
    public static int numLetters=0;
    public static int wrongGuesses;
    public static int right;
    public static String theGuess;
    public static CmdLineView view;
    public static String[] hints;


    public static void main(String[] args) {
        wrongGuesses=2;
        GetWord getWord= new GetWord();
        String theWord = getWord.getTheWord();
        WordList word = new WordList(theWord);

        letters = calculateLetters(word.getTheWord());
        view = new CmdLineView(letters);
        view.startGame();
        view.cheat(word.getTheWord());
        String[] guessed = new String[letters.length];
        right=1;
        while(wrongGuesses != 0){
            hints = guess(guessed);
            view.displayHints(hints);
            if(right==0)
                break;

        }
        if(wrongGuesses==0)
            view.outOfGuesses();
        else
            view.guessedRight();

    }
    private static String[] calculateLetters(String theWord){
        String[] letters = theWord.split("");
        numLetters =letters.length;
        return letters;
    }
    private static String[] guess(String[] guessed) {

            theGuess = view.makeAGuess();
            String msg = "";
            int c=0;

            String[] hints = new String[letters.length];
            for (int i = 0; i < letters.length; i++) {
                if (letters[i].equals(theGuess)) {
                    hints[i] = theGuess;
                    guessed[i]=hints[i];
                    c++;
                }
                else if(guessed[i]== null) {
                    guessed[i]="_";
                }

            }
            if(c==0) {
                wrongGuesses--;
                view.wrongGuess();
            }
            right=letters.length;
            for(int j=0;j<letters.length;j++){
                if(guessed[j]!="_")
                    right--;
            }



        return guessed;
    }
}

