import java.util.*;

public class Subset {
	
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int i = 0;i < 3;i++)
			list.add(i+1);
		
		ArrayList<ArrayList<Integer>> s = subsets(list, 2);
		int a = s.size();
		
	}
	
	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> list, int n) {
		ArrayList<ArrayList<Integer>> combinations = new ArrayList<ArrayList<Integer>> ();
	
		if (n == 0) {
		    combinations.add(new ArrayList<Integer>());
		    return combinations;
		}
		    
		if (n > list.size()) 
		    return combinations;

		ArrayList<Integer> list_without_x = new ArrayList<Integer> (list);
		Integer x = list_without_x.remove(list_without_x.size() - 1);
		ArrayList<ArrayList<Integer>> subsets_without_x = subsets(list_without_x, n);
		ArrayList<ArrayList<Integer>> subsets_with_x = subsets(list_without_x, n - 1);
		
		for (ArrayList<Integer> subset : subsets_with_x) 
			subset.add(x);
		    
		combinations.addAll(subsets_without_x);
		combinations.addAll(subsets_with_x);
		
		return combinations;
	}
}

