package codewars;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class Statistics {

	public static String stat(String strg) {
		String[] strs = strg.split(",");
		List<Integer> intArr = new ArrayList<Integer>();
		for(int i = 0; i < strs.length; i++){
			intArr.add(dateStrToNum(strs[i]));
		}
		Integer[] date = (Integer[]) intArr.toArray(new Integer[intArr.size()]);
		return "Range: "+getRange(date)+" Average: "+getAverage(date)+" Median: "+getMedian(date)+"";
	}
	//turn to timeStr
	public static String numToDateStr(int num){
		int seconds = num % 60;
		int mins = (num / 60) % 60;
		int hours = (num / 60) / 60;
//		String res = (hours > 9 ? hours : "0" + hours) + "|" + (mins > 9 ? mins : "0" + mins) + "|" + (seconds > 9 ? seconds : "0" + seconds);
		Date date = new Date();
		date.setHours(hours);
		date.setMinutes(mins);
		date.setSeconds(seconds);
		DateFormat dateFormat = new SimpleDateFormat("HH|mm|ss");
		String resStr = dateFormat.format(date);
		
		return resStr;
	}
	//turn to seconds
	public static int dateStrToNum(String date){
		String[] split = date.trim().split("\\|");
		return (Integer.parseInt(split[0])*60+Integer.parseInt(split[1]))*60+Integer.parseInt(split[2]);
	}
	
	public static String getRange(Integer[] date){
		Arrays.sort(date);
		return numToDateStr(date[date.length-1]-date[0]);
	}
	
	public static String getAverage(Integer[] date){
		int res = 0;
		for(int i = 0; i < date.length; i++){
			res += date[i];
		}
		return numToDateStr(res/date.length);
	}
	
	public static String getMedian(Integer[] date){
		Arrays.sort(date);
		int down = (int) Math.floor(date.length/2.0);
		int up = down + ((0 == (date.length%2))?1:0);
		
		return numToDateStr((date[up-1]+date[down-1])/2);
	}
	
	public static void main(String[] args) {
		System.out.println(stat("01|15|59, 1|47|16, 01|17|20, 1|32|34, 2|17|17"));
		//01|15|59 01|17|20 1|32|34 1|47|16 2|17|17
	}
}
