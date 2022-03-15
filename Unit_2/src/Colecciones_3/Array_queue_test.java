package Colecciones_3;

import java.util.ArrayDeque;
import java.util.Queue;

public class Array_queue_test implements Comparable{

		static int mikePhone = 699924569;
		static int paulPhone = 699924888;
	public static void main(String[] args) {
		Queue<Integer> taskQueue = new ArrayDeque<Integer>();
		//offer() añade una nueva variable a la lista
		taskQueue.offer(mikePhone);
		taskQueue.offer(paulPhone);
		//Peek() coge el primero en la lista
		int print = taskQueue.peek();
		System.out.println(print);
		//poll() elimina el primero de la lista
		taskQueue.poll();
		System.out.println(taskQueue.peek());
		
		//Como recorrer lista, printear todo y luego vaciarlo
		while(!taskQueue.isEmpty()) {
			int p = taskQueue.poll();
			System.out.println(p);
		}
		taskQueue.offer(mikePhone);
		taskQueue.offer(paulPhone);
		((ArrayDeque<Integer>) taskQueue).offerFirst(paulPhone);
		System.out.println("----------");
		while(!taskQueue.isEmpty()) {
			int p = taskQueue.poll();
			System.out.println(p);
		}

	}
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
