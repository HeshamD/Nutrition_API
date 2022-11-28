package Validation;

public class ValidateInput {
    private static String expresstion ="$#%^&*()!@,.;:'{}';";
    public static boolean isValidString(String input){
        if(input.contains(expresstion)) return false;
        return true;
    }
    public static String normalization(String input){
        return input.toLowerCase().trim().strip().replace(" ","");
    }
}
