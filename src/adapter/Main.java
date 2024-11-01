package adapter;

import java.util.Iterator;

import domain.Covid19Pacient;
import domain.Symptom;

public class Main {
	public static void main(String[] args) {
     
        Covid19Pacient pacient = new Covid19Pacient("John Doe", 30);
        pacient.addSymptom(new Symptom("Cough", 5, 3), 3);
        pacient.addSymptom(new Symptom("Fever", 7, 4), 4);
        pacient.addSymptom(new Symptom("Fatigue", 3, 2), 2);
        pacient.addSymptom(new Symptom("Headache", 2, 1), 1);
        pacient.addSymptom(new Symptom("Loss of Smell", 6, 5), 5);

        // Crear el adaptador del paciente
        InvertedIterator pacientAdapter = new Covid19PacientAdapter(pacient);

        // Ordenar e imprimir por nombre de síntoma
        System.out.println("Ordenado por symptomName:");
        Iterator<Object> sortedByName = Sorting.sortedIterator(pacientAdapter, new ComparatorSymptomName());
        sortedByName.forEachRemaining(System.out::println);

        // Ordenar e imprimir por índice de severidad
        System.out.println("\nOrdenado por severityIndex:");
        Iterator<Object> sortedBySeverity = Sorting.sortedIterator(pacientAdapter, new ComparatorSeverityIndex());
        sortedBySeverity.forEachRemaining(System.out::println);
    }
}
