package camera2;

import camera2.Picture.LeikaTakePictureLogic;
import com.company.November.camera.CameraView;


public class CameraController {
    public static void main(String[] args) {
        AbstractCamera camera = new LeikaCamera(2020, 200, true);
        camera.setTakePictureLogic(new LeikaTakePictureLogic());
        camera.setHasMemoryCard(false);

        System.out.println(camera.toString());
        for(var i = 0; i < 7; i++) {
            camera.takePicture();
        }

        var pictures = camera.getPictures();
        CameraView.printAllPictures(pictures);


    }
}
