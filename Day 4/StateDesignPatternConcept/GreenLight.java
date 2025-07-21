package StateDesignPatternConcept;

public class GreenLight implements TrafficLightState 
{
    public void next(TrafficLight light) 
    {
        light.setState(new YellowLight());
    }

    public void show() 
    {
        System.out.println("Green Light - GO");
    }
}
