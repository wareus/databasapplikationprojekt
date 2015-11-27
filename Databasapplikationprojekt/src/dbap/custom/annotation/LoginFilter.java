package dbap.custom.annotation;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

@Login
public class LoginFilter implements ContainerRequestFilter
{

	@Context
	HttpServletRequest webRequest;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{

		HttpSession session = webRequest.getSession(true);

		if (session.getAttribute("id") == null)
		{
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}

	}
}
