import java.util.Date;
//import java.text.DecimalFormat;

public class BasicReceipt implements Receipt {
	private String storeName, store_number, store_address, phone_number, state_code;
	// private String stateCode;

	private PurchasedItems items;
	// private BasicReceipt recTax;
	private Date date;
	private TaxComputation tc;

	public BasicReceipt(PurchasedItems items) {
		this.items = items;
	}

	public void setTaxComputation(TaxComputation tc) {
		this.tc = tc;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public double subTotalCost() {
		return items.getTotalCost();
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void setStNumber(String store_number) {
		this.store_number = store_number;
	}

	public void setStAddress(String store_address) {
		this.store_address = store_address;
	}

	// set phone number
	public void setPhnumber(String phone_number) {
		this.phone_number = phone_number;
	}

	// set store state code
	public void setStCode(String state_code) {
		this.state_code = state_code;
	}

	public double getTax() {
		return subTotalCost() * tc.computeTax(items, date);
	}

	public Date getDate() {
		return date;
	}

	// store_number, store_address, phone_number, state_code;
	public void prtReceipt() {
		System.out.println(storeName + " (Store #" + store_number + ")" + "\n" + "Address: " + store_address + " "
				+ state_code + "\n" + " Phone Number: " + phone_number);
		System.out.println("Item purchased on: " + date);
		// items.printItems();
		System.out.println("Subtotal Cost: $" + subTotalCost());
		System.out.println("Total Cost: $" + subTotalCost() + getTax() + "\n");
	}
}
