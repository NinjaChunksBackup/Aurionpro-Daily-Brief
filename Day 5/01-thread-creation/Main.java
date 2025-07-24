public class Main {

	public static class ChildThreadTest implements Runnable {

		@Override
		public void run() {
			count();

		}
//		
	}

		public static void main(String[] args) {
			
			//ChildThreadTest runnable = 	new ChildThreadTest();

			//Thread childThread = new Thread(runnable," child");
			Thread childThread = new Thread(() -> count()," CHILD");
		
			childThread.start();
		

			System.out.println(Thread.currentThread().getName() + " thread");

			count();
		}

		public static void count() {

			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + " : "+ i);
				
				 
			}
		}
	}

