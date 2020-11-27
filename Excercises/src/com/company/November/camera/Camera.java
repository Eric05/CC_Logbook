package com.company.November.camera;

import java.util.List;

public class Camera extends Pictures implements ICamera {

    private String model;
    private int year;
    private double displaySize;
    private boolean hasMemoryCard;
    private IPicture picture = new MockPicture();

    public Camera(String model, int year, int displaySize, boolean hasMemoryCard) {
        this.model = model;
        this.year = year;
        this.displaySize = displaySize;
        this.hasMemoryCard = hasMemoryCard;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public double getDisplaySize() {
        return displaySize;
    }

    public boolean isHasMemoryCard() {
        return hasMemoryCard;
    }

    public void setHasMemoryCard(boolean hasMemoryCard) {
        this.hasMemoryCard = hasMemoryCard;
    }

    @Override
    public void makePicture() {
        addPicture(picture.createPicture());
    }

    @Override
    public List getPictures() {
        return getAllPictures();
    }

    public Object searchPicture(String png) {
        return searchSinglePicture(png);
    }
}