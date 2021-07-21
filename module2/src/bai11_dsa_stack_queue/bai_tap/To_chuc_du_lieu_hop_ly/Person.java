package bai11_dsa_stack_queue.bai_tap.To_chuc_du_lieu_hop_ly;

public class Person {
    private String name;
    private String gender;
    private int dateOfBirth;
    public  Person(){

    }
    public Person(String name, String gender, int dateOfBirth) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public int getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                '}';
    }
}
