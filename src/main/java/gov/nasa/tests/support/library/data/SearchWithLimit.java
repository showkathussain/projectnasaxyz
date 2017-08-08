package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

public class SearchWithLimit {

    @SerializedName("type")
    private String type;

    @SerializedName("search")
    private String search;

    @SerializedName("limit")
    private int limit;

    @SerializedName("responseCode")
    private int responseCode;

    public String getType() {
        return type;
    }

    public String getSearch() {
        return search;
    }

    public int getLimit() {
        return limit;
    }

    public int getResponseCode() {
        return responseCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SearchWithLimit that = (SearchWithLimit) o;

        if (limit != that.limit) return false;
        if (responseCode != that.responseCode) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        return search != null ? search.equals(that.search) : that.search == null;

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (search != null ? search.hashCode() : 0);
        result = 31 * result + limit;
        result = 31 * result + responseCode;
        return result;
    }

    @Override
    public String toString() {
        return "SearchWithLimit{" +
                "type='" + type + '\'' +
                ", search='" + search + '\'' +
                ", limit=" + limit +
                ", responseCode=" + responseCode +
                '}';
    }
}
