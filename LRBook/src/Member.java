

import java.util.ArrayList;

public class Member {
	private String Id;
	private String Name;
	private ArrayList<Loan> Loans = new ArrayList<Loan>();
	
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<Loan> getLoans() {
		return Loans;
	}

	public void setLoans(ArrayList<Loan> loans) {
		Loans = loans;
	}


	public boolean CanLoan(Book book) {
		return book.getLoanTo() == null;

	}
    /*����*/
	public Loan Loan(Book book) {
		Loan loan =null;
		if (CanLoan(book) && this.validate(book)) {
			loan = LoanFactory.CreateLoan(book, this);
			Loans.add(loan);
			return loan;
		}else{
			return null;
		}
	}
	/*���黹��*/
	public Loan FindCurrentLoanFor(Book book) {
		 for(Loan tmp:Loans){
	            if(tmp.getBook().getId().equals(book.getId())){
	        		return tmp;	
	            }
	        }
		return null;

	}

	public void Return(Book book) {
		Loan loan = FindCurrentLoanFor(book);
		if (!(loan == null)) {
			loan.MarkAsReturned();
			book.setLoanTo(null);
			System.out.println("лл����"+loan.getReturnDate()+"����ɹ�����ӭ�´�����");

		}

	}
     /*��֤����*/
	public boolean validate(Book wantbook) {
		HasReachMaxSpecification hasmax = new HasReachMaxSpecification();
		LoanOnlyOneSpecification onlyone = new LoanOnlyOneSpecification(wantbook);
		return (hasmax.IsSatisfiedBy(this) & onlyone.IsSatisfiedBy(this));

	}

}
