package utility;

/**
 * Класс, предназначенный для вывода информации в консоль об успешности выполнения команды.
 * @author skadibtw
 */
public class ExecutionResponse {
	private final boolean exitCode;
	private final String message;
	
	public ExecutionResponse(boolean code, String s) {
		exitCode = code;
		message = s;
	}

 	public ExecutionResponse(String s) {
		this(true, s);
	}

	/**
	 * возвращает успешность выполнения команды
	 * @return Успешность выполнения команды.
	 */

	public boolean getExitCode() { return exitCode; }


	/**
	 * возвращает полученное сообщение при выполнении команды
	 * @return message
	 */

	public String getMessage() { return message; }
	public String toString() { return exitCode + ";" + message; }
}