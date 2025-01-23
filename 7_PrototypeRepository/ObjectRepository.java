import java.util.HashMap;

public class ObjectRepository implements Framework {
    private HashMap<String, DataBean> hashMap;

    public ObjectRepository() {
        this.hashMap = new HashMap<>();
    }

    public void register(DataBean dataBean) {
        this.hashMap.put(dataBean.getClass().getName(), dataBean);
    }

    public DataBean getObject(String product) {
        DataBean dataBean = hashMap.get(product);
        if(dataBean.getClass().getDeclaredAnnotation(CreationType.class).type() == ObjectType.PROTOTYPE) {
            return clone(dataBean);
        }

        if(dataBean.getClass().getDeclaredAnnotation(CreationType.class).type() == ObjectType.SINGLETON){
            return dataBean;
        }

        return null;
    }

    public DataBean clone(DataBean dataBean) {
        return dataBean.createData();
    }

}
