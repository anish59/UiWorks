package anish59.helperUtils.utilPack;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by anish on 27-03-2017.
 */

public class AlarmHelper extends BroadcastReceiver {
    private AlarmManager alarmManager;

    @Override
    public void onReceive(Context context, Intent intent) {

    }

    public void setReminder(Context context, Date date, int calId, String title, String subTitle) {
        cancelAlarm(context, calId);
        if (date == null) {
            return;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Log.e("calendar time", "" + calendar);
        PendingIntent pendingIntent;

        Intent intent = new Intent(context, AlarmHelper.class);
        intent.putExtra(UtilConstants.INTENT_TITLE, title);
        intent.putExtra(UtilConstants.INTENT_SUBTITLE, subTitle);
        pendingIntent = PendingIntent.getBroadcast(context, calId, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = getAlarmManager(context);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

    }

    public void cancelAlarm(Context context, long alarmID) { // to cancel the alarm of a specific id.
        Intent intent = new Intent(context, AlarmHelper.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, (int) alarmID, intent, PendingIntent.FLAG_CANCEL_CURRENT);
        AlarmManager alarmManager = getAlarmManager(context);
        alarmManager.cancel(pendingIntent);
    }

    private AlarmManager getAlarmManager(Context context) { //using the alarm service of device

        if (this.alarmManager == null) {
            alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        }
        return alarmManager;
    }
}
