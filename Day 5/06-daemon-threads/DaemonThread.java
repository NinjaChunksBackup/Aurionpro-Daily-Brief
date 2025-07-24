public class DaemonThread {
    public static void main(String[] args) {
    	
    	//Daemon Thread - bg task - logging monitoring
    	// core thread performs essential tasks
    	// bg task should stop when primary tasks are done mean core threads are executed
    	
        Thread memoryMonitorThread = new Thread(new MemoryMonitorDaemon());
        memoryMonitorThread.setDaemon(true);
        memoryMonitorThread.start();

        Thread memoryIntensiveTaskThread = new Thread(new MemoryIntensiveTask());
        memoryIntensiveTaskThread.start();
        
        
    }
}