import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class OutputFile implements IFile{
	ArrayList<String> info;
	final static String fileName = "output.txt";
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
	    	output.println(records.toString());
	    }
	    output.close();
    }		
}
