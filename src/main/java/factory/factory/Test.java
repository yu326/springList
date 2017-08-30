package factory.factory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String data = "";
        ExportFactory exportFactory = new ExportHtmlFactory();
        ExportFile ef = exportFactory.factory("financial");
        ef.export(data);
    }
}
