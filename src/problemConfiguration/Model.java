package problemConfiguration;

import java.util.ArrayList;


public class Model {
	
	private String name;
	
	public ArrayList<String> sets;
	public ArrayList<String> constraints;
	private Data dat;
	
	Model(String Name){
		sets = new ArrayList<String>();
		constraints = new ArrayList<String>();
		this.name = Name;
		
		sets.add("Personen");
		sets.add("Tage");
		sets.add("Dienste");
		sets.add("TInputs");
		
		dat = new Data("11-15_Modell_modified.xlsm");
		
		addNBB1();
	}
	
	public String getCName(){
		return this.name;
	}
	
	
	private void addNBB1(){
		String tmp = "";
		int pi;
		int di;
		int ti; 
		
		
		for(Person p : dat.Personen){
			for(Dienst d : dat.Dienste){
				pi = dat.Personen.indexOf(p);
				di = dat.Dienste.indexOf(d);
				constraints.add(ciDrei(pi, di, "x") + "== 1");
			}
		}
		
		constraints.add(tmp);
	}
	
	private String ciDrei(int i1, int i2, String ausdruck){
		String tmp = "";
		for(Tag t : dat.Tage){
			tmp = tmp + ausdruck + "[" + i1 + "," + i2 + "," + dat.Tage.indexOf(t) + "] +"; 
		}
		tmp = tmp.substring(0, tmp.length()-1);
		System.out.println("TEMP: "+tmp);
		return tmp;
	}
	
	
}
