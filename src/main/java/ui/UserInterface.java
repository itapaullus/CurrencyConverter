package ui;

public interface UserInterface {

    void showMenu();

    Action getAction() throws InvalidAction;

    String getCurrency(String message);

    Double getAmount(String message);

    void showMessage(String message);
}
