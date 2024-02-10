package com.hawolt;

public class JSONElement {
    private Object value;

    public JSONElement(Object value) {
        if (value instanceof String) {
            this.value = JSON.escape(value.toString());
        } else if (value instanceof Long) {
            this.value = value;
        } else if (value instanceof Integer) {
            this.value = value;
        } else if (value instanceof Short) {
            this.value = value;
        } else if (value instanceof Float) {
            this.value = value;
        } else if (value instanceof Double) {
            this.value = value;
        } else if (value instanceof Byte) {
            this.value = value;
        } else if (value instanceof JSONObject) {
            this.value = value;
        } else if (value instanceof JSONArray) {
            this.value = value;
        } else {
            throw new JSONException("Invalid value of type " + value.getClass().getName() + " for JSONElement");
        }
    }

    public Object get() {
        return value;
    }
}
