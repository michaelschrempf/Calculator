package at.fh.swengb.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public double calculateConsumption(View view){

        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        EditText editTextPower = (EditText) findViewById(R.id.editTextPower);
        EditText editTextHours = (EditText) findViewById(R.id.editTextHours);



        try {
            double power = Double.parseDouble(editTextPower.getText().toString().trim());
            double hours = Double.parseDouble(editTextHours.getText().toString().trim());

            DecimalFormat df = new DecimalFormat("####0.00");

            if (hours <= 24) {
                double result = ((power/1000)*hours)*365;
                textViewResult.setText(df.format(result)+" "+"kW/H");
                return result;
            } else {
                textViewResult.setText("Days only have 24 hours!!!");
            }


        } catch (NumberFormatException e) {
            e.printStackTrace();
            String wrongInput = "Wrong Input!!!";
            textViewResult.setText(wrongInput);
        }


        return 0;
    }

    public void calculateCosts(View view) {


        TextView textViewCosts = (TextView) findViewById(R.id.textViewCosts);
        //TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        EditText editTextPrice = (EditText) findViewById(R.id.editTextPrice);

        DecimalFormat df = new DecimalFormat("####0.00");

        try {
            //double result = Double.parseDouble(textViewResult.getText().toString().trim());
            double costs = Double.parseDouble(editTextPrice.getText().toString().trim());

            double costsPerYear = calculateConsumption(view) * costs;

            textViewCosts.setText(df.format(costsPerYear)+" "+"Euro");
        } catch (NumberFormatException e) {
            e.printStackTrace();
            String wrongInput = "None or wrong Input!!";
            textViewCosts.setText(wrongInput);
        }


    }

    public void showAbout(View view) {

        TextView textViewResult = (TextView) findViewById(R.id.textViewResult);
        TextView textViewCosts = (TextView) findViewById(R.id.textViewCosts);

        Intent intent = new Intent(this, ShowAboutActivity.class);
        String message = textViewResult.getText().toString();
        String message2 = textViewCosts.getText().toString();
        intent.putExtra("resultOfCalculation", message);
        intent.putExtra("resultOfCalculationCosts", message2);
        startActivity(intent);




    }
}
