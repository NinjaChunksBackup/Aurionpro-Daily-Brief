public class ThreadJoin {

    public static void main(String[] args) throws InterruptedException {

        PlayerThread[] threads = new PlayerThread[4];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new PlayerThread(i+1);
            threads[i].start();
        }
        
        
        for (PlayerThread playerThread : threads) {
			playerThread.join();
		}
       
        
        int winningScore = 0;
        int winner = 0;
        for (int i = 0; i < threads.length; i++) {
            if (threads[i].getScore() > winningScore) {
                winningScore = threads[i].getScore();
                winner = i + 1;
            }
        }

        System.out.println("Player " + winner + " wins with a score of " + winningScore);

    }
}