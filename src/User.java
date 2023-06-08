public class User {
    private String username;
    private String password;
    private String job;

    public User(String username, String password, String job) {
        this.username = username;
        this.password = password;
        this.job = job;
    }

    public String getUsername() {
        return username;
    }

    public void setUserId(String userId) {
        this.username = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
}
