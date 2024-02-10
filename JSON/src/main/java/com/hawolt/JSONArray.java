package com.hawolt;

import java.util.Arrays;

public class JSONArray {
    private JSONElement[] objects = new JSONElement[0];

    public void add(Object o) {
        this.objects = Arrays.copyOf(objects, objects.length + 1);
        this.objects[objects.length - 1] = new JSONElement(o);
    }

    public <T> T get(int position) {
        if (position >= objects.length) {
            throw new JSONException("Unable to access array Index " + position + " for size " + objects.length);
        }
        return (T) objects[position].get();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < objects.length; i++) {
            if (i > 0) builder.append(",");
            Object reference = objects[i].get();
            if (reference instanceof String) {
                builder.append("\"").append(reference).append("\"");
            } else {
                builder.append(reference.toString());
            }
        }
        return builder.append("]").toString();
    }
}
