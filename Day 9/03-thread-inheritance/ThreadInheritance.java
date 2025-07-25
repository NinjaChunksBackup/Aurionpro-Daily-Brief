public class ThreadInheritance {

    public static void main(String[] args) {
        // Creating the first athlete thread
        AthleteThread firstAthlete = new AthleteThread("suraj",Thread.MAX_PRIORITY,10);
        AthleteThread secondAthlete = new AthleteThread("pankaj",Thread.MIN_PRIORITY,20);

        // Starting the threads
        firstAthlete.start();
        secondAthlete.start();
    }

  
}