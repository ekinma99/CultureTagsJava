package com.culturetagsjava;

public class Utils {
    
    public static void clearScreen() {
        try {
            if (System.getProperty("os.name").startsWith("Windows")) {
                // Clear terminal on Windows machine
                new ProcessBuilder("cmd.exe", "/c", "cls")
                    .inheritIO()
                    .start()
                    .waitFor();
            } else {
                // Clear terminal on Apple/Linux machine
                new ProcessBuilder("clear")
                    .inheritIO()
                    .start()
                    .waitFor();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("woah");
        System.out.println("woah");
        System.out.println("woah");
        System.out.println("woah");

        Utils.clearScreen();

        System.out.println("woah");
        System.out.println("woah");

    }

}
