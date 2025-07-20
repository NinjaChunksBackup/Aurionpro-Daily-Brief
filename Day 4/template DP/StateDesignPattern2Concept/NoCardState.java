package StateDesignPattern2Concept;

public class NoCardState implements ATMState 
{
    private ATMMachine atm;

    public NoCardState(ATMMachine atm) 
    {
        this.atm = atm;
    }

    public void insertCard() 
    {
        System.out.println("Card inserted.");
        atm.setState(atm.getHasCardState());
    }

    public void ejectCard() 
    {
        System.out.println("No card to eject.");
    }

    public void enterPin(int pin) 
    {
        System.out.println("Insert card first.");
    }

    public void withdrawCash(int amount) 
    {
        System.out.println("Insert card first.");
    }
}
