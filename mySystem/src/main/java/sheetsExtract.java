package org.example;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;

import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import com.google.api.client.json.jackson2.JacksonFactory;

public class sheetsExtract {
    public sheetsExtract(){

    }

    private static Sheets sheetsService;
    public static String APPLICATION_NAME = "Google Sheets Information";
    private  static String SPREADSHEET_ID = "1M2XWw5x9ATJDfEG2NHMaPv-9Tf3cqjTIBYNzB8G3zE0";

    private static Credential authorize() throws IOException, GeneralSecurityException{
        InputStream in = sheetsExtract.class.getResourceAsStream("/credentials.json");
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                JacksonFactory.getDefaultInstance(), new InputStreamReader(in)
        );
        List<String> scopes = Arrays.asList(SheetsScopes.SPREADSHEETS);
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(),
                clientSecrets, scopes)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File("tokens")))
                .setAccessType("offline")
                .build();
        Credential credential = new AuthorizationCodeInstalledApp(
                flow, new LocalServerReceiver()).authorize("useṙ");

        return credential;
    }

    public static Sheets getSheetsService() throws IOException, GeneralSecurityException{
        Credential credential = authorize();
        return new Sheets.Builder(GoogleNetHttpTransport.newTrustedTransport(), JacksonFactory.getDefaultInstance(), credential)
                .setApplicationName(APPLICATION_NAME)
                .build();
    }

    public static List<List<Object>> fetchData() throws IOException, GeneralSecurityException{
        sheetsService = getSheetsService();
        String range = "announcements!A2:D4";

        ValueRange response = sheetsService.spreadsheets().values().get(SPREADSHEET_ID, range).execute();
        List<List<Object>> values = response.getValues();
        return values;
    }

//    public static void main(String[] args) throws IOException, GeneralSecurityException{
//
//        List<List<Object>> values = fetchData();
//        if(values == null || values.isEmpty()){
//            System.out.println("No Data found.");
//        } else {
//            for (List row: values){
//                System.out.printf("Tittle:\n%s\nMessage:\n%s\nFrom:\n%s\nDate:\n%s", row.get(0), row.get(2), row.get(1), row.get(3));
//            }
//        }
//    }

}
