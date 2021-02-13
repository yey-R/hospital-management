import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class InputFile implements IFile{
	ArrayList<String> info;
	String fileName;
	public InputFile (String fileName) {
		this.fileName = fileName;
	}
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
	public void writeFile(ArrayList<?> toWrite) throws IOException {}		

}
