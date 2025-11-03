package edu.univ.erp.ui.auth;
import javax.swing.*;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLightLaf;
import net.miginfox.swing.MigLayout;

public class LoginWindowPrototype extends JFrame {
    public LoginWindowPrototype() {
        super("University ERP Login");
        // 1. Setup L&F (The modern desktop appearance)
        try {
            UIManager.setLookAndFeel(new FlatLightLaf()); // Use the modern FlatLaf L&F 
        } catch (Exception ex) {
            System.err.println("Failed to initialize FlatLaf.");
        }
        // 2. Setup the main panel and layout
        JPanel panel = new JPanel(new MigLayout(
                "wrap 2, gap 15 10, insets 30", // 2 columns, wrap after 2, standard gaps, padding
                "[grow, right]10[200, fill]" // Column constraints
        ));        
        // --- Title and Description ---
        JLabel titleLabel = new JLabel("University ERP System");
        titleLabel.putClientProperty(FlatClientProperties.STYLE, "font: bold +5");
        panel.add(titleLabel, "span 2, align center, wrap 20");        
        // --- Form Components ---
        // Username Field
        panel.add(new JLabel("Username:"));
        JTextField usernameField = new JTextField(15);
        panel.add(usernameField);
        // Password Field
        panel.add(new JLabel("Password:"));
        JPasswordField passwordField = new JPasswordField(15);
        panel.add(passwordField);
        // Login Button
        JButton loginButton = new JButton("Login");
        // Use an Action Listener that calls the API layer, not DB directly [cite: 83, 223]
        loginButton.addActionListener(e -> attemptLogin(usernameField.getText(), new String(passwordField.getPassword())));
        panel.add(loginButton, "span 2, align right, gaptop 10");
        // --- Window Setup ---
        this.setContentPane(panel);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack(); // Size the window based on components
        this.setLocationRelativeTo(null); // Center the window
        this.setVisible(true);
    }
    private void attemptLogin(String username, String password) {
        // [IMPORTANT]: In the final app, this calls edu.univ.erp.api.auth.login(username, password)
        System.out.println("Attempting login for: " + username);
        // On success: new DashboardWindow(role).setVisible(true); this.dispose();
        // On failure: JOptionPane.showMessageDialog(this, "Incorrect username or password.", "Login Error", JOptionPane.ERROR_MESSAGE); [cite: 109]
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginWindowPrototype::new);
    }
}