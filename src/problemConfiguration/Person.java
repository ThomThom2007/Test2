package problemConfiguration;

public class Person {
	
	public String name; 
	public String qualification; 
	public double hoursweek;
	public int optout; 
	public int wnullft;
	public int wedienst;
	public int bddienst;
	public int maxbd;
	public int maxot;
	public int maxWorkinghours;
	public double stdkto; 
	public int inputwe;
	public double azschutzstunden; 
	public int azschutzwochen; 
	
	Person(	String name, 
				String qualification, 
				double hoursweek, 
				int optout, 
				int wnullft, 
				int wedienst, 
				int bddienst,
				int maxbd, 
				int maxot, 
				int maxWorkinghours, 
				double stdkto, 
				int inputwe, 
				double azschutzstunden, 
				int azschutzwochen){
		this.name = name;
		this.qualification = qualification; 
		this.hoursweek = hoursweek;
		this.optout = optout; 
		this.wnullft = wnullft;
		this.wedienst = wedienst;
		this.bddienst = bddienst;
		this.maxbd = maxbd;
		this.maxot = maxot;
		this.maxWorkinghours = maxWorkinghours;
		this.stdkto = stdkto;
		this.inputwe = inputwe;
		this.azschutzstunden = azschutzstunden;
		this.azschutzwochen = azschutzwochen;
	}
	
	
	
}
//tuple TPersonal{											//Tupel für das Personal
//	  key string name;
//	  string qualifikation;
//	  float stundenwoche;
//	  int optout;  
//	  int wnullft;
//	  int wedienst;
//	  int bddienst;
//	  int maxbd;
//	  int maxot;
//	  int maxarbeitszeit;
//	  float stdkto;
//	  int inputwe;
//	  float azschutzstunden;
//	  int azschutzwochen;
//	}
//	{TPersonal} Personal				=...;					//Menge des Personals