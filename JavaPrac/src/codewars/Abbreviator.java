package codewars;

public class Abbreviator {

	  public static String abbreviate(String string) {
	    // ...
		  System.out.println(string);
		  StringBuffer resStr = new StringBuffer();
		  String[] array = string.split("\\s+");
		  for (int i = 0; i < array.length; i++) {
			  int charIndex = 0;
			  String[] words = array[i].split("\\W");
			  for (int j = 0; j < words.length; j++) {
				  int len = words[j].length();
				  if( len > 3){
					  resStr.append(String.valueOf(words[j].charAt(0))+(len-2)+String.valueOf(words[j].charAt(len - 1)));
				  }else{
					  resStr.append(words[j]);
				  }
				  if(j!=words.length-1){
					  charIndex+=words[j].length();
					  resStr.append(array[i].charAt(charIndex++));
				  }
			  }
			  char s = array[i].charAt(array[i].length()-1);
			  if((s < 97 || s > 122) &&(s > 90 || s < 65) ){
				  resStr.append(s);
			  }
			  resStr.append(" ");
		  }
		  return resStr.toString().trim();
	  }
	
		public static void main(String[] args) {
			System.out.println(abbreviate("internationalization internationalizationX"));
		}
}
