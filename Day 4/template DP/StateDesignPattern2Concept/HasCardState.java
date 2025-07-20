package StateDesignPattern2Concept;

public class HasCardState implements ATMState 
{
    private ATMMachine atm;

    public HasCardState(ATMMachine atm) 
    {
        this.atm = atm;
    }

    public void insertCard() 
    {
        System.out.println("Card already inserted.");
    }

    public void ejectCard() 
    {
        System.out.println("Card ejected.");
        atm.setState(atm.getNoCardState());
    }

    public void enterPin(int pin) 
    {
        if (pin == 1234) 
        {
            System.out.println("Correct PIN.");
            atm.setState(atm.getPinEnteredState());
        } else 
        {
            System.out.println("Incorrect PIN.");
        }
    }

    public void withdrawCash(int amount) 
    {
        System.out.println("Enter PIN first.");
    }
}

