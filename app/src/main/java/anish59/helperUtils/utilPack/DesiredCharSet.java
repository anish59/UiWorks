package anish59.helperUtils.utilPack;

import android.text.InputFilter;
import android.text.Spanned;

/**
 * Created by anish on 03-04-2017.
 */

public class DesiredCharSet implements InputFilter {
    private String charSet = "";
    private boolean isCharSetAllowed = false;

    public DesiredCharSet(String charSet, boolean isCharSetAllowed) {
        this.charSet = charSet;
        this.isCharSetAllowed = isCharSetAllowed;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
        if (isCharSetAllowed) {
            if (!(source != null && charSet.contains(("" + source)))) {
                return "";
            }
        } else {
            if (source != null && charSet.contains(("" + source))) {
                return "";
            }
        }
        return null;
    }
}
