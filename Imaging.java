public class Imaging extends ExaminationDecorator{
	public Imaging() {
		
	}
	public Imaging(IExamination examination) {
		super(examination);
	}
	@Override
	public int getCost() {
		return tempExamination.getCost() + 10;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + " Imaging";
	}	
}
