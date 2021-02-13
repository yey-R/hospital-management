public class Tests extends ExaminationDecorator{
	public Tests() {
		
	}
	public Tests(IExamination examination) {
		super(examination);
	}
	
	@Override
	public int getCost() {
		return tempExamination.getCost() + 7;
	}
	
	@Override
	public String getDescription() {
		return tempExamination.getDescription() + " Tests";
	}
}
