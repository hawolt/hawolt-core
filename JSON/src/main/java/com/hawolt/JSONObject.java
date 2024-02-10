package com.hawolt;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {
    private Map<String, JSONElement> map = new HashMap<>();

    public JSONObject put(String key, Object value) {
        this.map.put(key, new JSONElement(value));
        return this;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("{");
        int index = 0;
        for (Map.Entry<String, JSONElement> entry : map.entrySet()) {
            if (index > 0) builder.append(",");
            builder.append("\"").append(JSON.escape(entry.getKey())).append("\"").append(":");
            Object reference = map.get(entry.getKey()).get();
            if (reference instanceof String) {
                builder.append("\"").append(reference).append("\"");
            } else {
                builder.append(reference.toString());
            }
            index += 1;
        }
        return builder.append("}").toString();
    }

    public <T> T get(String key) {
        if (!map.containsKey(key)) {
            throw new JSONException("JSONElement for key " + key + " does not exist");
        }
        return (T) map.get(key).get();
    }
}
