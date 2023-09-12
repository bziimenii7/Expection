package ru.netology.javaqa.ShopRepository;
public class NotFoundException extends RuntimeException {
    public NotFoundException(int id) {
        super("Товар с номером id - " + id + " не существует");
    }
}
