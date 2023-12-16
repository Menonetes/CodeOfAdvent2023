package day1;

import util.Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public int getCalibrationValue(){
        int calibrationValue = 0;
        List<String> calibrationData = new Reader().getText("AdventOfCode2023/src/day1/CalibrationData");
        List<Integer> listCalibrationValues = formtaingCalibrationValues(calibrationData);
        calibrationValue = parseListeStringtoint(listCalibrationValues);
        return calibrationValue;
    }
    public int parseListeStringtoint(List<Integer> listCalibrationValues){
        int calibrationValues = 0;
        for (Integer value : listCalibrationValues) {
            calibrationValues += value;
        }
        return calibrationValues;
    }
    public List<Integer> formtaingCalibrationValues(List<String> calibrationData){
        List<Integer> listCalibrationValues = new ArrayList<>();
        
        for(String calibrationLine : calibrationData){
            String number = getLineNumber(calibrationLine);

            listCalibrationValues.add(Integer.valueOf(number));
        }

        return listCalibrationValues;
    }

    private static String getLineNumber(String calibrationLine) {
        String number = "";
        String secondNumber = "";
        String[] n = calibrationLine.split("");
        int posFirstNumerical = 0;
        int posSecondNumerical = 0;
        int pos = 0;
        for (String letter : n){
            if(letter.matches("[1-9]")){
                if(number.isEmpty()){
                    number = letter;
                    posFirstNumerical = pos;
                }
                secondNumber = letter;
                posSecondNumerical = pos;
            }
            pos++;
        }
        LetterNumberPosHolder letterLowestNumberPosHolder = getLowestLetterIndexNumber(calibrationLine, number);
        LetterNumberPosHolder letterHighestNumberPosHolder = getHighestLetterIndexNumber(calibrationLine, number);


        if(letterLowestNumberPosHolder.posLetter() < posFirstNumerical){
            number = letterLowestNumberPosHolder.letterNumber();
        }
        if(letterHighestNumberPosHolder.posLetter() > posSecondNumerical){
            secondNumber = letterHighestNumberPosHolder.letterNumber();
        }
        String finalNumber = number += secondNumber;
        return finalNumber;
    }
    private static LetterNumberPosHolder getHighestLetterIndexNumber(String calibrationLine, String number) {
        String letterNumber = number;
        int posLetter = 0;
        while (calibrationLine.indexOf("one") != -1 && calibrationLine.indexOf("one", posLetter + 1) > posLetter) {
            if (calibrationLine.indexOf("one") != -1 && calibrationLine.indexOf("one", posLetter + 1) > posLetter) {
                letterNumber = "1";
                posLetter = calibrationLine.indexOf("one", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("two") != -1 && calibrationLine.indexOf("two", posLetter + 1) > posLetter) {
            if (calibrationLine.indexOf("two") != -1 && calibrationLine.indexOf("two", posLetter + 1) > posLetter) {
                letterNumber = "2";
                posLetter = calibrationLine.indexOf("two", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("three") != -1 && calibrationLine.indexOf("three", posLetter + 1) > posLetter) {
            if (calibrationLine.indexOf("three") != -1 && calibrationLine.indexOf("three", posLetter + 1) > posLetter) {
                letterNumber = "3";
                posLetter = calibrationLine.indexOf("three", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("four") != -1 && calibrationLine.indexOf("four", posLetter + 1) > posLetter){
            if (calibrationLine.indexOf("four") != -1 && calibrationLine.indexOf("four", posLetter + 1) > posLetter) {
                letterNumber = "4";
                posLetter = calibrationLine.indexOf("four", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("five") != -1 && calibrationLine.indexOf("five", posLetter+1) > posLetter) {
            if (calibrationLine.indexOf("five") != -1 && calibrationLine.indexOf("five", posLetter + 1) > posLetter) {
                letterNumber = "5";
                posLetter = calibrationLine.indexOf("five", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("six") != -1 && calibrationLine.indexOf("six", posLetter+1) > posLetter) {
            if (calibrationLine.indexOf("six") != -1 && calibrationLine.indexOf("six", posLetter + 1) > posLetter) {
                letterNumber = "6";
                posLetter = calibrationLine.indexOf("six", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("seven") != -1 && calibrationLine.indexOf("seven", posLetter + 1) > posLetter) {
            if (calibrationLine.indexOf("seven") != -1 && calibrationLine.indexOf("seven", posLetter + 1) > posLetter) {
                letterNumber = "7";
                posLetter = calibrationLine.indexOf("seven", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("eight") != -1 && calibrationLine.indexOf("eight", posLetter+1) > posLetter) {
            if (calibrationLine.indexOf("eight") != -1 && calibrationLine.indexOf("eight", posLetter + 1) > posLetter) {
                letterNumber = "8";
                posLetter = calibrationLine.indexOf("eight", posLetter + 1);
            }
        }
        while (calibrationLine.indexOf("nine") != -1 && calibrationLine.indexOf("nine", posLetter+1) > posLetter) {
            if (calibrationLine.indexOf("nine") != -1 && calibrationLine.indexOf("nine", posLetter + 1) > posLetter) {
                letterNumber = "9";
                posLetter = calibrationLine.indexOf("nine", posLetter + 1);
            }
        }
        LetterNumberPosHolder result = new LetterNumberPosHolder(letterNumber, posLetter);
        return result;
    }
    private static LetterNumberPosHolder getLowestLetterIndexNumber(String calibrationLine, String number) {
        String letterNumber = number;
        int posLetter = 1000;
        if(calibrationLine.indexOf("one") != -1 && calibrationLine.indexOf("one") < posLetter){
            letterNumber = "1";
            posLetter = calibrationLine.indexOf("one");
        }
        if(calibrationLine.indexOf("two") != -1 && calibrationLine.indexOf("two") < posLetter){
            letterNumber = "2";
            posLetter = calibrationLine.indexOf("two");
        }
        if(calibrationLine.indexOf("three") != -1 && calibrationLine.indexOf("three") < posLetter){
            letterNumber = "3";
            posLetter = calibrationLine.indexOf("three");
        }
        if(calibrationLine.indexOf("four") != -1 && calibrationLine.indexOf("four") < posLetter){
            letterNumber = "4";
            posLetter = calibrationLine.indexOf("four");
        }
        if(calibrationLine.indexOf("five") != -1 && calibrationLine.indexOf("five") < posLetter){
            letterNumber = "5";
            posLetter = calibrationLine.indexOf("five");
        }
        if(calibrationLine.indexOf("six") != -1 && calibrationLine.indexOf("six") < posLetter){
            letterNumber = "6";
            posLetter = calibrationLine.indexOf("six");
        }
        if(calibrationLine.indexOf("seven") != -1 && calibrationLine.indexOf("seven") < posLetter){
            letterNumber = "7";
            posLetter = calibrationLine.indexOf("seven");
        }
        if(calibrationLine.indexOf("eight") != -1 && calibrationLine.indexOf("eight") < posLetter){
            letterNumber = "8";
            posLetter = calibrationLine.indexOf("eight");
        }
        if(calibrationLine.indexOf("nine") != -1 && calibrationLine.indexOf("nine") < posLetter){
            letterNumber = "9";
            posLetter = calibrationLine.indexOf("nine");
        }
        LetterNumberPosHolder result = new LetterNumberPosHolder(letterNumber, posLetter);
        return result;
    }

    private record LetterNumberPosHolder(String letterNumber, int posLetter) {
    }
}