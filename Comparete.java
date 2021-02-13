import java.util.Comparator;

public class Comparete implements Comparator<Patient> 
{ 
    public int compare(Patient patient1, Patient patient2) 
    { 
        return patient1.getPatientName().compareTo(patient2.getPatientName()); 
    } 
} 