package com.yk.Tool;

import com.yk.IO.TextIO;
import org.junit.Test;

public class TestTool {

    @Test
    public void getSimHashTest() {
        String s = HashTool.getSimHash("AAAA");
        System.out.println(s);
    }

    @Test
    public void getHammingToolTest() {
        String s1 = HashTool.getSimHash(TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig.txt"));
        String s2 = HashTool.getSimHash(TextIO.readText("D:\\系统自定义修改\\new桌面\\软件工程个人项目\\SoftwareProject\\TestData\\orig_0.8_dis_15.txt"));
        System.out.println(s1);
        System.out.println(s2 );
        Double d = HammingTool.getSimilarity(s1,s2);
        System.out.println(d);
    }
}
