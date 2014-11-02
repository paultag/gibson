package bike.shed.gibson.models;


import java.util.Date;
import java.util.List;

public class Trip {
    public int id;
    public String name;
    public String reason;
    public User user;
    public List<Stay> stays;
    public List<Leg> legs;
}
