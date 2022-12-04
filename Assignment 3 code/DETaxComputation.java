import java.util.Date;

public class DETaxComputation extends TaxComputation {

    public double computeTax(PurchasedItems items, Date date) {
        double total;
        if (taxHoliday(date) == true) {
            total = items.getTotalCost();
            return total;
        } else {
            total = items.getTotalCost();
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
