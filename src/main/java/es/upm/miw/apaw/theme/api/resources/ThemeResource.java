package es.upm.miw.apaw.theme.api.resources;

import java.util.List;
import java.util.Optional;

import es.upm.miw.apaw.theme.api.controllers.ThemeController;
import es.upm.miw.apaw.theme.api.dtos.ThemeDto;
import es.upm.miw.apaw.theme.api.dtos.ThemeVoteDto;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeFieldInvalidException;
import es.upm.miw.apaw.theme.api.resources.exceptions.ThemeIdNotFoundException;

public class ThemeResource {

    public static final String THEMES = "themes";

    public static final String $ID = "{id}";

    public static final String $ID_OVERAGE = $ID + "/overage";

    public static final String $ID_VOTES = $ID + "/votes";

    // GET **/themes
    public List<ThemeDto> themeList() {
        return new ThemeController().themeList();
    }

    // GET **/themes/{id}
    public ThemeDto readTheme(int themeId) throws ThemeIdNotFoundException {
        Optional<ThemeDto> optional = new ThemeController().readTheme(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
        
    }

    // POST **/themes body="themeName"
    public void createTheme(String themeName) throws ThemeFieldInvalidException {
        this.validateField(themeName);
        new ThemeController().createTheme(themeName);
    }

    private void validateField(String field) throws ThemeFieldInvalidException {
        if (field == null || field.isEmpty()) {
            throw new ThemeFieldInvalidException(field);
        }
    }

    // GET **/themes/{id}/overage
    public Double themeOverage(int themeId) throws ThemeIdNotFoundException {
        Optional<Double> optional = new ThemeController().themeOverage(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }

    // GET **/themes/{id}/votes
    public ThemeVoteDto themeVotes(int themeId) throws ThemeIdNotFoundException {
        Optional<ThemeVoteDto> optional = new ThemeController().themeVotes(themeId);
        return optional.orElseThrow(() -> new ThemeIdNotFoundException(Integer.toString(themeId)));
    }
}
