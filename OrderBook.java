import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderBook {

// Priority queue implementation in Java
static class PriorityQueue<T extends Comparable<T>> {
	private List<T> data;

	// Implementing Priority Queue using inbuilt available List in Java
	public PriorityQueue() {
		this.data = new ArrayList<T>();
	}

	// Element Inserting function
	public void Enqueue(T item) {
		// item Insertion
		data.add(item);
		int ci = data.size() - 1;

		// Re-structure heap(Max Heap) so that after addition max element will lie on top of pq
		while (ci > 0) {
			int pi = (ci - 1) / 2;
			if (data.get(ci).compareTo(data.get(pi)) <= 0)
				break;
			T tmp = data.get(ci);
			data.set(ci, data.get(pi));
			data.set(pi, tmp);
			ci = pi;
		}
	}

	public T Dequeue() {
		// deleting top element of pq
		int li = data.size() - 1;
		T frontItem = data.get(0);
		data.set(0, data.get(li));
		data.remove(li);

		--li;
		int pi = 0;

		// Re-structure heap(Max Heap) so that after deletion max element will lie on top of pq
		while (true) {
			int ci = pi * 2 + 1;
			if (ci > li)
				break;
			int rc = ci + 1;
			if (rc <= li && data.get(rc).compareTo(data.get(ci)) < 0)
				ci = rc;
			if (data.get(pi).compareTo(data.get(ci)) >= 0)
				break;
			T tmp = data.get(pi);
			data.set(pi, data.get(ci));
			data.set(ci, tmp);
			pi = ci;
		}
		return frontItem;
	}

	// Function which returns peek element
	public T Peek() {
		T frontItem = data.get(0);
		return frontItem;
	}

	public int Count() {
		return data.size();
	}
}

// Driver code
public static void main(String[] args) {
	// Basic functionality sample of Priority Queue

	// Creating priority queue which contains int in it
	PriorityQueue<Order> pq = new PriorityQueue<Order>();

	// Insert element 1 in pq
	pq.Enqueue(new Order(100L, new Date()));

	System.out.println("Size of orderbook is : " + pq.Count() + " and Best price is : " + pq.Peek().getPrice());

	// Insert element 10 and -8 in pq
	pq.Enqueue(new Order(150L, new Date()));
	pq.Enqueue(new Order(90L, new Date()));

	System.out.println("Size of orderbook is : " + pq.Count() + " and Best price is : " + pq.Peek().getPrice());

	// Delete element from pq
	pq.Dequeue();

	System.out.println("Size of orderbook is : " + pq.Count() + " and Best price is : " + pq.Peek().getPrice());

	// Delete element from pq
	pq.Dequeue();

	System.out.println("Size of orderbook is : " + pq.Count() + " and Best price is : " + pq.Peek().getPrice());

	// Insert element 25 in pq
	pq.Enqueue(new Order(200L, new Date()));

	System.out.println("Size of orderbook is : " + pq.Count() + " and Best price is : " + pq.Peek().getPrice());
}
}
