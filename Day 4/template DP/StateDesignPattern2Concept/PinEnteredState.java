package StateDesignPattern2Concept;

public class PinEnteredState implements ATMState
{
    private ATMMachine atm;

    public PinEnteredState(ATMMachine atm) 
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
        System.out.println("PIN already entered.");
    }

    public void withdrawCash(int amount) 
    {
        if (atm.getCash() < amount) 
        {
            System.out.println("Not enough cash.");
            atm.setState(atm.getNoCashState());
        } else
        {
            System.out.println("Withdrawn: $" + amount);
            atm.setCash(atm.getCash() - amount);

            if (atm.getCash() == 0) 
            {
                atm.setState(atm.getNoCashState());
            } else 
            {
                atm.setState(atm.getNoCardState());
            }
        }
    }
}
