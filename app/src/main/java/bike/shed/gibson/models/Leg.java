package bike.shed.gibson.models;

/**
 * Created by tag on 11/2/14.
 */
public class Leg {
    public int id;
    public boolean complete;
    public String type;
    public String code;
    public Stop destination;
    public Stop origin;
    public ServiceProvider carrier;
}
