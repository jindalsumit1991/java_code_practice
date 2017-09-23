
import java.util.concurrent.LinkedBlockingQueue;

public class MyThreadPool {

    private final int thread_count;
    private final TaskExecutor[] threads;
    private final LinkedBlockingQueue queue;
 
    //Constructor to create a new thread pool with count as number of threads in the pool
    public ThreadPool(int count) {
        this.thread_count = count;
        queue = new LinkedBlockingQueue();
        threads = new TaskExecutor[thread_count];
 
        for (int i = 0; i < thread_count; i++) {
            threads[i] = new TaskExecutor();
            threads[i].start();
        }
    }
 
    public void execute(Runnable task) {
        synchronized (queue) {
            queue.add(task);
            queue.notify();
        }
    }
 
    private class TaskExecutor implements Runnable {
        public void run() {
            Runnable task;
 
            while (true) {
                synchronized (queue) {
                    while (queue.isEmpty()) {
                        try {
                            queue.wait();
                        } catch (InterruptedException e) {
                            System.out.println("Thread interrupted while waiting: " + e.getMessage());
                        }
                    }
                    task = queue.poll();
                }
                task.run();
            }
        }
    }
}

public class Task implements Runnable {
 
    private int num;
    public Task(int n) {
        num = n;
    }
	
    public void run() {
        System.out.println("Task " + num + " is running.");
    }
}


//Sample Main class
public class Main {
 
    public static void main(String[] args) {
        MyThreadPool pool = new ThreadPool(4);
 
        for (int i = 0; i < 4; i++) {
            Task task = new Task(i);
            pool.execute(task);
        }
}
