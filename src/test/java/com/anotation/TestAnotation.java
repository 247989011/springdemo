package com.anotation;

import com.BasicTest;
import com.spring.demo.anotation.WxConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAnotation extends BasicTest {

    @Autowired
    private WxConfig wxConfig;

    @Test
    public void testConfig() {
        System.out.println(wxConfig);
    }
}
