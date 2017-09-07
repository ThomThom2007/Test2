package problemConfiguration;

public class Dienst {
	
	public String name;
	public String group; 
	public double hours; 
	public double payedHours; 
	public double workingHours;
	public int fza;
	public int unecht;
	public int frwe; 
	public int bdfa;
	public int bddienste; 
	public int fta; 
	
	Dienst(	String name, 
			String group, 
			double hours, 
			double payedHours,
			double workingHours,
			int fza, 
			int unecht, 
			int frwe, 
			int bdfa, 
			int bddienste, 
			int fta){
		this.name = name;
		this.group = group; 
		this.hours = hours;
		this.payedHours = payedHours;
		this.workingHours = workingHours;
		this.fza = fza;
		this.unecht = unecht; 
		this.frwe = frwe;
		this.bdfa = bdfa; 
		this.bddienste = bddienste;
		this.fta = fta;
	}
}
/*
tuple TDienste{												//Tupel für die Ikonen
-  key string bezeichnung;
-  string gruppe;
-  float stunden;
-  float bezahlstunden;
-  float arbeitszeit;
-  int fza;
-  int unecht;
-  int frwe;
-  int bdfa;
-  int bddienste;
-  int fta;
}  
{TDienste} 	Dienste					=...;					//Menge für die Ikonen

*/