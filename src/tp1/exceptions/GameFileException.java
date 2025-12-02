package tp1.exceptions;

public class GameFileException extends GameModelException {
	private static final long serialVersionUID = 1L;

	public GameFileException() {
		super();
	}

	public GameFileException(String message) {
		super(message);
	}

	public GameFileException(Throwable cause) {
		super(cause);
	}

	public GameFileException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public GameFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	
}
