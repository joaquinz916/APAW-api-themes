package es.upm.miw.apaw.theme.api.dtos;

import java.util.List;

import es.upm.miw.apaw.theme.api.entities.Theme;

public class ThemeVoteDto {

    private ThemeDto themeDto;
    
    private List<Integer> voteList;

    public ThemeVoteDto() {
    }

    public ThemeVoteDto(Theme theme, List<Integer> voteList) {
        themeDto = new ThemeDto(theme);
        this.voteList = voteList;
    }

    public ThemeDto getThemeDto() {
        return themeDto;
    }

    public List<Integer> getVoteList() {
        return voteList;
    }

    @Override
    public String toString() {
        return "{"+ themeDto + "," + voteList + "}";
    }
    
    
    
}
