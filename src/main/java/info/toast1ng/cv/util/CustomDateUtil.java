package info.toast1ng.cv.util;

import java.util.Calendar;
import java.util.Date;

public class CustomDateUtil {
    public static Date makeDate(int year, int month) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);
        calendar.set(Calendar.DATE, 1);
        calendar.set(Calendar.HOUR, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }

    public static String getDateString(Calendar calendar) {
        String dateString = "" + calendar.get(Calendar.YEAR) + ".";
        int month = calendar.get(Calendar.MONTH) + 1;
        if (month < 10) {
            dateString += "0";
        }
        dateString += month;
        return dateString;
    }
}
