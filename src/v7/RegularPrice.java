package v7;

public class RegularPrice extends Price {
    public RegularPrice() {
    }

    public double getRentalAmount(int duration) {
        double result = 2;
        if (duration > 2)
            result += (duration - 2) * 1.5;
        return result;
    }

    public int getFrequentRentalPoints(int duration) {
        return 1;
    }
}
