package com.culturetagsjava;
import java.sql.SQLException;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Logic {
    private Scanner scanner;
    private DealCards cardMeaning;
    private Guess guess;

  /*  long millis=System.currentTimeMillis();
    Date date=new java.sql.Date(millis);
    private String win = "loser";
    private String lose = "winner"; */
    private String kyhu;
    private String wygac;
    private String ifykyk;
    private String ibyitwaictyo;
    private String boafft;
    private String igswimkichs;
    private String tmhtd;
    private String tiwislwdc;
    private String litbm;
    private String fiuymi;

    public Logic(Scanner scanner, DealCards dealCards, Guess guess) {
        this.scanner = scanner;
        this.cardMeaning = dealCards;
        this.guess = guess;
        this.kyhu = cardMeaning.kyhu();
        this.wygac = cardMeaning.wygac();
        this.ifykyk = cardMeaning.ifykyk();
        this.ibyitwaictyo = cardMeaning.ibyitwaictyo();
        this.boafft = cardMeaning.boafft();
        this.igswimkichs = cardMeaning.igswimkichs();
        this.tmhtd = cardMeaning.tmhtd();
        this.tiwislwdc = cardMeaning.tiwislwdc();
        this.litbm = cardMeaning.litbm();
        this.fiuymi = cardMeaning.fiuymi();
    }

    public String guesserToMySql(int b, int c){
              String guesser = (b>c) ? "A" : "B";
              return guesser;
          }

    public void textPlayers(String team) {
        if (!team.equals("A") && !team.equals("B")) {
            return;
        } else {
            System.out.println("enter amount of players for team " + team);
        }
    }

    public boolean compareAmountOfMembers(Team tA, Team tB) {
        if (tA.amountOfPlayers() != tB.amountOfPlayers()) {
            System.out.println("teams are not even");
            System.out.println("add more players");
        } else {
            System.out.println("Team A has\t" + tA.amountOfPlayers() + "\tmembers");
            System.out.println("Team B has\t" + tB.amountOfPlayers() + "\tmembers");
        }
        return tA.amountOfPlayers() != tB.amountOfPlayers();
    }

    public void biggerNumberStart(int x, int y) {
        // doesn't ask to try again
        String winnerNumber = (x > y) ? "highest number is\t" + x : "highest number is\t" + y;
        System.out.println(winnerNumber);
    }

    public void addPlayer(String player, Team team, int amountOfPlayers) {
        int count = 0;
        do {
            System.out.println("insert players");
            player = this.scanner.nextLine();
            team.addPlayer(player); // when line 72 is uncommented, delete this
            // team.addPlayer(player.toUpperCase(Locale.ROOT));
            count++;
        } while (count < amountOfPlayers);
    }

    public void assignCardsToLetters(int b, int c, String player, Team t, int amountOfPlayers) {
        int counter = 0;
        String hint = "";
        if (b < c) {
            player = t.AssignCardsPlayer1(1); // need to store the categories    
            String assignedCard = t.assignedCard();
            if (assignedCard.contains("WYGAC")) {
                assignedCard = wygac;
                hint = "A General Saying";
            }
            if (assignedCard.contains("IFYKYK")) {
                assignedCard = ifykyk;
                hint = " A General Saying";
            }
            if (assignedCard == "IBYITWAICTYO") {
                assignedCard = ibyitwaictyo;
                hint = " A Mother Saying";
            }
            if (assignedCard == "BOAFFT") {
                assignedCard = boafft;
                hint = " A General Saying";
            }
            if (assignedCard == "IGSWIMKICHS") {
                assignedCard = igswimkichs;
                hint = "song";
            }
            if (assignedCard == "TMHTD") {
                assignedCard = tmhtd;
                hint = "song";
            }
            if (assignedCard == "TIWISLWDC") {
                assignedCard = tiwislwdc;
                hint = "song";
            }
            if (assignedCard == "LITBM") {
                assignedCard = litbm;
                hint = "cliche";
            }
            if (assignedCard == "FIUYMI") {
                assignedCard = fiuymi;
                hint = "cliche";
            }
            if (assignedCard == "KYHU") {
                assignedCard = kyhu;
                hint = "cliche";
            }
            System.out.println("player is\t" + player);
            System.out.println("assigned card is\t" + t.assignedCard());
            System.out.println("hint: " + hint);
            System.out.println("________________________________________________");

            algo(counter, amountOfPlayers, t, assignedCard);
        }
    }

    public void algo(int counter, int amountOfPlayers, Team t, String assignedCard) {
        if (counter < amountOfPlayers) {
            String playerName = t.playerTurn(counter);
            System.out.println(playerName + "\tIts Guessing");
            System.out.println("enter your word");
            String word = guess.myGuess();
            String myWord = word;
            if (myWord.equals(assignedCard)) {
                System.out.println("Your team won " + t.getTeamName());
                // connect.db( win, lose, assignedCard, guesserToMySql(b,c), (java.sql.Date) date);System.exit(1);
                System.exit(0); // delete if 126 is uncommented
            }
            if (myWord != assignedCard) {
                System.out.println("Next Player " + t.getTeamName());
                counter++;
                algo(counter, amountOfPlayers, t, assignedCard);
            }
        }
    }

}
