import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Updater {
	ArrayList<String> newInputs = new ArrayList<>();
	public Updater(String inputFileName,InterfaceDAO ...DAO) throws IOException {
		IFile inputFile = new InputFile(inputFileName);
		IFile newOutput = new OutputFile();
		newInputs = inputFile.readFile();
		ArrayList<String> outputInfo = new ArrayList<>();
		for(String command : newInputs) {
			if(command.contains("AddPatient")) {
				command = updateCommand(command);
				DAO[0].add(command);
				outputInfo.add("Patient " + command.split("\t")[0] + " " + command.split("\t")[1].split(" ")[0] + " added");
			}
			else if(command.contains("RemovePatient")) {
				command = updateCommand(command);
				outputInfo.add("Patient " + command + " " + ((Patient)DAO[0].getByID(Integer.parseInt(command))).getPatientName() + " removed");
				DAO[0].deleteByID(Integer.parseInt(command));
				DAO[1].deleteByID(Integer.parseInt(command));
			}
			else if(command.contains("CreateAdmission")) {
				command = updateCommand(command);
				DAO[1].add(command);
				outputInfo.add("Admission " + command.split("\t")[0] + " created");
			}
			else if(command.contains("AddExamination")) {
				command = updateCommand(command);
				DAO[1].add(command.split("\t")[0], command.split(command.split("\t")[0]+"\t")[1]);
				outputInfo.add(command.split("\t")[1].split(" ")[0] + " examination added to admission " + command.split("\t")[0]);
			}
			else if(command.contains("TotalCost")) {
				command = updateCommand(command);
				outputInfo.add("TotalCost for admission " + command);
				int ID = Integer.parseInt(command);
				int totalCost = 0;
				for(int index = 0; index < ((Admission)DAO[1].getByID(ID)).getExamination().size(); index++) {
					outputInfo.add("\t" + ((Admission)DAO[1].getByID(ID)).getExamination().get(index).getDescription() + " " + ((Admission)DAO[1].getByID(ID)).getExamination().get(index).getCost() + "$");
					totalCost += ((Admission)DAO[1].getByID(ID)).getExamination().get(index).getCost();
				}
				outputInfo.add("\tTotal: " + totalCost + "$");
			}
			else if(command.contains("ListPatients")) {
				outputInfo.add("Patient List:");
				Collections.sort(((ArrayList<Patient>) DAO[0].getALL()), new Comparete()); 
				for(int index = 0; index < DAO[0].getALL().size(); index++) {
					outputInfo.add(((Patient) DAO[0].getALL().get(index)).toString());
				}
			}
			newOutput.writeFile(outputInfo);
		}
	}

	
	public String updateCommand(String command) {
		if(command.contains("AddPatient")) {
			command = command.replace("AddPatient ", "");
			int subStringIndex = command.indexOf(command.split(" ")[3]) + command.split(" ")[3].split("").length + 1;
			command = command.split(" ")[0] + "\t" + command.split(" ")[1] + " " + command.split(" ")[2] + "\t" + command.split(" ")[3] + "\t" + command.substring(subStringIndex);
			return command;
		}
		else if(command.contains("RemovePatient")) {
			command = command.split(" ")[1];
			return command;
		}
		else if(command.contains("CreateAdmission")) {
			command = command.replace("CreateAdmission ", "").replace(" ", "\t");
			return command;
		}
		else if(command.contains("AddExamination")) {
			command = command.replace("AddExamination ", "");
			int index = command.indexOf(" ");
			command = command.substring(0, index).replace(" ", "") + "\t" + command.substring(index+1);
			index = command.indexOf(" ");
			command = command.substring(0, index).replace(" ", "") + "\t" + command.substring(index+1);
			return command;
		}
		else if(command.contains("TotalCost")) {
			command = command.split(" ")[1];
			return command;
		}
		return null;
	}
}
