package anish59.helperUtils.utilPack;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by anish on 27-03-2017.
 */


//    D	day in year	(Number)	189
//    E	day of week	(Text)	E/EE/EEE:Tue, EEEE:Tuesday, EEEEE:T
//    F	day of week in month	(Number)	2 (2nd Wed in July)
//    G	era designator	(Text)	AD
//    H	hour in day (0-23)	(Number)	0
//    K	hour in am/pm (0-11)	(Number)	0
//    L	stand-alone month	(Text)	L:1 LL:01 LLL:Jan LLLL:January LLLLL:J
//    M	month in year	(Text)	M:1 MM:01 MMM:Jan MMMM:January MMMMM:J
//    S	fractional seconds	(Number)	978
//    W	week in month	(Number)	2
//    Z	time zone (RFC 822)	(Time Zone)	Z/ZZ/ZZZ:-0800 ZZZZ:GMT-08:00 ZZZZZ:-08:00
//    a	am/pm marker	(Text)	PM
//    c	stand-alone day of week	(Text)	c/cc/ccc:Tue, cccc:Tuesday, ccccc:T
//    d	day in month	(Number)	10
//    h	hour in am/pm (1-12)	(Number)	12
//    k	hour in day (1-24)	(Number)	24
//    m	minute in hour	(Number)	30
//    s	second in minute	(Number)	55
//    w	week in year	(Number)	27
//    y	year	(Number)	yy:10 y/yyy/yyyy:2010
//    z	time zone	(Time Zone)	z/zz/zzz:PST zzzz:Pacific Standard Time
//    '	escape for text	(Delimiter)	'Date=':Date=
//            ''	single quote	d(Literal)	'o''clock':o'clock


public class DateHelper {

    //Define date patterns here

    private static int mYear, mMonth, mDay, mHour, mMin;

    public static void getDateFromDialog(Context mContext, final Button button) {
        final Calendar c = Calendar.getInstance();

        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);


        DatePickerDialog datePickerDialog = new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                datePicker.setMinDate(System.currentTimeMillis() - 1000);
                button.setText(String.format("%s-%s-%s", dayOfMonth, monthOfYear + 1, year));
            }
        }, mYear, mMonth, mDay);

        datePickerDialog.show();
        datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
    }

    public static void getTimeFromDilog(Context mContext, final Button button) {
        final Calendar c = Calendar.getInstance();

        mHour = c.get(Calendar.HOUR_OF_DAY); //24 hour format
        mMin = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                button.setText(String.format("%s-%s", hourOfDay, minute));
            }
        }, mHour, mMin, false);
        timePickerDialog.show();
    }

    public static String dateToString(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date).trim();
    }

    public static Date stringToDate(String dateStr, String pattern)
            throws Exception {
        return new SimpleDateFormat(pattern).parse(dateStr);
    }

    public static Calendar toCalendar(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    public static Date toDate(Calendar calObject) {
        Date date = null;
        date = calObject.getTime();
        return date;
    }

    public static Date parseDate(String inputDate, String inputPattern) {
        SimpleDateFormat sdf = new SimpleDateFormat(inputPattern);
        Date date = null;
        try {
            date = sdf.parse(inputDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String formatDate(String inputDate, String inputPattern, String outputPattern) {

        SimpleDateFormat inputFormat = new SimpleDateFormat(inputPattern);
        SimpleDateFormat outPutFormat = new SimpleDateFormat(outputPattern);
        Date date = null;
        String formattedDate = "";

        try {
            date = inputFormat.parse(inputDate);
            formattedDate = outPutFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
}
