package codewars;

public class Runes {

	public static int solveExpression( final String expression ) {
		int missingDigit = -1;

    //Write code to determine the missing digit or unknown rune
    //Expression will always be in the form
    //(number)[opperator](number)=(number)
    //Unknown digit will not be the same as any other digits used in expression
    
		int addIndex = expression.indexOf("+");
		int equalIndex = expression.indexOf("=");
		int multipIndex = expression.indexOf("*");
		int subIndex = expression.substring(1).indexOf("-")+1;
		int endIndex = expression.length();
		
		String resStr = expression.substring(equalIndex+1);
		String firstStr = null;
		String secondStr = null;
		
		if(addIndex > -1){
			firstStr = expression.substring(0, addIndex);
			secondStr = expression.substring(addIndex+1, equalIndex);
		}else if(multipIndex > -1){
			firstStr = expression.substring(0, multipIndex);
			secondStr = expression.substring(multipIndex+1, equalIndex);
		}else{
			firstStr = expression.substring(0, subIndex);
			secondStr = expression.substring(subIndex+1, equalIndex);
		}
		
		int first = 0;
		int second = 0;
		int res = 0;
		
		for (int i = 0; i < 10; i++) {
			if(firstStr.contains(i+"") || secondStr.contains(i+"") || resStr.contains(i+"")){
				continue;
			}
			first = getNum(firstStr,i);
			second = getNum(secondStr,i);
			res = getNum(resStr,i);
			if(addIndex > -1){
				if((first+second) == res){
					if(resStr.length() > 1 && resStr.charAt(0) == 63 && i == 0){
						continue;
					}
					return i;
				}
			}else if(multipIndex > -1){
				if((first*second) == res){
					if(resStr.length() > 1 && resStr.charAt(0) == 63 && i == 0){
						continue;
					}
					return i;
				}
			}else{
				if((first-second) == res){
					if(resStr.length() > 1 && resStr.charAt(0) == 63 && i == 0){
						continue;
					}
					return i;
				}
			}
			
			
		}
		
		return missingDigit;
	}
	/**
	 * 
	 * @param numStr
	 * @param n i
	 * @return
	 */
	public static int getNum(String numStr,int n){
		char[] numArr = numStr.toCharArray();
		int lastIndex = numArr.length-1;
		int res = 0;
		int abs = 1;
		for (int i = 0; i < numArr.length; i++) {
			if(45 == numArr[i]){
				abs = -1;
			}else if(63 == numArr[i]){
				res += n * Math.pow(10,lastIndex - i);
			}else{
				res += Integer.parseInt(String.valueOf(numArr[i])) * Math.pow(10,lastIndex - i);
			}
		}
		
		return res*abs;
	}
	
	public static void main(String[] args) {
		Integer.parseInt("-1");
		System.out.println(solveExpression("9-9=?"));
	}
}
