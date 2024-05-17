package com.example;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class GamePanel extends JPanel implements Runnable {
    // Screen Settings
    final int originalTileSize = 16; // 16x16 tile (16 pixels x 16 pixels)
    final int scale = 3;

    final int tileSize = originalTileSize * scale; // 48x48 tile size
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol; // 48*16 = 768 pixels
    final int screenHeight = tileSize * maxScreenRow; // 48*12 = 576 pixels

    // Frame per second
    int FPS = 60;

    KeyHandler keyHandler = new KeyHandler();
    Thread gameThread;

    // Set player's default position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4; // 4 pixels

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight)); // set the size of this class (JPanel)
        this.setBackground(Color.black);
        this.setDoubleBuffered(true); // enabling this can improve game's rendering performance
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    // GAME LOOP (DELTA)
    public void run() {
    }
    // GAME LOOP (SLEEP)
    // public void run() { // when we start the gameThread, this method is automatically called

    //     double drawInterval = 1000000000 / FPS; // 1,000,000,000 = 1 second
    //     // draw interval is 0.016666 seconds (1/60 = 0.016666)
    //     double nextDrawTime = System.nanoTime() + drawInterval;
    //     long timer = 0;
    //     int drawCount = 0;
    //     while (gameThread != null) {

    //         // long currentTime = System.nanoTime();
    //         // System.out.println("Current time: " + currentTime);
    //         // 1 UPDATE: update information such as character positions
    //         update();
    //         // 2 DRAW: draw the screen with the updated information
    //         repaint();

    //         try {
    //             double remainingTime = nextDrawTime - System.nanoTime(); // the time remaining until the next draw time
    //             remainingTime = remainingTime / 1000000; // Thread.sleep just accepts milliseconds

    //             if (remainingTime < 0) { // Just in case
    //                 remainingTime = 0;
    //             }

    //             Thread.sleep((long) remainingTime); // Pause the hame loop. Wont do anything until this sleep time is
    //                                                 // over
    //             nextDrawTime += drawInterval;

    //         } catch (InterruptedException e) {
    //             // TODO Auto-generated catch block
    //             e.printStackTrace();
    //         }
    //     }
    //     throw new UnsupportedOperationException("Unimplemented method 'run'");
    // }

    public void update() { // Change player position
        // In Java, the uppder left corner is X:0 Y:0
        // X values increases to the right
        // Y values increases to the left
        if (keyHandler.upPressed == true) {
            playerY -= playerSpeed; // Increases 4 pixels
        } else if (keyHandler.downPressed == true) {
            playerY += playerSpeed;
        } else if (keyHandler.leftPressed == true) {
            playerX -= playerSpeed;
        } else if (keyHandler.rightPressed == true) {
            playerX += playerSpeed;
        }
    }

    public void paintComponent(Graphics g) { // Graphics is a class that has many functions to draw objects on the
                                             // screen
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setColor(Color.WHITE);
        g2d.fillRect(playerX, playerY, tileSize, tileSize);
        g2d.dispose();
    }
}
