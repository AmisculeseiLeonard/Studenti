package factories;

import java.util.ArrayList;


import studentiJPAC.Curs;

public class Cursuri {
	public static ArrayList<Curs> cursuri = new ArrayList<Curs>();
	
	
	public static ArrayList<Curs> getCursuri() {
		cursuri.add(new Curs("Programare II", 6));
		cursuri.add(new Curs("Baze de date", 5));
		cursuri.add(new Curs("Analiza sistemelor informationale", 5));
		cursuri.add(new Curs("Microeconomie", 5));
		cursuri.add(new Curs("TIA", 5));
		cursuri.add(new Curs("Management", 4));
		cursuri.add(new Curs("Cercetari operationale", 5));
		cursuri.add(new Curs("Finantele intreprinderii", 4));
		cursuri.add(new Curs("Limba engleza 1 pentru afaceri", 4));
		cursuri.add(new Curs("Moneda si credit", 5));
		cursuri.add(new Curs("Piete de capital", 5));
		cursuri.add(new Curs("Buget si fiscalitate", 6));
		cursuri.add(new Curs("Management bancar", 4));
		cursuri.add(new Curs("Algoritmi si logica programarii", 6));
		cursuri.add(new Curs("Comert electronic", 4));
		cursuri.add(new Curs("Dezvoltarea site-urilor web", 4));
		cursuri.add(new Curs("Proiectarea sistemelor informationale", 6));
		cursuri.add(new Curs("Dreptul afacerilor", 4));
		cursuri.add(new Curs("Matematici aplicate in economie", 5));
		cursuri.add(new Curs("Fundamente ale cercetarii statistice si econometrice", 6));
		cursuri.add(new Curs("Instrumente software pentru afaceri", 6));
		cursuri.add(new Curs("Introducere in Data Mining", 6));
		cursuri.add(new Curs("Statistica si modelare economico-financiara", 5));
		cursuri.add(new Curs("Contabilitatea exportului si importului de marfuri", 4));
		return cursuri;
	}
	
}
