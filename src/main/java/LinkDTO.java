import com.opencsv.bean.CsvBindByPosition;

public class LinkDTO {

    @CsvBindByPosition(position = 0)
    private String presentationId;

    @CsvBindByPosition(position = 1)
    private String slideId;

    @CsvBindByPosition(position = 2)
    private String grade_id;

    @CsvBindByPosition(position = 3)
    private String image_url;

    @CsvBindByPosition(position = 4)
    private String size_in_bytes;

    @CsvBindByPosition(position = 5)
    private String downloaded_path;

    @CsvBindByPosition(position = 6)
    private String resized;

    public void setPresentationId(String presentationId) {
        this.presentationId = presentationId;
    }

    public void setSlideId(String slideId) {
        this.slideId = slideId;
    }

    public void setGrade_id(String grade_id) {
        this.grade_id = grade_id;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setSize_in_bytes(String size_in_bytes) {
        this.size_in_bytes = size_in_bytes;
    }

    public String getPresentationId() {
        return presentationId;
    }

    public String getSlideId() {
        return slideId;
    }

    public String getDownloaded_path() {
        return downloaded_path;
    }

    public void setDownloaded_path(String downloaded_path) {
        this.downloaded_path = downloaded_path;
    }

    public String getResized() {
        return resized;
    }

    public void setResized(String resized) {
        this.resized = resized;
    }

    public String getGrade_id() {
        return grade_id;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSize_in_bytes() {
        return size_in_bytes;
    }
}
