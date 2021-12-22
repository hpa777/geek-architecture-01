package ru.geekbrains.mediator;

public class User {

    private final String name;
    private final ChatRoomMediator chatMediator;

    public User(String name, ChatRoomMediator chatMediator) {
        this.name = name;
        this.chatMediator = chatMediator;
    }

    public String getName() {
        return name;
    }
    public void send(String message) {
        this.chatMediator.showMessage(this, message);
    }
}
