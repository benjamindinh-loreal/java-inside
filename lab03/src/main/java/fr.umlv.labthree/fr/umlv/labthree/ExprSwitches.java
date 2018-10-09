package fr.umlv.labtwo;



public class Switches {

    
    public enum Day {
        DEBUG, WARNING, INFO, ERROR
    }
    
	
	public static String intSwitch(int i) {
		
		switch(i) {
			case 0 : case 3 :
				return "zero" ;
			case 1 :
				return "one" ;
			case 2 :
				return "a lot" ;
		}
		
		throw new IllegalArgumentException() ;
	}
	
	public static String intSwitch2(int i) {
		
		switch(i) {
			case 0 : case 3 :
				return "zero" ;
			case 10 :
				return "one" ;
			case 100 :
				return "a lot" ;
		}
		
		throw new IllegalArgumentException() ;
	}
    
    public static String stringSwitch(String i) {
		
		switch(i) {
			case "foo" : case "viva zorg" :
				return "zero" ;
			case "bar" :
				return "one" ;
			case "baz" :
				return "a lot" ;
		}
		
		throw new IllegalArgumentException() ;
	}
    
    public static String enumSwitch(int i) {
		
		switch(i) {
			case DEBUG : case ERROR :
				return "zero" ;
			case WARNING :
				return "one" ;
			case INFO :
				return "a lot" ;
		}
		
		throw new IllegalArgumentException() ;
	}
	
}

