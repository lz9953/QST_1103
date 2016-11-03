package No4;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Locale  locale = Locale.US;
		SimpleDateFormat regularFormat1 = new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",locale);
		Date beginDate = regularFormat.parse(args[0]);//第一个参数为起始时间
		Date endDate = regularFormat.parse(args[1]);//第二个参数为结束时间
		Scanner scanner = new Scanner(System.in);//
		while (scanner.hasNext()){
			String line = scanner.nextLine();
			String strIp = null;
			String strTime = null;
			Pattern pattern =  Pattern.compile("(\\d+.\\d+.\\d+.\\d+).*(\\[.*\\]).*");
    		Matcher matcher = pattern.matcher(line);
    		if(matcher.find()){
    			strIp = matcher.group(1);
        		String[] t = matcher.group(2).split(" ");
    			strTime = t[0].substring(1, t[0].length());
    			Date StrTime = regularFormat1.parse(strTime);
    			// 对在时间区间内的数据进行输出
    			if(StrTime.after(beginDate) && StrTime.before(endDate)){
    				System.out.println(strIp + "\t" + StrTime);  // 作为reduce的输入
    			}
    		}
    		
			
		}
	}
}
