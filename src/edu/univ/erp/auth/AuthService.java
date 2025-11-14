package edu.univ.erp.auth;

import org.mindrot.jbcrypt.BCrypt;

public class AuthService {

    private final AuthRepository authRepository;

    public AuthService(AuthRepository authRepository) {
        this.authRepository = authRepository;
    }

    public AuthUser login(String username, String rawPassword) throws AuthException {
        if (username == null || username.isBlank() || rawPassword == null) {
            throw new AuthException("Username and password are required.");
        }

        AuthUser user = authRepository.findByUsername(username);
        if (user == null) {
            throw new AuthException("Incorrect username or password.");
        }

        if (!"active".equalsIgnoreCase(user.getStatus())) {
            throw new AuthException("User account is not active.");
        }

        String stored = user.getPasswordHash();
        boolean ok = false;

        if (stored != null) {
            // First try assuming it's a BCrypt hash
            try {
                ok = BCrypt.checkpw(rawPassword, stored);
            } catch (IllegalArgumentException ex) {
                // Not a BCrypt hash, ignore
            }

            // Fallback: allow plain-text match (for your current sample data)
            if (!ok && stored.equals(rawPassword)) {
                ok = true;
            }
        }

        if (!ok) {
            throw new AuthException("Incorrect username or password.");
        }

        return user;
    }
}
