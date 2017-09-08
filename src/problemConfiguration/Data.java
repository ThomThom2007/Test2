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
		
		Row rwIn = shIn.getRow(0);
		Cell clIn = rwIn.getCell(50);
		
		double lsRow = clIn.getNumericCellValue();
		int ilsRow = (int)(lsRow);
		
		for(int i = 1;i <= ilsRow; i++){
			int column = 0; 
			rwIn = shIn.getRow(i);
			
			clIn = rwIn.getCell((column + 0));
			name = clIn.getStringCellValue();
			if(name == "")break;
			
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
		int timehorizon = (int)clIn.getNumericCellValue();
		timehorizon = 50;
		
		for(int i = startRow; i < (startRow + timehorizon); i++){	//Startzeile + Anzahl Tagee (Parameter) 
			int column = startColumn; 
			rwIn = shIn.getRow(i);
			
			day = (int)rwIn.getCell(column + 0).getNumericCellValue();
			weekday = rwIn.getCell(column + 1).getStringCellValue();
			feiertag = (int)rwIn.getCell(column + 2).getNumericCellValue();
			month = rwIn.getCell(column + 3).getStringCellValue();
			group = rwIn.getCell(column + 4).getStringCellValue();
			week = (int)rwIn.getCell(column + 5).getNumericCellValue();
			
			if(weekday == "") break;
			
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
		int anzahlDienste = (int)shIn.getRow(0).getCell(29).getNumericCellValue();
		
		for(int i = startRow; i < (startRow + anzahlDienste); i++){
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
	
	public void readInEintrag(){
		
	}
	
	public void readInParameter(){
		/**
		 * Liest die benötigten Parameter ein
		 * Ranges werden nicht unbedingt benötigt
		 */
		Workbook wbIn = wb;
		Sheet shIn;
		
		shIn = wb.getSheet("Tage");
		Parameter.bgWk = (int)shIn.getRow(1).getCell(15).getNumericCellValue();			//Anfangswoche
		Parameter.ctWk = (int)shIn.getRow(0).getCell(19).getNumericCellValue();;		//Anzahl Wochen
		Parameter.week = new int[Parameter.ctWk+1]; 	//Range Wochen 0..AnzahlWochen
		for(int i = 0; i<=Parameter.ctWk;i++){
			Parameter.week[i] = i;
		}
		Parameter.lsWe = (int)shIn.getRow(3).getCell(19).getNumericCellValue();;		//Letztes Wochenende
		Parameter.ctWe = (int)shIn.getRow(2).getCell(19).getNumericCellValue();;		//Anzahl Wochenenden	5
		Parameter.whWk = new int[(Parameter.lsWe)]; 	//Range ganze WOchen	value 1..lsWe with index 0 - 4
		for(int i = 0; i<Parameter.lsWe;i++){
			Parameter.whWk[i] = i+1;
		}
		Parameter.szWh = Parameter.whWk.length;		//Amount of whole weeks: Anzahl ganze Wochen
		Parameter.ctWd = (int)shIn.getRow(1).getCell(19).getNumericCellValue();	//Anzahl Werktage: countWorkingdays
		Parameter.ctDs = (int)shIn.getRow(0).getCell(8).getNumericCellValue();			//amount of days in month
		
		shIn = wb.getSheet("Nachfrage");
		Parameter.demC = new int[Dienste.size()][Tage.size()];		//Demand matrix physicians		Dienste		Tage
		System.out.println("Dienste size: " + Dienste.size());
		System.out.println("Tage size: " + Tage.size());
		System.out.println("Personen size: " + Personen.size()); 
		for(int i = 0; i < Dienste.size();i++){
			for(int j = 0; j < Tage.size();j++){
				Parameter.demC[i][j] = (int)shIn.getRow((1+i)).getCell((8+j)).getNumericCellValue();	//ab I2 weil erst ab dem 1. des Monats Bedarfe berücksichtigt werden
			}
		}
		
		shIn = wb.getSheet("NachfrageFA");
		Parameter.demF = new int[Dienste.size()][Tage.size()];		//Demand matrix Facharzt		Dienste		Tage
		for(int i = 0; i < Dienste.size();i++){
			for(int j = 0; j < Tage.size();j++){
				Parameter.demF[i][j] = (int)shIn.getRow((1+i)).getCell((8+j)).getNumericCellValue();	//ab I2 weil erst ab dem 1. des Monats Bedarfe berücksichtigt werden
			}
		}
		
		shIn = wb.getSheet("NachfrageOA");
		Parameter.demO = new int[Dienste.size()][Tage.size()];		//Demand matrix Oberarzt		Dienste		Tage
		for(int i = 0; i < Dienste.size();i++){
			for(int j = 0; j < Tage.size();j++){
				Parameter.demO[i][j] = (int)shIn.getRow((1+i)).getCell((8+j)).getNumericCellValue();	//ab I2 weil erst ab dem 1. des Monats Bedarfe berücksichtigt werden
			}
		}
		
		shIn = wb.getSheet("Personal");
		Parameter.qual = new int[Personen.size()][Dienste.size()];	//Qualifikation					Personal	Dienste
		for(int i = 0; i < Personen.size();i++){
				for(int j = 0; j < Dienste.size();j++){
					Parameter.qual[i][j] = (int)shIn.getRow((1+i)).getCell((14+j)).getNumericCellValue();	//ab O2 
				}
		}

		Parameter.mxWs = (int)shIn.getRow(9).getCell(50).getNumericCellValue();	//aufeinanderfolgende Arbeitstage (7)
//		Parameter.wsRn;	//0 - mxWs: used for workstrech condition	
//		for...
//		Parameter.ioRn;	//Range 0 - 4: wokring patterns in ensivecare 
//		for...
		Parameter.bdDB = (int)shIn.getRow(11).getCell(50).getNumericCellValue();	//Amount of days between Bereitschaftsdienst
//		Parameter.bdDR;	//Range 0 - (bdDB-1) for BD shifts
//		for...
		Parameter.mnWf = (int)shIn.getRow(10).getCell(50).getNumericCellValue();	//minimum free weekends free (2) 
		Parameter.ctPh = (int)shIn.getRow(0).getCell(50).getNumericCellValue();	//amount of physicians
		Parameter.wdWe = new int[Personen.size()][6];		//Working Days a Week
//		for...
		Parameter.mnFA = (int)shIn.getRow(12).getCell(50).getNumericCellValue(); 	//Mindestanzahl an FA anwesend
		Parameter.tmAc = shIn.getRow(13).getCell(50).getNumericCellValue(); 	//multiple of contract working time (1.5) upper bound
		Parameter.avgA = shIn.getRow(14).getCell(50).getNumericCellValue();;	//multiple of contract working time (1.2) upper bound in 26-week cycle 
		Parameter.avgO = shIn.getRow(15).getCell(50).getNumericCellValue();;	//multiple of contract working time (0.3) upper bound in 26-week cycle with opt-out
		Parameter.tmAL = new double[Personen.size()];	//average time account limit
//		for...
		
		shIn = wb.getSheet("Ergebnis");
		Parameter.tFVl = new String[23];	//Target function values
		for(int i = 0; i < Parameter.tFVl.length; i++){
			Parameter.tFVl[i] = shIn.getRow(1+i).getCell(61).getStringCellValue();
		}
		Parameter.alph = new double[23];	//weight for target function values		TFVl
		for(int i = 0; i < Parameter.alph.length; i++){
			Parameter.alph[i] = shIn.getRow(1+i).getCell(62).getNumericCellValue();
		}
		Parameter.pdAL = (int)shIn.getRow(16).getCell(50).getNumericCellValue();		//payed Account limit 
		
		shIn = wb.getSheet("Neuplanung");
		Parameter.dNew = (int)shIn.getRow(3).getCell(11).getNumericCellValue(); 	//Tag an dem Neugeplant wird
		Parameter.ynNW = (int)shIn.getRow(1).getCell(12).getNumericCellValue(); 	//Decision for replanning: yes/no
		//Größe herausfinden!!
		//Solangs bis next row ="" oder so 
		Parameter.inNW = new TInput[20];	//Input for replanning
		Parameter.rqNw = new TInput[20];	//requests for replanning
		Parameter.inNw = new TInput[20];	//Erag neuplanung
		
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