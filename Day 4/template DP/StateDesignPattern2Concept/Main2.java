package StateDesignPattern2Concept;

public class Main2 {
    public static void main(String[] args) 
    {
        ATMMachine atm = new ATMMachine(500); 

        atm.insertCard();
        atm.enterPin(1234);
        atm.withdrawCash(100);

        atm.insertCard();
        atm.enterPin(1234);
        atm.withdrawCash(50); 

        atm.insertCard(); 
    }
}
