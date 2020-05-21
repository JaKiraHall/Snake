import java.util.ArrayList;
public class Apple {
    protected int width;
    protected int height;
    protected Position position;
    private String horizontalDir;
    private String verticalDir;
    /**
     * This creates an Apple
     */
    public Apple(int width, int height, ArrayList<Position> snakePositions) {
        int x = 0;
        int y = 0;
        this.width = width;
        this.height = height;
        position = new Position(x,y);
        for (;;) {
            position.x = (int) (Math.random() * (width - 1));
            position.y = (int) (Math.random() * (height - 1));
            if (position.y == 0 || position.x == 0 || position.y == height - 1 || position.x == width - 1) {
                continue;
            }
            
            boolean findMySnake = false;
            for (int i = 0; i < snakePositions.size(); i++) {
                if (position.x == snakePositions.get(i).x && position.y == snakePositions.get(i).y) {
                    findMySnake = true;
                }
            }
            
            if (findMySnake == true) {
                continue;
            } else {
                break;
            }
        }
        
        
    }
    /**
     * Draw the apple
     */
    public void draw(Gui gui) {
        gui.drawCharacter(position.x, position.y, '@', "RED", "GREEN");
    }
}
