import io.Input;
import io.Output;
import race.Race;
import unit.Unit;

import java.io.*;
import java.util.ArrayList;

public class JBDJ09_002_Starcraft {
    static Race myRace;
    static Race comRace;
    static Input input = new Input();
    static Output output = new Output();

    public static void main(String[] args) throws IOException {

        myRace = input.selectRace();
        comRace = input.selectComRace();

        while(true) {
            ArrayList<Unit> myUnits = myRace.getUnits();
            ArrayList<Unit> comUnits = comRace.getUnits();

            if(comUnits.isEmpty()) {
                output.printWinMessage();
                input.showComUnitsStatus();
                input.showMyUnitsStatus();
                break;
            }

            if(myUnits.isEmpty()) {
                output.printLossMessage();
                input.showComUnitsStatus();
                input.showMyUnitsStatus();
                break;
            }

            input.showComUnitsStatus();
            input.showMyUnitsStatus();

            input.attackCom();
            if(comUnits.isEmpty()) {
                output.printWinMessage();
                input.showComUnitsStatus();
                input.showMyUnitsStatus();
                break;
            }

            input.attackUser();
            if(myUnits.isEmpty()) {
                output.printLossMessage();
                input.showComUnitsStatus();
                input.showMyUnitsStatus();
                break;
            }

        }

    }
}
