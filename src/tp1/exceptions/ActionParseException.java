package tp1.exceptions;

public class ActionParseException extends GameModelParseException {
	private static final long serialVersionUID = 1L;
	
	public ActionParseException() {
		super();
	}

	public ActionParseException(String message) {
		super(message);
	}

	public ActionParseException(Throwable cause) {
		super(cause);
	}

	public ActionParseException(String message, Throwable cause) {		// to wrap low-level exceptions into high-level ones
		super(message, cause);
	}

	public ActionParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
