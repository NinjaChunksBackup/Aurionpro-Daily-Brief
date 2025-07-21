package StateDesignPatternConcept;

public class YellowLight implements TrafficLightState 
{
    public void next(TrafficLight light) 
    {
        light.setState(new RedLight());
    }

    public void show() 
    {
        System.out.println("Yellow Light - SLOW DOWN");
    }
}
