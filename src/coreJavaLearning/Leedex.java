package coreJavaLearning;
import java.util.*;
import java.util.function.*;
interface IntBiConsumer{
	void accept(int x,int y);
}
interface IntBiFunction{
	int apply(int x,int y);
}

public class Leedex {
	  
	static int p=234;
	   static int q=11;
public static void main(String[] args) {
	List l=new ArrayList();
	 IntBiConsumer f1=(x,y)->  {
         for(int j=0;j<x;j++){
             l.add(y+j);
         }
     };
    
     IntBiFunction f2=(v,i)->v+i*10+1;
     IntBiConsumer f3=(m,n)->{q=n*10+1;
                            p=m+n;
                             
                              };
     BiConsumer<String,String> f4=(x,y)->x=x+y; 
     f4.accept("mani","kandan");
    f1.accept(4,123);
    System.out.println(f2.apply(234, 11));
     System.out.println(l);
     f3.accept(p,q);
     System.out.println(p+"..."+q);
}
}
