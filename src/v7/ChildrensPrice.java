package v7;

public class ChildrensPrice extends Price {
    public ChildrensPrice() {
    }

    public double getRentalAmount(int duration) {
        double result = 1.5;
        if (duration > 3)
            result += (duration - 3) * 1.5;
        return result;
    }

    public int getFrequentRentalPoints(int duration) {
        return 1;
    }
}
