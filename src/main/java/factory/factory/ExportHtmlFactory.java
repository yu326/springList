package factory.factory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class ExportHtmlFactory implements ExportFactory {

    public ExportFile factory(String type) {
        // TODO Auto-generated method stub
        if("standard".equals(type)){

            return new ExportStandardHtmlFile();

        }else if("financial".equals(type)){

            return new ExportFinancialHtmlFile();

        }else{
            throw new RuntimeException("没有找到对象");
        }
    }
}
