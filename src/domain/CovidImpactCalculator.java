package domain;

import java.util.Map;
import java.util.Set;

public class CovidImpactCalculator {

    public double calculateImpact(int age, Map<Symptom, Integer> symptoms) {
        double afection = 0;
        double increment = 0;
        double impact = 0;

        // Calcular afection
        for (Symptom c : symptoms.keySet()) {
            if (c != null) {
                afection += c.getSeverityIndex() * symptoms.get(c);
            }
        }
        afection = afection / symptoms.size();

        // Calcular increment
        if (age > 65) {
            increment = afection * 0.5;
        }

        // Calcular impacto total
        impact = afection + increment;
        return impact;
    }

}
