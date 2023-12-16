package day2;

import util.Reader.Reader;

import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public Integer getSumOfPower(){
        Integer sumOfPower = 0;
        for(String gameLine : new Reader().getText("AdventOfCode2023/src/day2/CubeConundrum")) {
            List<Integer> minimumOfCubes = getMinimumCubes(gameLine);
            sumOfPower += (minimumOfCubes.get(0) * minimumOfCubes.get(1) * minimumOfCubes.get(2));
        }

        return sumOfPower;
    }

    private List<Integer> getMinimumCubes(String gameline){
        Integer redMin = 0;
        Integer greenMin = 0;
        Integer blueMin = 0;

        List<Integer> minimumOfCubes = new ArrayList<>();
        List<String> game = List.of(gameline.split(": "));
        List<String> set = List.of(game.getLast().split(", |; "));
        for(String cube : set){
            List<String> numberPlusCube = List.of(cube.split(" "));
            Integer number = Integer.valueOf(numberPlusCube.getFirst());
            if(numberPlusCube.getLast().equals("red") && number > redMin){
                redMin = number;
            }
            if(numberPlusCube.getLast().equals("green") && number > greenMin){
                greenMin = number;
            }
            if(numberPlusCube.getLast().equals("blue") && number > blueMin){
                blueMin = number;
            }
        }
        minimumOfCubes.add(redMin);
        minimumOfCubes.addLast(greenMin);
        minimumOfCubes.addLast(blueMin);

        return minimumOfCubes;
    }
}
