package edu.univ.erp.ui.student;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

public class StudentDashboard extends JFrame {

    public StudentDashboard() {
        setTitle("Student Dashboard - University ERP");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Dashboard", createDashboardPanel());
        tabs.addTab("Course Catalog", createCatalogPanel());
        tabs.addTab("My Registrations", createRegistrationPanel());
        tabs.addTab("Timetable", createTimetablePanel());
        tabs.addTab("Grades", createGradesPanel());
        tabs.addTab("Transcript", createTranscriptPanel());

        add(tabs);
    }

    private JPanel createDashboardPanel() {
        JPanel p = new JPanel(new BorderLayout());

        JLabel label = new JLabel("Welcome, Student!", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        p.add(label, BorderLayout.CENTER);

        return p;
    }

    private JPanel createCatalogPanel() {
        JPanel p = new JPanel(new BorderLayout());

        String[] cols = {"Course Code", "Title", "Credits", "Instructor", "Capacity"};
        String[][] data = {}; // backend later

        JTable table = new JTable(new DefaultTableModel(data, cols));
        JScrollPane scroll = new JScrollPane(table);

        JButton regBtn = new JButton("Register Selected Course");

        p.add(scroll, BorderLayout.CENTER);
        p.add(regBtn, BorderLayout.SOUTH);

        return p;
    }

    private JPanel createRegistrationPanel() {
        JPanel p = new JPanel(new BorderLayout());

        String[] cols = {"Course Code", "Section", "Instructor", "Time", "Room"};
        String[][] data = {}; // backend later

        JTable table = new JTable(new DefaultTableModel(data, cols));
        JScrollPane scroll = new JScrollPane(table);

        JButton dropBtn = new JButton("Drop Selected Registration");

        p.add(scroll, BorderLayout.CENTER);
        p.add(dropBtn, BorderLayout.SOUTH);

        return p;
    }

    private JPanel createTimetablePanel() {
        JPanel p = new JPanel();
        p.add(new JLabel("Timetable will be shown here.", SwingConstants.CENTER));
        return p;
    }

    private JPanel createGradesPanel() {
        JPanel p = new JPanel(new BorderLayout());

        String[] cols = {"Course", "Component", "Score", "Final Grade"};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));

        p.add(new JScrollPane(table), BorderLayout.CENTER);
        return p;
    }

    private JPanel createTranscriptPanel() {
        JPanel p = new JPanel();
        JButton download = new JButton("Download Transcript (PDF/CSV)");
        p.add(download);
        return p;
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new StudentDashboard().setVisible(true);
    }
}
