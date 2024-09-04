@SuppressWarnings("ALL")
public class Points {
    int points;
    int spins;

    public int getPoints() {
        return points;
    }

    public int getSpins() {
        return spins;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void setSpins(int spins) {
        this.spins = spins;
    }

    public void addPoints(int points) {
        this.points += points;
    }

    public void addRolls(int rolls) {
        this.spins += rolls;
    }

    public void resetPoints() {
        this.points = 0;
    }

    public void resetRolls() {
        this.spins = 0;
    }
}
