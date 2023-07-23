package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.IOException;
import java.util.LinkedList;


public class GridPainter implements KeyboardHandler {
    private Rectangle[][] grid;
    private Rectangle smallRectangle;
    private Grid grid1;
    private boolean spaceKeyPressed = false;
    private WritingFile writingFile;

    public GridPainter() {
        grid1 = new Grid();
        this.grid = grid1.getGrid();
        this.smallRectangle = grid1.getSmallRectangle();

        Keyboard keyboard = new Keyboard(this);
        registerKeys(keyboard);
    }

    public void painter() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (smallRectangle.getX() == grid[i][j].getX() && smallRectangle.getY() == grid[i][j].getY() && grid[i][j].isFilled()) {
                    //grid[i][j].delete();
                    grid[i][j].setColor(Color.BLACK);
                    //grid[i][j].fill();
                    grid[i][j].draw();

                    break;
                } else if (smallRectangle.getX() == grid[i][j].getX() && smallRectangle.getY() == grid[i][j].getY()) {
                    //System.out.println((" x rect " + smallRectangle.getX()));
                    grid[i][j].setColor(Color.RED);
                    grid[i][j].fill();
                    break;
                }
            }
        }

    }
    public void unPaint() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (smallRectangle.getX() == grid[i][j].getX() && smallRectangle.getY() == grid[i][j].getY()) {
                    grid[i][j].setColor(Color.BLACK);
                    grid[i][j].draw();
                }
            }
        }
    }



    public void moveRight() {
        int x = smallRectangle.getX() + smallRectangle.getWidth();
        if (x <= grid1.getGridWidth() - grid1.getPadding()) {
            smallRectangle.translate(20, 0);
        }
    }

    public void moveLeft() {
        int x = smallRectangle.getX();
        if (x > grid1.getPadding())  {
        smallRectangle.translate(-20, 0);
        }
    }

    public void moveUp() {
        int y = smallRectangle.getY();
        if (y > grid1.getPadding()){
        smallRectangle.translate(0, -20);
        }
    }

    public void moveDown() {
        int y = smallRectangle.getY() + smallRectangle.getHeight();
        if (y <= grid1.getGridHeight() - grid1.getPadding()){
            smallRectangle.translate(0, 20);
        }
    }

    public void clearGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                grid[i][j].setColor(Color.BLACK);
                grid[i][j].draw();
            }
        }

    }

    public void repaintGrid() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j].isFilled()){
                    grid[i][j].setColor(Color.RED);
                    grid[i][j].fill();
                }
                else {
                    grid[i][j].setColor(Color.BLACK);
                    grid[i][j].draw();
                }
            }
        }


    }




    private void registerKeys(Keyboard keyboard) {
        KeyboardEvent event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_UP);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_DOWN);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_RIGHT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_LEFT);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_S);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_L);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_C);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(event);

        event = new KeyboardEvent();
        event.setKey(KeyboardEvent.KEY_SPACE);
        event.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        keyboard.addEventListener(event);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        int keyPressed = keyboardEvent.getKey();

        if (keyPressed == KeyboardEvent.KEY_SPACE) {
            spaceKeyPressed = true;
           // painter();
        }

        if (keyPressed == KeyboardEvent.KEY_RIGHT) {
            moveRight();
            if (spaceKeyPressed) {
                painter();
            }else{
                unPaint();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_LEFT) {
            moveLeft();
            if (spaceKeyPressed) {
                painter();
            }else{
                unPaint();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_UP) {
            moveUp();
            if ((spaceKeyPressed)) {
                painter();
            }else{
                unPaint();
            }

        }
        if (keyPressed == KeyboardEvent.KEY_DOWN) {
            moveDown();
            if ((spaceKeyPressed)) {
                painter();
            }else{
                unPaint();
            }
        }

        if (keyPressed == KeyboardEvent.KEY_C) {
            clearGrid();
        }

        if(keyPressed == keyboardEvent.KEY_S){
            try {
                writingFile = new WritingFile();
                writingFile.savePaintedGridToFile(grid);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        if(keyPressed == keyboardEvent.KEY_L){
            try {
                writingFile = new WritingFile();
                writingFile.loadPaintedGridFromFile(grid);
                //this.grid = writingFile.loadPaintedGridFromFile();
                //repaintGrid();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        int keyReleased = keyboardEvent.getKey();
        if (keyReleased == KeyboardEvent.KEY_SPACE) {
            spaceKeyPressed = false;
        }
    }


}


