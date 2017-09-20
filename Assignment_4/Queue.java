public class Queue<T> {
	//Construct queue.
	public Queue(){	
		head = tail = new Node<T>(null);
		size = 0;
	};	
	
	//Test whether container is empty.
	public boolean empty(){	
		return size == 0;
	};             
	
	//Return size.
	public int size(){	
		return size;
	};	
	
	//Access next element.
	public T front(){
		if(!empty())
			return head.nodeValue;
		else return null;
	}
	
	//Access last element.
	public T back(){
		if(!empty())
			return tail.nodeValue;
		else return null;
	}
	
	//Insert element.
	public void push(final T item){
		Node<T> n = new Node<T>(item);
		if(empty()) 
			head = tail = n;
		
		else if(size() == 1){
			head.next = n;
			tail = n;
		}
		
		else{
			Node<T> temp = tail;
			tail = n;
			temp.next = n;
		}
		size++;
	};         
	
	//Remove next element.
	public void pop(){
		if(empty()){
			System.out.println("No elements to pop.");
			return;
		}
		
		else if(size() == 1){
			head = tail = new Node<T>(null);
		}
		
		else head = head.next;
		
		size --;
	};                
	
	//Print all elements of queue.
	public void printQueue(){
		if(empty()){
			System.out.println("Queue is empty, no elements to print.");
			return;
		}
		
		Node<T> n = head;
		while(n != null){
			System.out.print(n.nodeValue + " ");
			n = n.next;
		}
		System.out.println();
	};         
	
	protected int size;
	protected Node<T> head;
	protected Node<T> tail;	
}
