package camera2;

import java.util.ArrayList;
import java.util.List;

import camera2.Picture.GenericPicture;
import camera2.Picture.TakePictureLogic;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractCamera {

    private String model;
    private int year;
    private double displaySize;

    @Setter(AccessLevel.PUBLIC)
    private boolean hasMemoryCard;
    @Setter(AccessLevel.PUBLIC)
    private List<GenericPicture> pictures = new ArrayList<>();
    @Setter(AccessLevel.PUBLIC)
    protected TakePictureLogic takePictureLogic;

    public abstract GenericPicture executeTakePictureLogic();

    public GenericPicture takePicture() {
        GenericPicture picture = executeTakePictureLogic();
        this.addPicture(picture);
        return picture;
    }

    public AbstractCamera(String model, int year, int displaySize, boolean hasMemoryCard) {
        this.model = model;
        this.year = year;
        this.displaySize = displaySize;
        this.hasMemoryCard = hasMemoryCard;
    }

    public void addPicture(GenericPicture pic) {
        pictures.add(pic);
    }

    public List<GenericPicture> getAllPictures() {
        return pictures;
    }

    @Override
      public String toString() {
        return "AbstractCamera{" +
                "model='" + model + '\'' +
                ", year=" + year +
                ", displaySize=" + displaySize +
                ", hasMemoryCard=" + hasMemoryCard +
                ", pictures=" + pictures +
                '}';
    }
}
