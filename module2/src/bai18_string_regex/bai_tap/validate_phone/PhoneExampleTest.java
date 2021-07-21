package bai18_string_regex.bai_tap.validate_phone;

public class PhoneExampleTest {
    private static PhoneExample phoneExample;

    public static final String[] validPhone= new String[] { "(84)-(0978489648)", "(84)-(0983470724)", "(a8)-(22222222)", "(84)-(222a2222)"};

    public static void main(String args[]) {
        phoneExample = new PhoneExample();
        for (String phone : validPhone) {
            boolean isValid = phoneExample.validate(phone);
            System.out.println("Number phone is " + phone +" is valid: "+ isValid);
        }

    }
}
