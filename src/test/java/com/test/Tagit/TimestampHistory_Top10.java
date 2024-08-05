package com.test.Tagit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import org.junit.Test;

public class TimestampHistory_Top10 {
	 @Test
	    public void testDB() {
	        String url = "jdbc:mysql://apollo2.humanbrain.in:3306/HBA_V2";
	        String username = "root";
	        String password = "Health#123";

	        String query = "SELECT " +
	                       "    at.id, " +
	                       "    cu.user_name, " +
	                       "    at.section, " +
	                       "    at.ontology, " +
	                       "    at.start_timestamp, " +
	                       "    at.end_timestamp, " +
	                       "    at.node, " +
	                       "    at.contributor, " +
	                       "    at.action, " +
	                       "    at.contributor_userhash, " +
	                       "    at.duration " +
	                       "FROM " +
	                       "    atlas_timestamp AS at " +
	                       "INNER JOIN " +
	                       "    CC_User AS cu ON at.user = cu.id " +
	                       "ORDER BY " +
	                       "    at.end_timestamp DESC " +
	                       "LIMIT 10;";

	        int idWidth = 8;
	        int userNameWidth = 20;
	        int sectionWidth = 8;
	        int ontologyWidth = 6;
	        int startTsWidth = 30;
	        int endTsWidth = 30;
	        int nodeWidth = 35;
	        int contributorWidth = 15;
	        int actionWidth = 10;
	        int contribHashWidth = 15;
	        int durationWidth = 17;

	        int totalWidth = idWidth + userNameWidth + sectionWidth + ontologyWidth + startTsWidth + endTsWidth + nodeWidth + contributorWidth + actionWidth + contribHashWidth + durationWidth + 20;

	        try (Connection connection = DriverManager.getConnection(url, username, password);
	             Statement statement = connection.createStatement();
	             ResultSet resultSet = statement.executeQuery(query)) {

	            Class.forName("com.mysql.cj.jdbc.Driver");
	            System.out.println("Driver loaded");
	            System.out.println("MYSQL database connected");

	            System.out.printf("%-" + idWidth + "s %-" + userNameWidth + "s %-" + sectionWidth + "s %-" + ontologyWidth + "s %-" + startTsWidth + "s %-" + endTsWidth + "s %-" + nodeWidth + "s %-" + contributorWidth + "s %-" + actionWidth + "s %-" + contribHashWidth + "s %-" + durationWidth + "s%n",
	                              centerText("Id", idWidth),
	                              centerText("User_name", userNameWidth),
	                              centerText("Section", sectionWidth),
	                              centerText("Ontology", ontologyWidth),
	                              centerText("Start_ts", startTsWidth),
	                              centerText("End_ts", endTsWidth),
	                              centerText("Node", nodeWidth),
	                              centerText("Contributor", contributorWidth),
	                              centerText("Action", actionWidth),
	                              centerText("Contrib_hash", contribHashWidth),
	                              centerText("Duration", durationWidth));

	            String separatorLine = "-".repeat(totalWidth);
	            System.out.println(separatorLine);

	            while (resultSet.next()) {
	                Integer id = resultSet.getInt("id");
	                String userName = resultSet.getString("user_name");
	                Integer section = resultSet.getInt("section");
	                Integer ontology = resultSet.getInt("ontology");
	                Timestamp startTs = resultSet.getTimestamp("start_timestamp");
	                Timestamp endTs = resultSet.getTimestamp("end_timestamp");
	                String node = resultSet.getString("node");
	                String contributor = resultSet.getString("contributor");
	                String action = resultSet.getString("action");
	                String contribHash = resultSet.getString("contributor_userhash");
	                String duration = resultSet.getString("duration");

	                System.out.printf("%-" + idWidth + "d %-" + userNameWidth + "s %-" + sectionWidth + "d %-" + ontologyWidth + "d %-" + startTsWidth + "s %-" + endTsWidth + "s %-" + nodeWidth + "s %-" + contributorWidth + "s %-" + actionWidth + "s %-" + contribHashWidth + "s %-" + durationWidth + "s%n",
	                                  id, userName, section, ontology, startTs, endTs, node, contributor, action, contribHash, duration);
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    private String centerText(String text, int width) {
	        if (text == null) {
	            text = "";
	        }
	        int padding = width - text.length();
	        if (padding <= 0) {
	            return text;
	        }
	        int padLeft = padding / 2;
	        int padRight = padding - padLeft;
	        StringBuilder sb = new StringBuilder();
	        for (int i = 0; i < padLeft; i++) sb.append(" ");
	        sb.append(text);
	        for (int i = 0; i < padRight; i++) sb.append(" ");
	        return sb.toString();
	    }
	}