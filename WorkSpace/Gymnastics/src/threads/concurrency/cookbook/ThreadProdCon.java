package threads.concurrency.cookbook;

import java.util.Date;
import java.util.LinkedList;

public class ThreadProdCon {
	
	public static void main(String[] args) {
		EventStorage storage=new EventStorage();	
		Producer producer=new Producer(storage);
		Thread thread1=new Thread(producer);
		
		Consumer consumer=new Consumer(storage);
		Thread thread2=new Thread(consumer);
		
		thread2.start();
		thread1.start();
	}


	static class EventStorage {
		private int maxSize;
		private LinkedList<Date> storage;
		public EventStorage(){
			maxSize=10;
			storage=new LinkedList<>();
		}

		public synchronized void set(){
			while (storage.size()==maxSize){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			storage.offer(new Date());
			System.out.printf("Set: %d",storage.size());
			System.out.println();
			notifyAll();
		}


		public synchronized void get(){
			while (storage.size()==0){
				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.printf("Get: %d: %s",storage.
					size(),((LinkedList<?>)storage).poll());
			System.out.println();
			notifyAll();
		}
	}

	static class Producer implements Runnable { 

		private EventStorage storage;
		public Producer(EventStorage storage){
			this.storage=storage;
		}

		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.set();
			}
		}
	}

	static class Consumer implements Runnable { 

		private EventStorage storage;
		public Consumer(EventStorage storage){
			this.storage=storage;
		}

		@Override
		public void run() {
			for (int i=0; i<100; i++){
				storage.get();
			}
		}

	}



}
