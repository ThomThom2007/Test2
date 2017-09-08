package problemConfiguration;

public class Parameter {
	/**
	 * Parameter erst nach den Mengen erzeugen, 
	 * Mengen werden benötigt um die Parameter Arrays zu definieren.
	 */
	public static int 		bgWk;		//Anfangswoche
	public static int 		ctWk;		//Anzahl Wochen
	public static int[] 	week; 	//Range Wochen 0..AnzahlWochen
	public static int 		lsWe;		//Letztes Wochenende
	public static int 		ctWe;		//Anzahl Wochenenden
	public static int[] 	whWk; 	//Range ganze WOchen	1..lsWe
	public static int 		szWh;		//Amount of whole weeks: Anzahl ganze Wochen
	
	public static int[][]	demC;	//Demand matrix physicians		Dienste		Tage
	public static int[][]	demF;	//Demand matrix Facharzt		Dienste		Tage
	public static int[][]	demO;	//Demand matrix Oberarzt		Dienste		Tage
	public static int[][]	qual;	//Qualifikation					Personal	Dienste
	public static int 		ctWd;	//Anzahl Werktage: countWorkingdays
	public static int 		mxWs;	//aufeinanderfolgende Arbeitstage (7)
	public static int[] 	wsRn;	//0 - mxWs: used for workstrech condition	
	public static int[] 	ioRn;	//Range 0 - 4: wokring patterns in intensivecare 
	public static int 		bdDB;	//Amount of days between Bereitschaftsdienst
	public static int[] 	bdDR;	//Range 0 - (bdDB-1) for BD shifts
	public static int 		mnWf;	//minimum free weekends free (2) 
	public static int 		ctDs;	//amount of days in month
	public static int 		ctPh;	//amount of physicians
	public static int[][] 	wdWe;	//Working Days a Week
	public static int 		mnFA; 	//Mindestanzahl an FA anwesend
	public static double 	tmAc; 	//multiple of contract working time (1.5) upper bound
	public static double 	avgA;	//multiple of contract working time (1.2) upper bound in 26-week cycle 
	public static double 	avgO;	//multiple of contract working time (0.3) upper bound in 26-week cycle with opt-out
	public static double[] 	tmAL;	//average time account limit
	
	public static String[] 	tFVl;	//Target function values
	public static double[] 	alph;	//weight for target function values		TFVl
	
	public static int 		pdAL;	//payed Account limit 
	public static int 		dNew; 	//Tag an dem Neugeplant wird
	public static int 		ynNW; 	//Decision for replanning: yes/no
	public static TInput[] 	inNW;	//Input for replanning
	public static TInput[] 	rqNw;	//requests for replanning
	public static TInput[] 	inNw;	//Eintrag neuplanung
	
	
}


/*
int 		c[Dienste][Tage]		=...;					//Matrix für die Nachfrage (Mindestanzahl an benötigten Ärzten pro Tag)
int 		cf[Dienste][Tage]		=...;					//Matrix für die Personalstruktur an FA oder höher (OA,CA)
int 		co[Dienste][Tage]		=...;					//Matrix für die Personalstruktur an OA odder höher (CA)
int 		q[Personal][Dienste]	=...;					//Qualifikation: 1-0 Matrix um zu kennzeichnen, welcher Arzt welche Schichten ausführt oder ausführen darf
int 		AnzahlWerktage			=...;					//Anzahl an Werktage im aktuellen Monat
int 		MaxWorkstrech			=...;					//Anzahl an aufeinanderfolgenden Arbeitstagen (Standardwert: 7)
range 		WorkstrechRange 		= 0..MaxWorkstrech;		//Range von 0 bis MaxWorkstrech; wird für Bedingung Workstrech benötigt
range 		IOPRange 				= 1..5;					//Range von 1 bis 5 für Arbeitsmuster auf Intensivstation
int			BDTageDazw				=...;					//Anzahl an Tagen die zwischen zwei Bereitschaftsdiensten liegen (Standardwert: 3)
range 		BDTageRange 			= 1..BDTageDazw;		//Range von 1 bis BDTageDazw für BD-Dienste
int 		MinWeFrei 				=...;					//Mindestanzahl an freien WEs (Standardwert: 2)
int 		AnzahlTage				=...;					//Anzahl an Tagen im Monat
int 		AnzahlPersonal			=...;					//Anzahl an Ärzten
int 		ATageWoche[Personal][Wochen]		=...;		
int			FAMin					=...;					//Mindestanzahl an FA anwesend rund um die Uhr (Standardwert: 1)
float		ZeitktoGrenze			=...;					//Vielfaches der Vertragszeit (Standardwert: 1.5), Obergrenze Zeitkonto
float		SchnittktoGrenze		=...;					//Vielfaches der Vertragszeit (Standardwert: 1.2), Obergrenze 26-Wochen-Durchschnittskonto
float		SchnittktoOpt			=...;					//Vielfaches der Vertragszeit (Standardwert: 0.3), Obergrenze 26-Wochen-Durchschnittskonto erhöht sich bei Opt-Out
float		AzSchnittktoGrenze[p in Personal]=SchnittktoGrenze+p.optout*SchnittktoOpt;		//Obergrenze 26-Wochen-Durchschnittskonto
{string} 	ZF=...;								
float 		alpha[ZF]=...;									//Gewichte für die Zielfunktion

//Erweiterungen
int			BezahlktoGrenze			=...;					//Erweiterung Bezahlkonto, Obergrenze Bezahlkonto
int 		tNeuplanung				=...;					//Tag an dem neugeplant wird
int 		NeuplanungJaNein		=...;					//1: Neuplanung Ja, 0: keine Neuplanung
{TInput} 	InputNeuplanung			=...;					//Menge für den Input bei Neuplanung
{TInput} 	RequestNeuplanung		=...;					//Menge für den Input mit möglichst wenig Abweichungen im Falle der Neuplanung
{TInput} 	EintragNeuplanung		=...;
*/