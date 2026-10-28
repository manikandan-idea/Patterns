package java8feacher;
import java.util.*;
import java.util.function.*;

public class Leedex1 {
		  
		   List<String> l=new ArrayList<>();
		   	       
		    public List<String> generateParenthesis(int n) {
		    	 String s = null;
		        switch(n){
		            case 1:		                     
		                     l.add("()");
		                     return l;
		            case 2:
		                     l.add("(())");
		                     l.add("()()");		                     
		                     return l;		                  
		            case 3:		                   		                   
		                   s="()))))";
		                   break;
		            case 4:		                   
		                   s="()))))))";
		                   break; 
		            case 5:		                   
		            	       s="()))))))))";
		                   break;
		            case 6:		                		               
		                   s="()))))))))))";
		                   break;
		            case 7:		                 		              
		                   s="()))))))))))))";
		                   break;
		            case 8:		              
		                  s="()))))))))))))))";
		                   break;                
		                  }
		        int[] i=new int[n];
		        for(int x=0;x<n;x++) {
		        	    i[x]=x+1;
		        	}
		        System.out.println(Arrays.toString(i));
		        char[] ch=s.toCharArray();
		        demo(0,n,1,i,ch);
		       return l;
		      
		    }
		    int dummy;
		    public void demo(int current,int max,int iter,int[] i,char[] ch) {
		    	
		    	  
		    	 if(current==max){char []f=ch.clone();
		    	                      int d=0;
		    		            while(d<i.length) {
		    		            
		    		            
		    		            
		    		            f[i[d]-1]='(';
		    		            d++;
		    		            }
			                l.add(String.valueOf(f));
			                 
			           
			        
		    		
		    		return;
		    	 }
		    	 
		    	 int[] ii=i.clone();
		    	 for( int j=0;j<iter;j++) {
		    		   if(j!=0&&current!=0) {for(int y=ii.length-1;y>=current;y--) {
		    			                         ii[y]=ii[y]+1;
		    		                          }
		    		   }
				   demo(current+1,max,iter+1-j,ii,ch);			    		 					
		 		}			
		    	 
		    	
		    }
			
		    public static void main(String[] args) {
				Leedex1 w=new Leedex1();
				System.out.println(w.generateParenthesis(8));
			}
		    }
		

