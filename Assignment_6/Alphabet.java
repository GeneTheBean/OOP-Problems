import java.util.ArrayList;

public class Alphabet {
	ArrayList<String> list = new ArrayList<String>();
	private int num_combinations = 0;
	
	public int words(int n){
		num_combinations = 0;
		rwords(new String(), n);
		return num_combinations;
	}
	
	private void rwords(String s, int n) {
		if(n <= 0) {
			//list.add(s);		//For debugging purposes
			num_combinations++;
			return;
		}
		
		if(s.endsWith("a")) {
			rwords(s += 'b', n - 1);
			return;
		}
		
		rwords(s + 'a', n - 1);
	    rwords(s + 'b', n - 1);
	}
	
	public ArrayList<String> get_list() {
		return list;
	}
	
	public static void main(String[] args){
		Alphabet a = new Alphabet();
		
		System.out.print(a.words(5));
	}
}
