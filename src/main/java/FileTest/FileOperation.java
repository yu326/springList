package FileTest;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.io.*;

/**
 * Created by koreyoshi on 2017/11/1.
 */
public class FileOperation {

    /**
     * 创建文件
     *
     * @param
     * @return
     */
    @Test
    public void createFile() throws Exception {
        File fileName = new File("test12.txt");
        boolean flag = false;
        try {
            if (!fileName.exists()) {
                fileName.createNewFile();
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 读TXT文件内容
     *
     * @param
     * @return
     */
    @Test
    public void readTxtFile() throws Exception {
        File fileName = new File("uids.txt");
        String result = "";
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(fileName);
            bufferedReader = new BufferedReader(fileReader);
            try {
                String reads = null;
                String read = null;

                JSONObject jsonData = new JSONObject();
                while ((read = bufferedReader.readLine()) != null) {
                    reads = reads+"\""+read +"\",";

                }
                System.out.println(reads);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
        }
        System.out.println("读取出来的文件内容是：" + "\r\n" + result);

    }

    @Test
    public void writeTxtFile() throws Exception {
        File fileName = new File("test12.txt");
        String content = "《小巷》----顾城\n小巷\n又弯又长\n没有门\n没有窗\n我拿把旧钥匙\n敲着厚厚的墙\n";
        RandomAccessFile mm = null;
        boolean flag = false;
        FileOutputStream o = null;
        try {
            o = new FileOutputStream(fileName,true);
            o.write(content.getBytes("utf-8"));
            o.close();
//   mm=new RandomAccessFile(fileName,"rw");
//   mm.writeBytes(content);
            flag = true;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            if (mm != null) {
                mm.close();
            }
        }

    }


    public void contentToTxt(String filePath, String content) {
        String str = new String(); //原有txt内容
        String s1 = new String();//内容更新
        try {
            File f = new File(filePath);
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();// 不存在则创建
            }
            BufferedReader input = new BufferedReader(new FileReader(f));

            while ((str = input.readLine()) != null) {
                s1 += str + "\n";
            }
            System.out.println(s1);
            input.close();
            s1 += content;

            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            output.write(s1);
            output.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
