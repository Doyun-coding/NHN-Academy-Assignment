import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class JBDJ09_002_Tictactoe {
    static int[][] arr;

    static boolean check(boolean turn) {
        boolean win = false;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(turn) {
                    if(arr[i][j] != 1) {
                        break;
                    }

                    if(j == 2) {
                        win = true;
                    }
                }
                else {
                    if(arr[i][j] != 2) {
                        break;
                    }

                    if(j == 2) {
                        win = true;
                    }
                }
            }
        }

        if(win) return true;

        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(turn) {
                    if(arr[j][i] != 1) break;

                    if(j == 2) {
                        win = true;
                    }
                }
                else {
                    if(arr[j][i] != 2) break;

                    if(j == 2) {
                        win = true;
                    }
                }
            }
        }

        if(win) return true;

        for(int i = 0; i < 3; i++) {
            if(turn) {
                if(arr[i][i] != 1) break;

                if(i == 2) {
                    win = true;
                }
            }
            else {
                if(arr[i][i] != 2) break;

                if(i == 2) {
                    win = true;
                }
            }
        }

        if(win) return true;

        for(int i = 0; i < 3; i++) {
            if(turn) {
                if(arr[i][2-i] != 1) break;

                if(i == 2) {
                    win = true;
                }
            }
            else {
                if(arr[i][2-i] != 2) break;

                if(i == 2) {
                    win = true;
                }
            }
        }

        if(win) return true;

        return false;
    }

    static void printResult() {
        System.out.println();

        for(int i = 0; i < 3; i++) {
            if(arr[0][i] == 0) {
                System.out.print("   ");
            }
            else if(arr[0][i] == 1) {
                System.out.print(" O ");
            }
            else if(arr[0][i] == 2) {
                System.out.print(" X ");
            }

            if(i != 2) {
                System.out.print("|");
            }
        }

        System.out.println();
        System.out.println("-----------");

        for(int i = 0; i < 3; i++) {
            if(arr[1][i] == 0) {
                System.out.print("   ");
            }
            else if(arr[1][i] == 1) {
                System.out.print(" O ");
            }
            else if(arr[1][i] == 2) {
                System.out.print(" X ");
            }

            if(i != 2) {
                System.out.print("|");
            }
        }

        System.out.println();
        System.out.println("-----------");

        for(int i = 0; i < 3; i++) {
            if(arr[2][i] == 0) {
                System.out.print("   ");
            }
            else if(arr[2][i] == 1) {
                System.out.print(" O ");
            }
            else if(arr[2][i] == 2) {
                System.out.print(" X ");
            }

            if(i != 2) {
                System.out.print("|");
            }
        }
        System.out.println();
        System.out.println();

    }

    static void computer() {

        while(true) {
            int x = (int) (Math.random() * 3);
            int y = (int) (Math.random() * 3);

            if(arr[x][y] == 0) {
                arr[x][y] = 2;

                return;
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        arr = new int[3][3];

        while(true) {
            System.out.println("사용자의 턴입니다");
            System.out.print("사용자 입력 (x y): ");
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if(arr[x][y] == 0) {
                arr[x][y] = 1;

                printResult();

                if(check(true)) {
                    System.out.println("사용자가 이겼습니다!");
                    break;
                }

                System.out.println("사용자의 턴이 끝났습니다!");
                System.out.println("컴퓨터 차례입니다");

                computer();

                printResult();

                if(check(false)) {
                    System.out.println("컴퓨터가 이겼습니다!");
                    break;
                }

            }
            else {
                System.out.println("빈 공간의 좌표를 입력해주셔야 합니다!!");
            }

        }

    }
}
