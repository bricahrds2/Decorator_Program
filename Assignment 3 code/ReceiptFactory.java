import java.util.Date;
//import java.time.LocalDateTime;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;

public class ReceiptFactory {
	public String stname, stadd, stnum, stphnum, stcode; // Name, Store Name, Address , Phone Number, State Code
	String header;
	String state_code;

	private TaxComputation[] taxComputationsObjs;
	private AddOn[] addOns;

	public ReceiptFactory() throws IOException {
		taxComputationsObjs = new TaxComputation[100];
		addOns = new AddOn[100];

		// header = "Best Buy, 1717 York Rd, 149, (410) 561-2260";
		// state_code = "MD";

		List<String> strings = new ArrayList<String>();

		BufferedReader bf = new BufferedReader(new FileReader(
				"\\Users\\brand\\Downloads\\Assignment 3 code-20221202T193915Z-001\\Assignment 3 code\\Configuration.txt"));
		String line = bf.readLine();

		while (line != null) {
			strings.add(line);
			line = bf.readLine();
		}
		bf.close();
		// String[] array = strings.toArray(new String[0]);

		stname = strings.get(0);
		stadd = strings.get(1);
		stnum = strings.get(2);
		stphnum = strings.get(3);
		stcode = strings.get(4);

		if (stcode.equals("MD")) {
			taxComputationsObjs[0] = new MDTaxComputation();
		} else if (stcode.equals("CA")) {
			taxComputationsObjs[0] = new CATaxComputation();
		} else if (stcode.equals("MA")) {
			taxComputationsObjs[0] = new MATaxComputation();
		} else if (stcode.equals("DE")) {
			taxComputationsObjs[0] = new DETaxComputation();
		}

		addOns[0] = new Coupon100Get10Percent();
		addOns[1] = new HolidayGreeting();
		addOns[2] = new Rebate1406();
	}

	public Receipt getReceipt(PurchasedItems items, Date date) {
		BasicReceipt custRec = new BasicReceipt(items);
		custRec.setDate(date); // Sets current date
		custRec.setTaxComputation(taxComputationsObjs[0]); // attaches the state tax to basic recipet

		custRec.setPhnumber(stphnum);
		custRec.setStAddress(stadd);
		custRec.setStCode(stcode);
		custRec.setStoreName(stname);
		custRec.setStNumber(stnum);
		custRec.subTotalCost();

		// Receipt newRec;

		for (int i = 0; i < addOns.length; i++) { // traverse over add on to see which one applies
			if (addOns[i].applies(items)) {
				if (addOns[i] instanceof Coupon100Get10Percent || addOns[i] instanceof Rebate) {
					// Decorator decorator = new PostDecorator(addOns[i], custRec);
					custRec.setDate(date);
					Receipt newRec = new PostDecorator(addOns[i], custRec);
					return newRec; // return basic abject as receipt

				} else if (addOns[i] instanceof HolidayGreeting) {
					// Decorator decorator = new PreDecorator(addOns[i], custRec);
					custRec.setDate(date);
					Receipt newRec = new PreDecorator(addOns[i], custRec);
					return newRec; // return basic object as receipt
				}
			}
		}
		// newRec.setDate(date);
		// Receipt newRec = new (custRec).
		return null;
	}
}
