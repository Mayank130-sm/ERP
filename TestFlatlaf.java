import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;

public class TestFlatlaf {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        JFrame f = new JFrame("FlatLaf Working!");
        f.setSize(300,200);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JLabel("Yes! FlatLaf Loaded!", SwingConstants.CENTER));
        f.setVisible(true);
    }
}
