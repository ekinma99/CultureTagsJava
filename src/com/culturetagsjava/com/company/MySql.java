package com.culturetagsjava;
import java.sql.*;

public class MySql {

    static final String PASS = "YOUR PASSWORD FOR MYSQL";
    static final String DB_URL = "jdbc:mysql://localhost:3306/culturalTags";
    static final String USER = "root";
    static private String INSERT_USERS_SQL = "INSERT INTO team_record" + " (teamA, teamB, word, guesser, date) VALUES " + " (?, ?, ?, ?, ?)";
    static private String READ_USERS = "SELECT teamA, teamB, word, guesser, date FROM team_record";

    // Open a connection
    public void db(String win , String lose, String word, String guesser,Date date) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement myStmt = conn.prepareStatement(INSERT_USERS_SQL);

        myStmt.setString(1,win);
        myStmt.setString(2,lose);
        myStmt.setString(3,word);
        myStmt.setString(4,guesser);
        myStmt.setString(5,String.valueOf(date));

        myStmt.executeUpdate();
        System.out.println("saving results ...");
        conn.close();
    }
    public void readSql(String yes) throws SQLException {
        if(yes.contains("y")){
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(READ_USERS);
            int count = 0;

            while (result.next()){
                //Display values
                System.out.print(count++ +"\t");
                System.out.print("team A: " + result.getString("teamA"));
                System.out.print(", team B: " + result.getString("teamB"));
                System.out.print(", word: " + result.getString("word"));
                System.out.print(", guesser: " + result.getString("guesser"));
                System.out.println(", date: " + result.getString("date"));

            }
        }

    }
}

