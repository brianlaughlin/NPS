public class NpsSurvey {

    Contact contact;
    String reason;
    String type;
    int score;
    final int id;

    public NpsSurvey(Contact contact, String reason, String type, int score) {
        this.contact = contact;
        this.reason = reason;
        this.type = type;
        this.score = score;
        // give this.id a random value between 1 to 10000
        this.id = (int) (Math.random() * 10000) + 1;
    }

    public NpsSurvey(String reason, String type, int score) {
        this.reason = reason;
        this.type = type;
        this.score = score;
        this.id = (int) (Math.random() * 10000) + 1;
    }

    public NpsSurvey() {
        this.id = (int) (Math.random() * 10000) + 1;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getId() {
        return id;
    }
}
