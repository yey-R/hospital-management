public interface IExamination {
	int getCost();
	String getDescription();
	void addOperaiton(IExamination iExamination);
	String[][] getListOperation();
}