package dbap.custom.annotation;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;

@Login
public class SecureFilter implements ContainerRequestFilter
{
 @Override
 public void filter(ContainerRequestContext requestContext) throws IOException
 {
	 System.out.println("working");
	 
 }
}
