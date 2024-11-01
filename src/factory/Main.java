package factory;

import domain.Covid19Pacient;
import domain.DigestiveSymptom;
import domain.FactorySymptoms;
import domain.Medicament;
import domain.Symptom;

public class Main {

	public static void main(String[] args) {
		Covid19Pacient p1=new Covid19Pacient("aitor", 35);
		new PacientSymptomGUI(p1);
		
		//double impact = CovidImpactCalculator.calculateImpact(p1);
		
		FactorySymptoms factory = FactorySymptoms.getInstance();
		factory.registerSymptom("mareos", 2, 1, DigestiveSymptom.class);

		
		
		//Medicament	m=new Medicament("Ibuprofeno");
		//MedicalGUI	mgui=new MedicalGUI(m);
				
	}

	
}
