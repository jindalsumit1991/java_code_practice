import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.locks.*;

class ThreadPoolFactory implements Callable<Integer> {
	final static Lock lock = new ReentrantLock();
    final static Condition notFull  = lock.newCondition(); 
    final static Condition notEmpty = lock.newCondition();
	
	public enum Role{
		PRODUCER,
		CONSUMER,
		UNKNOWN
	};
	
	final int CAPACITY = 10;
	Role role;
	private static volatile int i = 0;
	private volatile boolean isRunning = true;
	private List<String> list;
	
	public ThreadPoolFactory(Role role, List<String> l){
		this.list = l;
		this.role = role;
	}
	
	public Integer call() throws Exception{
		if(role == Role.PRODUCER){
			produce();
		}
		else if(role == Role.CONSUMER){
			consume();
		}
		else
			return null;
		return 0;
	}
	
	private void produce() throws InterruptedException {
		while(true){
			lock.lock();
			try{
				while(list.size()  == CAPACITY){
					System.out.println("--------------------------------------");
					System.out.println("List is full to its CAPACITY, waiting");
					System.out.println("--------------------------------------");
					notEmpty.await();
				}
				if(i == 100)
					i = 0;
				String str = "Data " + i++;
				System.out.println(Thread.currentThread().getName() + " : PUSH -> " + str);
				list.add(str);
				notFull.signalAll();
			}
			finally{
				lock.unlock();
				Thread.sleep(400);
			}
		}
	}
	
	private void consume() throws InterruptedException{
		while(true){
			lock.lock();
			try{
				while(list.size() == 0){
					System.out.println("-----------------------");
					System.out.println("List is empty, waiting");
					System.out.println("-----------------------");
					notFull.await();
				}
				String str = list.remove(list.size()-1);
				System.out.println(Thread.currentThread().getName() + " :    " + str + " -> POP");
				notEmpty.signal();
			}
			finally{
				lock.unlock();
				Thread.sleep(1000);
			}
		}
	}
}

public class ProducerConsumerExecuter{
	public static void main(String[] args){
		List<String> l = new ArrayList<>();
		
		ExecutorService producerExecutor = Executors.newFixedThreadPool(5);
		ExecutorService consumerExecutor = Executors.newFixedThreadPool(3);
		
		producerExecutor.submit(new ThreadPoolFactory(ThreadPoolFactory.Role.PRODUCER,l));
		
		try{
			Thread.sleep(2000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		consumerExecutor.submit(new ThreadPoolFactory(ThreadPoolFactory.Role.CONSUMER,l));
	}
}