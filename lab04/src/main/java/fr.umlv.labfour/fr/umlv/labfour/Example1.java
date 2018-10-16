package fr.umlv.labfour;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Random;

public class Example1 {
	
	/* 
	 * 
	 * 
	 * 1 - 4) Si l'on ajoute pas un second run, le fait de placer un yield bloquera l'exécution du code 
	 * 
	 * 1 - 5) yield enregistre sur la pile le pointeur de l'opération à traiter en cours et run relance l'exécution à partir de ce pointeur
	 * 
	 * 1 - 8) Thread.currentThread() retournera le thread courant. Meme dans le main celui ci sera dans un thread. Alors que pour le continuous,
	 * le main n'est présent dans aucun continuous donc celui ci retourne null (celui ci n'est pas une continuation). 
	 * 
	 * 1 - 9) Il y a un état étrange car le synchronised vérouille une fonction sauf que yield sort de cet état de vérou 
	 * pour éxécuter une autre portion de code, il y a alors une "java.lang.IllegalStateException" qui est jetée.
	 * 
	 * 1 - 11) Continuation => Permet d'exécuter du code et de pouvoir le pause pour reprendre plus tard. Tout cela en mono thread et en 
	 * pouvant exécuter plusieurs code les uns après les autres.
	 * Les threads eux, s'exécutent sur du multi core.
	 * 
	 * 
	 * */
	
	static enum SchedulerMode{
		STACK{
			public void getData() {
				
			}
		},
		FIFO{
			public void getData() {
					
			}
		},
		RANDOM{
			public void getData() {
					
			}
		};
	}
	
	static class Scheduler	{
		
		private final ArrayList<Continuation> continuations = new ArrayList<>();
		private final SchedulerMode sm ;
		
		public Scheduler(SchedulerMode sm){
			this.sm = sm ;
		}
		
		void enqueue(ContinuationScope cs){
			
			/*get continuation*/
			
			if(c == null)
				throw new IllegalStateException("######## Pas de continuation courante ########") ;
			
			continuations.add(c) ;
			Continuation.yield(cs) ;
		}
		
		void runLoop() {
			while(!continuations.isEmpty()) {
				
				Continuation continuation;
				
				switch (this.sm) {
					case STACK : 	continuation = continuations.remove(continuations.size() - 1) ; break ;
					case FIFO : 	continuation = continuations.remove(0) ; break ;
					case RANDOM : 	continuation = continuations.remove((int) (Math.random() * continuations.size()) ) ; break;
					default:		throw new IllegalArgumentException("######## Pas de SchedulerMode renseigné ########") ;
				}
				
				continuation.run() ;
				
			}
		}
		
	}
	
	
	public static void main() {
		
		
		var scheduler = new Scheduler(SchedulerMode.STACK) ;
		var scope = new ContinuationScope("scope") ;
		
		Runnable runnable = () ->  { 
			/*if(Continuation.getCurrentContinuation(scope1).isDone())*/
			System.out.println(Continuation.getCurrentContinuation(scope)) ;
			System.out.println("hello continuation") ;
		} ;
		
		for(int i = 0 ; i < 10 ; i++) {
			var continuation = new Continuation(scope, runnable) ;
			continuation.run();
			scheduler.enqueue(continuation, scope);
		}
		
		scheduler.runLoop();
		
	}
}