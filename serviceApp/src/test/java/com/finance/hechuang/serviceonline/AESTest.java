package com.finance.hechuang.serviceonline;

import com.finance.hechuang.serviceonline.utils.encrypt.EncrypAES;

import org.junit.Test;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class AESTest {

    @Test
    public void test1() {
        String str1="test1";
        String encrypted=EncrypAES.getInstance().encrypt(str1);
        System.out.println(encrypted);
        System.out.println(EncrypAES.getInstance().decrypt(encrypted));
    }

    @Test
    public void test2() {
        String str1="test1";
        System.out.println(str1);
    }


}