package fr.umlv.labthree;



public class ExprSwitches {

    public enum Messages {
        DEBUG, WARNING, INFO, ERROR
    }
    
    /* INTSWITCH */
    
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
    
	public static String exprIntSwitch(int i) {
   
		return switch (i) {
            case 0,3 -> "zero" ;
            case 1 -> "one" ;
            case 2 -> "a lot" ;
            default -> throw new IllegalArgumentException();
        };

	}
    
    /* INTSWITCH2 */
	
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
    
    public static String exprIntSwitch2(int i) {
   
		return switch (i) {
            case 0,3 -> "zero" ;
            case 10 -> "one" ;
            case 100 -> "a lot" ;
            default -> throw new IllegalArgumentException();
        };

	}
    
    /* stringSwitch */
    
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
    
        
    public static String stringSwitch(String i) {
		
		return switch (i) {
            case "foo","viva zorg" -> "zero" ;
            case "bar" -> "one" ;
            case "baz" -> "a lot" ;
            default -> throw new IllegalArgumentException();
        };
        
	}
    
    /* enumSwitch */
    
    public static String enumSwitch(Messages i) {
		
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

