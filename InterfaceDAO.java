import java.io.IOException;
import java.util.ArrayList;

public interface InterfaceDAO {
	Object getByID(int ID);
	void deleteByID(int ID) throws IOException;
	void add(String ... info) throws IOException;
	ArrayList<?> getALL();
}
