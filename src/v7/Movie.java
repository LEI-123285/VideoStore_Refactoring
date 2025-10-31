package v7;

public class Movie {

	private String _title;
	private Price _price;

	public Movie(String title, Price price) {
		_title = title;
		_price = price;
	}

	public String getTitle() {
		return _title;
	}

	public double getRentalAmount(int duration) {
		return _price.getRentalAmount(duration);
	}

	public int getFrequentRentalPoints(int duration) {
		return _price.getFrequentRentalPoints(duration);
	}
}
