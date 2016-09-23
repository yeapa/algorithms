/**
 * Created by ye on 16-9-2.
 */
public class Manage extends Employee{
    Manage(String n, double s, int year, int month, int day) {
        super(n, s, year, month, day);
    }
    public void setBonus(){
        System.out.println("manage::setBonus");
    }
}
