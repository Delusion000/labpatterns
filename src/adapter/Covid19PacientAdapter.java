package adapter;

import java.util.ArrayList;
import java.util.List;	

import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientAdapter implements InvertedIterator {
    private List<Symptom> symptomsList;
    private int currentIndex;

    public Covid19PacientAdapter(Covid19Pacient pacient) {
        this.symptomsList = new ArrayList<>(pacient.getSymptomsMap().keySet());
        goLast();
    }

    @Override
    public void goLast() {
        currentIndex = symptomsList.size() - 1;
    }

    @Override
    public boolean hasPrevious() {
        return currentIndex >= 0;
    }

    @Override
    public Object previous() {
        return symptomsList.get(currentIndex--);
    }
}

