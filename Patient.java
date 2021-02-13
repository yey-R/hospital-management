public class Patient {
	private int patientID;
	private String patientName;
	private String patientSurname;
	private String patientPhone;
	private String patientAdress;
	private Admission admissionInfo;
	public Patient(int patientID, String ... info) {
		this.patientID = patientID;
		this.patientName = info[0];
		this.patientSurname = info[1];
		this.patientPhone = info[2];
		this.patientAdress = (info[3].contains("Address:")) ? info[3] : "Address: " + info[3];

	}
	@Override
	public String toString() {
		return String.format("%d\t%s %s\t%s\t%s", getPatientID(), getPatientName(), getPatientSurname(), getPatientPhone(), getPatientAdress());
	}
	public int getPatientID() {
		return patientID;
	}
	public void setPatientID(int patientID) {
		this.patientID = patientID;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public String getPatientAdress() {
		return patientAdress;
	}
	public void setPatientAdress(String patientAdress) {
		this.patientAdress = patientAdress;
	}
	public String getPatientPhone() {
		return patientPhone;
	}
	public void setPatientPhone(String patientPhone) {
		this.patientPhone = patientPhone;
	}
	public Admission getAdmissionInfo() {
		return admissionInfo;
	}
	public void setAdmissionInfo(Admission admissionInfo) {
		this.admissionInfo = admissionInfo;
	}
}
