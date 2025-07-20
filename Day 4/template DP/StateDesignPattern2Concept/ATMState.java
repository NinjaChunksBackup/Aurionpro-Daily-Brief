package StateDesignPattern2Concept;

public interface ATMState 
{
    void insertCard();
    void ejectCard();
    void enterPin(int pin);
    void withdrawCash(int amount);
}
