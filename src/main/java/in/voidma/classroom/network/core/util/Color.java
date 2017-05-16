package in.voidma.classroom.network.core.util;

import in.voidma.classroom.network.client.Client;

import java.util.Random;

/**
 * Created by Miles on 5/16/2017.
 */
public class Color {

    int red, green, blue;

    public Color(int red, int green, int blue) {

        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public static Color fromProsessingColor(int color) {

        int red = (int) Client.getInstance().red(color);
        int green = (int) Client.getInstance().green(color);
        int blue = (int) Client.getInstance().blue(color);
        return new Color(red, green, blue);
    }

    public static Color randomColor() {

        Random random = new Random();

        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);

        red = (red + 255) / 2;
        green = (green + 255) / 2;
        blue = (blue + 255) / 2;

        return new Color(red, green, blue);
    }

    public int prosessingColor() {

        return Client.getInstance().color(red, green, blue);
    }

    public int getRed() {

        return red;
    }

    public void setRed(int red) {

        this.red = red;
    }

    public int getGreen() {

        return green;
    }

    public void setGreen(int green) {

        this.green = green;
    }

    public int getBlue() {

        return blue;
    }

    public void setBlue(int blue) {

        this.blue = blue;
    }
}
