public class Letter {
    private String authorJob;
    private String authorName;
    private String receiverJob;
    private String receiverName;
    private String date;
    private String subject;
    private String textOfTheLetter;

    public Letter(String authorJob, String authorName, String receiverJob, String receiverName, String date, String subject, String textOfTheLetter) {
        this.authorJob = authorJob;
        this.authorName = authorName;
        this.receiverJob = receiverJob;
        this.receiverName = receiverName;
        this.date = date;
        this.subject = subject;
        this.textOfTheLetter = textOfTheLetter;
    }

    public String getAuthorJob() {
        return authorJob;
    }

    public void setAuthorJob(String authorJob) {
        this.authorJob = authorJob;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getReceiverJob() {
        return receiverJob;
    }

    public void setReceiverJob(String receiverJob) {
        this.receiverJob = receiverJob;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTextOfTheLetter() {
        return textOfTheLetter;
    }

    public void setTextOfTheLetter(String textOfTheLetter) {
        this.textOfTheLetter = textOfTheLetter;
    }

    @Override
    public String toString() {
        return "Letter{" +
                "authorJob='" + authorJob + '\'' +
                ", authorName='" + authorName + '\'' +
                ", receiverJob='" + receiverJob + '\'' +
                ", receiverName='" + receiverName + '\'' +
                ", date='" + date + '\'' +
                ", subject='" + subject + '\'' +
                ", textOfTheLetter='" + textOfTheLetter + '\'' +
                '}';
    }
}
