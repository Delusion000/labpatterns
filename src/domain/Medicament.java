package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Medicament {
	private String name;
	private SymptomRecord symptomRecord;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Medicament(String name) {
		super();
		this.name = name;
	}

	public Symptom addSymptomByNameMed(String symptom){
		return symptomRecord.addSymptomByNameMed(symptom);
	}
	
	public void removeSymptom(Symptom s){
		symptomRecord.removeSymptom(s);
	}
	
	public Iterator<Symptom> getSymptoms() {
		return symptomRecord.iterator();
	}
	
	public Symptom getSymptomByName(String symptomName) {
		return symptomRecord.getSymptomByName(symptomName);	
	}
	
	public Symptom removeSymptomByName(String symptomName) {
		return symptomRecord.removeSymptomByName(symptomName);
	}
	
}
