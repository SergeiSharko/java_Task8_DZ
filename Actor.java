package Task2;

public abstract class Actor implements ActorBehavior {

    protected String name;
    protected boolean isMakeOrder;
    protected boolean isTakeOrder;

    abstract String getName();
    
}
