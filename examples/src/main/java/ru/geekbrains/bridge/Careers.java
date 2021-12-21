package ru.geekbrains.bridge;

public class Careers implements WebPage{

    private Theme theme;
    @Override
    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String getContent() {
        return "Careers page in " + this.theme.getColor();
    }
}
