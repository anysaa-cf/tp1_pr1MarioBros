package tp1.exceptions;

public class PositionParseException extends GameModelParseException {
	private static final long serialVersionUID = 1L;
	
	public PositionParseException() {
		super();
	}

	public PositionParseException(String message) {
		super(message);
	}

	public PositionParseException(Throwable cause) {
		super(cause);
	}

	public PositionParseException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public PositionParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
