package userManagementService;

public abstract class AbstractReport {
	abstract public void formatData();
	abstract public void writeToFile();
	
	
	public void export(){
		formatData();
		writeToFile();
	}
	
	
}
