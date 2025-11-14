package edu.univ.erp.auth;

public class CurrentSession {
    private static AuthUser currentUser;

    public static void set(AuthUser user) {
        currentUser = user;
    }

    public static AuthUser get() {
        return currentUser;
    }

    public static void clear() {
        currentUser = null;
    }
}
