package com.yk.Main;
import com.yk.*;
import com.yk.IO.TextIO;
import com.yk.Tool.HashTool;

import javax.tools.Tool;

public class main {
    public static void main(String[] args) {
        String s = TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig.txt");
        System.out.println(s.length());

        System.out.println(HashTool.getSimHash(s));
    }
}
