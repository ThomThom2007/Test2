package problemConfiguration;

public class Woche {
	/**
	 * Wird wahrscheinlich nicht benötigt
	 */
	
	public int anfangsWoche;
	public int anzahlWochen;
	public int[] wochen; //= new int[anzahlWochen]
	public int letztesWE;
	public int anzahlWEs;
	public int[] wochenGanz;
	public int sizeWochenGanz;
	
	Woche(
			int anfangsWoche,
			int anzahlWochen,
			int letztesWE,
			int anzahlWEs){
		this.anfangsWoche = anfangsWoche;
		this.anzahlWochen = anzahlWochen;
		this.letztesWE = letztesWE;
		this.anzahlWEs = anzahlWEs;
		
		wochen = new int[anzahlWochen];
		wochenGanz = new int[letztesWE-1];
		this.sizeWochenGanz = wochenGanz.length; 
	}
}

/*
*
int AnfangsWoche				=...;						//0
int AnzahlWochen				=...;						
range Wochen					=0..AnzahlWochen;			//Range für die Wochen
int LetztesWE					=...;						
int AnzahlWEs					=...;						
range WochenGanz				=1..LetztesWE;
int sizeWochenGanz;
execute{
sizeWochenGanz					=WochenGanz.size;  
}  


*/