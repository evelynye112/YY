package edu.qc.seclass.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {

    TextView fifteen_tp,twenty_tp,tf_tp,fifteen_tt,twenty_tt,tf_tt;
    EditText price, size;
    Button compute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        fifteen_tp = findViewById(R.id.fifteenPercentTipValue);
        twenty_tp = findViewById(R.id.twentyPercentTipValue);
        tf_tp = findViewById(R.id.twentyfivePercentTipValue);
        fifteen_tt = findViewById(R.id.fifteenPercentTotalValue);
        twenty_tt = findViewById(R.id.twentyPercentTotalValue);
        tf_tt = findViewById(R.id.twentyfivePercentTotalValue);
        price = findViewById(R.id.checkAmountValue);
        size = findViewById(R.id.partySizeValue);
        compute = findViewById(R.id.buttonCompute);

        compute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideKeyboard();
                cal_tip();
            }
        });

    }


    public void cal_tip(){
        String  p = price.getText().toString();
        String s = size.getText().toString();

        if(p.isEmpty() || s.isEmpty()){
            Toast.makeText(TipCalculatorActivity.this,"Empty or incorrect value(s)!",Toast.LENGTH_LONG ).show();
            return;
        }
        double pp = Double.parseDouble(p);
        int ss = Integer.parseInt(s);

        if(pp<=0 || ss<=0){
            Toast.makeText(TipCalculatorActivity.this,"Empty or incorrect value(s)!",Toast.LENGTH_LONG ).show();
            return;
        }

        int tp15 = (int)Math.round((pp*0.15)/ss);
        int tp20 = (int)Math.round((pp*0.20)/ss);
        int tp25 = (int)Math.round((pp*0.25)/ss);

        int tt15 = tp15 + (int)pp/ss;
        int tt20 = tp20 + (int)pp/ss;
        int tt25 = tp25 + (int)pp/ss;

        fifteen_tp.setText(String.valueOf(tp15));
        twenty_tp.setText(String.valueOf(tp20));
        tf_tp.setText(String.valueOf(tp25));
        fifteen_tt.setText(String.valueOf(tt15));
        twenty_tt.setText(String.valueOf(tt20));
        tf_tt.setText(String.valueOf(tt25));

    }
    public void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);

        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
    }

}