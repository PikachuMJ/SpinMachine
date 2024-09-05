@SuppressWarnings("ALL")
public class Points {
    //1 point == 0,01 euro
    private int points;
    private int spins;
    private int moneyInEuro;

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
    public int getMoneyInEuro() {
        return moneyInEuro;
    }
    public void setMoneyInEuro(int points) {
        Spin spin = new Spin();
        this.moneyInEuro += (points * spin.getMultiplierer()) / 100;
    }
}
