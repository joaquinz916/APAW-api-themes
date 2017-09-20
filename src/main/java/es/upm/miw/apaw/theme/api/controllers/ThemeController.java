package es.upm.miw.apaw.theme.api.controllers;

import java.util.ArrayList;
import java.util.List;

import es.upm.miw.apaw.theme.api.daos.DaoFactory;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeController {

    public List<ThemeDto> themeList() {
        List<Theme> themeList = DaoFactory.getFactory().getThemeDao().findAll();
        List<ThemeDto> themeDtoList = new ArrayList<>();
        for (Theme theme : themeList) {
            themeDtoList.add(new ThemeDto(theme));
        }
        return themeDtoList;
    }

    public void createTheme(String themeName) {
        DaoFactory.getFactory().getThemeDao().create(new Theme(themeName));
    }

    public boolean existThemeId(int themeId) {
        return DaoFactory.getFactory().getThemeDao().read(themeId) != null;
    }

    public Double themeOverage(int themeId) {
        List<Integer> voteValues = DaoFactory.getFactory().getVoteDao().findValueByThemeId(themeId);
        if (voteValues.isEmpty()) {
            return Double.NaN;
        } else {
            double total = 0;
            for (Integer value : voteValues) {
                total += value;
            }
            return total / voteValues.size();
        }
    }

}