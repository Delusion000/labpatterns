package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SymptomRecord {
    private Map<Symptom, Integer> symptoms = new HashMap<>();
    private List<Symptom> symptomsmed=new ArrayList<Symptom>();
    
    // Agregar un síntoma con su peso
    public void addSymptom(Symptom symptom, Integer weight) {
        symptoms.put(symptom, weight);
    }

    // Agregar un síntoma por nombre
    public Symptom addSymptomByName(String symptomName, Integer weight) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom == null) {
            symptom = FactorySymptoms.getInstance().createSymptom(symptomName);
            symptoms.put(symptom, weight);
        }
        return symptom;
    }
    
    public Symptom addSymptomByNameMed(String symptom) {
    	Symptom s2=null;
		Symptom s= getSymptomByName(symptom);
		if (s==null) {

			s2= FactorySymptoms.getInstance().createSymptom(symptom);
			symptomsmed.add(s2);
		}
		return s2;
    	
    }

    // Eliminar un síntoma por nombre
    public Symptom removeSymptomByName(String symptomName) {
        Symptom symptom = getSymptomByName(symptomName);
        if (symptom != null) {
            symptoms.remove(symptom);
        }
        return symptom;
    }

    // Obtener un síntoma por nombre
    public Symptom getSymptomByName(String symptomName) {
        for (Symptom symptom : symptoms.keySet()) {
            if (symptom.getName().equals(symptomName)) {
                return symptom;
            }
        }
        return null;
    }

    // Obtener todos los síntomas
    public Set<Symptom> getSymptoms() {
        return symptoms.keySet();
    }

    // Obtener el peso de un síntoma
    public int getWeight(Symptom symptom) {
        return symptoms.getOrDefault(symptom, 0);
    }

    // Obtener el mapa de síntomas
    public Map<Symptom, Integer> getSymptomsMap() {
        return symptoms;
    }
    
    // Método para obtener un iterador sobre los síntomas
    public Iterator<Symptom> iterator() {
        return symptoms.keySet().iterator();
    }
    
    public void removeSymptom(Symptom s){
		symptoms.remove(s);
	}
}
