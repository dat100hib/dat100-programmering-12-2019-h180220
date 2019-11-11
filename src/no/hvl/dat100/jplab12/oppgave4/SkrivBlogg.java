package no.hvl.dat100.jplab12.oppgave4;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import no.hvl.dat100.jplab12.oppgave3.*;
import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.Innlegg;

public class SkrivBlogg {

	private static String MAPPE = System.getProperty("user.dir") + "/src/no/hvl/dat100/jplab12/tests/";

	@SuppressWarnings("finally")
	public static boolean skriv(Blogg samling, String filnavn) {
		boolean lagret = false;
		PrintWriter skriver = null;
		try {
			skriver = new PrintWriter(MAPPE + filnavn);
			Innlegg[] samlinga = samling.getSamling();
			for (int i = 0; i < samlinga.length; i++) {
				Blogg tabell = new Blogg(samlinga.length);
				tabell.leggTil(samlinga[i]);
				
				if (tabell != null) {
					skriver.println(samling.toString());
					lagret = true;
				}

			}
		} catch (FileNotFoundException e) {
			System.out.println("Filen ikke funnet");
		}

		finally {
			if (skriver != null) {
				skriver.close();
			}
			return lagret;
		}

	}
}
