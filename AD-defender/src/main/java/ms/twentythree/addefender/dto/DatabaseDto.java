package ms.twentythree.addefender.dto;

public class DatabaseDto {
    private int id;
    private String url;
    private boolean includesAd;
    private String summary;

    public DatabaseDto() {
    }

    public DatabaseDto(int id, String address, boolean includesAd, String summary) {
        this.id = id;
        this.url = address;
        this.includesAd = includesAd;
        this.summary = summary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isIncludesAd() {
        return includesAd;
    }

    public void setIncludesAd(boolean includesAd) {
        this.includesAd = includesAd;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "DatabaseDto{" +
                "id=" + id +
                ", address='" + url + '\'' +
                ", includesAd=" + includesAd +
                ", summary='" + summary + '\'' +
                '}';
    }
}
