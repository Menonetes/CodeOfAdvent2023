package day1;

import util.Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
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
            String number = "";
            String secondNumber = "";
            String[] n = calibrationLine.split("");
            for (String letter : n){
                if(letter.matches("[0-9]")){
                    if(number.isEmpty()){
                        number = letter;
                    }
                    secondNumber = letter;
                }
            }
            number += secondNumber;
            listCalibrationValues.add(Integer.valueOf(number));
        }
        return listCalibrationValues;
    }
}