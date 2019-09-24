package com.example.gs_temperature;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private TextView result, showresult, msg;
    private EditText settext;
    private Button convert;
    private RadioGroup radioGroup;
    private RadioButton radioButton;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        settext = findViewById(R.id.etxt);
        convert = findViewById(R.id.btnconvert);
        msg = findViewById(R.id.titlemsg);
        radioGroup = findViewById(R.id.rgroup);
        showresult = findViewById(R.id.showresult);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               try {
                   checkRbtn(radioGroup);
                   convertTem();
               } catch (Exception r){
                   }
            }
        });
    }

    public RadioButton checkRbtn(RadioGroup radioGroup) {

        int selected = radioGroup.getCheckedRadioButtonId();
        if (selected == -1) {
            Toast.makeText(this, "Please Select one option", Toast.LENGTH_SHORT).show();
        } else {
            radioButton = radioGroup.findViewById(selected);
            showresult.setText("Temperature converted  to " + radioButton.getText()+" is");
         //   convertTem();

        }
        return radioButton;
    }
    public void  convertTem(){
     if(checkRbtn(radioGroup).getText().toString().equalsIgnoreCase("celsius")) {
            try {
                double input = Double.parseDouble(settext.getText().toString());
                double f = (input - 32) * 0.55;
                result.setText((decimalFormat.format(f)));
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, " enter number \n" + e, Toast.LENGTH_SHORT).show();
            }

        } else if (checkRbtn(radioGroup).getText().toString().equalsIgnoreCase("fahrenheit")) {
            try {
                double input = Double.parseDouble(settext.getText().toString());
                double c = (input * 9 / 5) + 32;
                result.setText(decimalFormat.format(c));
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "enter number \n" + e, Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(MainActivity.this, "please select one option ", Toast.LENGTH_SHORT).show();
        }
    }


}