package camera2.Picture;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GenericPicture {

    public void setHeight(int height) {
        this.height = (height < 200) ? 200 : height;
    }

    public void setWidth(int width) {
        this.width = (width < 200) ? 200 : width;
    }

    private int height;
    private int width;
    private String filePath;
}
