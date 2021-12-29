package ru.geekbrains.mediator;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ChatRoom implements ChatRoomMediator{

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    @Override
    public void showMessage(User user, String message) {
        String time = dateFormat.format(new Date());
        String sender = user.getName();
        System.out.printf("%s [%s] %s%n",time, sender, message);
    }
}
