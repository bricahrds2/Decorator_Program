
public class Coupon100Get10Percent implements AddOn, Coupon {

	public boolean applies(PurchasedItems items) {
		if(items.getTotalCost()>= 100) {
			return true;
		}
		else return false;
	}
	public String getLines() {
		return "Coupon 100 get 10 percent\n";
	}
}
