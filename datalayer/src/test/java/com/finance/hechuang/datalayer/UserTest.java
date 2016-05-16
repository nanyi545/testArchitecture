package com.finance.hechuang.datalayer;

import com.finance.hechuang.core.entities.User;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class UserTest {


    @Test
    public void testUser1()  {
        User user1=new User("nanyi545","123321");
        User user2=new User("nanyi545","123321");
        boolean same=user1.equals(user2);
        assertTrue(same);
    }

    @Test
    public void testUser2()  {
        User user1=new User("nanyi545","123321");
        User user2=new User("nanyi5451","123321");
        boolean same=user1.equals(user2);
        assertFalse(same);
    }

    @Test
    public void testUser3()  {
        User user1=new User("nanyi545","123321");
        User user2=new User("nanyi545","1233212");
        boolean same=user1.equals(user2);
        assertFalse(same);
    }



}