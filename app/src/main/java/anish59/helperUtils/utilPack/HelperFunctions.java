package anish59.helperUtils.utilPack;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import anish59.helperUtils.BuildConfig;

/**
 * Created by anish on 03-04-2017.
 */

public class HelperFunctions {
    private enum logType {d, e}

    public static void utilLog(logType type, String tag, String print) {
        if (BuildConfig.DEBUG) {
            switch (type) {
                case d:
                    Log.d(tag, print);
                    break;
                case e:
                    Log.e(tag, print);
                    break;
            }
        }
    }

    public static void simpleToast(Context ctx, String msg, boolean isDebug) {
        if (isDebug) {

            if (BuildConfig.DEBUG) {
                Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(ctx, msg, Toast.LENGTH_SHORT).show();
        }
    }
    //todo: need to have a nice animated toast keep in mind to make it
}
