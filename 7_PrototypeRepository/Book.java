@CreationType(type = ObjectType.PROTOTYPE)
public class Book extends DataBean {
    private int bookNo;
    private String name;
    private String author;

    public Book() {
    }

    public Book(int bookNo, String name, String author) {
        this.bookNo = bookNo;
        this.name = name;
        this.author = author;
    }

    public int getBookNo() {
        return this.bookNo;
    }

    public String getName() {
        return this.name;
    }

    public String getAuthor() {
        return this.author;
    }

    @Override
    public DataBean createData() {
        return new Book(this.bookNo, this.name, this.author);
    }
}
