package edu.msu.huangmax.ece480_app;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.*;

public class DatabaseTool {

    private int userId = 15;
    private final String link = "https://webdev.cse.msu.edu/~huangmax/ece480/ece480app/";

    public DatabaseTool() {

    }

    public void writeWakeUpQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        String writeLink = link;
                        writeLink += "wakeup_insert.php?" + "user_id="
                                + userId + "&time=" + responses[0] + "&response1=" + responses[1]
                                + "&response2=" + responses[2] + "&response3=" + responses[3];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeNapQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        for (int i = 0; i < responses.length; i++) {
                            if (responses[i].equals("")) {
                                responses[i] = "N/A";
                            }
                        }
                        String writeLink = link;
                        writeLink += "nap_insert.php?" + "user_id="
                                + userId + "&nap_taken=" + responses[0] + "&first_nap_start=" + responses[1]
                                + "&first_nap_end=" + responses[2] + "&second_nap_start=" + responses[3]
                                + "&second_nap_end=" + responses[4] + "&third_nap_start=" + responses[5]
                                + "&third_nap_end=" + responses[6];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void writeBedtimeQuestions(String[] responses) {
        try {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try  {
                        for (int i = 0; i < responses.length; i++) {
                            if (responses[i].equals("")) {
                                responses[i] = "N/A";
                            }
                        }
                        String writeLink = link;
                        writeLink += "bedtime_insert.php?" + "user_id="
                                + userId + "&bedtime=" + responses[0] + "&fatigue_level=" + responses[1]
                                + "&sleepiness_level=" + responses[2];
                        for (int i = 0; i < writeLink.length(); i++) {
                            if (writeLink.charAt(i) == ' ') {
                                writeLink = writeLink.substring(0, i) + '+' + writeLink.substring(i + 1);
                            }
                        }
                        URL url = new URL(writeLink);
                        HttpURLConnection con = (HttpURLConnection) url.openConnection();
                        con.setRequestMethod("POST");
                        con.connect();
                        con.getInputStream();
                        System.out.println(writeLink);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
