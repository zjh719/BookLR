import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;



public class TestBook {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "ISBN-1-1", "����");
	Book book2 = new Book("0001", "ISBN-1-2", "����");
	Book book3 = new Book("0002", "ISBN-2-1", "Ӣ��");
	Book book4 = new Book("0002", "ISBN-2-2", "Ӣ��");
	Book book5 = new Book("0003", "ISBN-3-1", "��ѧ");
	Book book6 = new Book("0003", "ISBN-3-2", "��ѧ");
	Member loanmember = member1;
	Book loanbook = book5;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public TestBook() {
		/*
		 * ��ӽ���������
		 */
		member1.setId("01");
		member1.setName("����");
		member2.setId("02");
		member2.setName("����");
		member3.setId("03");
		member3.setName("����");		
		/*
		 * ��ӽ����¼
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
	 * ����
	 */
	public void Loan() {
		HasReachMaxSpecification all = new HasReachMaxSpecification();
		System.out.println(loanmember.getName()+"�Ѿ�����"+loanmember.getLoans().size()
				+"��");	
		System.out.println(all.IsSatisfiedBy(loanmember)+"�����û�����������Խ���");		
		 LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
			System.out.println(one.IsSatisfiedBy(loanmember)+"����Ҳû�н��");	
			System.out.println("���ԣ����Խ��飡");
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println("����ɹ���");
		 System.out.println("�����¼��"+loanmember.hashCode()+'\r'+"����ʱ��: " +
		 loan.getLoanDate()+
		 " ����ʱ��: " + loan.getDateForReuturn()+
		 " ������: " + loanmember.getName()+
		 " �����鼮: " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("���ԣ����鲻�ɹ���");
		 }
	
		/**����**/
		
		loanmember.Return(loanbook);
	}



}
