package camera2;

import camera2.Picture.GenericPicture;
import camera2.Picture.NikonTakePictureLogic;

public class NikonCamera extends AbstractCamera {

    public NikonCamera(int year, int displaySize, boolean hasMemoryCard) {
        super("Nikon", year, displaySize, hasMemoryCard);
        this.setTakePictureLogic(new NikonTakePictureLogic());
    }

    @Override
    public GenericPicture executeTakePictureLogic() {
        return this.takePictureLogic.takePicture();
    }
}
