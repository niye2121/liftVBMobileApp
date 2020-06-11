package et.com.synctech.mobileappexam.entity;
;import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;
import com.orm.dsl.Column;
import com.orm.dsl.Unique;

/**
 * Created by Queen on 6/10/2020.
 */

public class Employee extends SugarRecord {



    @Column(name="employee_name")
    @SerializedName("employee_name")
    private String name;
    @Column(name="employee_salary")
    @SerializedName("employee_salary")
    private Double salary;
    @Column(name="employee_age")
    @SerializedName("employee_age")
    private Integer age;




    public Employee() {
    }

    public Employee(String name, Double salary, Integer age) {

        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
