

import java.util.ArrayList;

public class HasReachMaxSpecification implements Specification<Member> {
	int count=0;
	ArrayList<Loan> loans = new ArrayList<Loan>();

	@Override
	public boolean IsSatisfiedBy(Member member) {
		// TODO Auto-generated method stub
		loans=member.getLoans();
		for(Loan l:loans){
			if(l.getReturnDate()==null)
				count=count+1;			
		}
		if(count<3){
			return true;
		}
		//System.out.println(count);
		return false;
	}

}
