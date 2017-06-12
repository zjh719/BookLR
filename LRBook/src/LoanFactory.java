

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LoanFactory {

	public static Loan CreateLoan(Book book, Member menber) {
		LocalDate localDate = LocalDate.now();
		Loan loan=new Loan();
		loan.setBook(book);
		loan.setMember(menber);
		loan.setLoanDate(localDate);		
		loan.setDateForReuturn(localDate.plus(2, ChronoUnit.DAYS));
		return loan;

	}

}
