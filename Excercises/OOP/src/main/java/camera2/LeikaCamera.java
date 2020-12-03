package camera2;

import camera2.Picture.GenericPicture;
import camera2.Picture.LeikaTakePictureLogic;

public class LeikaCamera extends AbstractCamera {

    public LeikaCamera(int year, int displaySize, boolean hasMemoryCard) {
        super("Leika", year, displaySize, hasMemoryCard);
        this.setTakePictureLogic(new LeikaTakePictureLogic());
    }

    @Override
    public GenericPicture executeTakePictureLogic() {
        return this.takePictureLogic.takePicture();
    }
}
