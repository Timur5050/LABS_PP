package logging;

import java.util.HashMap;

abstract public class BaseLogger {
    HashMap<String, String> map = new HashMap<>() {{
        put("reset", "\u001B[0m");
        put("green", "\u001B[32m");
        put("blue", "\u001B[34m");
        put("yellow", "\u001B[33m");
        put("purple", "\u001B[35m");
        put("white", "\033[0;37m");
    }};

    public abstract void logInformation(String content, String color);
}
