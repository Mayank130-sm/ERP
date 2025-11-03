package edu.univ.erp.auth;

import org.mindrot.jbcrypt.BCrypt;

public class PasswordHashUtil {

    // Define the BCrypt workload factor (10 is a good default for security/performance balance)
    private static final int WORKLOAD = 10;

    /**
     * Hashes the plaintext password using BCrypt.
     * @param password_plaintext The user's password in plaintext.
     * @return The secure BCrypt hash string.
     */
    public static String hashPassword(String password_plaintext) {
        String salt = BCrypt.gensalt(WORKLOAD); // Generates a random salt
        return BCrypt.hashpw(password_plaintext, salt);
    }

    /**
     * Checks a plaintext password against a stored hash.
     * @param password_plaintext The password provided by the user during login.
     * @param stored_hash The hash stored in the Auth DB.
     * @return True if the passwords match, false otherwise.
     */
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
        // BCrypt handles the extraction of the salt from the stored_hash automatically
        return BCrypt.checkpw(password_plaintext, stored_hash);
    }
}