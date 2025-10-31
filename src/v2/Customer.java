package v2;

import java.util.Vector;

public class Customer
{
	private String			_name;
	private Vector<Rental>	_rentals	= new Vector<Rental>();

	public Customer(String _name)
	{
		this._name = _name;
	}

	public void addRental(Rental arg)
	{
		_rentals.addElement(arg);
	}

	public String getName()
	{
		return _name;
	}

	public String statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;

		// header
		String result = "Rental Record for " + getName() + "\n";

		for (Rental each: _rentals)
		{
			double thisAmount = each.getAmount();

			// Extract Method: Move point calculation out of the main loop
			frequentRenterPoints += getFrequentRenterPoints(each);

			// show figures for this rental
			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points";
		return result;
	}

	/**
	 * Calculates the frequent renter points earned for a single rental.
	 * @param aRental The rental object.
	 * @return The number of frequent renter points.
	 */
	private int getFrequentRenterPoints(Rental aRental) {
		int frequentRenterPoints = 1; // Base point for any rental

		// Add bonus for a two day new release rental
		if ((aRental.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE) && aRental.getDaysRented() > 1)
			frequentRenterPoints++;

		return frequentRenterPoints;
	}
}
