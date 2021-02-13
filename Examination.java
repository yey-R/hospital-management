import java.util.ArrayList;

public class Examination implements IExamination{
	private ArrayList<IExamination> operations = new ArrayList<>();
	@Override
	public int getCost() {
		return 0;
	}
	@Override
	public String getDescription() {
			return "";
	}
	@Override
	public void addOperaiton(IExamination operations) {
		this.operations.add(operations);

	}
	@Override
	public String[][] getListOperation() {
		String[][] allOperations = new String[operations.size()][operations.size()];
		int index = 0;
		for(IExamination operation : operations) {
			allOperations[index][0] = operation.getDescription();
			allOperations[index][1] = String.valueOf(operation.getCost());
			index++;
		}
		return allOperations;
	}
}
