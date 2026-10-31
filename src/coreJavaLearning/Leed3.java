package coreJavaLearning;
import java.util.*;
public class Leed3 {
	public boolean isValid(String s) {
        ArrayList<Character> ar=new ArrayList();
        int z=0;
        for(int i=0;i<s.length();i++){
            switch(s.charAt(i)){
                case '(':
                         ar.add('(');
                         z++;
                         break;
                 case '{':
                         ar.add('{');
                         z++;
                         break;
                 case '[':
                         ar.add('[');
                         z++;
                         break;
                 case ')':
                         if(i==0||ar.remove(z-1)!='(')
                         return false;
                         z--;
                         break;
                 case '}':
                         if(i==0||ar.remove(z-1)!='{')
                         return false;
                         z--;
                         break;
                 case ']':System.out.println(z-1);
                         if(i==0||ar.remove(z-1)!='[')
                         return false;
                         z--;
                         break;                  
            }
        }
        
    return true;
    }
    String s="()[]{}";
	public static void main(String[] args) {
		 Leed3 l=new Leed3();
		 System.out.println(l.isValid(l.s));
		 
		 

	}

}
