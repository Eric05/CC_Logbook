package com.company.November.camera;

import java.util.ArrayList;
import java.util.List;

public interface ICamera<T> {

    void makePicture();
    List getPictures();
    T searchPicture(String png);
}
