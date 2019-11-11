package no.hvl.dat100.jplab12.oppgave3;

import no.hvl.dat100.jplab12.common.TODO;
import no.hvl.dat100.jplab12.oppgave1.*;

public class Blogg {

	// TODO: objektvariable 
	private Innlegg innleggtabell[];
	private int nesteledig;

	public Blogg() {
		this.innleggtabell = new Innlegg[20];
	}

	public Blogg(int lengde) {
		this.innleggtabell = new Innlegg[lengde];
		this.nesteledig = 0;
	}

	public int getAntall() {
		return nesteledig;
	}
	
	public Innlegg[] getSamling() {
		return innleggtabell;

	}
	
	public int finnInnlegg(Innlegg innlegg) {
		boolean funnet = false;
		int pos = 0;
        while (pos < nesteledig && !funnet) {
        	if (innleggtabell[pos].erLik(innlegg)) {
        		funnet = true;
        	}
        	else {
        		pos++;
        	}      	
        }
        
        if (funnet) {
        	return pos;
        }
        else {
        	return -1;
        }
	}

	public boolean finnes(Innlegg innlegg) {
		boolean finnes = false;
		for (int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].erLik(innlegg)) {
				finnes = true;
			}
			
			}
		return finnes;
	
	}
		

	public boolean ledigPlass() {
		boolean ledig = false;
		if (nesteledig < innleggtabell.length) {
			ledig = true;
		}
		
		return ledig;

	}
	
	public boolean leggTil(Innlegg innlegg) {
		if (finnes(innlegg) || nesteledig>=innleggtabell.length) {
			return false;
		}
		else {
			innleggtabell[nesteledig] = innlegg;
			nesteledig++;
			return true;
		}
	}
	
	public String toString() {
		String objectAsString = Integer.toString(nesteledig) + "\n";
        for (int i = 0; i < nesteledig; i++) {
            objectAsString += innleggtabell[i].toString();
        }
        
        return objectAsString;
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		Innlegg[] ny = new Innlegg[2 * innleggtabell.length];
        for (int i = 0; i < nesteledig; i++) {
            ny[i] = innleggtabell[i];
        }
        
        innleggtabell = ny;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		int p = finnInnlegg(innlegg);
        
        if (p >= 0) {
            return false;
        } else {
        	if (nesteledig == innleggtabell.length) {
                utvid();
            }
            innleggtabell[nesteledig] = innlegg;
            nesteledig++;
            return true;
        }
		
	}
	
	public boolean slett(Innlegg innlegg) {
		int p = finnInnlegg(innlegg);
        if (p >= 0) {
            nesteledig--;
            innleggtabell[p] = innleggtabell[nesteledig];
            innleggtabell[nesteledig] = null;
            return true;
        } else {
            return false;
        }
	}
	
	public int[] search(String keyword) {
		int[] idTab = new int[nesteledig];
		int teller = 0;
		for(int i = 0; i < nesteledig; i++) {
			if (innleggtabell[i].toString().contains(keyword)){
				idTab[teller] = innleggtabell[i].getId();
				teller++;
			}
		}
		
		return idTab;
		
	}
}