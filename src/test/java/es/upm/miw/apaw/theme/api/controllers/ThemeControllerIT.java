package es.upm.miw.apaw.theme.api.controllers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.daos.memory.DaoFactoryMemory;

public class ThemeControllerIT {

    private ThemeController themeController;

    @Before
    public void before() {
        DaoFactory.setFactory(new DaoFactoryMemory());
        themeController = new ThemeController();
    }

    @Test
    public void testCreateAndThemeList() {
        themeController.createTheme("tema1");
        themeController.createTheme("tema2");
        assertEquals(2, themeController.themeList().size());
        assertEquals("tema1", themeController.themeList().get(0).getName());
    }

    @Test
    public void testExistThemeIdTrue() {
        themeController.createTheme("tema1");
        assertTrue(themeController.existThemeId(1));
    }

    @Test
    public void testExistThemeIdFalse() {
        assertFalse(themeController.existThemeId(1));
    }

    @Test
    public void testThemeOverage() {
        themeController.createTheme("tema1");
        new VoteController().createVote(1, 2);
        new VoteController().createVote(1, 3);
        assertEquals(2.5,themeController.themeOverage(1),10e-3);
    }

}