package camera2.Picture;

public class LeikaTakePictureLogic implements TakePictureLogic{

    @Override
    public GenericPicture takePicture() {
        TakePictureLogicMock mock = new TakePictureLogicMock();

        return mock.takePicture();
    }
}
