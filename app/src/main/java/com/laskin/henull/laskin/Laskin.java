package com.laskin.henull.laskin;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import com.udojava.evalex.Expression;


public class Laskin extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private String calculation = "";
    //private List<Double> lukulista = new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laskin);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast t1 = Toast.makeText(this, "ABOUT", Toast.LENGTH_SHORT);
                t1.show();
                Intent intent = new Intent(this, AboutActivity.class);
                String message = "(C) Hermanni Mäkitalo";
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                return true;
            case R.id.help:
                Toast t2 = Toast.makeText(this, "HELP", Toast.LENGTH_SHORT);
                t2.show();
                Intent i2 = new Intent(this, HelpActivity.class);
                String m2 = "HALP";
                i2.putExtra(EXTRA_MESSAGE, m2);
                startActivity(i2);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //region Buttons
    public void NumberPressed(View v) {
        TextView resultbox = (TextView) findViewById(R.id.resultBox);

        if (v == findViewById(R.id.button0)) {
            resultbox.append("0");
            calculation += "0";
        } else if (v == findViewById(R.id.button1)) {
            resultbox.append("1");
            calculation += "1";
        } else if (v == findViewById(R.id.button2)) {
            resultbox.append("2");
            calculation += "2";
        } else if (v == findViewById(R.id.button3)) {
            resultbox.append("3");
            calculation += "3";
        } else if (v == findViewById(R.id.button4)) {
            resultbox.append("4");
            calculation += "4";
        } else if (v == findViewById(R.id.button5)) {
            resultbox.append("5");
            calculation += "5";
        } else if (v == findViewById(R.id.button6)) {
            resultbox.append("6");
            calculation += "6";
        } else if (v == findViewById(R.id.button7)) {
            resultbox.append("7");
            calculation += "7";
        } else if (v == findViewById(R.id.button8)) {
            resultbox.append("8");
            calculation += "8";
        } else if (v == findViewById(R.id.button9)) {
            resultbox.append("9");
            calculation += "9";
        } else {
            Toast t = Toast.makeText(this, "This shouldn't happen.", Toast.LENGTH_SHORT);
            t.show();
            //TODO: Handle error, shouldn't be here unless number 99button pressed.
        }
    }

    public void EnterPressed(View v) {
        final TextView resultbox = (TextView) findViewById(R.id.resultBox);
        Double result = 0.0;
        try {
            Expression expression = new Expression(resultbox.getText().toString());
            result = Double.parseDouble(expression.eval().toString());
        } catch (Exception e) { //java.lang.ArithmeticException //EmptyExpression
            Toast t = Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT);
            t.show();
        }
        resultbox.setText(result.toString());
    }

    public void CommaPressed(View v){
        TextView resultbox = (TextView) findViewById(R.id.resultBox);
        resultbox.append(".");
    }

    public void ClearPressed(View v) {
        TextView resultbox = (TextView) findViewById(R.id.resultBox);
        String temp = resultbox.getText().toString();
        resultbox.setText(temp.substring(0,temp.length()-1));
    }

    public void ClearallPressed(View v) {
        TextView resultbox = (TextView) findViewById(R.id.resultBox);
        resultbox.setText("");
    }

    public void OperationPressed(View v) {
        TextView resultbox = (TextView) findViewById(R.id.resultBox);

        if (v == findViewById(R.id.buttonSum)) {
            resultbox.append("+");
            calculation += "+";
        } else if (v == findViewById(R.id.buttonMin)) {
            resultbox.append("-");
            calculation += "-";
        } else if (v == findViewById(R.id.buttonDiv)) {
            resultbox.append("/");
            calculation += "/";
        } else if (v == findViewById(R.id.buttonMul)) {
            resultbox.append("*");
            calculation += "*";
        }
    }
//endregion

}
