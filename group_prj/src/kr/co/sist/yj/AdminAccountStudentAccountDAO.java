package kr.co.sist.yj;

public class AdminAccountStudentAccountDAO {

	private static AdminAccountStudentAccountDAO aasaDAO;
	
	private AdminAccountStudentAccountDAO() {
		
	} //AdminAccountStudentAccountDAO
	
	public static AdminAccountStudentAccountDAO getInstance() {
		if( aasaDAO == null ) {
			aasaDAO = new AdminAccountStudentAccountDAO();
		} //end if
		
		return aasaDAO;
	} //getInstance
	
} //class
