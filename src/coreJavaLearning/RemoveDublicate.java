package coreJavaLearning;

import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RemoveDublicate {

	public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	Set<Integer> s=Stream.of(sc.nextLine().split(" ")).map(i->Integer.parseInt(i)).collect(Collectors.toSet());
	sc.close();
     System.out.println(s);
	}

}
