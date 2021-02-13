import java.io.IOException;
import java.util.ArrayList;

public interface IFile {
	ArrayList<String> readFile();
	void writeFile(ArrayList<?> toWrite) throws IOException;
}
