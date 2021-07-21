package com.example.service.impl;

import com.example.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements ICalculatorService {
    @Override
    public double calculator(double number1, double number2, String cal) {
        double result=0;
        switch (cal){
            case "+":
                result = number1 + number2;
                break;
            case "-":
                result = number1 -number2;
                break;
            case "*":
                result = number1 *number2;
                break;
            case "/":
                try{
                    result = number1 / number2;
                }catch (Exception e){
                    result = 0;
                }
                break;
        }
        return result;
    }
}
