package codewars;

public class RankingSystem {
	
	public static void main(String[] args) {
		User user = new User();
		System.out.println(user.rank); // => -8
		System.out.println(user.progress); // => 0
		user.incProgress(-1);
		System.out.println(user.progress); // => 10
	}
}
