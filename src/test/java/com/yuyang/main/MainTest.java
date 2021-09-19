package com.yuyang.main;

import org.junit.Test;

import static com.yuyang.main.Main.main;

public class MainTest {
    @Test
    public void testMain(){
            Main.main(new String[]{"D:\\测试文本\\orig.txt","D:\\测试文本\\orig_0.8_add.txt","D:\\测试文本\\RepetitionRate.txt"});
    }
}
