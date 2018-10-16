package fr.umlv.labfour;

public class Example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		var t = new Thread( () -> System.out.println("hello continuation") ) ;
		
		t.setName("hello1") ;
		
		t.run() ;
		
	}

}
