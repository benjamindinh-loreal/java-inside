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
/*
BYTECODE

Le switch 1 utilise un tableau (référencé)
Le switch 2 utilise un lookupswitch (recherche dichotomique)

Lors de l'ajout d'un fallthrough, le byte code triche et insère la meme valeur de goto que l'autre valeur.

intSwitch(int) :
 0: iload_1
 1: tableswitch   { // 0 to 2
               0: 28
               1: 31
               2: 34
         default: 37
    }
 28: ldc           #16                 // String zero
 30: areturn
 31: ldc           #18                 // String one
 33: areturn
 34: ldc           #20                 // String a lot
 36: areturn
 37: new           #22                 // class java/lang/IllegalArgumentException
 40: dup
 41: invokespecial #24                 // Method java/lang/IllegalArgumentException."<init>":()V
 44: athrow



intSwitch2(int) :
 0: iload_1
 1: lookupswitch  { // 3
               0: 36
              10: 39
             100: 42
         default: 45
    }
 36: ldc           #16                 // String zero
 38: areturn
 39: ldc           #29                 // String ten
 41: areturn
 42: ldc           #20                 // String a lot
 44: areturn
 45: new           #22                 // class java/lang/IllegalArgumentException
 48: dup
 49: invokespecial #24                 // Method java/lang/IllegalArgumentException."<init>":()V
 52: athrow
*/
