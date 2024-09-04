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
        setTitle("Spin Machine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
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
        Machine.setIcon(new ImageIcon("resources/Machine.png"));
        pack();
        setVisible(true);
    }
}
