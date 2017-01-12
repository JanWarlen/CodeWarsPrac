package codewars;

import java.util.ArrayList;
import java.util.List;

public class Decompose {

	  public String decompose(long n) {
		  List<Long> squares = getSquares(n*n,n);
		  int size = squares.size();
		  StringBuffer res = new StringBuffer();
		  for (int i = 0; i < size; i++) {
			  res.append(squares.get(i));
			  if(i != size-1){
				  res.append(" ");
			  }
		  }
		  
		  return res.toString();
	  }
	  
	  public List<Long> getSquares(long nn,long n){
		  if(nn > 1 && nn < 4){
			  return null;
		  }
		  List<Long> res = new ArrayList<Long>();
		  int x = (int) Math.sqrt(nn);
		  int bottom = (int) Math.sqrt(nn/2);
		  for (long i = x; i > bottom; i--) {
			  if(i*i == nn && i < n){
				  res.add(i);
				  return res;
			  }else if(i*i < nn){
				  List<Long> tmp = getSquares(nn-i*i,n);
				  if(null != tmp){
					  res.addAll(tmp);
					  res.add(i);
					  return res;
				  }
			  }
		  }
		  
		  return null;
	  }
	
	  
	  public static void main(String[] args) {
		Decompose de = new Decompose();
		System.out.println(de.decompose(1234567));
	}
}
