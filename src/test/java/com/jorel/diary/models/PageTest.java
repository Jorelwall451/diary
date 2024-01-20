package com.jorel.diary.models;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public final class PageTest {
    @Test
    public void testPageCreation(){
        User user = new User();
        Page page = new Page(user.getId());

        assertNull(page.getTitle());
        assertNull(page.getText());
        assertNotNull(page.getId());
        assertNotNull(page.getCreatedAt());
        assertNull(page.getUpdatedAt());
        assertNotNull(page.getUserId());
    }

    @Test
    public void testGettersAndSetters(){
        User user = new User();
        Page page = new Page(user.getId());

        String pageTitle = "A pretty day";
        String pageText = "I'm happy";

        page.setTitle(pageTitle);
        page.setText(pageText);

        assertEquals(pageTitle, page.getTitle());
        assertEquals(pageText, page.getText());

        assertNotNull(page.getUpdatedAt());
    }
}
