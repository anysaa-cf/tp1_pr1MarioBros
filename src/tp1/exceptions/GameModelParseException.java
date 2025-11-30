package tp1.exceptions;

public class GameModelParseException extends GameModelException {
	private static final long serialVersionUID = 1L;
	
	public GameModelParseException() {
		super();
	}

	public GameModelParseException(String message) {
		super(message);
	}

	public GameModelParseException(Throwable cause) {
		super(cause);
	}

	public GameModelParseException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public GameModelParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
