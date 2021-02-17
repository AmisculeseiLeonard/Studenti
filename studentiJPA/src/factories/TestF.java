package factories;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import studentiJPAC.Bursa;
import studentiJPAC.StudentID;
import studentiJPAC.StudentIF;
import studentiJPAC.TipBursa;

public class TestF {

	public static void main(String[] args) throws ParseException {
		for (int i = 0; i < 10; i++) {
			StudentIF student = StudentIFFactory.createStudent();
			student.setBursa(new Bursa(TipBursa.S1,580));
			System.out.println(student);
			System.out.println(student.getBursa());
		}
		
		for (int i = 0; i < 10; i++) {
			StudentID student = StudentIDFactory.createStudent();
			System.out.println(student);
		}
		
		
//		String pattern = "MM-dd-yyyy";
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
//		Date data = simpleDateFormat.parse("10-10-2020");
//		System.out.println(data.toString());
//		//Date date = simpleDateFormat.format(new Date());
		
	}

}
