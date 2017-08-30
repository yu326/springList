package factory.factory;

/**
 * Created by koreyoshi on 2017/8/30.
 */
public class ExportStandardPdfFile implements ExportFile {
    public boolean export(String data) {
        // TODO Auto-generated method stub
        /**
         * 业务逻辑
         */
        System.out.println("导出标准PDF文件");
        return true;
    }
}
