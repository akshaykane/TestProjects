package com.jira;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.Properties;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraCleanUsers {

    @Test
    public void deleteJiraUsers() throws Exception {
        
        FileInputStream file = new FileInputStream(new File("files/default.properties"));
        Properties propObj = new Properties();
        propObj.load(file);
        
        String jiraUrl = propObj.getProperty("jira.baseUrl");
        String jiraUser = propObj.getProperty("jira.username");
        String jiraPassword = propObj.getProperty("jira.password");
        
        String auth = jiraUser + ":" + jiraPassword;
        byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("ISO-8859-1")));
        String authHeader = "Basic " + new String(encodedAuth);
        
            
            int userDeletionCount = 0;
            int userDeletionFailedCount = 0;
        
            String searchKeys[] = {"a", "b", "d", "i", "n", "s", "t"};
            
            for (String keyword : searchKeys) {
                
            // Get all users belonging a particular keyword search and store them in JSONArray
            RestAssured.baseURI = jiraUrl;
            RestAssured.useRelaxedHTTPSValidation();
            RequestSpecification req = RestAssured.given();
            req.auth().basic(jiraUser, jiraPassword);
            req.header("Accept","application/json");
            Response getUsersResponse = req.request(Method.GET, "/rest/api/3/user/search?query=" + keyword + "*");
            JSONArray usersArray = new JSONArray(getUsersResponse.getBody().asString());
            
            
            // Iterate over the JSONArray and delete individual user using the accountId 
               for(int i = 0; i< usersArray.length(); i++)
               {
                   JSONObject userJson = usersArray.getJSONObject(i);
                   String userAccountId = userJson.getString("accountId");
                   RestAssured.baseURI = jiraUrl;
                   RestAssured.useRelaxedHTTPSValidation();
                   RequestSpecification req1 = RestAssured.given();
                   req1.header("Authorization", authHeader);
                   req1.header("Accept","application/json");
                   req1.header("Content-Type", "application/json");
                   Response deleteUserResponse = req1.request(Method.DELETE, "/rest/api/3/user?accountId="+userAccountId);
                   
                   if (deleteUserResponse.getStatusCode() == 204)
                   {
                       userDeletionCount++;
                       System.out.println("Deleted jira user with account id - " + userAccountId);
                   }
                   else {
                       userDeletionFailedCount++;
                       System.out.println("Delete action failed for user with account id " + userAccountId + " with response - " + deleteUserResponse.getStatusCode());
                   }
                   
               }
           
            }
            
            System.out.println("Total number of JIRA users deleted - " + userDeletionCount);
            
            System.out.println("Total number of JIRA users delete action failed for - " + userDeletionFailedCount);
        
    }

}
