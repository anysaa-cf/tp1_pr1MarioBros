package tp1.exceptions;

public class ObjectParseException extends GameModelParseException {
	private static final long serialVersionUID = 1L;
	
	public ObjectParseException() {
		super();
	}

	public ObjectParseException(String message) {
		super(message);
	}

	public ObjectParseException(Throwable cause) {
		super(cause);
	}

	public ObjectParseException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public ObjectParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
