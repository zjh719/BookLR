import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class TestBook {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "ISBN-1-1", "语文");
	Book book2 = new Book("0001", "ISBN-1-2", "语文");
	Book book3 = new Book("0002", "ISBN-2-1", "英语");
	Book book4 = new Book("0002", "ISBN-2-2", "英语");
	Book book5 = new Book("0003", "ISBN-3-1", "数学");
	Book book6 = new Book("0003", "ISBN-3-2", "数学");
	Member loanmember = member1;
	Book loanbook = book5;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public TestBook() {
		/*
		 * 添加借书人属性
		 */
		member1.setId("01");
		member1.setName("张三");
		member2.setId("02");
		member2.setName("李三");
		member3.setId("03");
		member3.setName("老三");		
		/*
		 * 添加借书记录
		 */
		Loan loan1 = new Loan();
		Loan loan2 = new Loan();
		loan1.setMember(loanmember);
		loan1.setBook(book2);
		loan2.setMember(loanmember);
		loan2.setBook(book3);
		Loans.add(loan1);
		Loans.add(loan2);
		loanmember.setLoans(Loans);
	}
	
	@Test
	/* 
	 * 借书
	 */
	public void Loan() {
		HasReachMaxSpecification all = new HasReachMaxSpecification();
		System.out.println(loanmember.getName()+"已经借了"+loanmember.getLoans().size()
				+"本");	
		System.out.println(all.IsSatisfiedBy(loanmember)+"借的书没超数量，可以借书");		
		 LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
			System.out.println(one.IsSatisfiedBy(loanmember)+"此书也没有借过");	
			System.out.println("所以，可以借书！");
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("借书成功！");
		 System.out.println("借书记录："+loanmember.hashCode()+'\r'+"借书时间: " +
		 loan.getLoanDate()+
		 " 到期时间: " + loan.getDateForReuturn()+
		 " 借书人: " + loanmember.getName()+
		 " 所借书籍: " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("所以，借书不成功！");
		 }
	
		/**还书**/
		
		loanmember.Return(loanbook);
	}



}
