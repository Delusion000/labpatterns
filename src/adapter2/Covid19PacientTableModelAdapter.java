package adapter2;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import domain.Covid19Pacient;
import domain.Symptom;

public class Covid19PacientTableModelAdapter extends AbstractTableModel {
    protected Covid19Pacient pacient;
    protected String[] columnNames = new String[] {"Symptom", "Weight"};
    private List<Symptom> symptoms;

    public Covid19PacientTableModelAdapter(Covid19Pacient p) {
        this.pacient = p;
        this.symptoms = new ArrayList<>(pacient.getSymptoms());
    }

    @Override
    public int getColumnCount() {
        return columnNames.length; // Dos columnas: "Symptom" y "Weight"
    }

    @Override
    public String getColumnName(int i) {
        return columnNames[i]; // Nombre de la columna según el índice
    }

    @Override
    public int getRowCount() {
        return symptoms.size(); // Número de filas es el número de síntomas
    }

    @Override
    public Object getValueAt(int row, int col) {
        Symptom symptom = symptoms.get(row); // Obtener el síntoma de la fila actual
        switch (col) {
            case 0:
                return symptom.getName(); // Nombre del síntoma
            case 1:
                return pacient.getWeight(symptom); // Peso del síntoma obtenido del paciente
            default:
                return null;
        }
    }
}
