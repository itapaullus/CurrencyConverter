package ui;

import model.Currency;

public interface UserInterface {

    void showMenu();

    Action getAction();

    Currency getCurrency(String message);

    Double getAmount(String message);

    void showMessage(String message);
}
