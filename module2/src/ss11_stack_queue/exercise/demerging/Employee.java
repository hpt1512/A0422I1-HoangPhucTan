package ss11_stack_queue.exercise.demerging;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Employee {
    private String name;
    private String gender;
    private LocalDate birthday;

    public Employee() {

    }

    public Employee(String name, String gender, LocalDate birthday) {
        this.name = name;
        this.gender = gender;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }
}
