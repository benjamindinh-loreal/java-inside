package fr.umlv.labtwo;

public class Switches {
	
	public String intSwitch(int i) {
		
		switch(i) {
			case 0 :
				return "zero" ;
			case 1 :
				return "one" ;
			case 2 :
				return "a lot" ;
		}
		
		throw new IllegalArgumentException() ;
	}
	
}
