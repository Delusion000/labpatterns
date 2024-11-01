package domain;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Covid19Pacient {
	private String  name; 
	private int age;
	private SymptomRecord symptomRecord;
	private Map<Symptom,Integer> symptoms=new HashMap<Symptom,Integer>();
	
	public Covid19Pacient(String name, int years) {
		this.name = name;
		this.age = years;
		this.symptomRecord = new SymptomRecord();
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
	
	 // Delegar operaciones de síntomas a SymptomsRecord
    public void addSymptom(Symptom symptom, Integer weight) {
        symptomRecord.addSymptom(symptom, weight);
    }

    public Symptom addSymptomByName(String symptomName, Integer weight) {
        return symptomRecord.addSymptomByName(symptomName, weight);
    }

    public Symptom removeSymptomByName(String symptomName) {
        return symptomRecord.removeSymptomByName(symptomName);
    }

    public Set<Symptom> getSymptoms() {
        return symptomRecord.getSymptoms();
    }

    public int getWeight(Symptom symptom) {
        return symptomRecord.getWeight(symptom);
    }
    
    public Symptom getSymptomByName(String symptom){
    	return symptomRecord.getSymptomByName(symptom);
    	
    }
	
	public Map<Symptom, Integer> getSymptomsMap() {
	    return symptomRecord.getSymptomsMap();
	    }

	public Iterator<Symptom> iterator() {
        return symptomRecord.iterator();
    }
}

