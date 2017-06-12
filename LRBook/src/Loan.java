

import java.time.LocalDate;

public class Loan {
	private String Id;
	private LocalDate LoanDate;
	private LocalDate DateForReuturn;
	private LocalDate ReturnDate;
	private Book book;
	private Member member;

	

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public LocalDate getLoanDate() {
		return LoanDate;
	}

	public void setLoanDate(LocalDate loanDate) {
		LoanDate = loanDate;
	}

	public LocalDate getDateForReuturn() {
		return DateForReuturn;
	}

	public void setDateForReuturn(LocalDate dateForReuturn) {
		DateForReuturn = dateForReuturn;
	}

	public LocalDate getReturnDate() {
		return ReturnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		ReturnDate = returnDate;
	}


	public boolean HasNotBeenRuturn() {
		return ReturnDate == null;

	}

	public void MarkAsReturned() {
		ReturnDate = LocalDate.now();
	}





	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}




}
