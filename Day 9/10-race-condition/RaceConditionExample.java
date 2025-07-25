import java.util.concurrent.atomic.AtomicInteger;

public class RaceConditionExample {
	
	
    public static int count = 0;
  
   // public static AtomicInteger count = new  AtomicInteger(0);
    public static Object lock = new Object();
    
    public static void increment() {
    	//count.incrementAndGet();  //Atomic steps are executed as single steps one thread at a time
       // count++; // Non-atomic increment can cause race condition
        
        synchronized (lock) {
        	count++;
        }
        
        // 250
       // 250 - 251 count = 251  --- t1 t2 
    }

  
    public static int getCount() {
       return count;
    	//return count.get();
    }

    public static void main(String[] args) throws InterruptedException {

        Runnable incrementTask = () -> {
            for (int i = 0; i < 1000; i++) {
                increment();
            }
        };

        Thread t1 = new Thread(incrementTask);
        Thread t2 = new Thread(incrementTask);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count (might be incorrect): " + getCount());
    }
    
}









