package utility;

public class ExecutionResponse {
	private final boolean exitCode;
	private final String massage;
	
	public ExecutionResponse(boolean code, String s) {
		exitCode = code;
		massage = s;
	}

 	public ExecutionResponse(String s) {
		this(true, s);
	}
	
	public boolean getExitCode() { return exitCode; }
	public String getMassage() { return massage; }
	public String toString() { return exitCode +";"+massage; }
}