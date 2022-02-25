public class Main {
    public static void main(String[] args) {

        Contact contactBrian = new Contact(1, "Brian", "Laughlin", "brian@inetoc.com");
        NpsSurvey survey = new NpsSurvey(contactBrian, "After support survey", "Support", -1);

        EmailCreator emailCreator = new EmailCreator(survey);
        System.out.println(emailCreator.createEmail());
    }
}
