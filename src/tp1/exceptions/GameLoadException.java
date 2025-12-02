package tp1.exceptions;

public class GameLoadException extends GameFileException {
	private static final long serialVersionUID = 1L;
	
	public GameLoadException() {
		super();
	}

	public GameLoadException(String message) {
		super(message);
	}

	public GameLoadException(Throwable cause) {
		super(cause);
	}

	public GameLoadException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public GameLoadException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
