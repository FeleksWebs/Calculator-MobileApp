package com.example.first_project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class Calculator extends AppCompatActivity {



    @Override
    //Buttons for Calc
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
    }

    //Num String
    public static String TempNumber ="";
    public static String FinalNum ="";


    //Add Num To String
    public void GetNum(View view){
        switch (view.getId()){
            case R.id.num7:
                TempNumber +="7";
                break;
            case R.id.num8:
                TempNumber +="8";
                break;
            case R.id.num9:
                TempNumber +="9";
                break;
            case R.id.num4:
                TempNumber +="4";
                break;
            case R.id.num5:
                TempNumber +="5";
                break;
            case R.id.num6:
                TempNumber +="6";
                break;
            case R.id.num1:
                TempNumber +="1";
                break;
            case R.id.num2:
                TempNumber +="2";
                break;
            case R.id.num3:
                TempNumber +="3";
                break;
            case R.id.num0:
                TempNumber +="0";
                break;
            case R.id.Dot:
                TempNumber +=".";
                break;


        }
        TextView DisplayText= (TextView) findViewById(R.id.DisplayAns);
        DisplayText.setText(TempNumber);
    }

    //Add Calculation
    public String Calculate(View view){
        String expressions ="/,*,+,-";
        for(int i=0;i<expressions.split(",").length;i++){
            String RecurrentChar = expressions.split(",")[i];
            String LastChar = Character.toString(TempNumber.charAt(TempNumber.length() - 1));
            System.out.println(LastChar);
            if(LastChar.contains(RecurrentChar)){
                return TempNumber;
            }
        }
        switch (view.getId()){
            case R.id.Plus:
                TempNumber +="+";
                break;
            case R.id.Minus:
                TempNumber +="-";
                break;
            case R.id.Divide:
                TempNumber +="/";
                break;
            case R.id.Times:
                TempNumber +="*";
                break;
        }
        TextView DisplayText= (TextView) findViewById(R.id.DisplayAns);
        DisplayText.setText(TempNumber);
        return TempNumber;
    }

    //Add All numbers together
    public String Equals(View view){

        String expressions ="/,*,+,-";
        //calculate
        for(int i=0;i<expressions.split(",").length;i++){
            String RecurrentChar = expressions.split(",")[i];
            String LastChar = Character.toString(TempNumber.charAt(TempNumber.length() - 1));
            if(LastChar.contains(RecurrentChar)){
                TempNumber = TempNumber.substring(0, TempNumber.length() - 1);
            }
        }
        String a = TempNumber;
        //Split removes dot
        String operators[]=a.split("[0-9\\.]+");
        String operands[]=a.split("[*+/-]");
        String Fdot[] = a.split("[*]");
        double agregate =  Double.parseDouble(operands[0]);
        for(int i=0;i<operands.length;i++){
            if(operators[i].equals("+"))
                //Use Float inside this
                agregate += Double.parseDouble(operands[i]);
            else if(operators[i].equals("-")){
                agregate -= Double.parseDouble(operands[i]);
            }else if(operators[i].equals("*")){
                agregate *= Double.parseDouble(operands[i]);
            }else if(operators[i].equals("/")){
                agregate /= Double.parseDouble(operands[i]);
            }
        }
        //Create FinalNum
        String FinalNum = "";
        if((agregate-(int)agregate)==0){
            int value = (int)agregate;
            FinalNum = String.valueOf(value);
        }else{
            FinalNum =  String.valueOf(agregate);
        }
        TextView DisplayText= (TextView) findViewById(R.id.DisplayAns);
        DisplayText.setText(FinalNum);
        TempNumber = FinalNum;
        return FinalNum;

    }

    public void ClearTxt(View view){
        TempNumber ="";
        TextView DisplayAns = (TextView) findViewById(R.id.DisplayAns);
        DisplayAns.setText(TempNumber);
    }


}
