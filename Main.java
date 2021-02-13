import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException{
		InterfaceDAO patientData = new PatientDAO();
		InterfaceDAO admissionData = new AdmissionDAO();
		Updater update = new Updater(args[0], patientData, admissionData);
	}
}
