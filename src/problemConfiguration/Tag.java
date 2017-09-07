package problemConfiguration;

public class Tag {
	
	public String weekday;
	public int day; 
	public String month; 
	public int week;
	public String group; 
	public int feiertag; 

	Tag(	int day, 
			String weekday, 
			String month, 
			int week, 
			String group, 
			int feiertag){
		this.day = day;
		this.weekday = weekday;
		this.month = month; 
		this.week = week; 
		this.group = group; 
		this.feiertag = feiertag; 
	}
}
/*tuple TTage{												//Tupel für die Tage
-	  key int tag;	%%%%%%%% um 1 reduziert!!!
-	  string wochentag;
-	  string monat;
-	  int woche;
-	  string gruppe;
-	  int feiertag;
	}
	{TTage} Tage					=...;  						Menge für die Tage
 */