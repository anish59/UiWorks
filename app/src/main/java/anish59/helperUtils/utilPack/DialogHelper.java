package anish59.helperUtils.utilPack;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by anish on 27-03-2017.
 */

public class DialogHelper {
    DialogOptionsSelectedListener optionsSelectedListener;

    public static void showMessage(Context context, String msg, final DialogOptionsSelectedListener selectedListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (selectedListener != null) {
                            selectedListener.onSelect(true);
                            dialog.dismiss();
                        }
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public static void dialogWithTwoOpt(Context mContext, String message, final DialogOptionsSelectedListener selectedListener, String yesOption, String noOption) {
        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setMessage(message)
                .setCancelable(false)
                .setPositiveButton(yesOption, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (selectedListener != null)
                            selectedListener.onSelect(true);
                        dialog.dismiss();
                    }

                })
                .setNegativeButton(noOption, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (selectedListener != null)
                            selectedListener.onSelect(false);
                        dialog.dismiss();
                    }
                });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public interface DialogOptionsSelectedListener {
        void onSelect(boolean isYes);
    }
    //Todo: need have a nice animated custom dialog just keep in mind
}
