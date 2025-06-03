package za.ac.cput.util;

public class Helper {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String cleanString(String str) {
        return str == null ? null : str.trim();
    }
}