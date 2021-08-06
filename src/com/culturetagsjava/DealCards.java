package com.culturetagsjava;

import java.util.ArrayList;
import java.util.Collections;

public class DealCards {
    // These are supposed to be the cards
    private String a = "FIUYMI";
    private String b = "LITBM";
    private String c = "TIWISLWDC";
    private String d = "TMHTD";
    private String e = "IGSWIMKICHS";
    private String f = "BOAFFT";
    private String g = "IFYKYK";
    private String h = "WYGAC";
    private String i = "IBYITWAICTYO";
    private String j= "KYHU";


    public String wygac() {
        String a = "When You Get a Chance";
        return a;
    }

    public String ifykyk() {
        String b = "If You Know You Know";
        return b;
    }

    public String ibyitwaictyo() {
        String c = "I Brought You In This World And I Can Take You Out";
        return c;
    }

    public String boafft() {
        String d = "Birds of A Feather Flock Together";
        return d;
    }

    public String igswimkichs() {
        String e= " I Get So Weak In My Knees I Can Hardly Speak ";
        return e;
    }

    public String tmhtd() {
        String f = "Teach Me How To Dougie";
        return f;
    }
    public String tiwislwdc() {
        String g = "This Is What It Sounds Like When Doves Cry";
        return g;
    }
    public String litbm() {
        String h = "Laughter Is The Best Medicine";
        return h;
    }
    public String fiuymi() {
        String i = "Fake It Until You Make It";
        return i;
    }
    public String kyhu() {
        String j = "Keep Your Head Up";
        return j;
    }

    // Cards are stored in this arrayList
    private ArrayList<String> cards = new ArrayList<String>();

    // Here Cards are shuffle so user dont sam ecards everytime.
    public ArrayList<String> cards() {
        cards.add(a);
        cards.add(b);
        cards.add(c);
        cards.add(d);
        cards.add(e);
        cards.add(f);
        cards.add(g);
        cards.add(h);
        cards.add(i);
        cards.add(j);

        Collections.shuffle(cards);
        return cards;
    }

}
