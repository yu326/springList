package factory.factory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class ExportPdfFactory implements ExportFactory {

    public ExportFile factory(String type) {
        // TODO Auto-generated method stub
        if("standard".equals(type)){

            return new ExportStandardPdfFile();

        }else if("financial".equals(type)){

            return new ExportFinancialPdfFile();

        }else{
            throw new RuntimeException("没有找到对象");
        }
    }
}
