package bai18_string_regex.bai_tap.validate_name_class;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ClassExample {
    private final String CLASS_REGEX="^[ACP][0-9]{4}[GHIKLM]$";

    public ClassExample() {
    }
    public boolean validate(String regex){
        Pattern pattern = Pattern.compile(CLASS_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
