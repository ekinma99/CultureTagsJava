package culturetagsjava;

import java.util.Scanner;

public  class  Guess {
    public Guess(){}
    public String myGuess(String word){
        return word;
    }
    public String myScanner(){
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();

        return word;
    }

}
