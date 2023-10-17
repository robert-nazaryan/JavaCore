package homeworks.medicalCenter.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy hh:mm");

    public static Date stringToDate(String strData) throws ParseException {
        return SDF.parse(strData);
    }

    public static String dateToString(Date date) {
        return SDF.format(date);
    }
}
