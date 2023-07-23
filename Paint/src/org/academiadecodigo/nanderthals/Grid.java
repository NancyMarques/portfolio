package org.academiadecodigo.nanderthals;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    int rows = 20;
    int cols = 20;
    int cellSize = 20;
    int gridWidth = cols * cellSize;
    int gridHeight = rows * cellSize;
    private Rectangle[][] grid = new Rectangle[rows][cols];
    private int padding = 10;
    private int x;
    private int y;
    private Rectangle newRectangles;
    private Rectangle smallRectangle;


    public Grid(){
        Rectangle gridExt = new Rectangle(padding, padding, gridWidth, gridHeight);
        gridExt.draw();
        createGrid();
        smallRectangle = new Rectangle(10, 10, 20, 20);
        smallRectangle.draw();
        smallRectangle.fill();
    }

    public void createGrid() {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int x = j * cellSize;
                int y = i * cellSize;
                newRectangles = new Rectangle(padding+x, padding + y, cellSize, cellSize);
                newRectangles.draw();
                grid[i][j] = newRectangles;
            }
        }
    }

    public Rectangle[][] getGrid(){
        return grid;
    }

    public Rectangle getSmallRectangle() {
        return smallRectangle;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPadding() {
        return padding;
    }


    }




