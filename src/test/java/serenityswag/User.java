package serenityswag;

/*
Accepted usernames are:
standard_user
locked_out_user
problem_user
performance_glitch_user
 */
public enum User {

    STANDARD_USER("standard_user","secret_sauce","a standard user"),
    LOCKED_OUT_USER("locked_out_user","secret_sauce","a LOCKED USER"),
    PROBLEM_USER("problem_user","secret_sauce","a PROBLEM USER"),
    PERFORMANCE_GLITCH_USER("performance_glitch_user","secret_sauce","a PERFROMANCE USER");

    private final String username;
    private final String password;
    private final String description;

    User(String username, String password, String description) {
        this.username = username;
        this.password = password;
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getDescription() {
        return description;
    }
}
