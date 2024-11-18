package com.test.Tagit;

 
 

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Find_Duplicate_Label {

    private Session session;

    @BeforeClass
    public void setUp() {
        try {
            JSch jsch = new JSch();
            // Replace with actual username, hostname, and port
            session = jsch.getSession("username", "correct-hostname-or-ip", 22); 
            session.setPassword("password");
            
            // Configure session properties if needed
            session.setConfig("StrictHostKeyChecking", "no");
            
            session.connect();
            System.out.println("Session connected successfully.");
        } catch (JSchException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to connect to host", e);
        }
    }

    @Test
    public void testMethod() {
        // Your test code here
        System.out.println("Running testMethod...");
    }

    @AfterClass
    public void tearDown() {
        if (session != null && session.isConnected()) {
            try {
                session.disconnect();
                System.out.println("Session disconnected successfully.");
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to disconnect session", e);
            }
        }
    }
}
