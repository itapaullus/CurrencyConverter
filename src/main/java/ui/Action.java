package ui;

import java.util.HashMap;
import java.util.Map;

public enum Action {
    EXCHANGE_CURRENCY("C"),
    QUIT("Q");
    private static final Map<String, Action> actionMap = new HashMap<>();

    static {
        for (Action action : Action.values()) {
            actionMap.put(action.value, action);
        }
    }

    private final String value;

    Action(String value) {
        this.value = value;
    }

    public static Action fromString(String value) {
        if (value == null) {
            throw new IllegalArgumentException("Action cannot be null");
        }

        Action action = actionMap.get(value.toUpperCase());
        if (action == null) {
            throw new IllegalArgumentException("Invalid Action: " + value);
        }

        return action;
    }
}
