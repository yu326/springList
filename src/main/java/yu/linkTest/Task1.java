package yu.linkTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by koreyoshi on 2017/7/27.
 */
public class Task1 {

    //练习  用链表实现栈，然后平衡符号
    //读取一个文件，然后读取，如果字符是一个开放符号，则将其推入栈中
    //如果是一个封闭符号，则当栈空时则报错。否则，将栈元素弹出
    //如果弹出的符号不是对应的开放符号，则报错。
    //在文件结尾，如果栈非空则报错
    public static void main(String[] args) {
        try {
//  符号数组
            ArrayList<String> startSymbol = new ArrayList<String>();
            startSymbol.add("(");
            startSymbol.add("{");
            startSymbol.add("[");
            ArrayList<String> closeSymbol = new ArrayList<String>();
            closeSymbol.add(")");
            closeSymbol.add("}");
            closeSymbol.add("]");

            //链表
            LinkedList link = new LinkedList();
            //读取文件
//        readFileByChars("D:/Java/SpringList/yu_04/src/main/java/yu/TestController.java", startSymbol, closeSymbol, link);
            readFileByChars("D:/Java/github/springTest/src/main/java/yu/read.txt", startSymbol, closeSymbol, link);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 以行为单位读取文件，常用于读面向行的格式化文件
     */
//    public static void readFileByLines(String fileName) {
//        File file = new File(fileName);
//        BufferedReader reader = null;
//        try {
//            System.out.println("以行为单位读取文件内容，一次读一整行：");
//            reader = new BufferedReader(new FileReader(file));
//            String tempString = null;
//            int line = 1;
//            // 一次读入一行，直到读入null为文件结束
//            while ((tempString = reader.readLine()) != null) {
//                // 显示行号
//                System.out.println("line " + line + ": " + tempString);
//                line++;
//            }
//            reader.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e1) {
//                }
//            }
//        }
//    }
    public static void readFileByChars(String fileName, ArrayList startSymbol, ArrayList closeSymbol, LinkedList link) {
        File file = new File(fileName);
        Reader reader = null;
        try {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            // 一次读一个字符
            reader = new InputStreamReader(new FileInputStream(file));
            int tempchar;
            while ((tempchar = reader.read()) != -1) {
                // 对于windows下，\r\n这两个字符在一起时，表示一个换行。
                // 但如果这两个字符分开显示时，会换两次行。
                // 因此，屏蔽掉\r，或者屏蔽\n。否则，将会多出很多空行。

                String symbol = String.valueOf((char) tempchar);
                if (startSymbol.contains(symbol)) {
                    System.out.println("in startSymbol is:" + symbol);
                    link.addFirst(symbol);
                } else if (closeSymbol.contains(symbol)) {
                    System.out.println("in closeSymbol is:" + symbol);
                    if (link.size() == 0) {
                        throw new RuntimeException("封闭符号前面，没有开始符号, the symbol is: [" + symbol + "],the link is null");
                    }
                    int index = closeSymbol.indexOf(symbol);
                    String currSymbol = String.valueOf(link.removeFirst());
                    int index1 = startSymbol.indexOf(currSymbol);
                    if (index == index1) {
                        System.out.println("this is ok!!! the symbol is: [" + symbol + "] , the link symbol is:[" + currSymbol + "]");
                    } else {
                        throw new RuntimeException("元素符号不匹配~~~, the symbol is: [" + symbol + "] , the link symbol is:[" + currSymbol + "]");
                    }
                } else {
                    //不在符号表内，不做处理
//                        System.out.println("都不存在");
                }
            }
            if (link.size() != 0) {
                System.out.println("at the ending the link is not null,the link size is" + link.size());
                throw new RuntimeException("元素没有结束符号。the link size is" + link.size());
            }
            //最后检查符号表
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public Boolean regSymbol(int type, String symbol, LinkedList link) {
//        Boolean res = true;
//        if (type == 1) {
//            link.addFirst(symbol);
//        } else if (type == 2) {
//            if (link.size() == 0) {
//                throw new RuntimeException("封闭符号前面，没有开始符号");
//            }
////            symbol
//        }
//
//
//        return true;
//    }

}
