package ch09.ex08;

import java.awt.*;
import javax.swing.*;

public class RandomPanelFrame extends JFrame {
    public RandomPanelFrame() {
        super("여러 개의 패널을 가진 프레임");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        Container contentPane = getContentPane();
        contentPane.add(new SouthPanel(), BorderLayout.SOUTH);
        contentPane.add(new CenterPanel(), BorderLayout.CENTER);
        contentPane.add(new NorthPanel(), BorderLayout.NORTH);
        
        setSize(300, 300);
        setVisible(true);
    }
    
    class SouthPanel extends JPanel {
        public SouthPanel() {
            setBackground(Color.YELLOW);
            setOpaque(true);
            add(new JButton("Word Input"));
            add(new JTextField(15));
        }
    }
    
    class CenterPanel extends JPanel {
        public CenterPanel() {
            setBackground(Color.WHITE);
            setLayout(null);
            for (int i = 0; i < 10; i++) {
                JLabel la = new JLabel("*");
                int x = (int)(Math.random() * 250);
                int y = (int)(Math.random() * 150);
                la.setLocation(x, y);
                la.setSize(10, 10);
                add(la);
            }
            
        }
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY);
            add(new JButton("열기"));
            add(new JButton("닫기"));
            add(new JButton("나가기"));	
        }
    }
    
    public static void main(String[] args) {
        new RandomPanelFrame();
    }
}
