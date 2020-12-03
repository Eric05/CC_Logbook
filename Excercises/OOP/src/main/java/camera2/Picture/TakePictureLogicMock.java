package camera2.Picture;

import java.util.Random;

public class TakePictureLogicMock implements TakePictureLogic{

    @Override
    public GenericPicture takePicture() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder("natur_");

        for (int i = 0; i < 10; i++) {
            var ch = r.nextInt(20) + 65;
            sb.append((char) ch);
        }
        GenericPicture p = new GenericPicture();
        p.setHeight(300);
        p.setWidth(0);
        p.setFilePath(sb.append(".png").toString());
        return p;
    }
}