public class DoctorVisit extends ExaminationDecorator{
	public DoctorVisit() {
		
	}
	public DoctorVisit(IExamination examination) {
		super(examination);
	}
	
	@Override
	public int getCost() {
		return tempExamination.getCost() + 15;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + " DoctorVisit";
	}
}
