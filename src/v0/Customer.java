package v0;

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

    private void appendHeader(StringBuilder result) {
        result.append("Rental Record for ").append(getName()).append("\n");
    }

    private double calculateCharge(Rental rental) {
        double amount = 0;
        switch (rental.getMovie().getPriceCode()) {
            case Movie.Code.REGULAR:
                amount += 2;
                if (rental.getDaysRented() > 2)
                    amount += (rental.getDaysRented() - 2) * 1.5;
                break;
            case Movie.Code.NEW_RELEASE:
                amount += rental.getDaysRented() * 3;
                break;
            case Movie.Code.CHILDRENS:
                amount += 1.5;
                if (rental.getDaysRented() > 3)
                    amount += (rental.getDaysRented() - 3) * 1.5;
                break;
        }
        return amount;
    }

    private int calculateFrequentRenterPoints(Rental rental, int currentPoints) {
        int points = currentPoints + 1;
        if (rental.getMovie().getPriceCode() == Movie.Code.NEW_RELEASE && rental.getDaysRented() > 1)
            points++;
        return points;
    }

    private void appendRentalLine(StringBuilder result, Rental rental, double amount) {
        result.append("\t")
                .append(rental.getMovie().getTitle())
                .append("\t")
                .append(amount)
                .append("\n");
    }

    private void appendFooter(StringBuilder result, double totalAmount, int points) {
        result.append("Amount owed is ").append(totalAmount).append("\n");
        result.append("You earned ").append(points).append(" frequent renter points");
    }
    
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder();

        appendHeader(result);

        for (Rental rental : _rentals) {
            double thisAmount = calculateCharge(rental);
            frequentRenterPoints += calculateFrequentRenterPoints(rental, frequentRenterPoints);
            appendRentalLine(result, rental, thisAmount);
            totalAmount += thisAmount;
        }

        appendFooter(result, totalAmount, frequentRenterPoints);
        return result.toString();
    }
}
