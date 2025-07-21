package StateDesignPatternConcept;

public class TrafficLight 
{
    private TrafficLightState state;

    public TrafficLight() 
    {
        state = new RedLight();
    }

    public void setState(TrafficLightState state) 
    {
        this.state = state;
    }

    public void change() 
    {
        state.next(this);
    }

    public void showLight() 
    {
        state.show();
    }
}
