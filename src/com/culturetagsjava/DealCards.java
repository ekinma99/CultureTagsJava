package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Collections;

public class DealCards {
    // These are supposed to be the cards
    private String a = "WW2";
    String b = "MMA";
    String c = "LALALAND";
    String d = "RT";
    String f = "WTH";
    String g = "FTP";

    public String ww2() {
        String a = "war world 2";
        return a;
    }

    public String mma() {
        String b = "mixed martial arts";
        return b;
    }

    public String lalaland() {
        String c = "la la land";
        return c;
    }

    public String rt() {
        String d = "radio tv";
        return d;
    }

    public String wth() {
        String f = "what the hell";
        return f;
    }

    public String ftp() {
        String g = "file transfer protocol";
        return g;
    }

    // Cards are stored in this arrayList
    ArrayList<String> cards = new ArrayList<String>();

    // Here Cards are shuffle so user dont sam ecards everytime.
    ArrayList<String> cards() {
        cards.add(a);
        cards.add(b);
        cards.add(c);
        cards.add(d);
        cards.add(f);
        cards.add(g);
        Collections.shuffle(cards);
        return cards;
    }

}
