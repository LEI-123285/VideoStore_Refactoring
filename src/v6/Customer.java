package v6;

import java.util.Vector;

public class Customer {
    private String _name;
    private Vector<Rental> _rentals = new Vector<>();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() { return _name; }

    // ——— Helper: Total Charge ———
    public double getTotalCharge() {
        double total = 0;
        for (Rental rental : _rentals) {
            total += rental.getCharge();
        }
        return total;
    }

    // ——— Helper: Total Points ———
    public int getTotalFrequentRenterPoints() {
        int total = 0;
        for (Rental rental : _rentals) {
            total += rental.getFrequentRenterPoints();
        }
        return total;
    }

    // ——— Text Statement ———
    public String statement() {
        String result = "Rental Record for " + getName() + "\n";
        for (Rental rental : _rentals) {
            result += "\t" + rental.getMovie().getTitle() + "\t" + rental.getCharge() + "\n";
        }
        result += "Amount owed is " + getTotalCharge() + "\n";
        result += "You earned " + getTotalFrequentRenterPoints() + " frequent renter points";
        return result;
    }

    // ——— HTML Statement (Easy!) ———
    public String htmlStatement() {
        String result = "<h1>Rental Record for <em>" + getName() + "</em></h1>\n";
        result += "<table>\n";
        for (Rental rental : _rentals) {
            result += "  <tr><td>" + rental.getMovie().getTitle() + "</td><td>" + rental.getCharge() + "</td></tr>\n";
        }
        result += "</table>\n";
        result += "<p>Amount owed is <strong>" + getTotalCharge() + "</strong></p>\n";
        result += "<p>You earned <strong>" + getTotalFrequentRenterPoints() + "</strong> frequent renter points</p>";
        return result;
    }
}