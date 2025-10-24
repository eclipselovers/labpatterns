package domain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Set;

import factory.SymptomFactory;
import iterator.Covid19PacientIterator;

public class Covid19Pacient extends Observable {
	private String  name; 
	private int age;
	private Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();
	private SymptomFactory factory = new SymptomFactory();

	public Covid19Pacient(String name, int years) {
		this.name = name;
		this.age = years;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getWeight(ISymptom s) {
		return symptoms.get(s);
	}

	public Set<Symptom> getSymptoms() {
		return symptoms.keySet();
	}
	
	public ISymptom getSymptomByName(String symptomName) {
		Iterator<Symptom> i= getSymptoms().iterator();
		ISymptom s=null;
		while (i.hasNext()) {
			s=i.next();
			if (s!=null && s.getName().equals(symptomName)) return s;
		}
		return null;	
	}

	public void addSymptom(Symptom c, Integer w){
		symptoms.put(c,w);
		// notify observers that state changed
		setChanged();
		notifyObservers(c);
	}
	
	public ISymptom addSymptomByName(String symptom, Integer w){
		Symptom s=null;
		s=factory.createSymptom(symptom); 
		if (s!=null) {
			symptoms.put(s,w);
			// notify observers that state changed
			setChanged();
			notifyObservers(s);
		}		
		return s;
	}

	public ISymptom removeSymptomByName(String symptomName) {
		ISymptom s=getSymptomByName(symptomName);
		System.out.println("Simptom to remove: "+s);
		if (s!=null) {
			symptoms.remove(s);
			// notify observers that state changed
			setChanged();
			notifyObservers(s);
		}
		return s;
	}
	public Iterator iterator() {
		return new Covid19PacientIterator(this.symptoms.keySet());
	}
	
	public double covidImpact() {
		double afection=0;
		double increment=0;
		double impact=0;
		
		//calculate afection
		for (ISymptom c: symptoms.keySet()) {
			if (c!=null )
			   afection=afection+c.getSeverityIndex()*symptoms.get(c);
		}
		afection=afection/symptoms.size();
		
		//calculate increment
		if (getAge()>65) increment=afection*0.5;
		
		//calculate impact
		impact=afection+increment;
		return impact;
	}
}