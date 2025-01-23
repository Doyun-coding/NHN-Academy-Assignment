public class TokenVisitor implements WorldTokenVisitor {
    @Override
    public String visit(Token token) {
        return token.getWord();
    }

    @Override
    public String visit(ClassToken token) {
        return "<span style=\"color:blue\">" + token.getWord() + "</span>";
    }

    @Override
    public String visit(PublicToken token) {
        return "<span style=\"color:blue\">" + token.getWord() + "</span>";
    }

    @Override
    public String visit(StaticToken token) {
        return "<span style=\"color:yellow\">" + token.getWord() + "</span>";
    }

    @Override
    public String visit(MethodToken token) {
        return "<span style=\"color:green\">" + token.getWord() + "</span>";
    }

    @Override
    public String visit(ReturnToken token) {
        return "<span style=\"color:yellow\">" + token.getWord() + "</span>";
    }

    @Override
    public String visit(TabToken token) {
        return "&nbsp;&nbsp;&nbsp;&nbsp;";
    }

    @Override
    public String visit(LineToken token) {
        return "<br>";
    }
}
