package gov.nasa.tests.pojo;

import com.google.gson.annotations.SerializedName;

public class Results {

    @SerializedName("description")
    private String description;

    @SerializedName("license")
    private String license;

    @SerializedName("title")
    private String title;

    @SerializedName("download_url")
    private String download_url;

    @SerializedName("duration")
    private long duration;

    @SerializedName("last_modified")
    private String last_modified;

    @SerializedName("stream_url")
    private String stream_url;

    @SerializedName("tag_list")
    private String tag_list;

    @SerializedName("id")
    private long id;


    public String getDescription() {
        return description;
    }

    public String getLicense() {
        return license;
    }

    public String getTitle() {
        return title;
    }

    public String getDownload_url() {
        return download_url;
    }

    public long getDuration() {
        return duration;
    }

    public String getLast_modified() {
        return last_modified;
    }

    public String getStream_url() {
        return stream_url;
    }

    public String getTag_list() {
        return tag_list;
    }

    public long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Results results = (Results) o;

        if (duration != results.duration) return false;
        if (id != results.id) return false;
        if (description != null ? !description.equals(results.description) : results.description != null) return false;
        if (license != null ? !license.equals(results.license) : results.license != null) return false;
        if (title != null ? !title.equals(results.title) : results.title != null) return false;
        if (download_url != null ? !download_url.equals(results.download_url) : results.download_url != null)
            return false;
        if (last_modified != null ? !last_modified.equals(results.last_modified) : results.last_modified != null)
            return false;
        if (stream_url != null ? !stream_url.equals(results.stream_url) : results.stream_url != null) return false;
        return tag_list != null ? tag_list.equals(results.tag_list) : results.tag_list == null;

    }

    @Override
    public int hashCode() {
        int result = description != null ? description.hashCode() : 0;
        result = 31 * result + (license != null ? license.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (download_url != null ? download_url.hashCode() : 0);
        result = 31 * result + (int) (duration ^ (duration >>> 32));
        result = 31 * result + (last_modified != null ? last_modified.hashCode() : 0);
        result = 31 * result + (stream_url != null ? stream_url.hashCode() : 0);
        result = 31 * result + (tag_list != null ? tag_list.hashCode() : 0);
        result = 31 * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Results{" +
                "description='" + description + '\'' +
                ", license='" + license + '\'' +
                ", title='" + title + '\'' +
                ", download_url='" + download_url + '\'' +
                ", duration=" + duration +
                ", last_modified='" + last_modified + '\'' +
                ", stream_url='" + stream_url + '\'' +
                ", tag_list='" + tag_list + '\'' +
                ", id=" + id +
                '}';
    }
}
