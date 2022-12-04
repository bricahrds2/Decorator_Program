import java.util.ArrayList;

public class PurchasedItems {
	private ArrayList<StoreItem> items;
	
	public PurchasedItems() {
		items = new ArrayList<StoreItem>();
	}
	
	public void addItem(StoreItem item) {
		items.add(item);
	}
	
	public double getTotalCost() {
		double total = 0;
		for(int i = 0; i<items.size(); i++) {
			total += Double.parseDouble(items.get(i).getItemPrice());
		}
		return total;
	}
	
	public boolean containsItem(String itemCode) {
		if(items.get(0) == null) {
			return false;
		}
		else return true;
	}
}
