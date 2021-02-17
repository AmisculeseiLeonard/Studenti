package factories;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import studentiJPAC.Profesor;

public class ProfesorFactory {
	private static Random random = new Random();
	private static SimpleDateFormat f = new SimpleDateFormat("dd/mm/yy");
	private static Integer count = 0;
	
	public static Profesor createProfesor() throws ParseException {
		Integer zi = random.nextInt(29) + 1;
		Integer luna = random.nextInt(12) + 1;
		Integer anNastere = (int)(Math.random() * (1940 - 1970 + 1) + 1940);
		//System.out.println(zi + "-"+ luna +"-"+ anNastere);
		Date data = f.parse(zi + "/" + luna + "/"+ anNastere);
		return new Profesor("Profesor " + ++count, data);
	}
	
}
