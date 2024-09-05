import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class VisualMachine extends JFrame{
    private JButton resetButton;
    private JButton spinButton;
    private JLabel Machine;
    private JPanel SpinMachine;
    private JComboBox multiplierer;
    private JTextField inputPoints;


    public VisualMachine() {

        Points points = new Points();
        Spin spin = new Spin();

        setContentPane(SpinMachine);
        setTitle("Spin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
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
        Machine.setIcon(new ImageIcon("resources/Machine.png"));
        pack();
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
                points.setMoneyInEuro(Integer.parseInt(inputPoints.getText()));
            }
        });
    }
}
