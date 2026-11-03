package coreJavaLearning;
import java.util.*;
public class Leed1 {
	int[] nums= {2,3,8,9,10};
	int target=16;
		public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int sum=0;
        int sumone=0;
        int sub=0;
        int b=1;
      for(int i=0; i<nums.length-2;i++){
        if(i!=0&&nums[i]==nums[i-1])continue;
        int left=i+1;
        int right=nums.length-1;
        while(left<right){
            	b=1;
            
            sumone= nums[i]+nums[left]+nums[right];
            if(sumone-target<0)b=-1;
            if(sub==0||b*(sumone-target)<sub)
                   {
                    sum=sumone;
                  	b=1;
                    if(sum-target<0)b=-1;
                    sub=b*(sum-target);
                   }
           if(sumone<target)left++;
           else if(sumone>target)right--;
           else return sum;
        }
      }
      return sum;  
    }
	public static void main(String[] args) {
		Leed1 a=new Leed1();
		System.out.println(a.threeSumClosest(a.nums,a.target)); 		
	}
}
