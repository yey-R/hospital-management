import java.util.ArrayList;

public class Admission{
	private int admissionID;
	private int patientID;
	private ArrayList<IExamination> examination = new ArrayList<>();
	public Admission(int ... ID) {
		this.admissionID = ID[0];
		this.patientID = ID[1];
	}
	@Override
	public String toString() {
		return String.format("%d\t%d", getAdmissionID(), getPatientID());
	}
	public void addExamination(IExamination examination) {
		this.examination.add(examination);
	}
	public ArrayList<IExamination> getExamination() {
		return examination;
	}
	public void setAdmissionID(int admissionID) {
		this.admissionID = admissionID;
	}
	public int getAdmissionID() {
		return admissionID;
	}
	public int getPatientID() {
		return patientID;
	}
}
