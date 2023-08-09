package com.example.calculator;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView result, solution;
    MaterialButton clear, brac_open, brac_close, all_clear, dot;
    MaterialButton divide, multiply, plus, minus, equals;
    MaterialButton one, two, three, four, five, six, seven, eight, nine, zero;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = findViewById(R.id.result);
        solution = findViewById(R.id.solution_tv);
        assignid(clear,R.id.clear);
        assignid(brac_open,R.id.open_bracket);
        assignid(brac_close,R.id.close_bracket);
        assignid(all_clear,R.id.allclear);
        assignid(dot,R.id.butt_dot);
        assignid(divide,R.id.divide);
        assignid(multiply,R.id.multiply);
        assignid(plus,R.id.add);
        assignid(minus,R.id.substarct);
        assignid(equals,R.id.equal);
        assignid(one,R.id.one);
        assignid(two,R.id.two);
        assignid(three,R.id.three);
        assignid(four,R.id.four);
        assignid(five,R.id.five);
        assignid(six,R.id.six);
        assignid(seven,R.id.seven);
        assignid(eight,R.id.num_eight);
        assignid(nine,R.id.nine);
        assignid(zero,R.id.zero);
    }
    void assignid(MaterialButton btn,int id){
        btn = findViewById(id);
        btn.setOnClickListener((View.OnClickListener) this);
    }
    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttontext = button.getText().toString();
        String datatocalculate = solution.getText().toString();
        if (buttontext.equals("AC")) {
            solution.setText("");
            result.setText("0");
            return;
        }
        if (buttontext.equals("=")) {
            solution.setText(result.getText());
            return;
        }
        if (buttontext.equals("C")) {
            datatocalculate = datatocalculate.substring(0, datatocalculate.length() - 1);
        } else {
            datatocalculate = datatocalculate + buttontext;
        }
        solution.setText(datatocalculate);
        String finalResult = getResult(datatocalculate);
        if(!finalResult.equals("Error")){
            result.setText(finalResult);
        }
    }
        String getResult (String data){
            try{
                Context context = Context.enter();
                context.setOptimizationLevel(-1);
                Scriptable scriptable = context.initSafeStandardObjects();
                 String finalResult =  context.evaluateString(scriptable,data,"Javascript", 1, null).toString();
                 if(finalResult.endsWith(".0")){
                     finalResult = finalResult.replace(".0","");
                 }
                 return finalResult;
            }
            catch (Exception e){
                return "Error";
            }
    }
}

