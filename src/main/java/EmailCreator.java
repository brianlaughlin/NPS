/*
1. Class will read a file called email_body and replace the tags surrounded by {{}}.
2. It will return the modified file as a string.
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class EmailCreator {

    public static final String fileName = "D:\\Code\\Fun\\NPS\\src\\main\\resources\\email_body.txt";
    final NpsSurvey survey;
    private final String urlBase = "https://www.someawesomepage.com/";
    int scoreCount = 1;

    public EmailCreator(NpsSurvey survey) {
        this.survey = survey;
        loadFile();
    }

    private BufferedReader loadFile() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                    new FileReader(fileName));
            System.out.println("File loaded");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }

    private String createUrl() {
        String url = urlBase +
                "?contact_id=" + survey.contact.getId() +
                "&survey_id=" + survey.getId() +
                "&score=" + scoreCount;

        scoreCount++;

        return url;
    }

    /*
    Create method that will replace the tags found in text file fileName and return a string
     */
    public String createEmail() {
        StringBuilder email = new StringBuilder();

        try {
            BufferedReader br = loadFile();
            String line;
            while ((line = br.readLine()) != null) {
                email.append(line);
                email.append("\n");
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int lengthNameTag = 8;
        int lengthReasonTag = 10;
        int lengthUrlTag = 7;
        int numberOfUrlsToCreateForScore = 10;

        email.replace(email.indexOf("{{Name}}"),
                email.indexOf("{{Name}}") + lengthNameTag,
                survey.contact.getFirstName());

        email.replace(email.indexOf("{{Reason}}"),
                email.indexOf("{{Reason}}") + lengthReasonTag,
                "We want to know what you think");


        for (int i = 0; i < numberOfUrlsToCreateForScore; i++) {
            email.replace(email.indexOf("{{URL}}"), email.indexOf("{{URL}}") + lengthUrlTag, createUrl());
        }

        return email.toString();
    }


}
