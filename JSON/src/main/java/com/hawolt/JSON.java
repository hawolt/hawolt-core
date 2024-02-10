package com.hawolt;

public class JSON {

    public static String escape(String in) {
        StringBuilder builder = new StringBuilder(in);
        for (int i = builder.length() - 1; i >= 0; i--) {
            char character = builder.charAt(i);
            switch (character) {
                case '"':
                    builder.insert(i, "\\");
                    break;
                case '\\':
                    builder.replace(i, i + 1, "\\\\");
                    break;
                case '\b':
                    builder.replace(i, i + 1, "\\b");
                    break;
                case '\f':
                    builder.replace(i, i + 1, "\\f");
                    break;
                case '\n':
                    builder.replace(i, i + 1, "\\n");
                    break;
                case '\r':
                    builder.replace(i, i + 1, "\\r");
                    break;
                case '\t':
                    builder.replace(i, i + 1, "\\t");
                    break;
            }
        }
        return builder.toString();
    }

    public static String unescape(String in) {
        StringBuilder builder = new StringBuilder(in);
        for (int i = builder.length() - 1; i >= 0; i--) {
            char character = builder.charAt(i);
            if (i == 0) break;
            char previous = builder.charAt(i - 1);
            if (previous != '\\') continue;
            switch (character) {
                case '"':
                    builder.replace(i, i, "");
                    break;
                case '\\':
                    builder.replace(i - 1, i, "\\");
                    break;
                case 'b':
                    builder.replace(i - 1, i, "\b");
                    break;
                case 'f':
                    builder.replace(i - 1, i, "\f");
                    break;
                case 'n':
                    builder.replace(i - 1, i, "\n");
                    break;
                case 'r':
                    builder.replace(i - 1, i, "\r");
                    break;
                case 't':
                    builder.replace(i - 1, i, "\t");
                    break;
            }
        }
        return builder.toString();
    }
}
