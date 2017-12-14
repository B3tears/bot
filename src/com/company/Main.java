package com.company;

public class Main {

    public static void main(String[] args) {
        UndeadSong undead = new UndeadSong();
        String msg = undead.msg;
        SendMsg mail = new SendMsg();
        mail.setServer("smtp.gmail.com");
        mail.setProperties();
        mail.Message("receiver@gmail.com", "Hollywood Undead", msg, "sender@gmail.com", "1357924680");//FOR EXAMPLE!
    }
}