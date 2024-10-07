package main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import mino.Block;
import mino.Mino;
import mino.Mino_L1;

public class PlayManager {
    // Main Play Area
    final int WIDTH = 360;
    final int HEIGHT = 600;
    public static int left_x;
    public static int right_x;
    public static int top_y;
    public static int bottom_y;

    // Mino
    Mino currentMino;
    final int MINO_START_X;
    final int MINO_START_Y;

    public PlayManager(){
        // Main Play Area frame
        left_x = (GamePanel.WIDTH / 2) - (WIDTH / 2);
        right_x = left_x + WIDTH;
        top_y = 50;
        bottom_y = (GamePanel.HEIGHT / 2) - (HEIGHT / 2);

        MINO_START_X = left_x + (WIDTH/2) - Block.SIZE;
        MINO_START_Y = bottom_y + Block.SIZE;

        // Set starting Mino
        currentMino = new Mino_L1();
        currentMino.setXY(MINO_START_X, MINO_START_Y);
    }

    public void update(){
        currentMino.update();
    }

    public void draw(Graphics2D g2){
        // Draw Play Area Frame
        g2.setColor(Color.white);
        g2.setStroke(new BasicStroke(4f));
        g2.drawRect(left_x - 4, bottom_y - 4, WIDTH + 8, HEIGHT + 8);

        // Draw Next Mino Frame
        int x = right_x + 100;
        int y = GamePanel.HEIGHT - 254;
        g2.drawRect(x, y - 4, 200, 200);
        g2.setFont(new Font("Arial",Font.PLAIN, 30));
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.drawString("NEXT MINO", x + 20, y + 50);

        // Draw current Mino
        if(currentMino != null){
            currentMino.draw(g2);
        }
    }
}
