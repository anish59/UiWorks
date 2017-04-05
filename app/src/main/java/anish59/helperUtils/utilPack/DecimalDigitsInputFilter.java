package anish59.helperUtils.utilPack;

import android.text.InputFilter;
import android.text.Spanned;

public class DecimalDigitsInputFilter implements InputFilter {

    private int MAX_DIGITS_BEFORE_DECIMAL_POINT=0;
    private int MAX_DIGITS_AFTER_DECIMAL_POINT=0;

    public DecimalDigitsInputFilter(int MAX_DIGITS_BEFORE_DECIMAL_POINT, int MAX_DIGITS_AFTER_DECIMAL_POINT) {
        this.MAX_DIGITS_BEFORE_DECIMAL_POINT = MAX_DIGITS_BEFORE_DECIMAL_POINT;
        this.MAX_DIGITS_AFTER_DECIMAL_POINT = MAX_DIGITS_AFTER_DECIMAL_POINT;
    }

    @Override
    public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {


        StringBuilder builder = new StringBuilder(dest);
        builder.replace(dstart, dend, source
                .subSequence(start, end).toString());
        if (!builder.toString().matches(
                "(([0-9]{1})([0-9]{0," + (MAX_DIGITS_BEFORE_DECIMAL_POINT - 1) + "})?)?(\\.[0-9]{0," + MAX_DIGITS_AFTER_DECIMAL_POINT + "})?"

        )) {

            if (source.length() == 0)
                return dest.subSequence(dstart, dend);
            return "";
        }
        if (builder.length() == 1) {
            String s = builder.toString().trim();
            if (builder.toString().equals(".")) {

                return null;
            }
        }
        return null;
    }
}
