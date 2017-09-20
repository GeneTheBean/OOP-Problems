public class DerivedQueue<T> extends Queue<T>{
	public void emergency_push(T item){
		if(empty()) push(item);
		
		else {
			Node<T> n = new Node<T>(item);
			Node<T> temp = head;
			head = n;
			head.next = temp;
		}
		size++;
	}
}
