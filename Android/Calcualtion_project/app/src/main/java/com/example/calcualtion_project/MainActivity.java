package com.example.calcualtion_project;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;
    Button add, sub, mul, div, back, result, reset;
    EditText expressionText, resultText;
    String expression="";
    String lastString="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("계산기");

        this.setButtonListener(this.initializeView());
    }

    protected Button[] initializeView() {
        button1 = (Button)findViewById(R.id.Button1);
        button2 = (Button)findViewById(R.id.Button2);
        button3 = (Button)findViewById(R.id.Button3);
        button4 = (Button)findViewById(R.id.Button4);
        button5 = (Button)findViewById(R.id.Button5);
        button6 = (Button)findViewById(R.id.Button6);
        button7 = (Button)findViewById(R.id.Button7);
        button8 = (Button)findViewById(R.id.Button8);
        button9 = (Button)findViewById(R.id.Button9);
        button0 = (Button)findViewById(R.id.Button0);
        add = (Button)findViewById(R.id.Add);
        sub = (Button)findViewById(R.id.Sub);
        mul = (Button)findViewById(R.id.Mul);
        div = (Button)findViewById(R.id.Div);
        back = (Button)findViewById(R.id.Back);
        result = (Button)findViewById(R.id.Result);
        reset = (Button)findViewById(R.id.Reset);

        expressionText = (EditText)findViewById(R.id.EditText1);
        resultText = (EditText)findViewById(R.id.EditText2);
        Button[] buttonId = {button1, button2, button3, button4, button5, button6, button7, button8, button9, button0,
                add, sub, mul, div, back, result, reset};
        return buttonId;
    }

    protected String getCalculationResult(String expression) {
        String[] splitExpression = expression.split(" ");
        for(String str : splitExpression)
            System.out.print(str + " ");
        System.out.println("END");
        String returnCalculation;
        int resultCalculation = 0;
        Stack<String> operand = new Stack<>();
        Stack<String> operator = new Stack<>();
        String strOperator;
        int operand1, operand2;
        // 연산자 피연산자 분리
        for (String string : splitExpression) {
            if (isOperator(string)) {
                System.out.println(string + "is operator");
                operator.push(string);
            }
            else {
                System.out.println(string + "is operand");
                operand.push(string);
            }
        }
        // 계산 시작
        try {
            while (!operand.isEmpty() && !operator.isEmpty()) {
                strOperator = operator.pop();
                operand2 = Integer.parseInt(operand.pop());
                operand1 = Integer.parseInt(operand.pop());
                System.out.printf("%d %s %d\n", operand1, strOperator, operand2);
                switch (strOperator) {
                    case "+":
                        resultCalculation = operand1 + operand2;
                        break;
                    case "-":
                        resultCalculation = operand1 - operand2;
                        break;
                    case "*":
                        resultCalculation = operand1 * operand2;
                        break;
                    case "/":
                        resultCalculation = operand1 / operand2;
                }
                operand.push(Integer.toString(resultCalculation));
            }
        }catch(java.util.EmptyStackException e) {
        }
        returnCalculation = Integer.toString(resultCalculation);
        System.out.println(returnCalculation);
        return returnCalculation;
    }
    // 연산자인지 확인하는 메서드
    protected boolean isOperator(String operator) {
        String[] splitNull = operator.split(" ");
        for(String string : splitNull)
            if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/"))
                return true;
        return false;
    }
    protected void printExpression(String toSwitch) {
        switch(toSwitch) {
            case "result":
                resultText.setText(getCalculationResult(expression));
                break;
            case "back":
                try{
                if (isOperator(lastString))
                    expression = expression.substring(0, expression.length()-3);
                else
                    expression = expression.substring(0, expression.length()-1);
                lastString = Character.toString(expression.charAt(expression.length() - 1));
                } catch (java.lang.StringIndexOutOfBoundsException e) {
                    expression = "";
                }
                expressionText.setText(expression);
                break;
            case "Reset":
                lastString = "";
                expression = "";
                expressionText.setText("");
                resultText.setText("");
                break;
            default:
                if (isOperator(lastString) && isOperator(toSwitch))
                    return;
                expression = expression + toSwitch;
                lastString = toSwitch;
                expressionText.setText(expression);
        }
    }

    protected void setButtonListener(Button[] arrButton) {
        for(Button button : arrButton) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch(v.getId()) {
                        case R.id.Back:
                            printExpression("back");
                            break;
                        case R.id.Result:
                            printExpression("result");
                            break;
                        case R.id.Add:
                            printExpression(" + ");
                            break;
                        case R.id.Sub:
                            printExpression(" - ");
                            break;
                        case R.id.Mul:
                            printExpression(" * ");
                            break;
                        case R.id.Div:
                            printExpression(" / ");
                            break;
                        default:
                            printExpression(button.getText().toString());
                    }
                }
            });
        }
    }
}