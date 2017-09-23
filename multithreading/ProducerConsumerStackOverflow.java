<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadFactory {
    List<String> list = new ArrayList<>();
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final int CAPACITY = 10;

    public int i = 0;

    class Producer extends Thread {

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce() throws InterruptedException {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        while (true) {
            lock.lock();
            try {
                while (list.size() == CAPACITY) {
                    System.out.println("List is full to its CAPACITY, producer waiting");
                    notFull.await();
                }
                if (i == CAPACITY) i=0;
                String str = "Data " + i++;
                System.out.println("Putting " + str + " to list of size "+list.size());
                list.add(str);
                if (list.size() ==1 )
                    notEmpty.signal();
            } finally {
                lock.unlock();
                Thread.sleep(500);
            }
        }
    }

    private void consume() throws InterruptedException {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        while (true) {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println("List is empty, consumer waiting");
                    notEmpty.await();
                }
                String str = list.remove(list.size() - 1);
                System.out.println("Popping " + str + " from list of size "+list.size());
                if (list.size() == CAPACITY-1 )
                    notFull.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public ThreadFactory(List<String> l ){
        this.list = l;
        Thread p = new Producer();
        p.setName("Producer");
        p.start();
        Thread c=new Consumer();
        c.setName("Consumer");
        c.start();
    }
}

public class ProducerConsumerStackOverflow {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        ThreadFactory pc = new ThreadFactory(l);
    }
=======
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ThreadFactory {
    List<String> list = new ArrayList<>();
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();
    final Condition notEmpty = lock.newCondition();
    final int CAPACITY = 10;

    public int i = 0;

    class Producer extends Thread {

        @Override
        public void run() {
            try {
                produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer extends Thread {

        @Override
        public void run() {
            try {
                consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce() throws InterruptedException {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        while (true) {
            lock.lock();
            try {
                while (list.size() == CAPACITY) {
                    System.out.println("List is full to its CAPACITY, producer waiting");
                    notFull.await();
                }
                if (i == CAPACITY) i=0;
                String str = "Data " + i++;
                System.out.println("Putting " + str + " to list of size "+list.size());
                list.add(str);
                if (list.size() ==1 )
                    notEmpty.signal();
            } finally {
                lock.unlock();
                Thread.sleep(500);
            }
        }
    }

    private void consume() throws InterruptedException {
        System.out.println("Starting thread " + Thread.currentThread().getName());
        while (true) {
            lock.lock();
            try {
                while (list.size() == 0) {
                    System.out.println("List is empty, consumer waiting");
                    notEmpty.await();
                }
                String str = list.remove(list.size() - 1);
                System.out.println("Popping " + str + " from list of size "+list.size());
                if (list.size() == CAPACITY-1 )
                    notFull.signal();
            } finally {
                lock.unlock();
            }
        }
    }

    public ThreadFactory(List<String> l ){
        this.list = l;
        Thread p = new Producer();
        p.setName("Producer");
        p.start();
        Thread c=new Consumer();
        c.setName("Consumer");
        c.start();
    }
}

public class ProducerConsumerStackOverflow {
    public static void main(String[] args) {
        List<String> l = new ArrayList<>();
        ThreadFactory pc = new ThreadFactory(l);
    }
>>>>>>> cbe65f09e34485ecd7ffc641b9e784ccc8c0c06e
}