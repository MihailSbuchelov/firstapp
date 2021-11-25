package ru.gb.springTest.handler;

import ru.gb.springTest.model.Cart;
import ru.gb.springTest.model.Product;

import java.util.Scanner;

public class ClientHandler {

    public static void receiveMessage(Cart cart) {
        greetingMessage();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String message = scanner.nextLine();
                if (message.equals("sp")) {
                    cart.getRepositoryAvailable().printRepositoryImpl();
                }
                if (message.equals("add")) {
                    System.out.println("введите ID товара из списка доступных товаров, для добавления в корзину");
                    addProdToCart(cart);
                    cart.showCart();
                }
                if (message.equals("sc")) {
                    cart.showCart();
                }
                if (message.equals("dell")) {
                    System.out.println("введите ID товара, для удаления из корзины");
                    dellProdFromCart(cart);
                    cart.showCart();
                }
                if (message.equals("clear")) {
                    cart.clearCart();
                    cart.showCart();
                }
                if (message.equals("help")) {
                    greetingMessage();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void greetingMessage() {
        System.out.println("Доступные команды: \n" +
                "help - справка по доступным командам\n" +
                "sp - показать доступные товары\n" +
                "add - добавить товар в корзину\n" +
                "sc - показать корзину\n" +
                "dell - удалить товар из корзины\n" +
                "clear - очистить корзину\n"
        );
        System.out.println("Пожалуйста, введите команду..\n");
    }

    private static void addProdToCart(Cart cart) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int message = scanner.nextInt();
                for (Product p : cart.getRepositoryAvailable().getRepositoryProducts()) {
                    if (p.getId() == message) {
                        cart.addProductToCart(message);
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void dellProdFromCart(Cart cart) {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                int message = scanner.nextInt();
                cart.dellProductFromCart(message);
                return;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}