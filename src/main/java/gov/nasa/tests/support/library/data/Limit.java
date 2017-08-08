package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

public class Limit {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private int value;

    @SerializedName("responseCode")
    private int responseCode;

    public String getType() {
        return type;
    }

    public int getValue() {
        return value;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Limit limit = (Limit) o;

        if (value != limit.value) return false;
        if (responseCode != limit.responseCode) return false;
        return type != null ? type.equals(limit.type) : limit.type == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + value;
        result = 31 * result + responseCode;
        return result;
    }

    @Override
    public String toString() {
        return "Limit{" +
                "type='" + type + '\'' +
                ", value=" + value +
                ", responseCode=" + responseCode +
                '}';
    }
}
