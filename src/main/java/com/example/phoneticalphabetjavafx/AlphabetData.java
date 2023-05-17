package com.example.phoneticalphabetjavafx;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class AlphabetData {
    private HashMap<String, String> alphabet;
    private String currentLetter;

    public AlphabetData(){
        alphabet = new HashMap<>();

        alphabet.put("A", "Alpha");
        alphabet.put("B", "Bravo");
        alphabet.put("C", "Charlie");
        alphabet.put("D", "Delta");
        alphabet.put("E", "Echo");
        alphabet.put("F", "Foxtrot");
        alphabet.put("G", "Golf");
        alphabet.put("H", "Hotel");
        alphabet.put("I", "India");
        alphabet.put("J", "Juliett");
        alphabet.put("K", "Kilo");
        alphabet.put("L", "Lima");
        alphabet.put("M", "Mike");
        alphabet.put("N", "November");
        alphabet.put("O", "Oscar");
        alphabet.put("P", "Papa");
        alphabet.put("Q", "Quebec");
        alphabet.put("R", "Romeo");
        alphabet.put("S", "Sierra");
        alphabet.put("T", "Tango");
        alphabet.put("U", "Uniform");
        alphabet.put("V", "Victor");
        alphabet.put("W", "Whiskey");
        alphabet.put("X", "X-ray");
        alphabet.put("Y", "Yankee");
        alphabet.put("Z", "Zulu");

        getRandom();
    }

    public void getRandom(){
        String letter;
        ArrayList<String> key = new ArrayList<>(alphabet.keySet());
        Random random = new Random();

        int index = random.nextInt(key.size());
        letter= key.get(index);

        this.currentLetter = letter;
    }

    public String getCurrentLetter() {
        return currentLetter;
    }


        public boolean isCorrect(String guess){
            return guess.toLowerCase().equals(alphabet.get(currentLetter).toLowerCase());
    }


}