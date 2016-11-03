package No1;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex1
 * 1. 在个人分支下，修改Answers.md文件，里面填入当输入为'2016-11-11 11:11:11'时，输出的值是多少
 * 2. 对代码进行注释，说明每行代码的作用，把代码提交到个人分支下
 * 3. 创建pull request，与主仓库的master分支对比
 */
public class TimestampTransfer {
	@SuppressWarnings("resource")
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);//获取控制台输入 
		SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置输入时的日期格式
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置输出时的日期格式
		while (scanner.hasNext()){//每有一个输入就执行一次while循环
			String line = scanner.nextLine(); //用String 类型的 变量 line 接住输入的值
			Date lineDate = null;//定义一个date型的lineDate存储转换完格式的输入信息
			long lineTimestamp; //定义一个long 型的lineTimestamp存储转换完格式的输出信息
			try {
				lineDate = inputFormat.parse(line);//提取出按指定格式转换的日期
				lineTimestamp = lineDate.getTime();//将lineDate转换为时间戳，用lineTimestamp保存
				System.out.println(outputFormat.format(lineDate) + " to " + lineTimestamp);
				//将输入的日期和装换完的日期输出打印。
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
