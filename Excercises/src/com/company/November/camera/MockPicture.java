package com.company.November.camera;

import java.util.Random;

public class MockPicture implements IPicture {
    @Override
    public Object createPicture() {
        Random r = new Random();
        StringBuilder sb = new StringBuilder("natur_");

        for (int i = 0; i < 10; i++) {
            var ch = r.nextInt(20) + 65;
            sb.append((char) ch);
        }
        return sb.append(".png").toString();
    }
}
