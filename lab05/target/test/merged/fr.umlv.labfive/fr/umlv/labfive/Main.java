package fr.umlv.labfive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class Main {
	
	static class Person {
	  private final String firstName;
	  private final String lastName;

	  public Person(String firstName, String lastName) {
	    this.firstName = Objects.requireNonNull(firstName);
	    this.lastName = Objects.requireNonNull(lastName);
	  }
	  
	  @JSONProperty
	  public String getFirstName() {
	    return firstName;
	  }
	  
	  @JSONProperty
	  public String getLastName() {
	    return lastName;
	  }
	}
	
	static class Alien {
	  private final String planet;
	  private final int age;

	  public Alien(String planet, int age) {
	    if (age <= 0) {
	      throw new IllegalArgumentException("Too young...");
	    }
	    this.planet = Objects.requireNonNull(planet) ;
	    this.age = age;
	  }
	  
	  @JSONProperty
	  public String getPlanet() {
	    return planet;
	  }
	  
	  @JSONProperty
	  public int getAge() {
	    return age;
	  }
	}
	
	public static void main(String[] args) {
		System.out.println(toJSON(new Alien("Mars",6875))) ;
		assertEquals("{\n\"planet\": \"Mars\"\n\"age\": \"6875\"\n}", toJSON(new Alien("Mars",6875))) ;
		assertEquals("{\n\"firstName\": \"Ben\"\n\"lastName\": \"Dinh\"\n}", toJSON(new Person("Ben","Dinh"))) ;
	}
	
	public static String toJSON(Object object) {
		var s = Arrays.stream(object.getClass().getMethods())
				.filter(m -> isAnnotationPresent(m) && isAGoodGetter(m) && isObjectOrGetClass(m))
				.map(m -> "\"" + propertyName(m.getName()) + "\": \"" + executeMethod(object, m) + "\"\n")
				.collect(Collectors.joining());
		
		return "{\n" + s + "}" ;
	}

	private static boolean isAnnotationPresent(Method m) {
		return m.isAnnotationPresent(JSONProperty.class);
	}

	private static boolean isAGoodGetter(Method m) {
		return m.getParameterCount() == 0 && m.getName().startsWith("get");
	}

	private static boolean isObjectOrGetClass(Method m) {
		return !m.getName().equals("getClass") ;
	}

	private static String propertyName(String name) {
		return Character.toLowerCase(name.charAt(3)) + name.substring(4);
	}

	private static Object executeMethod(Object o, Method m) {
		try {
			return m.invoke(o);
		} catch (IllegalAccessException x) {
			
			throw new IllegalStateException(x) ;
			
		} catch (InvocationTargetException x) {
			
			var cause = x.getCause() ;
			
			if(cause instanceof RuntimeException)
				throw (RuntimeException) cause ;
			
			if(cause instanceof Error)
				throw (Error) cause ;
			
			throw new UndeclaredThrowableException(cause) ;
			
		}
	}
}
