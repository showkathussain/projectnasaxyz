package gov.nasa.tests.support.library.data;

import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("testDataSet")
    private TestDataSet testDataSet;

    public TestDataSet getTestDataSet() {
        return testDataSet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Data data = (Data) o;

        return testDataSet != null ? testDataSet.equals(data.testDataSet) : data.testDataSet == null;

    }

    @Override
    public int hashCode() {
        return testDataSet != null ? testDataSet.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Data{" +
                "testDataSet=" + testDataSet +
                '}';
    }
}
