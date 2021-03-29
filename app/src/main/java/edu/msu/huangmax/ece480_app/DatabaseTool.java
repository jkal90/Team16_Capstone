package edu.msu.huangmax.ece480_app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class DatabaseTool {

    private int userId = 15;
    private final String link = "https://database_insert.php?";

    public DatabaseTool() {

    }

    public void writeWakeUpQuestions(String[] responses) {
        try {
            String writeLink = link;
            writeLink += "user_id=" + userId + "& time=" + responses[0] + "& response1=" + responses[1]
                    + "& response2=" + responses[2] + "& response3=" + responses[3];
            URL url = new URL(writeLink);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeNapQuestions(String[] responses) {

    }

    public void writeBedtimeQuestions(String[] responses) {

    }
}
