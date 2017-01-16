package com.laskin.henull.laskin;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.widget.Toast;

import com.udojava.evalex.Expression;

import static com.udojava.evalex.Expression.e;


public class Laskin extends AppCompatActivity {

    private String calculation = "";
    //private List<Double> lukulista = new ArrayList<Double>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laskin);

    }

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
            Toast t = Toast.makeText(this,"This shouldn't happen.", Toast.LENGTH_SHORT);
            t.show();
            //TODO: Handle error, shouldn't be here unless number 99button pressed.
        }
    }

    public void EnterPressed(View v){
        TextView resultbox = (TextView) findViewById(R.id.resultBox);
        Double result = 0.0;
        try {
            Expression expression = new Expression(resultbox.getText().toString());
            result = Double.parseDouble(expression.eval().toString());
        }catch(Exception e){ //java.lang.ArithmeticException //EmptyExpression
            Toast t = Toast.makeText(this,e.getMessage(), Toast.LENGTH_SHORT);
            t.show();
        }
        AlertDialog.Builder dlgAlert  = new AlertDialog.Builder(this);
        dlgAlert.setMessage(result.toString());
        dlgAlert.setTitle("Result");
        dlgAlert.setPositiveButton("OK",new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // call your code here
            }
        });
        dlgAlert.show();

    }

    public void ClearPressed(View v){
        TextView resultbox = (TextView) findViewById(R.id.resultBox);
        resultbox.setText("");
    }

    public void OperationPressed(View v){
        TextView resultbox = (TextView) findViewById(R.id.resultBox);

        if (v == findViewById(R.id.buttonSum)) {
            resultbox.append("+");
            calculation += "+";
        }else if (v == findViewById(R.id.buttonMin)) {
            resultbox.append("-");
            calculation += "-";
        }else if (v == findViewById(R.id.buttonDiv)) {
            resultbox.append("/");
            calculation += "/";
        }else if (v == findViewById(R.id.buttonMul)) {
            resultbox.append("*");
            calculation += "*";
        }
    }

}
