import javax.swing.*;

import static javax.swing.JOptionPane.showMessageDialog;

@SuppressWarnings("ALL")
public class Spin{
    public int[] roll = new int[3];
    private int countJackpots;
    private int multiplierer = 1;
    private ImageIcon[] slotIcons = {new ImageIcon("resources/Bell.png"),
                         new ImageIcon("resources/Cherry.png"),
                         new ImageIcon("resources/Horseshoe.png"),
                         new ImageIcon("resources/Lemon.png"),
                         new ImageIcon("resources/Melon.png"),
                         new ImageIcon("resources/Jackpot.png")};

    public int spin() {
        int[] result = roll();

        if(result[0] == result[1] && result[1] == result[2] && result[0] == 1) {
            return 1000 * multiplierer;
        } else if (result[0] == result[1] && result[1] == result[2] && result[0] == 2) {
            return 2000 * multiplierer;
        } else if (result[0] == result[1] && result[1] == result[2] && result[0] == 3) {
            return 3000 * multiplierer;
        } else if (result[0] == result[1] && result[1] == result[2] && result[0] == 4) {
            return 4000 * multiplierer;
        } else if (result[0] == result[1] && result[1] == result[2] && result[0] == 5) {
            return 5000 * multiplierer;
        } else if (result[0] == result[1] && result[1] == result[2] && result[0] == 6) {
            int randomJackpot = (int) (Math.random() * 10000) + 1;
            if(randomJackpot == 5825) {
                countJackpots++;
                showMessageDialog(null, countJackpots);
                return 10000 * multiplierer;
            } else {
                result = new int[]{1, 1, 1};
                return 1000 * multiplierer;
            }
        }
        return -100;
    }
    public int[] roll() {
        for (int i = 0; i < 3; i++) {
            roll[i] = (int) (Math.random() * 6) + 1;
        }
        return roll;
    }
    public int[] getRoll(){
        return roll;
    }
    public ImageIcon[] getSlotIcons(){
        return slotIcons;
    }
    public void setMultiplier(int multiplier) {
        this.multiplierer = multiplier;
    }
    public int getMultiplierer(){
        return multiplierer;
    }
}
