package fr.umlv.javainside.labone;

import java.util.stream.IntStream;

public class Sums {
    
    public int loopSum(int n){
        
        int res = 0 ;
        
        for(int i = 1 ; i <= n ; i ++)
            res += n ;
            
        return res ;
    }
    
    public int streamSum(int n){
        return IntStream.range(0, n + 1).sum() ;
    }
   
}
