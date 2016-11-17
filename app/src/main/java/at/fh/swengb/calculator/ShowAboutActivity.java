package at.fh.swengb.calculator;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_about);

        Intent intent = getIntent();
        String message = intent.getStringExtra("resultOfCalculation");
        String message2 = intent.getStringExtra("resultOfCalculationCosts");
        TextView textView = (TextView)findViewById(R.id.textViewMessage);
        TextView textView2 = (TextView)findViewById(R.id.textViewCosts);
        textView.setText(message);
        textView2.setText(message2);



    }
}
