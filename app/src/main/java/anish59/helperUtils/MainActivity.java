package anish59.helperUtils;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.widget.EditText;

import anish59.helperUtils.utilPack.AlphaNumericInputFilter;
import anish59.helperUtils.utilPack.DesiredCharSet;
import anish59.helperUtils.utilPack.DecimalDigitsInputFilter;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.edtInput);
        InputFilter filter1 = new InputFilter.LengthFilter(5);
        DecimalDigitsInputFilter filter3 = new DecimalDigitsInputFilter(7, 3);
        DesiredCharSet filter4 = new DesiredCharSet("abcxyzAZ",false);
        AlphaNumericInputFilter filter5=new AlphaNumericInputFilter();
        editText.setFilters(new InputFilter[]{filter5});//you can add multiple input filters here
    }
}
