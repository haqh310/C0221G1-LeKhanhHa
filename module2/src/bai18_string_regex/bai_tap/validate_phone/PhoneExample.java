package bai18_string_regex.bai_tap.validate_phone;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneExample {
    private final String PHONE_REGEX="^\\([0-9]{2}\\)-\\(0[0-9]{9}\\)$";

    public PhoneExample() {
    }
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(PHONE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
