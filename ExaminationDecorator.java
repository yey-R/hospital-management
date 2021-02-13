import java.util.ArrayList;

public abstract class ExaminationDecorator implements IExamination {
	protected IExamination tempExamination;
	public ExaminationDecorator() {
		tempExamination = new Examination();
	}
	
	public ExaminationDecorator(IExamination newExamination) {
		tempExamination = newExamination;
	}
	@Override
	public int getCost() {
		return tempExamination.getCost();
	}
	@Override
	public String getDescription() {
		return tempExamination.getDescription();
	}
	
	
	// NOTHING TO USE
	@Override
	public void addOperaiton(IExamination iExamination) {}
	
	@Override
	public String[][] getListOperation() {
		return null;
	}
}
