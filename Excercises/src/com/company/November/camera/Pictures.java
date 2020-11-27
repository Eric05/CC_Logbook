package com.company.November.camera;

import java.util.ArrayList;
import java.util.List;

public class Pictures<T> {

    private List<T> pictures = new ArrayList<>();

    public void addPicture(T pic){
        pictures.add(pic);
    }

    public List<T> getAllPictures(){

        return pictures;
    }

    public T searchSinglePicture(String str){
        for ( var picture : pictures) {
            if( String.valueOf(picture).contains(str)){
                return picture;
            }
        }
        return null;
    }

}
