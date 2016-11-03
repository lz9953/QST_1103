package No4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ReducerOfIPFilter {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);
		Set<String> set =  new HashSet<String>();//用hasset存储IP hasSet自动去重存储 
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String[] tokens = line.split("\t");
			set.add(tokens[0]);//将IP存到set中。自动去重
		}
		System.out.println(set.size());// 输出set的size  即为所求ip的数量（去重）
	}
}
