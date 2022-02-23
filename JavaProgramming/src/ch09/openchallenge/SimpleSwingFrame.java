package ch09.openchallenge;

import java.awt.*;
import javax.swing.*;

public class SimpleSwingFrame extends JFrame{
    public SimpleSwingFrame() {
        super("Open Challenge 9");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        contentPane.add(new NorthPanel(), BorderLayout.NORTH);
        contentPane.add(new CenterPanel(), BorderLayout.CENTER);
        
        setSize(300, 300);
        setVisible(true);
    }
	
    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY);
            add(new JButton("Open"));
            add(new JButton("Read"));
            add(new JButton("Close"));	
        }
    }

    class CenterPanel extends JPanel {
        public CenterPanel() {
            setLayout(null);

            JLabel hello = new JLabel("Hello");
            hello.setSize(100,20);
            hello.setLocation(30, 10);

            JLabel java = new JLabel("Java");
            java.setSize(100,20);
            java.setLocation(20, 100);

            JLabel love = new JLabel("Love");
            love.setSize(100,20);
            love.setLocation(100, 200);

            add(hello);
            add(java);
            add(love);	
        }
    }

    static public void main(String[] arg) {
        new SimpleSwingFrame();
    }
}
