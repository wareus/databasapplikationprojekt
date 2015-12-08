package dbap.exceptions;

import javax.ws.rs.core.Response.Status;

public class AlertMessage {

	private String header, message;

	public AlertMessage(String header, String message) {
		super();
		this.header = header;
		this.message = message;
	}
	public String getHeader() {
		return header;
	}
	public String getMessage() {
		return message;
	}

	
}
