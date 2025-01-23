import java.util.ArrayList;
import java.util.List;

public class JBDJ09002_colortokenizer {
    public static void main(String[] args) {
        String code = "public class Sample {\n" +
                "    int I = 5;\n" +
                "}" +
                "\n";
        String[] words = code.split(" ");

        WorldTokenVisitor visitor = new TokenVisitor();
        List<Token> list = new ArrayList<>();

        for(int i = 0; i < words.length; i++) {
            if(words[i].contains("\n")) {
                for(int j = 0; j < words[i].length(); j++) {
                    if(words[i].charAt(j) == '\n') {
                        words[i] = words[i].substring(0, j) + "<br>" + words[i].substring(j+1);
                    }
                }
            }

            if(words[i].equals("class") || words[i].equals("abstract") || words[i].equals("interface")) {
                list.add(new ClassToken(words[i]));
            }
            else if(words[i].equals("public") || words[i].equals("private") || words[i].equals("protected")) {
                list.add(new PublicToken(words[i]));
            }
            else if(words[i].equals("static")) {
                list.add(new StaticToken(words[i]));
            }
            else if(words[i].equals("void") || words[i].equals("int") || words[i].equals("bytes") || words[i].equals("short") || words[i].equals("long") || words[i].equals("float") || words[i].equals("double") || words[i].equals("char") || words[i].equals("boolean")) {
                list.add(new MethodToken(words[i]));
            }
            else if(words[i].equals("return")) {
                list.add(new ReturnToken(words[i]));
            }
            else if(words[i].equals("")) {
                boolean check = true;
                for(int j = i; j <= i+2; j++) {
                    if(!words[j].equals("")) {
                        check = false;
                        break;
                    }
                }

                if(check) {
                    list.add(new TabToken(words[i]));
                    i += 2;
                }
            }
            else if(words[i].equals("\n")) {
                list.add(new LineToken(words[i]));
            }
            else {
                list.add(new Token(words[i]));
            }
        }

        for(Token token : list) {
            System.out.print(token.accept(visitor) + " ");
        }

    }

}
