public class Measurements extends ExaminationDecorator{
	public Measurements() {
		
	}
	public Measurements(IExamination examination) {
		super(examination);
	}
	
	@Override
	public int getCost() {
		return tempExamination.getCost() + 5;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + " Measurement";
	}
}