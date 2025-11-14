package edu.univ.erp.ui.auth;

import javax.swing.*;
import java.awt.*;

import com.formdev.flatlaf.FlatLightLaf;

import edu.univ.erp.auth.AuthException;
import edu.univ.erp.auth.AuthRepository;
import edu.univ.erp.auth.AuthService;
import edu.univ.erp.auth.AuthUser;
import edu.univ.erp.auth.CurrentSession;
import edu.univ.erp.ui.student.StudentDashboard;
import edu.univ.erp.ui.instructor.InstructorDashboard;
import edu.univ.erp.ui.admin.AdminDashboard;

public class LoginWindow extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private final AuthService authService;

    public LoginWindow() {
        this.authService = new AuthService(new AuthRepository());

        setTitle("University ERP - Login");
        setSize(400, 280);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel title = new JLabel("Login", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI", Font.BOLD, 20));
        gbc.gridwidth = 2;
        gbc.gridx = 0; gbc.gridy = 0;
        panel.add(title, gbc);

        gbc.gridwidth = 1;

        gbc.gridy++;
        panel.add(new JLabel("Username:"), gbc);
        usernameField = new JTextField();
        gbc.gridx = 1;
        panel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        panel.add(new JLabel("Password:"), gbc);
        passwordField = new JPasswordField();
        gbc.gridx = 1;
        panel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        JButton loginBtn = new JButton("Login");
        panel.add(loginBtn, gbc);

        add(panel, BorderLayout.CENTER);

        loginBtn.addActionListener(e -> handleLogin());
    }
    private void handleLogin() {
    String username = usernameField.getText().trim();
    String password = new String(passwordField.getPassword());

    try {
        AuthUser user = authService.login(username, password);
        CurrentSession.set(user);

        JOptionPane.showMessageDialog(
                this,
                "Login successful! Logged in as " + user.getRole(),
                "Success",
                JOptionPane.INFORMATION_MESSAGE
        );

        openDashboardForRole(user.getRole());
    } catch (AuthException ex) {
        JOptionPane.showMessageDialog(
                this,
                ex.getMessage(),
                "Login Failed",
                JOptionPane.ERROR_MESSAGE
        );
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(
                this,
                "Unexpected error during login.",
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }
    }

    
    private void openDashboardForRole(String role) {
        this.dispose(); // close login window

        if ("Student".equalsIgnoreCase(role)) {
            StudentDashboard s = new StudentDashboard();
            s.setVisible(true);
        } else if ("Instructor".equalsIgnoreCase(role)) {
            InstructorDashboard i = new InstructorDashboard();
            i.setVisible(true);
        } else if ("Admin".equalsIgnoreCase(role)) {
            AdminDashboard a = new AdminDashboard();
            a.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Unknown role: " + role,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new LoginWindow().setVisible(true);
    }
}
