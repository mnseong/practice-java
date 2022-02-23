package ch09.ex07;

import java.awt.*;
import javax.swing.*;

public class CalculatorFrame extends JFrame {
    public CalculatorFrame() {
        super("계산기 프레임");
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
            add(new JLabel("계산 결과"));
            add(new JTextField(20));
        }
    }

    class CenterPanel extends JPanel {
        JButton[] buttons = {
            new JButton("+"), new JButton("-"), new JButton("x"), new JButton("/")
        };

        public CenterPanel() {
            setBackground(Color.WHITE);
            setLayout(new GridLayout(4, 4, 5, 5));
            for (int i = 0; i < 10; i++) {
                JButton b = new JButton(Integer.toString(i));
                add(b);
            }
            add(new JButton("CE"));
            add(new JButton("계산"));

            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setBackground(Color.CYAN);
                add(buttons[i]);
            }
        }
    }

    class NorthPanel extends JPanel {
        public NorthPanel() {
            setBackground(Color.LIGHT_GRAY);
            setOpaque(true);
            add(new JLabel("수식입력"));
            add(new JTextField(16));
        }
    }
    
    public static void main(String[] args) {
        new CalculatorFrame();
    }
}
