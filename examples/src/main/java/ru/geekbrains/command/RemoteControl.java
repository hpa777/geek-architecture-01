package ru.geekbrains.command;

public class RemoteControl {

    public void submit (Command command) {
        command.execute();
    }
}
