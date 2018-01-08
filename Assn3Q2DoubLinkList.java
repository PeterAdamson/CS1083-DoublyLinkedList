//Author Peter Adamson

public class Assn3Q2DoubLinkList{
		
	private Node head, tail;
	private int count;

	public Assn3Q2DoubLinkList(){
		head = null;
		tail = null;
		count = 0;
	}

	public int size(){
		return count;
	}

	public void insert(int value){
		Node node = new Node(value);
		Node current;
		Node prevCurrent;

		if(head == null){
			head = node;
			tail = node;
			System.out.println("Insertion Successful.");
		}

		else if(count == 1){
			if(node.getValue() > head.getValue()){
				head.next = node;
				node.previous = head;
				tail = node;
				System.out.println("Insertion Successful.");
			}
			else{
				head.previous = node;
				node.next = head;
				head = node;
				System.out.println("Insertion Successful.");
			}
		}

		else if((tail.getValue() - head.getValue()) > node.getValue()){
			prevCurrent = head;			
			current = head.next;
			while(current != null){
				if(node.getValue() < head.getValue()){
					head.previous = node;
					node.next = head;
					head = node;
					System.out.println("Insertion Successful.");
					break;
				}
				else if(current.getValue() >= node.getValue()){
					node.next = current;
					current.previous = node;
					node.previous = prevCurrent;
					prevCurrent.next = node;
					System.out.println("Insertion Successful.");
					break;
				}
				else if(node.getValue() > tail.getValue()){
					tail.next = node;
					node.previous = tail;
					tail = node;
					System.out.println("Insertion Successful.");
					break;
				}
				prevCurrent = current;
				current = current.next;	
			}		
		}

		else{
			prevCurrent = tail;
			current = tail.previous;
			while(current != null){
				if(node.getValue() > tail.getValue()){
					tail.next = node;
					node.previous = tail;
					tail = node;
					System.out.println("Insertion Successful.");
					break;
				}
				else if(current.getValue() <= node.getValue()){
					node.previous = current;
					current.next = node;
					node.next = prevCurrent;
					prevCurrent.previous = node;
					System.out.println("Insertion Successful.");
					break;
				}
				else if(node.getValue() < head.getValue()){
					head.previous = node;
					node.next = head;
					head = node;
					System.out.println("Insertion Successful.");
					break;
				}
				prevCurrent = current;
				current = current.previous;
			}
		}
		count++;
	}

	public String toStringAscending(){
		Node current = head;
		String end = String.format("%d", current.value);
		
		while(current.next != null){
			current = current.next;
			end = String.format("%s, %d", end, current.value); 
		}
	
		return end;
	}

	public String toStringDescending(){
		Node current = tail;
		String end = String.format("%d", current.value);
		
		while(current.previous != null){
			current = current.previous;
			end = String.format("%s, %d", end, current.value); 
		}
	
		return end;
	}

	private class Node {
		private int value;
		private Node next, previous;
	
		public Node(int value){
			this.value = value;
			next = null;
			previous = null;
		}
		
		public int getValue(){
			return value;
		}
	}
}
