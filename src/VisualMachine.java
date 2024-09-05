import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("ALL")
public class VisualMachine extends JFrame{
    private JButton resetButton;
    private JButton spinButton;
    private JLabel machine;
    private JPanel SpinMachine;
    private JComboBox multiplierer;
    private JTextField inputPoints;
    private JTextField automateSpins;

    public VisualMachine() {
        Points points = new Points();
        Spin spin = new Spin();

        setContentPane(SpinMachine);
        setTitle("Spin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points.setSpins(0);
                points.setPoints(0);
            }
        });
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points.setSpins(points.getSpins() + 1);
                points.setPoints(points.getPoints() + spin.spin());
                System.out.println(points.getPoints() + " " + points.getSpins());
            }
        });
        machine.setIcon(new ImageIcon("resources/Machine.png"));
        pack();
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);
        multiplierer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(multiplierer.getSelectedIndex() == 0) {
                    spin.setMultiplier(1);
                }
                switch (multiplierer.getSelectedIndex()) {
                    case 1 -> spin.setMultiplier(2);
                    case 2 -> spin.setMultiplier(5);
                    case 3 -> spin.setMultiplier(10);
                    case 4 -> spin.setMultiplier(15);
                    case 5 -> spin.setMultiplier(20);
                    case 6 -> spin.setMultiplier(25);
                    case 7 -> spin.setMultiplier(50);
                    case 8 -> spin.setMultiplier(100);
                    default -> spin.setMultiplier(1);
                }
            }
        });
        inputPoints.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Integer.parseInt(inputPoints.getText()) > points.getPoints()) {
                    showMessageDialog(null, "Du hast nicht genug Punkte");
                }else {
                    try {
                        points.setMoneyInEuro(Integer.parseInt(inputPoints.getText()));
                    }catch (NumberFormatException ex) {
                        showMessageDialog(null, "Falsche Eingabe");
                    }
                    points.setPoints(points.getPoints() - Integer.parseInt(inputPoints.getText()));
                }
            }
        });

        automateSpins.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int automate;
                try {
                    automate = Integer.parseInt(automateSpins.getText());
                } catch (NumberFormatException ex) {
                    automate = 0;
                    automateSpins.setText("Hä");
                }
                for (int i = 0; i < automate; i++) {
                    if (points.getPoints() < 0){
                        points.setPoints(0);
                        showMessageDialog(null, "Mach mich doch nicht arm");
                        break;
                    }
                    points.setSpins(points.getSpins() + 1);
                    points.setPoints(points.getPoints() + spin.spin());
                    System.out.println(points.getPoints() + " " + points.getSpins());
                }
            }
        });
    }
}
