package observer;

import java.util.Observable;


public class Main {
    public static void main(String args[]) {
        Covid19Pacient2 pacient = new Covid19Pacient2("aitor", 35);
        new PacientObserverGUI(pacient);
        new PacientSymptomGUI((Covid19Pacient2) pacient);
        
        ShowPacientTableGUI gui=new ShowPacientTableGUI(pacient);
		gui.setPreferredSize(
			      new java.awt.Dimension(300, 200));
		gui.setVisible(true);
         
       
		Observable pacient2 = new Covid19Pacient2("pacient2", 35);
        new PacientObserverGUI(pacient2);
        new PacientSymptomGUI((Covid19Pacient2) pacient2);
        new PacientThermometerGUI((Covid19Pacient2) pacient2);
        
    }
}

