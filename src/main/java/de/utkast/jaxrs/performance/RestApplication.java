package de.utkast.jaxrs.performance;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * @author Florian Hirsch
 */
@ApplicationPath("/")
public class RestApplication extends Application {

	private Set<Class<?>> classes;
	
	private Set<Object> singletons;
	
	public RestApplication() {
		classes = new HashSet<>();
		classes.add(RequestResource1.class);
		classes.add(RequestResource2.class);
		singletons = new HashSet<>();
		singletons.add(new SingletonResource1());
		singletons.add(new SingletonResource2());
	}
	
	@Override
	public Set<Class<?>> getClasses() {
		return classes;
	}
	
	@Override
	public Set<Object> getSingletons() {
		return singletons;
	}
}
