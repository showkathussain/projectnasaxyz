package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class TestDataSet {

    @SerializedName("limit")
    private Limit[] limit;

    @SerializedName("search")
    private Search[] search;

    @SerializedName("apiKey")
    private ApiKey[] apiKey;

    @SerializedName("searchWithLimit")
    private SearchWithLimit[] searchWithLimit;

    public Limit[] getLimit() {
        return limit;
    }

    public Search[] getSearch() {
        return search;
    }

    public ApiKey[] getApiKey() {
        return apiKey;
    }

    public SearchWithLimit[] getSearchWithLimit() {
        return searchWithLimit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestDataSet that = (TestDataSet) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(limit, that.limit)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(search, that.search)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(apiKey, that.apiKey)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(searchWithLimit, that.searchWithLimit);

    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(limit);
        result = 31 * result + Arrays.hashCode(search);
        result = 31 * result + Arrays.hashCode(apiKey);
        result = 31 * result + Arrays.hashCode(searchWithLimit);
        return result;
    }

    @Override
    public String toString() {
        return "TestDataSet{" +
                "limit=" + Arrays.toString(limit) +
                ", search=" + Arrays.toString(search) +
                ", apiKey=" + Arrays.toString(apiKey) +
                ", searchWithLimit=" + Arrays.toString(searchWithLimit) +
                '}';
    }
}


