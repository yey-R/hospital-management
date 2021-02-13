public class Outpatient extends ExaminationDecorator{
	public Outpatient() {
		
	}
	public Outpatient(IExamination examination) {
		super(examination);
	}
	
	@Override
	public int getCost() {
		return tempExamination.getCost() + 15;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + "Outpatient";
	}
}
