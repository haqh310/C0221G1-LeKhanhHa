package bai11_dsa_stack_queue.bai_tap.To_chuc_du_lieu_hop_ly;

import java.util.*;

public class UseQueue {
    public static void main(String[] args) {
        Person[] persons = new Person[5];
        persons[0] = new Person("A", "male", 1999);
        persons[1] = new Person("B", "male", 1995);
        persons[2] = new Person("F", "female", 2000);
        persons[3] = new Person("H", "female", 1988);
        persons[4] = new Person("J", "female", 2002);
        final Queue<Person> MALE = new LinkedList<>();
        final Queue<Person> FEMALE = new LinkedList<>();

        Stack<Person> output = new Stack<>();
        Comparator<Person> comparator = new Comparator<>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getDateOfBirth() - o2.getDateOfBirth();
            }
        };
        Arrays.sort(persons,comparator);

        for (Person person : persons) {
            if (person.getGender().equals("male")) {
                MALE.add(person);
            } else {
                FEMALE.add(person);
            }
        }
        while (!FEMALE.isEmpty()){
            output.add(FEMALE.remove());
        }
        while (!MALE.isEmpty()){
            output.add(MALE.remove());
        }
        for(Person person:output){
            System.out.println(person);
        }
    }
}
