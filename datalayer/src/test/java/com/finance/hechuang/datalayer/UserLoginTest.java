package com.finance.hechuang.datalayer;

import com.finance.hechuang.core.entities.UserLogin;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UserLoginTest {


    @Test
    public void testUser1()  {
        UserLogin userLogin1 =new UserLogin("nanyi545","123321");
        UserLogin userLogin2 =new UserLogin("nanyi545","123321");
        boolean same= userLogin1.equals(userLogin2);
        assertTrue(same);
    }

    @Test
    public void testUser2()  {
        UserLogin userLogin1 =new UserLogin("nanyi545","123321");
        UserLogin userLogin2 =new UserLogin("nanyi5451","123321");
        boolean same= userLogin1.equals(userLogin2);
        assertFalse(same);
    }

    @Test
    public void testUser3()  {
        UserLogin userLogin1 =new UserLogin("nanyi545","123321");
        UserLogin userLogin2 =new UserLogin("nanyi545","1233212");
        boolean same= userLogin1.equals(userLogin2);
        assertFalse(same);
    }



}