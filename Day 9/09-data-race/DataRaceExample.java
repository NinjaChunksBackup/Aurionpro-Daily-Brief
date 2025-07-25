public class DataRaceExample {

	// volatile
    public static volatile boolean  flag = false;
    public static volatile int  count = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread writerThread = new Thread(() -> {
            flag = true;
            System.out.println("Flag set to true");
        });

        Thread readerThread = new Thread(() -> {
            while (!flag) {
            	//System.out.println(1);
            	count++;
            	//System.out.println(count);
                // Waiting for flag to become true - might never see the change
            }
            System.out.println("Flag is true");
            System.out.println(count);
        });
        
        readerThread.start();
        Thread.sleep(100); // Simulating some delay
        writerThread.start();

    }
}

