
public class PostDecorator extends Decorator {
	private AddOn b;

	public PostDecorator(AddOn b, Receipt r) {
		super(r);
		this.b = b;
	}

	public void prtReceipt() {
		System.out.println(b.getLines());
		callTrailer();
	}
}
