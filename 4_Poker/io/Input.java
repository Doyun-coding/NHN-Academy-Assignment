package io;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Input {
    public static final String startMessage = "포커 게임을 시작합니다!!";
    public static final String selectPlayerNumberMessage = "플레이어가 몇 명인지 골라주세요.(2~5명): ";
    public static final String selectPlayerExceptionMessage = "플레이어가 몇 명인지 숫자 2 에서 5 사이의 정수를 입력해주세요!!";
    public static final String inputUserNameMessage = "사용자의 이름을 입력해주세요.: ";
    public static final String inputUserNameExceptionMessage = "사용자의 이름을 문자열로 입력해주세요!!";

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public String startGame() {
        return startMessage;
    }

    public int selectPlayerNumber() {
        System.out.print(selectPlayerNumberMessage);
        int n = 0;

        try {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            if(n < 2 || n > 5) {
                System.out.println(selectPlayerExceptionMessage);
                return selectPlayerNumber();
            }
        }
        catch(Exception e) {
            System.out.println(selectPlayerExceptionMessage);
            return selectPlayerNumber();
        }

        return n;
    }

    public String inputUserName() {
        System.out.print(inputUserNameMessage);
        String userName = "";

        try {
            userName = br.readLine();

            if(userName.equals("")) {
                System.out.print(inputUserNameExceptionMessage);
                return inputUserName();
            }
        }
        catch (Exception e) {
            System.out.print(inputUserNameExceptionMessage);
            return inputUserName();
        }

        return userName;
    }

}
