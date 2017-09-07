package problemConfiguration;

public class TInput {
	
	public String name;
	public int day; 
	public String declaration;
	public int value; 
	
	TInput(String name, 
			int day, 
			String declaration, 
			int value){
		this.name = name; 
		this.day = day; 
		this.declaration = declaration; 
		this.value = value; 
	}
}
/*
  tuple TInput{												//Tupel für den Input (fixierte Dienste, Urlaub, A-Tage, Vormonat)
-  string name;
-  int tag;
-  string bezeichnung;
-  int wert;	
}  
{TInput} 	Input					=...;					//Menge für den Input
{TInput} 	Request					=...;					//Menge für die Wünsche
 */
