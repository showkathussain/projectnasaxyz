package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

public class ApiKey {

    @SerializedName("type")
    private String type;

    @SerializedName("value")
    private String value;

    @SerializedName("responseCode")
    private int responseCode;

    public String getType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ApiKey apiKey = (ApiKey) o;

        if (responseCode != apiKey.responseCode) return false;
        if (type != null ? !type.equals(apiKey.type) : apiKey.type != null) return false;
        return value != null ? value.equals(apiKey.value) : apiKey.value == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + responseCode;
        return result;
    }

    @Override
    public String toString() {
        return "ApiKey{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}
