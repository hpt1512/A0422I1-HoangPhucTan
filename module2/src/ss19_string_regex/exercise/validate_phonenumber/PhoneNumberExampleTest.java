package ss19_string_regex.exercise.validate_phonenumber;

import ss19_string_regex.exercise.validate_classname.ClassNameExample;

public class PhoneNumberExampleTest {
    private static PhoneNumberExample phoneNumberExample;

    public static final String[] validPhoneNumber = new String[] { "(84)-(0978489649)", "(84)-(0978489648)", "(84)-(0978489647)", "(84)-(0978489646)","(84)-(0978489645)" };
    public static final String[] invalidPhoneNumber = new String[] { "(a8)-(22222222)", "(a8)-(22222222)", "(a8)-(22222222)", "(a8)-(22222222)" };

    public static void main(String args[]) {
        phoneNumberExample = new PhoneNumberExample();
        for (String phoneNumber : validPhoneNumber) {
            boolean isvalid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number is " + phoneNumber +" is valid: "+ isvalid);
        }
        for (String phoneNumber : invalidPhoneNumber) {
            boolean isvalid = phoneNumberExample.validate(phoneNumber);
            System.out.println("Phone number  is " + phoneNumber +" is valid: "+ isvalid);
        }
    }
}
