package ru.geekbrains.proxy;

public class SecuredDoor {

    private final Door door;

    public SecuredDoor(Door door) {
        this.door = door;
    }

    public void open(String password) {
        if (this.authenticate(password)) {
            this.door.open();
        } else {
            System.out.println("Big no! It ain't possible.");
        }
    }

    private boolean authenticate(String password) {
        return password.equals("$ecr@t");
    }

    public void close() {
        this.door.close();
    }
}
