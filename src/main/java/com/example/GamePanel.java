package com.example;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;


public class GamePanel extends JPanel implements Runnable {
    //Screen Settings
    final int originalTileSize = 16; //16x16 tile (16 pixels x 16 pixels) 
    final int scale = 3;

    final int tileSize =  originalTileSize * scale; // 48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 48*16 = 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 48*12 = 576 pixels

    Thread gameThread;
    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // set the size of this class (JPanel)
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); //enabling this can improve game's rendering performance
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() { //when we start the gameThread, this method is automatically called
        // TODO Auto-generated method stub

        while(gameThread != null){
            System.out.println("THE GAME LOOP IS RUNNING!");

            //1: UPDATE

            //2: DRAW
        }
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
