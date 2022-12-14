package com.yk.Main;
import com.sun.prism.shader.Texture_ImagePattern_AlphaTest_Loader;
import com.yk.*;
import com.yk.IO.TextIO;
import com.yk.Tool.HammingTool;
import com.yk.Tool.HashTool;

import javax.tools.Tool;
import java.math.BigInteger;
import java.security.MessageDigest;

public class main {
    public static void main(String[] args) {
        //通过命令行的args数组读取文件绝对路径
        try{
            //传入原文文本
            String s1 = TextIO.readText(args[0]);
            //传入抄袭文章文本
            String s2 = TextIO.readText(args[1]);
            String sim1 = HashTool.getSimHash(s1);
            String sim2 = HashTool.getSimHash(s2);
            System.out.println(sim1);
            System.out.println(sim2);
            Double d = HammingTool.getSimilarity(sim1,sim2);
            System.out.println(d);
            //将结果写入存储结果的txt文件中
            TextIO.writeText(args[2],d);
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("文件路径不存在，请检测文件路径");
        }

    }
}
