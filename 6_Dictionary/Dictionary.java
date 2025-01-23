import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Dictionary {
    static BufferedWriter bw;
    static String searchWord;
    static HashMap<String, ArrayList<String>> hashMap;

    

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        StringTokenizer st;
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        hashMap = new HashMap<>();
        
        try {
            File file = new File("words.txt");
            br = new BufferedReader(new FileReader(file));
            String S;

            while((S = br.readLine()) != null) {
                st = new StringTokenizer(S);
                ArrayList<String> arrayList = new ArrayList<>();
                String s = st.nextToken();

                while(st.hasMoreTokens()) {
                    s = st.nextToken();
                    arrayList.add(s);
                }
                
                ArrayList<String> list = new ArrayList<>();
                for(int i = 1; i < arrayList.size(); i++) {
                    list.add(arrayList.get(i));
                }
                hashMap.put(arrayList.get(0), list);
            }

            while(true) {
                br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("검색할 단어를 입력하세요: ");
                st = new StringTokenizer(br.readLine());
                searchWord = st.nextToken();

                if(searchWord.equals("exit()")) {
                    break;
                }

                ArrayList<String> list = hashMap.get(searchWord);
                for(int i = 0; i < list.size(); i++) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();

            }

        }
        catch(Exception e) {
            e.getStackTrace();
        }
        

    }
}


