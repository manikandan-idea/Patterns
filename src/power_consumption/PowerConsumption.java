package power_consumption;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PowerConsumption

{

	 String date ;

	 int machineNo ;

	 int consumptionInHp ;

	 private int machineNO;

	 

	 public PowerConsumption( String date , int machineNo , int consumptionInHp )

	 {

		 this.date = date ;

		 this.machineNo = machineNo ;

		 this.consumptionInHp = consumptionInHp ;

	 }

	 

	 public String toString()

	 {

		 StringBuffer str = new StringBuffer() ;

		 str.append( date );

		 str.append( "\t\t" );

		 str.append( String.valueOf( machineNo ) );

		 str.append( "\t\t" );

		 str.append( String.valueOf( consumptionInHp ) );

		 return str.toString() ;

	 }

	 

	 public static void main( String ar[] )

	 {

		 PowerConsumption p[] = new PowerConsumption[6] ;

		 p[0] = new PowerConsumption ( "10.05.08" , 10 , 100 ) ;

		 p[1] = new PowerConsumption ( "10.05.08" , 11 , 120 ) ;

		 p[2] = new PowerConsumption ( "10.05.08" , 12 , 125 ) ;

		 p[3] = new PowerConsumption ( "11.05.08" , 10 , 145 ) ;

		 p[4] = new PowerConsumption ( "11.05.08" , 11 , 155 ) ;

		 p[5] = new PowerConsumption ( "12.05.08" , 12 , 165 ) ;

		 System.out.println("Date\t\tMachine\t\tConsumption");

		 for( int i = 0 ; i < p.length ; i++ ) {

		 System.out.println(p[i]) ;

		 }
		 
		 method1(p);
		 method2(p);
		 method3(p);
		 
	 }
	 
	 
     public static void method1(PowerConsumption p[]) {
    	 System.out.print("Machine/Date   ");
		 List<String> dateList=new ArrayList<>();
		 z:
		 for( int i = 0 ; i < p.length ; i++ ) {
				 for(int j=0;j<i;j++) {
					if(p[i].date.equals(p[j].date))continue z;
				 }
			 System.out.print(p[i].date+"   ");
			 dateList.add(p[i].date);
			 }
		 System.out.println("Total");
		 int dTotal[]=new int[dateList.size()]; 
		 
		 l:
		 for( int i = 0 ; i < p.length ; i++ ) {
			 
			 if(i==0) 
			     System.out.print(p[i].machineNo+"     ") ;
			 else {
				 for(int j=0;j<i;j++) {
				     if(p[i].machineNo==p[j].machineNo)continue l;
				     if(j==i-1)System.out.print(p[i].machineNo+"     ");
				 }
			  }
			 int k=0;
			 int mTotal=0;
			 q:
			 for(int j=0;j<p.length;j++) {
			     if(p[i].machineNo==p[j].machineNo) {
			    	 while(true) {
			    	     if(p[j].date.equals(dateList.get(k))) {
			    	         System.out.print(p[j].consumptionInHp+"     ");
			    	         mTotal+=p[j].consumptionInHp;
			    	         dTotal[k]+=p[j].consumptionInHp;
			    	         if(++k == dateList.size())break q;
			    	         break;
			    	     }else {
			    		     System.out.print(0+"     ");
			    		     if(++k == dateList.size())break q;
			    	     }
			    	 }
			     }
			     
			 }
			 while(k++ <dateList.size()) {
				 System.out.print(0+"     "); 
			 }
			 System.out.println(mTotal);
			 
		  }
		System.out.print("Total  ");
		int total=0;
		for(int x:dTotal) {
			System.out.print(x+"     ");
			total+=x;
		}
		System.out.println(total);
 
     }
     public static void method2(PowerConsumption p[]) {
    	 System.out.print("Machine/Date   ");
    	 Set<String> dateSet=new LinkedHashSet<>();
       	 Stream.of(p).filter(i->dateSet.add(i.date)).forEach(i->System.out.print(i.date+"   "));
       	 int[] dTotal=new int[dateSet.size()];
       	 Object[] dateArr = dateSet.stream().toArray();       	 
       	 System.out.println("Total");       	 
       	 Set<Integer> machineSet=Stream.of(p).map(i->i.machineNo).collect(Collectors.toSet());
       	 Map<Integer, List<PowerConsumption>> machineMap = machineSet.stream().map(i->Stream.of(p).filter(j->j.machineNo==i).collect(Collectors.toList())).collect(Collectors.toMap(i->i.get(0).machineNo,i->i));
       	 machineMap.forEach((mNo,list)->{
       		    int mTotal=0;
       		    System.out.print(mNo+"     ");
       		    l:
           		for(int j=0;j<dateArr.length;j++) {
           			for(int i=0;i<list.size();i++) {
           			    if(dateArr[j].equals(list.get(i).date)) {
           			    	mTotal+=list.get(i).consumptionInHp;
           			    	dTotal[j]+=list.get(i).consumptionInHp;
           				    System.out.print(list.get(i).consumptionInHp+"     ");
           				    continue l;
           			    }
           			}
           			System.out.print(0+"     ");
           		}
           		System.out.println(mTotal);
      		 
      	});
       	System.out.print("Total  ");
       	int total=0;
		for(int x:dTotal) {
			total+=x;
			System.out.print(x+"     ");
		}
		System.out.println(total);
		
       	
     }
     public static void method3(PowerConsumption p[]) {
    	 Set<String> dates=new LinkedHashSet<>();
         System.out.print("Machine/Date   ");
 		 Stream.of(p).filter(i->dates.add(i.date)).forEach(i->System.out.print(i.date+"   "));
 		 System.out.println("Total");
 		 Set<Integer> machines=new LinkedHashSet<>();
         Map<Integer, Map<String, Integer>> mapObj = Stream.of(p).filter(i->machines.add(i.machineNo)).collect(Collectors.toMap(i->i.machineNo, i->Stream.of(p).filter(j->j.machineNo==i.machineNo).collect(Collectors.toMap(x->x.date,x->x.consumptionInHp))));
         Object[] dateArr = dates.stream().toArray();
         int[] dTotal=new int[dates.size()];
 		 mapObj.forEach((mNO,value)->{
 			 int mTotal=0;
    		 System.out.print(mNO+"     ");
    		 int k=0;
    		 for(Entry<String,Integer> en:value.entrySet()){
    			 while(true) {
 			   	     if(en.getKey().equals(dateArr[k++])) {
    			    	 mTotal+=en.getValue();
    			    	 dTotal[k-1]+=en.getValue();
    				     System.out.print(en.getValue()+"     ");
    				     break;
     			      }else {
    				      System.out.print(0+"     "); 
 			   	          if(k ==dateArr.length)break;
     			      }
 				
 			     }
    		     
    	     }
    		 while(k++ <dateArr.length) {
			     System.out.print(0+"     ");
		     }
    		 System.out.println(mTotal);
 		});
 		System.out.print("Total  ");
       	int total=0;
		for(int x:dTotal) {
			total+=x;
			System.out.print(x+"     ");
		}
		System.out.println(total);
     }

}