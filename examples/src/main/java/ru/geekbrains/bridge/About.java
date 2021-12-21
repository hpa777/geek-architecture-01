package ru.geekbrains.bridge;

public class About implements WebPage {

    private Theme theme;

    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "About page in " + theme.getColor();
    }
}
