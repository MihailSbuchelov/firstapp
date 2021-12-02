package ru.gb;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.gb.config.HomeworkConfig;
import ru.gb.model.Buyer;

public class HomeworkApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new
                AnnotationConfigApplicationContext(HomeworkConfig.class);
        for (int i = 0; i < 5; i++) {
            Buyer buyer = applicationContext.getBean(Buyer.class);
            buyer.purchase();
            buyer.showCart();
        }

    }
}
