package com.jorel.diary.models;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public final class UserTest {

    @Test
    public void testUserCreation() {
        User user = new User();

        assertNotNull(user.getId());

        assertNull(user.getName());
        assertNull(user.getEmail());
        assertNull(user.getPassword());
        assertEquals(0, user.getAge());
        assertNotNull(user.getCreatedAt());
        assertNull(user.getUpdatedAt());
        assertNotNull(user.getPageList());
    }

    @Test
    public void testSettersAndGetters() {
        User user = new User();

        user.setName("John Doe");
        user.setEmail("john@example.com");
        user.setPassword("securePassword");
        user.setAge(25);

        assertEquals("John Doe", user.getName());
        assertEquals("john@example.com", user.getEmail());
        assertEquals("securePassword", user.getPassword());
        assertEquals(25, user.getAge());

        assertNotNull(user.getUpdatedAt());
    }

    @Test
    public void testAddPage() {
        User user = new User();
        Page page = new Page(user.getId());

        user.setPage(page);

        List<Page> pageList = user.getPageList();
        assertNotNull(pageList);
        assertEquals(1, pageList.size());
        assertEquals(page, pageList.get(0));
    }
}
