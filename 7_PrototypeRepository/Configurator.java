
@CreationType(type = ObjectType.SINGLETON)
public class Configurator extends DataBean {

    private String name;

    public Configurator() {
    }

    public String getName() {
        return this.name;
    }

    @Override
    public DataBean createData() {
        return new Configurator();
    }
}
