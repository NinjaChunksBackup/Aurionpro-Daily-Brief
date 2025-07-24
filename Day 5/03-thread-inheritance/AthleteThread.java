
public class AthleteThread extends Thread {
	
	private int id;

	public AthleteThread(String name,int priority ,int id) {
		this.id = id;
		this.setName(name);
		this.setPriority(priority);
	}

	public int getBibNumber() {
		return id;
	}

	public void setBibNumber(int bibNumber) {
		this.id = bibNumber;
	}

	@Override
	public void run() {
		double distanceKM = 10;
		
        double steps = 0.00000001;
        for (double i = 0; i <= distanceKM; i += steps) {
            if (Math.abs(i - distanceKM) < steps) {
                System.out.println("\nAthlete number " + id + " named "+ this.getName() +" has finished the race.\n");
                break; 
            }
        }
		
	}
	
	

}
