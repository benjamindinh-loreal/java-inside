package fr.umlv.labfive;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class Serialiser {
	
	private final ClassValue<Method[]> cache = new ClassValue<Method[]>() {
		@Override
		public Method[] computeValue(Class<?> type) {
			return type.getMethods() ;
		}
	} ;
	
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
	  
	  /* 
	   * getMethod retourne un tableau mutable de méthode mutable donc il faut copier a chaques fois toutes les méthodes.
	   * 
	   * Il y a donc de multiples copies de méthodes ce qui est lent (double copie défensive).
	   * */
	  
	  
	  @JSONProperty(rename = "age")
	  public int getAge() {
	    return age;
	  }
	}
	
	public static void main(String[] args) {
		Serialiser s = new Serialiser() ;
		System.out.println(s.toJSON(new Alien("Mars",6875))) ;
		assertEquals("{\n\"planet\": \"Mars\"\n\"age\": \"6875\"\n}", s.toJSON(new Alien("Mars",6875))) ;
		assertEquals("{\n\"firstName\": \"Ben\"\n\"lastName\": \"Dinh\"\n}", s.toJSON(new Person("Ben","Dinh"))) ;
	}
	
	public String toJSON(Object object) {
		var s = Arrays.stream(cache.get(object.getClass()))
				.filter(m -> isAnnotationPresent(m) && isAGoodGetter(m) && isObjectOrGetClass(m))
				.map(m -> "\"" + getPropertyName(m) + "\": \"" + executeMethod(object, m) + "\"\n")
				.collect(Collectors.joining());
		
		return "{\n" + s + "}" ;
	}

	private String getPropertyName(Method m) {
		
		var property = m.getAnnotation(JSONProperty.class);
		
		if(property.rename().isEmpty())
			return propertyName(m.getName());
		else
			return property.rename() ;
	}

	private boolean isAnnotationPresent(Method m) {
		return m.isAnnotationPresent(JSONProperty.class);
	}

	private boolean isAGoodGetter(Method m) {
		return m.getParameterCount() == 0 && m.getName().startsWith("get");
	}

	private boolean isObjectOrGetClass(Method m) {
		return !m.getName().equals("getClass") ;
	}

	private String propertyName(String name) {
		return Character.toLowerCase(name.charAt(3)) + name.substring(4);
	}

	private Object executeMethod(Object o, Method m) {
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
