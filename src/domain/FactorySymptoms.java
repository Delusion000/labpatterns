package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class FactorySymptoms {
    // Singleton instance
    private static FactorySymptoms instance;
    // Map to store unique instances of each symptom
    private Map<String, Symptom> symptomMap;
    // Map to store custom registration of symptoms with their respective creation logic
    private Map<String, BiFunction<String, Integer, Symptom>> customSymptomRegistry;

    // Private constructor for Singleton pattern
    private FactorySymptoms() {
        symptomMap = new HashMap<>();
        customSymptomRegistry = new HashMap<>();
        registerDefaultSymptoms();
    }

    // Public method to get the single instance of FactorySymptoms
    public static FactorySymptoms getInstance() {
        if (instance == null) {
            instance = new FactorySymptoms();
        }
        return instance;
    }

    // Method to register a new symptom dynamically
    public void registerSymptom(String symptomName, int index, int impact, Class<? extends Symptom> symptomType) {
        // Define the creation logic based on the symptom type
        BiFunction<String, Integer, Symptom> creationLogic = (name, idx) -> {
            if (DigestiveSymptom.class.equals(symptomType)) {
                return new DigestiveSymptom(name, idx, impact);
            } else if (NeuroMuscularSymptom.class.equals(symptomType)) {
                return new NeuroMuscularSymptom(name, idx, impact);
            } else if (RespiratorySymptom.class.equals(symptomType)) {
                return new RespiratorySymptom(name, idx, impact);
            }
            return null; // Default case if type is not recognized
        };
        // Register the symptom creation logic in the registry
        customSymptomRegistry.put(symptomName, creationLogic);
        // Add the symptom to the symptomMap if it does not already exist
        if (!symptomMap.containsKey(symptomName)) {
            symptomMap.put(symptomName, creationLogic.apply(symptomName, index));
        }
    }

    // Method to create a symptom by name, checking the registry first
    public Symptom createSymptom(String symptomName) {
        // Check if the symptom already exists in the map
        if (symptomMap.containsKey(symptomName)) {
            return symptomMap.get(symptomName); // Return existing instance
        }

        // If not in the map, check in the custom registry
        BiFunction<String, Integer, Symptom> creationLogic = customSymptomRegistry.get(symptomName);
        if (creationLogic != null) {
            Symptom symptom = creationLogic.apply(symptomName, 0); // The index is provided in registration
            symptomMap.put(symptomName, symptom);
            return symptom;
        }

        return null; // Returns null if the symptom is not registered
    }

    // Register the default symptoms (this method can include pre-defined symptoms)
    private void registerDefaultSymptoms() {
        List<String> impact5 = Arrays.asList("fiebre", "tos seca", "astenia", "expectoracion");
        List<Double> index5 = Arrays.asList(87.9, 67.7, 38.1, 33.4);
        List<String> impact3 = Arrays.asList("disnea", "dolor de garganta", "cefalea", "mialgia", "escalofrios");
        List<Double> index3 = Arrays.asList(18.6, 13.9, 13.6, 14.8, 11.4);
        List<String> impact1 = Arrays.asList("nauseas", "vómitos", "congestión nasal", "diarrea", "hemoptisis", "congestion conjuntival");
        List<Double> index1 = Arrays.asList(5.0, 4.8, 3.7, 0.9, 0.8, 0.5);

        // Register default symptoms using registerSymptom
        for (int i = 0; i < impact5.size(); i++) {
            registerSymptom(impact5.get(i), index5.get(i).intValue(), 5, NeuroMuscularSymptom.class);
        }
        for (int i = 0; i < impact3.size(); i++) {
            registerSymptom(impact3.get(i), index3.get(i).intValue(), 3, RespiratorySymptom.class);
        }
        for (int i = 0; i < impact1.size(); i++) {
            registerSymptom(impact1.get(i), index1.get(i).intValue(), 1, DigestiveSymptom.class);
        }
    }
}
