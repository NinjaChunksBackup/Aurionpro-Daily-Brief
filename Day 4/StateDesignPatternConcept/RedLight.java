package StateDesignPatternConcept;

public class RedLight implements TrafficLightState 
{
    public void next(TrafficLight light) 
    {
        light.setState(new GreenLight());
    }

    public void show() 
    {
        System.out.println("Red Light - STOP");
    }
}
