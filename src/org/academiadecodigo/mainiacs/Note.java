package org.academiadecodigo.mainiacs;

import org.academiadecodigo.mainiacs.Screen.Screen;
import org.academiadecodigo.mainiacs.Screen.Target;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Note {

    private Column column;
    private int y = 0; //fixo negativo sempre descer
    private boolean inTarget;
    private boolean reachedEnd;
    private Picture pic;
    public static final int WIDTH_OF_NOTE = 50;
    public static final int HEIGHT_OF_NOTE = 90;


    public Note() {
        column = Column.values()[(int) (Math.random() * Column.values().length)];
        pic = new Picture(column.getX(),y,column.getNotePic());
        pic.translate(-pic.getWidth()/2.0,0);
        pic.grow(WIDTH_OF_NOTE-pic.getWidth(),HEIGHT_OF_NOTE-pic.getHeight());
        show();
    }

    public Column getColumn() {
        return column;
    }

    public int getY() {
        return y;
    }


    public boolean isInTarget() {
        return inTarget;
    }

    public void show() {
        pic.draw();

    }

    public void hide() {
        pic.delete();

    }

    public void move() {
        pic.translate(0, 1);
        y++;
        if (y + HEIGHT_OF_NOTE == Screen.SCREEN_HEIGHT) {
            reachedEnd = true;
            hide();
            return;
        }
        if (y > Target.END_Y) {
            inTarget = false;
            return;
        }
        if (y + HEIGHT_OF_NOTE + 1 > Target.START_Y) {
            inTarget = true;
        }
    }

    public boolean reachedEnd() {
        return reachedEnd;
    }
}


