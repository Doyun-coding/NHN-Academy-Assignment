import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DictionaryList {
    static BufferedWriter bw;
    static String searchWord;

    static class Node {
        String title;
        String S;
        Node(String title, String S) {
            this.title = title;
            this.S = S;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        ArrayList<Node> arrayList = new ArrayList<>();

        try {
            File file = new File("words.txt");
            br = new BufferedReader(new FileReader(file));
            String S;

            while((S = br.readLine()) != null) {
                st = new StringTokenizer(S);
                String s = st.nextToken();
                String t = st.nextToken();

                while(st.hasMoreTokens()) {
                    s = st.nextToken();
                    arrayList.add(new Node(t, s));
                }
                
            }

            while(true) {
                br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("검색할 단어를 입력하세요: ");
                st = new StringTokenizer(br.readLine());
                searchWord = st.nextToken();

                if(searchWord.equals("exit()")) {
                    break;
                }

                for(Node node : arrayList) {
                    if(node.title.equals(searchWord)) {
                        System.out.print(node.S + " ");
                    }
                }
                System.out.println();

            }

        }
        catch(Exception e) {
            e.getStackTrace();
        }

    }
}
