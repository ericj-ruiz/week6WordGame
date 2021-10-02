package com.company.views;

import java.util.Scanner;

public class CmdLineView {
    private String[] letters;
    private String theGuess;

    public CmdLineView(String[] letters) {
        this.letters = letters;
    }

    public void startGame(){
        System.out.println("Guess the word \n");
        for(int i=0;i<letters.length;i++){
            System.out.print("_");
        }
        System.out.print("\n");

    }
    public String makeAGuess(){
        System.out.println("\nGuess a letter: ");
        Scanner input = new Scanner(System.in);
        return input.next();
    }
    public void displayHints(String [] hints){
        for(String hint: hints){
            System.out.print(hint);
        }
        System.out.print("\n");
    }
    public void guessedRight(){
        System.out.print("You guessed right!");
    }
    public void outOfGuesses(){
        System.out.print("Your out of guesses.");
    }
    public void wrongGuess(){
        System.out.print("Wrong Guess\n");
    }
    public void cheat(String theWord){
        System.out.print("The Word is " + theWord + "");
    }
    public String[] getLetters() {
        return letters;
    }

    public void setLetters(String[] letters) {
        this.letters = letters;
    }

    public String getTheGuess() {
        return theGuess;
    }

    public void setTheGuess(String theGuess) {
        this.theGuess = theGuess;
    }
}
