import java.io.BufferedReader;

public class Test {

    public static void main(String[] args) {
        try {
            ObjectRepository objectRepository = new ObjectRepository();
            objectRepository.register(new Book());
            objectRepository.register(new Configurator());
            objectRepository.register(new Pen());

            System.out.println(objectRepository.getObject("Book"));
            System.out.println(objectRepository.getObject("Book"));
            System.out.println(objectRepository.getObject("Book"));

            System.out.println(objectRepository.getObject("Configurator"));
            System.out.println(objectRepository.getObject("Configurator"));
            System.out.println(objectRepository.getObject("Configurator"));

            System.out.println(objectRepository.getObject("Pen"));
            System.out.println(objectRepository.getObject("Pen"));

            System.out.println();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
