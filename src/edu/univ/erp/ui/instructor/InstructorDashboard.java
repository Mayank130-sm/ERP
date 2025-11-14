package edu.univ.erp.ui.instructor;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import com.formdev.flatlaf.FlatLightLaf;

public class InstructorDashboard extends JFrame {

    public InstructorDashboard() {
        setTitle("Instructor Dashboard - University ERP");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabs = new JTabbedPane();

        tabs.addTab("Dashboard", createDashboardPanel());
        tabs.addTab("My Sections", createSectionsPanel());
        tabs.addTab("Grade Entry", createGradeEntryPanel());
        tabs.addTab("Class Stats", createStatsPanel());
        tabs.addTab("CSV Tools", createCSVPanel());

        add(tabs);
    }

    private JPanel createDashboardPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel welcome = new JLabel("Welcome, Instructor!", SwingConstants.CENTER);
        welcome.setFont(new Font("Segoe UI", Font.BOLD, 24));
        panel.add(welcome, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createSectionsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        String[] cols = {"Course Code", "Course Name", "Section", "Time", "Room"};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));
        JScrollPane scroll = new JScrollPane(table);

        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createGradeEntryPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JPanel top = new JPanel(new GridLayout(1, 2));
        top.add(new JLabel("Select Section:"));
        top.add(new JComboBox<>(new String[]{"Select..."})); // later dynamic

        panel.add(top, BorderLayout.NORTH);

        String[] cols = {"Roll No", "Student Name", "Quiz", "Midterm", "End-Sem"};
        JTable table = new JTable(new DefaultTableModel(new Object[][]{}, cols));
        JScrollPane scroll = new JScrollPane(table);

        JButton saveBtn = new JButton("Save Scores");
        JButton finalBtn = new JButton("Compute Final Grades");

        JPanel bottom = new JPanel();
        bottom.add(saveBtn);
        bottom.add(finalBtn);

        panel.add(scroll, BorderLayout.CENTER);
        panel.add(bottom, BorderLayout.SOUTH);

        return panel;
    }

    private JPanel createStatsPanel() {
        JPanel panel = new JPanel(new BorderLayout());

        JLabel info = new JLabel("Statistics & Averages will show here.", SwingConstants.CENTER);
        panel.add(info, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createCSVPanel() {
        JPanel panel = new JPanel();

        JButton importBtn = new JButton("Import Grades CSV");
        JButton exportBtn = new JButton("Export Grades CSV");

        panel.add(importBtn);
        panel.add(exportBtn);

        return panel;
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        new InstructorDashboard().setVisible(true);
    }
}
