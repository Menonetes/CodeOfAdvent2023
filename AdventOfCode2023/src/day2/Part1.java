package day2;

import util.Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public Integer getSum(){
        Integer sum = 0;
        for(String gameLine : new Reader().getText("AdventOfCode2023/src/day2/CubeConundrum")) {
            List<Integer> maxGameCube = getMax(gameLine);
            if (checkValid(maxGameCube.get(0), maxGameCube.get(1), maxGameCube.get(2))){
                sum = addToSum(sum, gameLine);
            }
        }
        return sum;
    }
    private List<Integer> getMax(String gameLine){
        List<Integer> maxGameCube= new ArrayList<>();
        Integer redMax = 0;
        Integer greenMax = 0;
        Integer blueMax = 0;
        Integer number = 0;

        List<String> gamesPlusID = List.of(gameLine.split(": "));
        List<String> games = List.of(gamesPlusID.getLast().split(", |; "));
        for(String game : games){
            List<String> numberPlusID = List.of(game.split(" "));
            number = Integer.valueOf(numberPlusID.getFirst());
            if(numberPlusID.getLast().equals("red") && number > redMax){
                redMax = number;
            }
            if(numberPlusID.getLast().equals("green") && number > greenMax){
                greenMax = number;
            }
            if(numberPlusID.getLast().equals("blue") && number > blueMax){
                blueMax = number;
            }
        }
        maxGameCube.addLast(redMax);
        maxGameCube.addLast(greenMax);
        maxGameCube.addLast(blueMax);
        return maxGameCube;
    }
    private int addToSum(Integer sum, String gameLine){
        List<String> gamePlusID = List.of(gameLine.split(": "));
        List<String> gameID = List.of(gamePlusID.getFirst().split("Game "));
        int ID = Integer.parseInt(gameID.getLast());
        sum += ID;
        return sum;
    }
    private boolean checkValid(int red, int green, int blue){
        int redCap = 12;
        int greenCap = 13;
        int blueCap = 14;
        if(red > redCap){
            return false;
        }
        if(green > greenCap){
            return false;
        }
        if(blue > blueCap){
            return false;
        }
        return true;
    }
}