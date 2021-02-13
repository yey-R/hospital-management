import java.io.IOException;
import java.util.ArrayList;

public class PatientDAO implements InterfaceDAO{
	private ArrayList<Patient> patientList;
	private IFile patientFile;
	public PatientDAO() throws IOException {
		patientFile = new PatientFile();
		patientList = new ArrayList<>();
		ArrayList<String> initialPatients = patientFile.readFile();
		for(String info: initialPatients) {
			add(info);
		}
	}
	
	@Override
	public void add(String ... info) throws IOException {
		Patient patient = new Patient(Integer.parseInt(info[0].split("\t")[0]), info[0].split("\t")[1].split(" ")[0], 
				info[0].split("\t")[1].split(" ")[1], info[0].split("\t")[2], info[0].split("\t")[3]);
		patientList.add(patient);
		sortPatientList();
		patientFile.writeFile(getALL());
	}

	@Override
	public void deleteByID(int patientID) throws IOException {
		for (int index = 0; index<patientList.size(); index++) {
			if(patientList.get(index).getPatientID() == patientID) {
				patientList.remove(index);
			}
			else {
				continue;
			}
		}
		patientFile.writeFile(getALL());
	}
	
	@Override
	public Object getByID(int ID) {
		for(int index = 0; index < patientList.size(); index++) {
			if(ID == patientList.get(index).getPatientID())
				return patientList.get(index);
		}
		return null;
	}
	
	@Override
	public ArrayList<?> getALL() {	
		return patientList;
	}
	
	public void sortPatientList() {
		int patientIndexSort = patientList.size()-1;
		for(int patientIndexCompare = patientList.size()-2; -1 < patientIndexCompare ; patientIndexCompare--) {
			if(patientList.get(patientIndexSort).getPatientID() < patientList.get(patientIndexCompare).getPatientID()) {
				Patient tempPatient = patientList.get(patientIndexCompare);
				patientList.set(patientIndexCompare, patientList.get(patientIndexSort));
				patientList.set(patientIndexSort, tempPatient);
				patientIndexSort--;
			}
			else {
				break;
			}
		}
	}
}
