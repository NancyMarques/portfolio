package org.academiadecodigo.nanderthals;
import java.io.*;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class WritingFile implements Iterable<String> {
    private String fileName = "RegisterPainting.txt";
    private Rectangle[][] grid;
    List<String> lines = new ArrayList<>();


    public void savePaintedGridToFile(Rectangle[][] grid) throws IOException {

        StringBuilder gridString = new StringBuilder();

        for (Rectangle[] row : grid) {
            for (Rectangle cell : row) {
                if (cell.isFilled()) {
                    gridString.append("1");
                } else {
                    gridString.append("0");
                }
            }
            gridString.append("\n");
        }

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.fileName))) {
            bufferedWriter.write(gridString.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


   public Rectangle[][] loadPaintedGridFromFile(Rectangle[][] grid) throws IOException {


       BufferedReader bufferedReader = new BufferedReader(new FileReader(this.fileName ));

       String line;
       while ((line = bufferedReader.readLine()) != null) {
           lines.add(line);
       }


       int numRows = lines.size();
       int numCols = lines.get(0).length();
       //Rectangle[][] grid = new Rectangle[numRows][numCols];

       for (int i = 0; i < numRows; i++) {
           String rowString = lines.get(i);
           for (int j = 0; j < numCols; j++) {
               char cellChar = rowString.charAt(j);
               boolean isFilled = (cellChar == '1');
               //grid[i][j] = new Rectangle();

               if(isFilled){
                   grid[i][j].setColor(Color.RED);
                   grid[i][j].fill();
               }
               else {
                   grid[i][j].setColor(Color.BLACK);
                   grid[i][j].draw();
               }

           }
       }

       return grid;
   }

    @Override
    public Iterator<String> iterator() {
        return lines.iterator();
    }
}
