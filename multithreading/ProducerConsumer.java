<<<<<<< HEAD
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

class ThreadFactory implements Runnable{
	List<String> list = new ArrayList<>();
	Thread prThread;
	final static Lock lock = new ReentrantLock();
    final static Condition notFull  = lock.newCondition(); 
    final static Condition notEmpty = lock.newCondition();
	final int CAPACITY = 10;
	
	public enum Role{
		PRODUCER,
		CONSUMER
	};
	Role role;
	private static volatile int i = 0;
	
	private void produce() throws InterruptedException {
		while(true){
			lock.lock();
			try{
				while(list.size()  == CAPACITY){
					System.out.println("List is full to its CAPACITY, waiting");
					notEmpty.await();
				}
				if(i == 100)
					i = 0;
				String str = "Data " + i++;
				System.out.println(Thread.currentThread().getName() + " : Putting " + str + " to list");
				list.add(str);
				notFull.signalAll();
			}
			finally{
				lock.unlock();
				Thread.sleep(200);
			}
		}
	}
	
	private void consume() throws InterruptedException{
		while(true){
			lock.lock();
			try{
				while(list.size() == 0){
					System.out.println("List is empty, waiting");
					notFull.await();
				}
				String str = list.remove(list.size()-1);
				System.out.println("Popping " + str + " from list");
				notEmpty.signal();
			}
			finally{
				lock.unlock();
				Thread.sleep(200);
			}
		}
	}
	
	public void run(){
		System.out.println("Starting thread " + prThread.getName());
		try{
			if(role == Role.PRODUCER){
				produce();
			}			
			else if(role == Role.CONSUMER){
				consume();
			}
		}
		catch(InterruptedException e){
			System.out.println("Thread interrupted");
		}
	}
	
	public ThreadFactory(List<String> l, int role, String name){
		this.list = l;
		prThread = new Thread(this, name);
		if(role == 0)
			this.role = Role.PRODUCER;
		else
			this.role = Role.CONSUMER;
		prThread.start();
	}
}

public class ProducerConsumer{
	public static void main(String[] args){
		List<String> l = new ArrayList<>();
		ThreadFactory p = new ThreadFactory(l,0, "Producer1");
		ThreadFactory p1 = new ThreadFactory(l,0, "Producer2");
		ThreadFactory p2 = new ThreadFactory(l,0, "Producer3");
		try{
			Thread.sleep(10000);
		}
		catch(Exception e){e.printStackTrace();}
		ThreadFactory c = new ThreadFactory(l,1, "Consumer");
	}
=======
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.locks.*;

class ThreadFactory implements Runnable{
	List<String> list = new ArrayList<>();
	Thread prThread;
	final static Lock lock = new ReentrantLock();
    final static Condition notFull  = lock.newCondition(); 
    final static Condition notEmpty = lock.newCondition();
	final int CAPACITY = 10;
	
	public enum Role{
		PRODUCER,
		CONSUMER
	};
	Role role;
	private static volatile int i = 0;
	
	private void produce() throws InterruptedException {
		while(true){
			lock.lock();
			try{
				while(list.size()  == CAPACITY){
					System.out.println("List is full to its CAPACITY, waiting");
					notEmpty.await();
				}
				if(i == 100)
					i = 0;
				String str = "Data " + i++;
				System.out.println(Thread.currentThread().getName() + " : Putting " + str + " to list");
				list.add(str);
				notFull.signalAll();
			}
			finally{
				lock.unlock();
				Thread.sleep(200);
			}
		}
	}
	
	private void consume() throws InterruptedException{
		while(true){
			lock.lock();
			try{
				while(list.size() == 0){
					System.out.println("List is empty, waiting");
					notFull.await();
				}
				String str = list.remove(list.size()-1);
				System.out.println("Popping " + str + " from list");
				notEmpty.signal();
			}
			finally{
				lock.unlock();
				Thread.sleep(200);
			}
		}
	}
	
	public void run(){
		System.out.println("Starting thread " + prThread.getName());
		try{
			if(role == Role.PRODUCER){
				produce();
			}			
			else if(role == Role.CONSUMER){
				consume();
			}
		}
		catch(InterruptedException e){
			System.out.println("Thread interrupted");
		}
	}
	
	public ThreadFactory(List<String> l, int role, String name){
		this.list = l;
		prThread = new Thread(this, name);
		if(role == 0)
			this.role = Role.PRODUCER;
		else
			this.role = Role.CONSUMER;
		prThread.start();
	}
}

public class ProducerConsumer{
	public static void main(String[] args){
		List<String> l = new ArrayList<>();
		ThreadFactory p = new ThreadFactory(l,0, "Producer1");
		ThreadFactory p1 = new ThreadFactory(l,0, "Producer2");
		ThreadFactory p2 = new ThreadFactory(l,0, "Producer3");
		try{
			Thread.sleep(10000);
		}
		catch(Exception e){e.printStackTrace();}
		ThreadFactory c = new ThreadFactory(l,1, "Consumer");
	}
>>>>>>> cbe65f09e34485ecd7ffc641b9e784ccc8c0c06e
}