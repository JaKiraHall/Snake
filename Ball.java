public class Ball {
    protected int width;
    protected int height; 
    protected Position position;
    private String horizontalDir;
    private String verticalDir;
    
    public Ball(int x, int y, int width, int height) {
       this.width = width;
       this.height = height;
       position = new Position(x,y);
       horizontalDir = "RIGHT";
       verticalDir = "DOWN";
    }
    
    public void draw(Gui gui) {
        gui.drawCharacter(position.x, position.y, '0', "YELLOW", "BLUE");
        
    }
    
    public void move() {
        if (position.y >= height) {
            verticalDir = "UP";
        } else if (position.y <= 0) {
            verticalDir = "DOWN";
        }
        if (verticalDir.equals("DOWN")) {
            position.y += 1;
        } else if (verticalDir.equals("UP")) {
            position.y -= 1;
        }
        if (position.x >= width) {
            horizontalDir = "LEFT";
        } else if (position.x <= 0) {
            horizontalDir = "RIGHT";
        }
        if (horizontalDir.equals("RIGHT")) {
            position.x += 1;
        } else if (horizontalDir.equals("LEFT")) {
            position.x -= 1;
        }

    }
}
