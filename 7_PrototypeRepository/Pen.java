@CreationType(type = ObjectType.PROTOTYPE)
public class Pen extends DataBean {

    Pen() {

    }

    @Override
    public DataBean createData() {
        return new Pen();
    }
}
