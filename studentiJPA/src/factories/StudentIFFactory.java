package factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import studentiJPAC.StudentIF;

public class StudentIFFactory {
	private static Random random = new Random();
	private static SimpleDateFormat f = new SimpleDateFormat("dd/mm/yy");
	private static Integer count = 0;
	private static String[] profile = {"Informatica Economica", "Contabilitate si Informatica de gestiune",
			"Management", "Marketing", "Statistica si previziune economica", "Economie si afaceri internationale", "Finante si Banci"};
	
	public static StudentIF createStudent() throws ParseException {
		int matricol = 1000 + ++count;
		String nume = "student " + count;
		String profil = profile[random.nextInt(profile.length)];
		Integer zi = random.nextInt(29) + 1;
		Integer luna = random.nextInt(12) + 1;
		Integer anNastere = (int)(Math.random() * (1997 - 1970 + 1) + 1970);
		//System.out.println(zi + "-"+ luna +"-"+ anNastere);
		Date data = f.parse(zi + "/" + luna + "/"+ anNastere);
		Integer an = random.nextInt(3) + 1;
		return new StudentIF(matricol, nume, data, profil, an);
	}
	
	
		
}
