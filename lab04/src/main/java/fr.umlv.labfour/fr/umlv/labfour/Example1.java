package fr.umlv.labfour;

public class Example1 {
	
	/* 1 - 4) Si l'on ajoute pas un second run, le fait de placer un yield bloquera l'exécution du code 
	 * 
	 * 1 - 5) yield enregistre sur la pile le pointeur de l'opération à traiter en cours et run relance l'exécution à partir de ce pointeur 
	 * 
	 * */
	
	public static void main() {
		
		var scope1 = new ContinuationScope("scope1") ;
		
		Continuation c = new Continuation(scope1,  
			() ->  { 
				Continuation.yield(scope1) ; 
				System.out.println("hello continuation") ;
			}
		) ;
	
		c.run() ;
		c.run() ;
		
	}

}
