package StateDesignPattern2Concept;

public class ATMMachine 
{
    private ATMState noCardState;
    private ATMState hasCardState;
    private ATMState pinEnteredState;
    private ATMState noCashState;

    private ATMState currentState;
    private int cash;

    public ATMMachine(int initialCash) 
    {
        noCardState = new NoCardState(this);
        hasCardState = new HasCardState(this);
        pinEnteredState = new PinEnteredState(this);
        noCashState = new NoCashState(this);

        this.cash = initialCash;

        if (initialCash > 0) {
            currentState = noCardState;
        } else {
            currentState = noCashState;
        }
    }

  
    public void insertCard() {
        currentState.insertCard();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void enterPin(int pin) {
        currentState.enterPin(pin);
    }

    public void withdrawCash(int amount) {
        currentState.withdrawCash(amount);
    }

    public void setState(ATMState state) {
        this.currentState = state;
    }

    public ATMState getNoCardState() {
        return noCardState;
    }

    public ATMState getHasCardState() {
        return hasCardState;
    }

    public ATMState getPinEnteredState() {
        return pinEnteredState;
    }

    public ATMState getNoCashState() {
        return noCashState;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }
}
