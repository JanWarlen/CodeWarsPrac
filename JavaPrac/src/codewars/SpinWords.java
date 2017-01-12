package codewars;

public class SpinWords {

	public String spinWords(String sentence) {
		String[] strs = sentence.split(" ");
		StringBuffer res = new StringBuffer();
		for(int i = 0; i < strs.length; i++){
			if(strs[i].length() > 4){
				res.append(reverseStr(strs[i])+" ");
			}else{
				res.append(strs[i]+" ");
			}
		}
		
		return res.toString().trim();
	}
	
	public String reverseStr(String str){
		return new StringBuffer(str).reverse().toString();
	}
	
}
