/** Contains methods to perform sorts. 
    It can only sort an array of integers. */
public class Sorter {
	private int[] arr;
	
	public Sorter(int [] arr) {	//Constructor
		this.arr = arr;
	}
	
	/** Recursive quick sort caller */
	public void quick_sort() {
		qsort(0, arr.length - 1);
	}
	
	private void qsort(int left, int right) {
		if(right - left <= 0)
			return;
		
		else {
			long pivot = arr[right];
			int part = partition(left, right, pivot);
			qsort(left, part - 1);
			qsort(part + 1, right);
		}
	}
	
  /** Partition an array with the pivot as the reference. Items smaller than the pivot are positioned 
	  to the left of it, and items larger than or equal to the pivot are positioned to the right of it.
	  The return value is the index of the pivot after the partition.													   
	  @param left Index for the starting left position
	  @param right Index for the starting right position
	  @param pivot Value for the pivot */
	private int partition(int left, int right, long pivot) {
		int leftPtr = left - 1;
		int rightPtr = right;
		
		while(true) {
			while(leftPtr < right && arr[++leftPtr] < pivot);	//Scans to the right to find bigger item
			while(rightPtr > left && arr[--rightPtr] > pivot);  //Scans to the left to find smaller item
			
			if(leftPtr >= rightPtr)
				break;
			
			else
				swap(leftPtr, rightPtr);
		}
		swap(leftPtr, right);	//restore pivot
		return leftPtr;			//returns the pivot index
	}
	
	/** Recursive bubble sort caller */
	public void bubble_sort() {
		bsort(1, 1, arr.length - 1, false);
	}
	
	 /** Performs a bubble sort recursively.												   
	  @param start Index for the starting element of the run
	  @param j Index for the current element during the run
	  @param end Index for the last element of the run
	  @param swapped Check value for the end of each run */
	private void bsort(int start, int j, int end, boolean swapped) {
		if(start > end) 
			return;
		
		if(j > end) {		//checks to see if anything was swapped by the end of a single run
			if(!swapped)	//If no elements were swapped by the end of a run the array is sorted.
				return;
				
			else bsort(1, 1, end - 1, false);
		}
		
		else {
			if(arr[j] < arr[j - 1]) {
				swap(j, j - 1);
				bsort(1, j + 1, end, true);
			}
			else bsort(1, j + 1, end, swapped);
		}
	}
	
	//Iterative bubble sort
	public void it_bubble_sort() {
	    boolean swapped;
    	for(int i = 0;i < arr.length;i++) {
    		swapped = false;
        
    		for(int j = 1;j < arr.length;j++) {
    			if(arr[j] < arr[j-1]){
    				swap(j, j - 1);
    				swapped = true;
    			}
    		}
    		if(!swapped) return;
    	}
	}
	
	public void merge_sort(){
		int [] arr2 = new int[arr.length];
		merge(arr2, 0, arr.length/2, arr. length-1);
	}
	
	public void msort(int [] arr2, int lower_bound, int upper_bound) {
		if(upper_bound == lower_bound) 
			return;
		
		else {
			int mid = (lower_bound + upper_bound) / 2;
			
			msort(arr2, lower_bound, mid);
			msort(arr2, mid + 1, upper_bound);
			merge(arr2, lower_bound, mid + 1, upper_bound);
		}
	}
	
	/** Merges two sub arrays, of the class array, defined by the function parameters. 
	  @param arr2 Array that stores the resulting merged array, and is used to copy elements to the class array
	  @param low Index of the start of the lower sub array
	  @param high Index of the start of the higher sub array
	  @param end Index of the last element of the higher sub array */
	private void merge(int [] arr2, int low, int high, int end){
		int i = low, j = high, k = 0;
		arr2 = new int[(end + 1) - low];
		
		while(true){
			if(i > high - 1){
				while(j < end + 1)
					arr2[k++] = arr[j++];
				break;
			}
			
			if(j > end){
				while(i < high)
					arr2[k++] = arr[i++];
				break;
			}
			
			if(arr[i] < arr[j])
				arr2[k++] = arr[i++];
			
			else 
				arr2[k++] = arr[j++];
		}
		
		for(i = low;i < arr2.length;i++)
			arr[i] = arr2[i];
	}
	
	// Swaps elements, specified by passed arguments, of the class array
	private void swap (int i, int j) {
		  int t = arr[i];
		  arr[i] = arr[j];
		  arr[j] = t;
	}
	
	public void setArray(int [] arr){ this.arr = arr; }
	
	public int[] getArray(){ return arr; }
	
	public static void main(String[] args){
		int [] array = {13, 14, 22, 43, 6, 12, 18, 23};
		Sorter sorter = new Sorter(array);
		sorter.merge_sort();
		
		for(Integer a:array){
			System.out.print(a + " ");
		}
	}		
}

