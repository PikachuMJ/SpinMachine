@SuppressWarnings("ALL")
public class Spin {
    private int multiplierer = 1;
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
            result = roll();
            if (result[0] == result[1] && result[1] == result[2] && result[0] == 6){
                return 10000 * multiplierer;
            }
        }
        return result[0]+result[1]+result[2];
    }
    public int[] roll() {
        int[] roll = new int[3];
        for (int i = 0; i < 3; i++) {
            roll[i] = (int) (Math.random() * 6) + 1;
        }
        return roll;
    }
    public void setMultiplier(int multiplier) {
        this.multiplierer = multiplier;
    }
    public int getMultiplierer(){
        return multiplierer;
    }
}
