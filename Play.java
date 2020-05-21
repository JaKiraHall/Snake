public class Play {
    
    /**
     * This is the main program for the Snake game. Run it with
     *   java -cp .:lanterna-3.0.1-jar Play
     */
    public static void main(String[] args) {
        // Create the new Gui and start it. This clears the screen
        // and the Gui now controls the screen
        Gui gui = new Gui();
        gui.start();

        // Get the dimensions of the screen
        int screenWidth = gui.getScreenWidth();
        int screenHeight = gui.getScreenHeight();
        int score = 0;

        // Create the room, the snake and the apple.
        // You will need to change the constructors later to pass more
        // information to the Snake and Apple constructors
        Room room = new Room(screenWidth, screenHeight);
        Snake snake = new Snake(screenWidth / 2, screenHeight / 2);
        Apple apple = new Apple(screenWidth, screenHeight, snake.positions);

        // The main loop of the game. If you change the value of
        // the continuePlaying boolean, the main loop will end
        boolean continuePlaying = true;
        while (continuePlaying) {
            // Get a key press from the user
            char c = gui.getKeypress();
            if (c == 'q') {
                continuePlaying = false;
            } else if (c == Gui.UP_ARROW_KEY) {
                snake.setDirection("UP");
            } else if (c == Gui.DOWN_ARROW_KEY) {
                snake.setDirection("DOWN");
            } else if (c == Gui.RIGHT_ARROW_KEY) {
                snake.setDirection("RIGHT");
            } else if (c == Gui.LEFT_ARROW_KEY) {
                snake.setDirection("LEFT");
            }
            //     do something depending on what was pressed,
            //     e.g. you may want to change the direction of the snake
            // } else if (c == Gui.DOWN_ARROW_KEY) {
            //     do something else
            // }

            // Add your code to move the snake
            // around the screen here.
            snake.move(); 
            

            // The redraw part of the game. First clear the screen
            gui.clear();

            // Redraw everything on the screen into an offscreen buffer,
            // including the room, the Snake and the apple
            room.draw(gui);
            apple.draw(gui);
            snake.draw(gui);

            // When done redrawing all the elements of the screen, refresh will
            // make the new graphic appear on the screen all at once
            gui.refresh();

            // Detect whether the snake ate the apple, or it hit the wall
            // or it hit its own tail here
            Position arrow = snake.positions.get(0);
            if (apple.position.x == arrow.x && apple.position.y == arrow.y) {
                apple = new Apple(screenWidth, screenHeight, snake.positions);
                score += 10;
                snake.grow();
            }
            
            if (arrow.x > screenWidth || arrow.x < 1 || arrow.y > screenHeight || arrow.y <1) {
                break;
            }


            // This call makes the program go quiescent for some time, so
            // that it doesn't run so fast. If the value in the call to
            // Gui.sleep is decreased, the game will speed up.
            Gui.sleep(100);
        }

        /*
         * Since we exited out of the main loop, the user must have died
         * or the user pressed 'q' to quit.
         * Uncomment this part when you're ready to work on Explosions
         */
        // Explosion explosion = new Explosion();
        // explosion.draw(gui);
        // gui.refresh();
        /*
         * Now wait for a keypress to really quit so that the user
         * has time to see the explosion
         */
        // while (gui.getKeypress() == (char) 0x0) {
        //     Gui.sleep(100);
        // }

        // Stop the GUI, clearing the screen and restoring the screen
        // back to its original state
        gui.stop();
        System.out.println("OOPS! Game Over!");
        System.out.println("Your Score:" + score);

        // The game has ended since we broke out of the main loop
        // Display the user's score here
    }
}
