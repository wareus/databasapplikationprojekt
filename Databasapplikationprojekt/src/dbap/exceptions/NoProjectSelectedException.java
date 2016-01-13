package dbap.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class NoProjectSelectedException extends AlertException {

	public NoProjectSelectedException() {
		super("No Project Selected", "You need to select a project", Response.Status.NOT_ACCEPTABLE);
	}

}
