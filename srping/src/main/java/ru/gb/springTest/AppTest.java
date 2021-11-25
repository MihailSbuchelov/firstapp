package ru.gb.springTest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.gb.springTest.handler.ClientHandler;
import ru.gb.springTest.model.Cart;

public class AppTest {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("config.xml");
        ClientHandler.receiveMessage(applicationContext.getBean(Cart.class));
    }
}
