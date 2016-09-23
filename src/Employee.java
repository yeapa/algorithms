import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by ye on 16-8-31.
 */
public class Employee {
    private String name;
    private double salary;
    private Date hireDay;

    Employee(String n, double s, int year, int month, int day) {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
        hireDay = calendar.getTime();
    }

    public void setBonus(){System.out.println("Employee::setBonus");}
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Date getHireDay() {
        return hireDay;
    }

    public void raiseSalary(double byPercent) {
        salary = salary * (1 + byPercent / 100);
    }
}
