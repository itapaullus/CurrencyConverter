package ui;

public interface UserInterface {

    void ShowMenu();
    Action getAction();

    String getCurrency(String message);

    Double getAmount(String message);
}
