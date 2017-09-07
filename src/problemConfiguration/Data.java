package problemConfiguration;

import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {
	
	/**Erstmal werden alle Daten deklariert, anschließend in passender Reihenfolge mit Werten initialisiert
	Reihenfolge der Initialisierung: 
	Mengen
	Ranges
	Parameter (die dann auf die Mengen zugreifen können müssen)
	Entscheidungsvariablen
	*/
	private static Workbook wb;
	private static String file; 
	
	//Mengen
	public static ArrayList<Person> Personen = new ArrayList<Person>();
	public static ArrayList<Tag> Tage = new ArrayList<Tag>(); 
	public static ArrayList<Dienst> Dienste = new ArrayList<Dienst>();
	public static ArrayList<TInput> Inputs = new ArrayList<TInput>();
	public static ArrayList<TInput> Requests = new ArrayList<TInput>();
	
/*	Ranges auch wie Mengen deklarieren?
 *  initialisieren erst weiter unten?
 *  Kann über For-Schleifen abgefangen werden, 
 *  es sind nur definierte Submengen
	public static int Wochen;
	public static int WochenGanz; 
	public static int MaxWorkstretchRange
	public static int IOPRange
	public static int BDTageRange
	public static string ZF
*/
	//Wochen und test werden wsl nicht gebraucht
	public static ArrayList<Woche> Wochen = new ArrayList<Woche>();
	public static ArrayList<String> test = new ArrayList<String>();
	
	Data(String file){
		this.file = file;
		try {
			this.wb = new XSSFWorkbook(file);
			System.out.println(file + " wurde geöffnet");
		} catch (IOException e) {
			System.out.println("Problem mit Dateiname inkl. Pfad");
			e.printStackTrace();
		}
	}
	

	public void readInPersonen(){
		/**
		 * Liest die vorhanden Personen im Arbeitsblatt "Personal" ein
		 * Fertig
		 */
		
		Workbook wbIn = wb;
		Sheet shIn = wbIn.getSheet("Personal");
		
		String name; 
		String qualification; 
		double hoursweek; 
		int optout; 
		int wnullft; 
		int wedienst; 
		int bddienst;
		int maxbd; 
		int maxot; 
		int maxWorkinghours; 
		double stdkto; 
		int inputwe; 
		double azschutzstunden; 
		int azschutzwochen;
		
		Row rwIn = shIn.getRow(44);
		Cell clIn = rwIn.getCell(0);
		
		double lsRow = clIn.getNumericCellValue();
		int ilsRow = (int)(lsRow);
		
//		Person[] p = new Person[ilsRow];
		
		for(int i = 1;i <= ilsRow; i++){
			int column = 0; 
			rwIn = shIn.getRow(i);
			
			clIn = rwIn.getCell((column + 0));
			name = clIn.getStringCellValue();
			System.out.println(clIn.toString());
			
			clIn = rwIn.getCell(column + 1);
			qualification = clIn.getStringCellValue();
			
			clIn = rwIn.getCell(column + 2);
			hoursweek = clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 3);
			optout = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 4);
			wnullft = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 5);
			wedienst = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 6);
			bddienst = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 7);
			maxbd = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 8);
			maxot = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 9);
			maxWorkinghours = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 10);
			stdkto = clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 11);
			inputwe = (int)clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 12);
			azschutzstunden = clIn.getNumericCellValue();
			
			clIn = rwIn.getCell(column + 13);
			azschutzwochen = (int)clIn.getNumericCellValue();
			
			Personen.add(new Person(	name, qualification, hoursweek, optout, wnullft, wedienst, 
					bddienst, maxbd, maxot, maxWorkinghours, stdkto, inputwe, 
					azschutzstunden, azschutzwochen));
		}
		System.out.println("Anzahl Personen: " + Personen.size());
	}

	public void readInTage(){
		/**
		 * Liest die vorhanden Tage im Arbeitsblatt "Tage" ein
		 * Fertig
		 */
		
		Workbook wbIn = wb;
		Sheet shIn = wbIn.getSheet("Tage");
		
		int day;
		String weekday;
		int feiertag;
		String month;
		String group; 
		int week;

		int startRow = 8;		//Start ab Zeile x 
		int startColumn = 10;
		
		Row rwIn = shIn.getRow(0);
		Cell clIn = rwIn.getCell(6);
		
		rwIn = shIn.getRow(0);
		clIn = rwIn.getCell(8);	//Tage!I1 = 0:8
		//Gehört zu Parameter
		Parameter.ctDs = (int)clIn.getNumericCellValue();
		
		int days = Parameter.ctDs;
		
		for(int i = startRow; i <= (startRow + days); i++){	//Startzeile + Anzahl Tagee (Parameter) 
			int column = startColumn; 
			rwIn = shIn.getRow(i);
			
			day = (int)rwIn.getCell(column + 0).getNumericCellValue();
			weekday = rwIn.getCell(column + 1).getStringCellValue();
			feiertag = (int)rwIn.getCell(column + 2).getNumericCellValue();
			month = rwIn.getCell(column + 3).getStringCellValue();
			group = rwIn.getCell(column + 4).getStringCellValue();
			week = (int)rwIn.getCell(column + 5).getNumericCellValue();
			
			Tage.add(new Tag(day, weekday, month, week, group, feiertag));
		}
		System.out.println("Anzahl Tage: " + Tage.size());
	}
	
	public void readInDienste(){
		/**
		 * Liest die vorhanden Dienste im Arbeitsblatt "Dienste" ein
		 * Fertig
		 */
		
		Workbook wbIn = wb;
		Sheet shIn = wbIn.getSheet("Dienste");
		Row rwIn;
		
		String name; 
		String group; 
		double hours; 
		double payedHours;
		double workingHours;
		int fza; 
		int unecht; 
		int frwe; 
		int bdfa; 
		int bddienste; 
		int fta;
		
		int startRow = 1;		//Ab Zeile 2
		int startColumn = 0;	//Ab Spalte A
//		int anzahlDienste = (int)shIn.getRow(49).getCell(0).getNumericCellValue();
		int anzahlDienste = 31;
		
		for(int i = startRow; i <= (startRow + anzahlDienste); i++){
			rwIn = shIn.getRow(i);
			name = rwIn.getCell(startColumn + 0).getStringCellValue();
			group = rwIn.getCell(startColumn + 1).getStringCellValue();
			hours = rwIn.getCell(startColumn + 2).getNumericCellValue();
			payedHours = rwIn.getCell(startColumn + 3).getNumericCellValue();
			workingHours = rwIn.getCell(startColumn + 4).getNumericCellValue();
			fza = (int)rwIn.getCell(startColumn + 5).getNumericCellValue();
			unecht = (int)rwIn.getCell(startColumn + 6).getNumericCellValue();
			frwe = (int)rwIn.getCell(startColumn + 7).getNumericCellValue();
			bdfa = (int)rwIn.getCell(startColumn + 8).getNumericCellValue();
			bddienste = (int)rwIn.getCell(startColumn + 9).getNumericCellValue();
			fta = (int)rwIn.getCell(startColumn + 10).getNumericCellValue();
			
			Dienste.add(new Dienst(name, group, hours, payedHours, workingHours, fza, unecht, frwe, bdfa, bddienste, fta));
		}
		System.out.println("Anzahl Dienste: " + Dienste.size());
	}
	
	public void readInInput(){
		
	}
	
	public void readInRequest(){
		
	}
	
	public void readInParameter(){
		/**
		 * Liest die benötigten Parameter ein
		 * Ranges werden nicht unbedingt benötigt
		 */
		Workbook wbIn = wb;
		Sheet shIn;
		
		//Sheet "Nachfrage"
		shIn = wbIn.getSheet("Nachfrage");
		int[][] demC = new int[Dienste.size()][Tage.size()];	//Demand matrix physicians
		
		//Sheet "NachfrageFA"
		shIn = wbIn.getSheet("NachfrageFA");
		int[][] demF = new int[Dienste.size()][Tage.size()];	//Demand matrix Facharzt
		
		//Sheet "NachfrageOA"
		shIn = wbIn.getSheet("NachfrageOA");
		int[][] demO = new int[Dienste.size()][Tage.size()];	//Demand matrix Oberarzt
		
		//Sheet "Tage"
		shIn = wbIn.getSheet("Tage");
				
		int bgWk;	//First week
		int ctWk;	//Count of weeks
//		int[] week;	//Range of weeks
		int lsWe;	//last weekend
		int ctWe;	//Count of weekends
//		int[] whWk;	//Range of whole weeks
		int szWW;	//Size of whole weeks
		int ctWd;	//Anzahl Werktage: countWorkingdays
		int ctPr;	//amount of physicians
		
		//Sheet "Personal"
		shIn = wbIn.getSheet("Personal");
		int[][] qual = new int[Personen.size()][Dienste.size()];	//Qualifikation
		int mxWs;	//aufeinanderfolgende Arbeitstage (7)
		int bdDB;	//Amount of days between Bereitschaftsdienst
//		int[] ioRn;	//Range 0 - 4: working patterns in intensivecare 
//		int[] bdDR;	//Range 0 - (bdDB-1) for BD shifts
//		int[] wsRn;	//0 - mxWs: used for workstrech condition: eigtl. 1 - 5 
		int mnWf;	//minimum free weekends free (2) 
		int wdWe;	//Working Days a Week
		int mnFA; 	//Mindestanzahl an FA anwesend
		float tmAc; //multiple of contract working time (1.5) upper bound
		float avgA;	//multiple of contract working time (1.2) upper bound in 26-week cycle 
		float avgO;	//multiple of contract working time (0.3) upper bound in 26-week cycle with opt-out
		float tmAL;	//average time account limit
		int pdAL;	//payed Account limit 
		
		//Sheet "Neuplanung"
		shIn = wbIn.getSheet("Neuplanung");
		int dNew; 	//Tag an dem Neugeplant wird
		int ynNW; 	//Decision for replanning: yes/no
		TInput[] inpt;// = new TInput[];	//Input for replanning
		TInput[] rqNw;	//requests for replanning
		TInput[] inNw;	//Eintrag neuplanung
		
// already initialized in readInTage		int ctDs;	//amount of days in month
		int[] TFVl;	//Target function values
		float alph;	//weight for target function values
	
		
	}
	
	public String getName(Person person){
		return person.name;
	}
	
	public int sizeOfPersonen(){
		return Personen.size();
	}
	public int sizeOfTage(){
		return Tage.size();
	}
	public int sizeOfDienste(){
		return Dienste.size();
	}

	public void fillIn(){
		Sheet sh = wb.getSheet("Personal");
		System.out.println(sh.getSheetName() + " wurde gefunden");
		String tmp = ""; 
		
		for(int i = 1; i < 30; i++){
			Row rw = sh.getRow(i);
			for(int j = 0; j < 2; j++){
				Cell c = rw.getCell(j);
				tmp = c.toString();
				test.add(tmp);
			}
		}
	System.out.println("Testgröße: "+ test.size());
	}
}