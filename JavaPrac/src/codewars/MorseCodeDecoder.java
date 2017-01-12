package codewars;

import java.util.Arrays;

public class MorseCodeDecoder {

	public static String decode(String morseCode) {
        // your brilliant code here, remember that you can access the preloaded Morse code table through MorseCode.get(code)
		String[] words = morseCode.split("   ");
		for(int i = 0; i < words.length; i++){
			String[] codes = words[i].split(" ");
			for(int j = 0; j < codes.length; j++){
				codes[j] = MorseCode.get(codes[j]);
				codes[j] = null==codes[j]?"":codes[j];
			}
			words[i] = String.join("", codes);
		}
		return String.join(" ", words).trim();
    }
	
	public static String decodeBits(String bits) {
		if((bits.length() % 4) == 2){
			bits += "00";
		}
		return bits.replaceAll("11111100", "-").replaceAll("1100", ".").replaceAll("0000", " ");
	}
	
	public static String decodeMorse(String morseCode) {
		StringBuffer result = new StringBuffer();
		for(String word : morseCode.trim().split("   ")) {
			for(String letter : word.split("\\s+")) {
				result.append(MorseCode.get(letter));
			}
			result.append(' ');
		}
		return result.toString().trim();
	}
	
	
	public static void main(String[] args) {
		String code = "1100";
		System.out.println(decodeBits(code));
	}
}
