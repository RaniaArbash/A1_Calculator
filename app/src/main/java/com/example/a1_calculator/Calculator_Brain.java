package com.example.a1_calculator;

import java.util.ArrayList;

public class Calculator_Brain {
    ArrayList<String> operators_oprands_list = new ArrayList<>(0);
    int index = 0;
     int mode = 1 ; // stander mode

    String oneExp = "";
    ArrayList<String> History = new ArrayList<>(0);

    public void toAdvanceMode(){
        mode = 2;
    }
    public void toStanderdMode(){
        mode = 1;
        History.clear();
    }

    public String getHistory(){
        String history_String = "";
        for (String s :
                History) {
            history_String = history_String + s;
        }
        return history_String;
    }

    public void push(String valueToPush){
        oneExp = oneExp + valueToPush;
        this.operators_oprands_list.add(valueToPush);
    }
// list[last index] = "$"
    /// void calc(num1, op, num2, size)
    public int calc(){
        int num1  = -1;
        int num2;
        String op;
        if (isValid()){
            // 3 + 4 - 2 * 5 =
            // size = 7
            // all odd inexes must be numbers
            // all even indexes must be strings (+-*/)
            index = 1;
//            String op =  operators_oprands_list.get(index);
//            if ((op.equals("+")) || (op.equals("-"))){ // char , int, double
//                num1 = Integer.parseInt(operators_oprands_list.get(index - 1));
//                num2 = Integer.parseInt( operators_oprands_list.get(index + 1));
//                num1 = op(num1,op,num2);
//                index = index + 2;
//            }

            index = 1;
            num1 = Integer.parseInt(operators_oprands_list.get(index - 1));
            while (index < operators_oprands_list.size()){
                op =  operators_oprands_list.get(index); // -  // *
                num2 = Integer.parseInt( operators_oprands_list.get(index +  1)); // 2 // 5
                num1 = op(num1,op,num2);
                index += 2;
            }
        }
        oneExp = oneExp + num1;
        if (mode == 2){
            this.History.add(oneExp);
            oneExp = "";
        }
        return num1;
    }

    public void clear(){
        operators_oprands_list.clear();
    }

    public String getOneExp(){
        return oneExp;
    }

    private int op(int num1, String op, int num2){
        int result = -100;
        if (op.equals("+")){
            result = num1 + num2;
        }
        if (op.equals("-")){
            result = num1 - num2;
        }

    return  result;
    }

    private boolean isValid(){
        // + -
        // 33 + 22
        // 2 + 3

        // 3 + 4 - 2 * 5 =
        // all odd inexes must be numbers using isNumeric function
        // all even indexes must be strings (+-*/)

        return true;
    }

    private static boolean isNumeric(String str) {// numbers or symbols or characters
        return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
    }
}
