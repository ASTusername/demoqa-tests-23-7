package utils;

public class LeapYearUtils {

    public static int getMaxDayOfFebruary(String year) {
        int checkedYear = Integer.parseInt(year);
        if ((checkedYear > 1584) && (((checkedYear % 400) == 0) || (((checkedYear % 4) == 0) && ((checkedYear % 100) != 0)))) {
            return 29;
        }
        return 28;
    }
}
