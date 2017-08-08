package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

public class Search {

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

        Search search = (Search) o;

        if (responseCode != search.responseCode) return false;
        if (type != null ? !type.equals(search.type) : search.type != null) return false;
        return value != null ? value.equals(search.value) : search.value == null;

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
        return "Search{" +
                "type='" + type + '\'' +
                ", value='" + value + '\'' +
                ", responseCode=" + responseCode +
                '}';
    }
}
