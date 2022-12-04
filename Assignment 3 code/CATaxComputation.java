import java.util.Date;

public class CATaxComputation extends TaxComputation {

    public double computeTax(PurchasedItems items, Date date) {
        double total;
        if (taxHoliday(date) == true) {
            total = items.getTotalCost();
            return total;
        } else {
            total = items.getTotalCost() * .075;
            return total;
        }

    }

    public boolean taxHoliday(Date date) {
        Date holiday;
        holiday = new Date(12);
        if (date.equals(holiday)) {
            return true;
        } else {
            return false;
        }
    }

}
