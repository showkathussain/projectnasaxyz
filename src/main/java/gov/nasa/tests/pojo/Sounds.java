package gov.nasa.tests.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;

public class Sounds {

    @SerializedName("count")
    private int count;

    @SerializedName("results")
    private Results[] results;

    public int getCount() {
        return count;
    }

    public Results[] getResults() {
        return results;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sounds sounds = (Sounds) o;

        if (count != sounds.count) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(results, sounds.results);

    }

    @Override
    public int hashCode() {
        int result = count;
        result = 31 * result + Arrays.hashCode(results);
        return result;
    }

    @Override
    public String toString() {
        return "Sounds{" +
                "count=" + count +
                ", results=" + Arrays.toString(results) +
                '}';
    }
}
