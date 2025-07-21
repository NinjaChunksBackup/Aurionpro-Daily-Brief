package StateDesignPattern2Concept;

public class NoCashState implements ATMState 
{
    private ATMMachine atm;

    public NoCashState(ATMMachine atm) 
    {
        this.atm = atm;
    }

    public void insertCard() 
    {
        System.out.println("ATM out of cash.");
    }

    public void ejectCard() 
    {
        System.out.println("ATM out of cash.");
    }

    public void enterPin(int pin) 
    {
        System.out.println("ATM out of cash.");
    }

    public void withdrawCash(int amount) 
    {
        System.out.println("ATM out of cash.");
    }
}
