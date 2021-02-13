import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class AdmissionFile implements IFile{
	ArrayList<String> info;
	final static String fileName = "admission.txt";
	@Override
    public ArrayList<String> readFile() {
        try {
            ArrayList<String> info =new ArrayList<String>();
            for (String line:Files.readAllLines(Paths.get(fileName))) {
                info.add(line);
            }
            return info;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

	@Override
	public void writeFile(ArrayList<?> toWrite) throws IOException {
		FileWriter fileWriter = new FileWriter(fileName);
		BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
	    PrintWriter output = new PrintWriter(bufferWriter);
	    for(Object records : toWrite) {
	    	output.println(((Admission) records).toString());
	    	for(int index = 0; index < ((Admission) records).getExamination().size(); index++) {
	    		int subStringIndex = ((((Admission) records).getExamination().get(index).getDescription().contains("Inpatient"))) ? "Inpatient".split("").length : "Outpatient".split("").length;
	    		String writeTo = (((Admission) records).getExamination().get(index).getDescription()).substring(0, subStringIndex) + "\t" + 
	    				(((Admission) records).getExamination().get(index).getDescription()).substring(subStringIndex +1);
	    		output.println(writeTo);
	    	}
	    }
	    output.close();
    }		

}
