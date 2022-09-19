package com.yk.Main;
import com.yk.*;
import com.yk.IO.TextIO;
import com.yk.Tool.HammingTool;
import com.yk.Tool.HashTool;

import javax.tools.Tool;

public class main {
    public static void main(String[] args) {
        String s1 = TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig.txt");
        String s2 = TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig_add.txt");
        String sim1 = HashTool.getSimHash(s1);
        String sim2 = HashTool.getSimHash(s2);
        System.out.println(sim1);
        System.out.println(sim2);
        Double d = HammingTool.getSimilarity(sim1,sim2);
        System.out.println(d);
    }
}
