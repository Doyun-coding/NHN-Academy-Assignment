package io;

import race.Protos;
import race.Race;
import race.Terran;
import race.Zerg;
import unit.Unit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Input {
    private static final String selectionMessage = "내 종족을 결정하세요(0: terran, 1: protos, 2: zerg) : ";
    private static final String selectAgainMessage = "숫자 0, 1, 2 중 하나의 값을 입력해주세요!!";
    private static final String attackComMessage = "상대 유닛과 공격할 유닛을 입력하십시오(내 유닛, 상대 유닛) : ";
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static Race myRace;
    private static Race comRace;

    public Race selectRace() throws IOException {
        System.out.print(selectionMessage);
        st = new StringTokenizer(br.readLine());

        try {
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) {
                myRace = new Terran();
                return myRace;
            }
            else if(n == 1) {
                myRace = new Protos();
                return myRace;
            }
            else if(n == 2) {
                myRace = new Zerg();
                return myRace;
            }
            else {
                System.out.println(selectAgainMessage);
                selectRace();
            }
        }
        catch(Exception e) {
            System.out.println("숫자 0, 1, 2 중 한 숫자를 선택해주세요!!");

            selectRace();
        }

        return myRace;
    }

    public Race selectComRace() {
        int n = (int) (Math.random() * 3);

        if(n == 0) {
            comRace = new Terran();
            return comRace;
        }
        else if(n == 1) {
            comRace = new Protos();
            return comRace;
        }
        else if(n == 2) {
            comRace = new Zerg();
            return comRace;
        }
        else {
            selectComRace();
        }

        return null;
    }

    public void showMyUnitsStatus() {
        ArrayList<Unit> myUnits = myRace.getUnits();

        System.out.println("아군: " + myRace.getRaceName());
        for(int i = 0; i < myUnits.size(); i++) {
            Unit unit = myUnits.get(i);
            System.out.println(i + "." + unit.getUnitName() + " (현재 방여력: " + unit.getUnitDefensePower() + ", 공격력: " + unit.getUnitAttackPower() + ")");
        }
        System.out.println();
    }

    public void showComUnitsStatus() {
        ArrayList<Unit> comUnits = comRace.getUnits();

        System.out.println("적군: " + comRace.getRaceName());
        for(int i = 0; i < comUnits.size(); i++) {
            Unit unit = comUnits.get(i);
            System.out.println(i + "." + unit.getUnitName() + " (현재 방여력: " + unit.getUnitDefensePower() + ", 공격력: " + unit.getUnitAttackPower() + ")");
        }
        System.out.println();
    }

    public void attackCom() throws IOException {
        ArrayList<Unit> myUnits = myRace.getUnits();
        ArrayList<Unit> comUnits = comRace.getUnits();

        System.out.print(attackComMessage);
        st = new StringTokenizer(br.readLine());

        try {
            String S = st.nextToken();
            int myUnitAttack = Integer.parseInt(String.valueOf(S.charAt(0)));

            int comUnitAttack = Integer.parseInt(String.valueOf(st.nextToken()));

            Unit myUnit = myUnits.get(myUnitAttack);
            Unit comUnit = comUnits.get(comUnitAttack);

            if(comUnit.isFly()) {
                if(myUnit.airAttack()) {
                    comUnit.setUnitDefensePower(myUnit.getUnitAttackPower());
                }
            }
            else {
                if(myUnit.groundAttack()) {
                    comUnit.setUnitDefensePower(myUnit.getUnitAttackPower());
                }
            }

            if(comUnit.getUnitDefensePower() <= 0) {
                comUnits.remove(comUnitAttack);
            }
        }
        catch(Exception e) {
            System.out.println("(내 유닛, 상대 유닛) 형식에 맞게 입력해주세요!!");

            attackCom();
        }
    }

    public void attackUser() {
        ArrayList<Unit> myUnits = myRace.getUnits();
        ArrayList<Unit> comUnits = comRace.getUnits();

        int myUnitAttack = (int) (Math.random() * myUnits.size());
        int comUnitAttack = (int) (Math.random() * comUnits.size());

        Unit myUnit = myUnits.get(myUnitAttack);
        Unit comUnit = comUnits.get(comUnitAttack);

        myUnit.setUnitDefensePower(comUnit.getUnitAttackPower());

        if(myUnit.getUnitDefensePower() <= 0) {
            myUnits.remove(myUnitAttack);
        }
    }

}
