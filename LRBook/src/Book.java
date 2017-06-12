

public class Book {

	private String Id;
	private String ISBN;
	private String Title;
	private Member LoanTo;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public Member getLoanTo() {
		return LoanTo;
	}

	public void setLoanTo(Member loanTo) {
		LoanTo = loanTo;
	}

	public Book(String id, String iSBN, String title ) {
		super();
		Id = id;
		ISBN = iSBN;
		Title = title;
	}

}
