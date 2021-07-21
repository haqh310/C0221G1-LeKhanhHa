package bai18_string_regex.bai_tap.validate_name_class;


public class ClassExampleTest {
    private static ClassExample classExample;

    public static final String[] validClass= new String[] { "C0318G", "C0221G", "M0318G", "P0323A"};

    public static void main(String args[]) {
        classExample = new ClassExample();
        for (String nameClass : validClass) {
            boolean isValid = classExample.validate(nameClass);
            System.out.println("Class is " + nameClass +" is valid: "+ isValid);
        }

    }
}
