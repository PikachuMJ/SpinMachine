import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("ALL")
public class VisualMachine extends JFrame{
    private JButton resetButton;
    private JButton spinButton;
    private JPanel SpinMachine;
    private JComboBox multiplierer;
    private JTextField inputPoints;
    private JTextField automateSpins;
    private JLabel slotOne;
    private JLabel slotTwo;
    private JLabel slotThree;
    private int[] rolledNums;
    private ImageIcon[] slotIcons;
    private JLabel[] slots = {slotOne, slotTwo, slotThree};

    public VisualMachine(){
        System.out.println("Start");
    }
    public void visualMachine() {
        Points points = new Points();
        Spin spin = new Spin();
        Thread thread = null;

        setContentPane(SpinMachine);
        setTitle("Spin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                points.setSpins(0);
                points.setPoints(0);
                points.setMoneyInEuro(0);
                spin.setMultiplier(1);
                multiplierer.setSelectedIndex(0);
                inputPoints.setText("Input points");
                resetImages();
            }
        });
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int automate;
                try {
                    automate = Integer.parseInt(automateSpins.getText());
                } catch (NumberFormatException ex) {
                    automate = 1;
                    automateSpins.setText("1");
                }
                for (int i = 0; i < automate; i++) {

                    points.setSpins(points.getSpins() + 1);
                    points.setPoints(points.getPoints() + spin.spin());
                    rolledNums = spin.getRoll();
                    slotIcons = spin.getSlotIcons();
                    for (int y = 0; y < 3; y++){
                        switch (rolledNums[y]){
                            case 1 -> slots[y].setIcon(slotIcons[0]);
                            case 2 -> slots[y].setIcon(slotIcons[1]);
                            case 3 -> slots[y].setIcon(slotIcons[2]);
                            case 4 -> slots[y].setIcon(slotIcons[3]);
                            case 5 -> slots[y].setIcon(slotIcons[4]);
                            case 6 -> slots[y].setIcon(slotIcons[5]);
                        }
                    }
                    System.out.println(points.getPoints() + " " + points.getSpins());
                    try {
                        thread.sleep(0);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        });
        resetImages();
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
                try {
                    points.setMoneyInEuro(Integer.parseInt(inputPoints.getText()));
                    points.setPoints(points.getPoints() - Integer.parseInt(inputPoints.getText()));
                }catch (NumberFormatException ex) {
                    showMessageDialog(null, "Falsche Eingabe");
                }
            }
        });
    }
    public void resetImages(){
        slotOne.setIcon(new ImageIcon("resources/Placeholder.png"));
        slotTwo.setIcon(new ImageIcon("resources/Placeholder.png"));
        slotThree.setIcon(new ImageIcon("resources/Placeholder.png"));
    }
}
