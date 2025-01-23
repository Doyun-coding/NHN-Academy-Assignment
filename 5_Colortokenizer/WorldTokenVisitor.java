public interface WorldTokenVisitor {
    public String visit(Token token);
    public String visit(ClassToken token);
    public String visit(PublicToken token);
    public String visit(StaticToken token);
    public String visit(MethodToken token);
    public String visit(ReturnToken token);
    public String visit(TabToken token);
    public String visit(LineToken token);
}
