package edu.univ.erp.ui.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

public class AdminDashboard extends JFrame {

    public AdminDashboard() {
        setTitle("Admin Dashboard - University ERP");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Dashboard", createDashboardPanel());
        tabs.addTab("User Management", createUserPanel());
        tabs.addTab("Course Management", createCoursePanel());
        tabs.addTab("Section Management", createSectionPanel());
        tabs.addTab("Assign Instructor", createAssignPanel());
        tabs.addTab("Maintenance Mode", createMaintenancePanel());

        add(tabs);
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel("Welcome, Administrator!", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 26));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    // ---------------- USER MANAGEMENT PANEL ----------------
    private JPanel createUserPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Add User"));

        JTextField username = new JTextField();
        JTextField role = new JTextField(); // later dropdown
        JTextField program = new JTextField();
        JTextField year = new JTextField();

        form.add(new JLabel("Username:"));
        form.add(username);
        form.add(new JLabel("Role (Admin/Student/Instructor):"));
        form.add(role);
        form.add(new JLabel("Program / Dept:"));
        form.add(program);
        form.add(new JLabel("Year/Semester:"));
        form.add(year);

        JButton addUserBtn = new JButton("Add User");

        String[] cols = {"User ID", "Username", "Role", "Program/Dept", "Year"};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));
        JScrollPane scroll = new JScrollPane(table);

        panel.add(form, BorderLayout.NORTH);
        panel.add(addUserBtn, BorderLayout.CENTER);
        panel.add(scroll, BorderLayout.SOUTH);

        return panel;
    }

    // ---------------- COURSE MANAGEMENT PANEL ----------------
    private JPanel createCoursePanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(3, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Add Course"));

        JTextField code = new JTextField();
        JTextField title = new JTextField();
        JTextField credits = new JTextField();

        form.add(new JLabel("Course Code:"));
        form.add(code);
        form.add(new JLabel("Title:"));
        form.add(title);
        form.add(new JLabel("Credits:"));
        form.add(credits);

        JButton addCourseBtn = new JButton("Add Course");

        String[] cols = {"Course ID", "Code", "Title", "Credits"};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));

        panel.add(form, BorderLayout.NORTH);
        panel.add(addCourseBtn, BorderLayout.CENTER);
        panel.add(new JScrollPane(table), BorderLayout.SOUTH);

        return panel;
    }

    // ---------------- SECTION MANAGEMENT PANEL ----------------
    private JPanel createSectionPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(6, 2, 10, 10));
        form.setBorder(BorderFactory.createTitledBorder("Add Section"));

        JTextField courseId = new JTextField();
        JTextField instructorId = new JTextField();
        JTextField dayTime = new JTextField();
        JTextField room = new JTextField();
        JTextField capacity = new JTextField();
        JTextField semYear = new JTextField();

        form.add(new JLabel("Course ID:"));
        form.add(courseId);
        form.add(new JLabel("Instructor ID:"));
        form.add(instructorId);
        form.add(new JLabel("Day/Time:"));
        form.add(dayTime);
        form.add(new JLabel("Room:"));
        form.add(room);
        form.add(new JLabel("Capacity:"));
        form.add(capacity);
        form.add(new JLabel("Semester & Year:"));
        form.add(semYear);

        JButton addSectionBtn = new JButton("Add Section");

        String[] cols = {"Section ID", "Course ID", "Instructor ID", "Time", "Room", "Cap."};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));

        panel.add(form, BorderLayout.NORTH);
        panel.add(addSectionBtn, BorderLayout.CENTER);
        panel.add(new JScrollPane(table), BorderLayout.SOUTH);

        return panel;
    }

    // ---------------- ASSIGN INSTRUCTOR PANEL ----------------
    private JPanel createAssignPanel() {
        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));

        panel.setBorder(BorderFactory.createTitledBorder("Assign Instructor to Section"));

        JTextField secId = new JTextField();
        JTextField instId = new JTextField();

        JButton assignBtn = new JButton("Assign");

        panel.add(new JLabel("Section ID:"));
        panel.add(secId);
        panel.add(new JLabel("Instructor ID:"));
        panel.add(instId);
        panel.add(new JLabel(""));
        panel.add(assignBtn);

        return panel;
    }

    // ---------------- MAINTENANCE MODE PANEL ----------------
    private JPanel createMaintenancePanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createTitledBorder("Maintenance Mode"));

        JButton on = new JButton("Enable Maintenance Mode");
        JButton off = new JButton("Disable Maintenance Mode");

        panel.add(on);
        panel.add(off);

        return panel;
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new AdminDashboard().setVisible(true);
    }
}
