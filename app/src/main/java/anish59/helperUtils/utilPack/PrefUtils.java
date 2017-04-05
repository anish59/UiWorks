package anish59.helperUtils.utilPack;

import android.content.Context;

/**
 * This class can be considered as a demo class, just to know how you can access and store in SharedPreference.
 */

public class PrefUtils {

    public static String IS_LOGGED_IN = "IS_LOGGED_IN";
    public static String USER_ID = "USER_ID";
    public static String USER_NAME = "USER_NAME";
    public static String PASSWORD = "PASSWORD";
    public static String OBJ = "OBJ";

    public static void setIsLoggedIn(Context context, boolean isLoggedIn) {
        Prefs.with(context).save(IS_LOGGED_IN, isLoggedIn);
    }

    public static void setUserId(Context context, String userId) {
        Prefs.with(context).save(USER_ID, userId);
    }

    public static void setUserName(Context context, String userName) {
        Prefs.with(context).save(USER_NAME, userName);
    }

    public static void setPASSWORD(Context context, String password) {
        Prefs.with(context).save(PASSWORD, password);
    }

    public static boolean getIsLoggedIn(Context context) {
        return Prefs.with(context).getBoolean(IS_LOGGED_IN, false);
    }

    public static String getUserId(Context context) {
        return Prefs.with(context).getString(USER_ID, "");
    }

    public static String getUserName(Context context) {
        return Prefs.with(context).getString(USER_NAME, "");
    }

    public static String getPassword(Context context) {
        return Prefs.with(context).getString(PASSWORD, "");
    }

    /**
     * Demo of storing an object as accessing the same is as below
     */

    /************************************************************************************
     public static void setNextDateListResponse(Context context, NextDateListResponse nextDateListResponse) {
     String text = PSPLApplication.getGson().toJson(nextDateListResponse);
     Prefs.with(context).save(NEXTDATE, text);
     }

     public static NextDateListResponse getNextDateListResponse(Context context) {
     NextDateListResponse nextDateListResponse = new NextDateListResponse();
     String text = Prefs.with(context).getString(NEXTDATE, "");
     if (!TextUtils.isEmpty(text)) {
     nextDateListResponse = PSPLApplication.getGson().fromJson(text, NextDateListResponse.class);
     }
     return nextDateListResponse;
     }

     **************************************************************************************/
}
