package dev.aithon.config;

public class MessageUtil {

    public static Type parseType(final String s){
        Type type = Type.MESSAGE;

        if (s.equalsIgnoreCase("action bar") || s.equalsIgnoreCase("action_bar")) {
            type = Type.ACTIONBAR;
        }
        if (s.equalsIgnoreCase("title")) {
            type = Type.TITLE;
        }
        if (s.equalsIgnoreCase("message/actionbar") || s.equalsIgnoreCase("actionbar/message")) {
            type = Type.ACTIONBAR_MESSAGE;
        }
        if (s.equalsIgnoreCase("title/actionbar") || s.equalsIgnoreCase("actionbar/title")) {
            type = Type.ACTIONBAR_TITLE;
        }
        if (s.equalsIgnoreCase("title/message") || s.equalsIgnoreCase("message/title")) {
            type = Type.MESSAGE_TITLE;
        }

        return type;
    }
}
