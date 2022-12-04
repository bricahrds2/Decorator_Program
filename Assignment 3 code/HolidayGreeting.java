
public class HolidayGreeting implements AddOn, SecondaryHeading {
	public boolean applies(PurchasedItems items) {
		return true;
	}
	public String getLines() {
		return "*Happy Holidays from Best Buy*";
	}
}
