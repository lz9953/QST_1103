package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Locale  locale = Locale.US;
		SimpleDateFormat regularFormat1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",locale);//定义时间格式，用于转换从文件中提取得时间
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		String filePath = "./access.log";//指定文件路径
		FileInputStream inputStream = new FileInputStream(filePath);//读取本地文件中的字节数据
		Scanner scanner = new Scanner(inputStream, "UTF-8");//
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			// 切分获取IP，Time
			String strIp = null;
			String strTime = null;
			Pattern pattern =  Pattern.compile("(\\d+.\\d+.\\d+.\\d+).*(\\[.*\\]).*");
    			Matcher matcher = pattern.matcher(line);
    		if(matcher.find()){
    			strIp = matcher.group(1);
        		
        		String[] t = matcher.group(2).split(" ");
    			strTime = t[0].substring(1, t[0].length());//对正则表达式中的第二项 去除"["
    			Date StrTime = regularFormat1.parse(strTime);//将提取得时间转换为date格式，用于区间比较
    			// 对在时间区间内的数据进行输出
    			if(StrTime.after(beginDate) && StrTime.before(endDate)){
    				System.out.println(strIp + "\t" + StrTime);
    			}
    		}
    		
			
		}
	}
	
}
