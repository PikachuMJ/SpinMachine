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

        setContentPane(SpinMachine);
        pack();
        setTitle("Spin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        spinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        setVisible(true);
    }
}
