package edu.msu.huangmax.ece480_app;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DatabaseToolTest {
    @Test
    public void testVerifyUser() {
        String userId = "3";
        String birthday = "02/26/1999";
        DatabaseTool databaseTool = new DatabaseTool(userId, birthday);
        boolean val = databaseTool.isValidUser();
        assertTrue(val);
    }
}