package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    private User user;

    @BeforeEach
    void setUp(){
        user = new User("1234", "Manolo");
    }
    

    @Test
    void testGetId(){

        String spectedId = "1234";
        assertEquals(spectedId, user.getName(), );
    }



}
