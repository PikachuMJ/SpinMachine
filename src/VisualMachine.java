import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("ALL")
public class VisualMachine extends JFrame{
    private JButton resetButton;
    private JButton spinButton;
    private JLabel Machine;
    private JPanel SpinMachine;


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
    }
}
