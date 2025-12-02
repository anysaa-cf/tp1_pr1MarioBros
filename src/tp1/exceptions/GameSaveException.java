package tp1.exceptions;

public class GameSaveException extends GameFileException {
	private static final long serialVersionUID = 1L;
	
	
	public GameSaveException() {
		super();
	}

	public GameSaveException(String message) {
		super(message);
	}

	public GameSaveException(Throwable cause) {
		super(cause);
	}

	public GameSaveException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public GameSaveException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
