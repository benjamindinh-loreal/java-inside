package fr.umlv.labtwo;

public class Switches {
	
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
	
}

