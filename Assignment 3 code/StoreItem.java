
public class StoreItem {
	private String itemCode;
	private String itemDescription;
	private String itemPrice;
	
	public StoreItem(String code, String descript, String price) {
		this.itemCode = code;
		this.itemDescription = descript;
		this.itemPrice = price;
	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public String getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
}
