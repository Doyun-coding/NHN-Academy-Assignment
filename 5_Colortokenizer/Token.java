public class Token {
    String word;

    public Token(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }

    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class ClassToken extends Token {
    public ClassToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class PublicToken extends Token {
    public PublicToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class StaticToken extends Token {
    public StaticToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class MethodToken extends Token {
    public MethodToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class ReturnToken extends Token {
    public ReturnToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class TabToken extends Token {
    public TabToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}

class LineToken extends Token {
    public LineToken(String word) {
        super(word);
    }

    @Override
    String accept(WorldTokenVisitor visitor) {
        return visitor.visit(this);
    }
}