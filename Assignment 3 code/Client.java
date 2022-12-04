import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.time.ZoneId;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) throws IOException {

		System.out.println(

				"\t1 – 1 - Start New Receipt\n" +
						"\t2 – 2 - Add items to cart\n" +
						"\t3 – 2 - Display Receipt\n" +
						"\t0 - Exit Menu\n");

		System.out.print("  Enter your choice: ");
		Scanner reader = new Scanner(System.in);
		String option = reader.next();
		int choice = Integer.parseInt(option);
		Date currDate = new Date(0);

		PurchasedItems items = new PurchasedItems();

		while (choice != 0) {
			switch (choice) {
				case 1:
					System.out.println("Enter year");
					Scanner year = new Scanner(System.in);
					String y = year.next();
					// int yr = Integer.parseInt(y);
					System.out.println("Enter month number");
					Scanner month = new Scanner(System.in);
					String m = month.next();
					// int mt = Integer.parseInt(m);
					System.out.println("Enter Day");
					Scanner day = new Scanner(System.in);
					String d = day.nextLine();
					// int dy = Integer.parseInt(d);
					// String longdate = yr+mt+dy;
					String dt = y + m + d;
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
					try {
						Date date = sdf.parse(dt);
						currDate = date;
					} catch (ParseException e) {
						System.out.println("There was no date");
					}
					break;

				case 2:
					System.out.println("Here is a list of times that you can purchase");
					System.out.println("Dell Labtop, code: 3010, price: $1200");
					System.out.println("PS5, code: 208, price: $500");
					System.out.println("TV, code: 810, price: $780");
					System.out.println("Microwave, code: 1200, price: $80");
					System.out.println("Enter the code of the item you want");

					Scanner select = new Scanner(System.in);
					String input = select.next();
					int in = Integer.parseInt(input);
					// PurchasedItems items = new PurchasedItems();
					StoreItem item;

					if (in == 3010) {
						item = new StoreItem("3010", "Dell Labtop", "1200");
						items.addItem(item);
					} else if (in == 208) {
						item = new StoreItem("208", "PS5", "500");
						items.addItem(item);
					} else if (in == 810) {
						item = new StoreItem("810", "TV", "780");
						items.addItem(item);
					} else if (in == 1200) {
						item = new StoreItem("1200", "Microwave", "80");
						items.addItem(item);
					} else {
						System.out.println("Invalid Entry");
					}
					break;
				case 3:
					ReceiptFactory factory = new ReceiptFactory();
					Receipt receipt = factory.getReceipt(items, currDate);
					receipt.prtReceipt();
					break;
			}
			System.out.print("   Which number is your next choice: **Press 0 to exit**");
			reader = new Scanner(System.in);
			option = reader.next();
			choice = Integer.parseInt(option);
		}

		reader.close();
		// select.close();
		// day.close();
		// year.close();
		// month.close();

		// ReceiptFactory factory = new ReceiptFactory();
		// Receipt receipt = factory.getReceipt(items, date);
		// receipt.prtReceipt();
	}
}
