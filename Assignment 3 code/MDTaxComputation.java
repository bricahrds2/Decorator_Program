import java.util.Date;
//import java.time.Month;
//import java.util.Calendar;

public class MDTaxComputation extends TaxComputation {

	public double computeTax(PurchasedItems items, Date date) {
		double total;
		// Date newDate = date.getDate();
		if (taxHoliday(date) == true) {
			total = items.getTotalCost();
			return total;
		} else {
			total = items.getTotalCost() * .06;
			return total;
		}

	}

	public boolean taxHoliday(Date rdate) {
		Date stholiday = new Date(1691899200000L);
		Date bfholiday = new Date(1692417600000L);
		// Date newDate = date.getDate();
		if (rdate.after(stholiday) && rdate.before(bfholiday)) {
			return true;
		} else {
			return false;
		}
	}

}
