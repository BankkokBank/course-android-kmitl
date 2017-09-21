package kmitl.lab05.bank58070041.simplemydot.model;


import android.graphics.Color;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Colors {
    private List<Integer> colorList = new ArrayList<>();

    public Colors() {
        colorList.add(Color.RED);
        colorList.add(Color.GREEN);
        colorList.add(Color.BLUE);
        colorList.add(Color.CYAN);
        colorList.add(Color.MAGENTA);
        colorList.add(Color.YELLOW);
        colorList.add(Color.GRAY);
    }
    public int getColor() {
        return colorList.get(
                new Random().nextInt(colorList.size()));
    }

    public int randomColor(){

        int r = new Random().nextInt(255);
        int g = new Random().nextInt(255);
        int b = new Random().nextInt(255);
        return Color.rgb(r,g,b);
    }


}