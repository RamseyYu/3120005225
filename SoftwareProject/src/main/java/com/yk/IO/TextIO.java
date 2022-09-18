package com.yk.IO;

import java.io.*;

public class TextIO {

    /*

     * @param textPath 文本文件的全路径
     * @param textElem 文本重复率数值，写入文本
     * @description: 将文本比对后得出的重复率数值，写入一指定文件中
     * @author:      yk
     * @return:      void
    */

    public static void writeText (String textPath, Double textElem) {
        File file = new File(textPath);
        FileWriter fileWriter = null;
        String elem = Double.toString(textElem);

        try {
            fileWriter = new FileWriter(file,true);
            fileWriter.write(elem,0, (elem.length() > 3 ? 4 : elem.length()));
            fileWriter.write("\r\n");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*

     * @param textPath 文件绝对路径
     * @description: 传入文本的绝对路径，将文本按行进行读出
     * @author:      yk
     * @return:      String
    */

    public static String readText(String textPath) {
        String content = "";
        String line;

        File file = new File(textPath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //将文本内容按行读出，再进行字符串拼接
            while ((line = bufferedReader.readLine()) != null) {
                content += line;
            }

            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

}
