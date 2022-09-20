package com.yk.IO;

import org.junit.Test;

public class TestTextIO {
    @Test
    public void TestTextIO() {
        String s1 = TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig.txt");
        System.out.println(s1);

        Double d = 0.54;
        TextIO.writeText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\new.txt",d);
    }
}
