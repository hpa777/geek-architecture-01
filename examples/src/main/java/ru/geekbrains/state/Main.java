package ru.geekbrains.state;

public class Main {

    public static void main(String[] args) {
        TextEditor editor = new TextEditor(new DefaultText());

        editor.type("First line");

        editor.setState(new UpperCase());

        editor.type("Second line");
        editor.type("Third line");

        editor.setState(new LowerCase());

        editor.type("Fourth line");
        editor.type("Fifth line");

    }
}
