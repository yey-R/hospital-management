public class Inpatient extends ExaminationDecorator{
	public Inpatient() {
		
	}
	public Inpatient(IExamination examination) {
		super(examination);
	}
	
	@Override
	public int getCost() {
		return tempExamination.getCost() + 10;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + "Intpatient";
	}
}
