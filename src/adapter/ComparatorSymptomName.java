package adapter;
import java.util.Comparator;

import domain.Symptom;

public class ComparatorSymptomName implements Comparator<Object> {
    @Override
    public int compare(Object o1, Object o2) {
        Symptom s1 = (Symptom) o1;
        Symptom s2 = (Symptom) o2;
        return s1.getName().compareTo(s2.getName());
    }
}


