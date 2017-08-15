package test.ota;

import org.bson.Document;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by koreyoshi on 2017/8/15.
 */
public class FilterStringUtil {
    public static void main(String[] args) {
//        String str = "<p class='xxxx'> Content\n\r内容\t\n\n</p>";
//        Matcher m = Pattern.compile("<p.*?>([\\s\\S]*)</p>").matcher(str);
//        while(m.find()){
//            System.out.println(m.group(1));
//        }
        String str = "<img src='a.jpg'/> aaaaa  <img src=\"b.jpg\"/>";
        Matcher m = Pattern.compile("/<[img|IMG].*?src=[\"|'](.*?(?:[\.gif|\.jpg|\.jpeg|\.bmp|\.png|\.pic]?))['|\"].*?[\/]?>/").matcher(str);
        while(m.find()){
            System.out.println(m.group(1));
        }

//        Document docData = new Document();
//        docData.append("text","<img src='a.jpg'/> aaaaa  <img src=\"b.jpg\"/>");
//        dataClean(docData);


    }



    public static Document dataClean(Document docData){
        String docText = (String) docData.get("text");



        return docData;
    }

}
