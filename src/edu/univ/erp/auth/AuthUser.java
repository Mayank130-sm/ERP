package edu.univ.erp.auth;

public class AuthUser {
    private int userId;
    private String username;
    private String role;
    private String status;
    private String passwordHash;

    public AuthUser(int userId, String username, String role, String status, String passwordHash) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.status = status;
        this.passwordHash = passwordHash;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public String getPasswordHash() {
        return passwordHash;
    }
}
