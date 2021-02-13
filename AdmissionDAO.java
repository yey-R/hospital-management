import java.io.IOException;
import java.util.ArrayList;
public class AdmissionDAO implements InterfaceDAO{
	private ArrayList<Admission> admissionList;
	protected IFile admissionFile;
	public AdmissionDAO() {
		admissionList = new ArrayList<>();
		admissionFile = new AdmissionFile();
		ArrayList<String> initialAdmission = admissionFile.readFile();
		int tempID = 0;
		for(String info: initialAdmission) {
			try {
				add(info);
				tempID = Integer.parseInt(info.split("\t")[0]);
			}
			catch(Exception e) {
				createExamination(tempID, info); 
			}
		}
	}
	
	@Override
	public void add(String ... info) throws IOException {
		if(info.length == 1) {
			Admission admission = new Admission(Integer.parseInt(info[0].split("\t")[0]), Integer.parseInt(info[0].split("\t")[1]));
			admissionList.add(admission);	
		} 
		else if(info[1].contains("Inpatient") || info[1].contains("Outpatient")){
			createExamination(Integer.parseInt(info[0]), info[1]);
		}
		sortAdmissionList();
		admissionFile.writeFile(getALL());
	}

	@Override
	public void deleteByID(int patientID) throws IOException {
		for (int index = 0; index<admissionList.size(); index++) {
			if(admissionList.get(index).getPatientID() == patientID) {
				admissionList.remove(index);
			}
			else {
				continue;
			}
		}
		admissionFile.writeFile(getALL());
	}
	
	@Override
	public Object getByID(int ID) {
		for(int index = 0; index < admissionList.size(); index++) {
			if(ID == admissionList.get(index).getAdmissionID())
				return admissionList.get(index);
		}
		return null;
	}
	
	@Override
	public ArrayList<?> getALL() {
		return admissionList;
	}
	
	public void createExamination(int ID, String operationStr) {
		IExamination examination = new Examination();
		String operationType = operationStr.split("\t")[0];
		String[] operations = operationStr.split("\t")[1].split(" ");
		IExamination newOperation = null;
		if(operationType.equals("Inpatient")) {
			newOperation = new Inpatient();
		}
		else if(operationType.equals("Outpatient")) {
			newOperation = new Outpatient();
		}
		examination = newOperation;
		for(String operation : operations) {
			
			if(operation.equals("tests")) {
				newOperation = new Tests(examination);
			} 
			else if(operation.equals("imaging")) {
				newOperation = new Imaging(examination);
			} 
			else if(operation.equals("doctorvisit")) {
				newOperation = new DoctorVisit(examination);
			} 
			else if(operation.equals("measurements")) {
				newOperation = new Measurements(examination);
			}
			examination = newOperation;
		}
		examination.addOperaiton(examination);
		((Admission)getByID(ID)).addExamination(examination);
	}
	
	public void sortAdmissionList() {
		int indexSort = admissionList.size() - 1;
		for(int indexCompare = admissionList.size()-2; -1 < indexCompare ; indexCompare--) {
			if(admissionList.get(indexSort).getAdmissionID() < admissionList.get(indexCompare).getAdmissionID()) {
				Admission tempAdmission = admissionList.get(indexCompare);
				admissionList.set(indexCompare, admissionList.get(indexSort));
				admissionList.set(indexSort, tempAdmission);
				indexSort--;
			}
			else {
				break;
			}
		}
	}
}