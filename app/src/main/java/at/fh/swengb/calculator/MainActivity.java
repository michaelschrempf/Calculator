package at.fh.swengb.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void calculateConsumption(View view){

        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        EditText editTextPower = (EditText) findViewById(R.id.editTextPower);
        EditText editTextHours = (EditText) findViewById(R.id.editTextHours);

        try {
            double power = Double.parseDouble(editTextPower.getText().toString().trim());
            double hours = Double.parseDouble(editTextHours.getText().toString().trim());

            if (hours < 24) {
                double result = ((power/1000)*hours)*365;
                textViewResult.setText(Double.toString(result)+" "+"kW/H");
            } else {
                textViewResult.setText("Days only have 24 hours!!!");
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            textViewResult.setText("Wrong Input!!!");
        }


    }
}
