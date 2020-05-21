import java.util.ArrayList;

public class Snake {
    Gui gui = new Gui();
    int width = gui.getScreenWidth() / 2;
    int height = gui.getScreenHeight() / 2;

    /**
     * The Snake is represented as a list of positions.
     * The head is at position 0.
     */
    public ArrayList<Position> positions = new ArrayList<Position>();
    
    private String direction = "RIGHT";

  
    public void setDirection(String direction) {
        if (direction == "RIGHT") {
            this.direction = "RIGHT";
        } else if (direction == "LEFT") {
            this.direction = "LEFT";
        } else if (direction == "UP") {
            this.direction = "UP";
        } else if (direction == "DOWN") {
            this.direction = "DOWN";
        }
        
        if ((this.direction == "RIGHT") && (direction == "LEFT")) {
            return;
        } else if ((this.direction == "UP") && (direction == "DOWN")) {
            return;
        } else if ((this.direction == "LEFT") && (direction == "RIGHT")) {
            return;
        } else if ((this.direction == "DOWN") && (direction == "UP")) {
            return;
        }
    }
    

    /**
     * The direction of motion of the snake can be either
     * UP, DOWN, LEFT or RIGHT. Default is to the right.
     */

    /**
     * Create a new Snake object. You will need to add to the
     * constructor here to pass it more information
     */
    public Snake(int x, int y) {
        Position top = new Position(x,y);
        positions.add(top);
        
        Position body = new Position(x - 1, y);
        positions.add(body);
        
        Position bodybody = new Position(x - 2, y);
        positions.add(bodybody);
    }

    /**
     * This method should draw the snake
     */
    public void draw(Gui gui) {
        Position slither = positions.get(0);
        for (int i = 0; i < positions.size(); i++) {
            if (direction.equals("RIGHT")) {
                gui.drawCharacter(slither.x, slither.y, '>', "BLUE", "WHITE");
            } else if (direction.equals("LEFT")) {
                gui.drawCharacter(slither.x, slither.y, '<', "BLUE", "WHITE");
            } else if (direction.equals("UP")) {
                gui.drawCharacter(slither.x, slither.y, '^', "BLUE", "WHITE");
            } else if (direction.equals("DOWN")) {
                gui.drawCharacter(slither.x, slither.y, 'v', "BLUE", "WHITE");    
            }
            
            gui.drawCharacter(positions.get(i).x, positions.get(i).y, '+', "BLUE", "WHITE");
        }
        
    }
    
    public void move() {
        if (direction.equals("RIGHT")) {
            for (int i = positions.size() - 1; i >= 1; i--) {
                Position position = new Position(positions.get(i - 1).x, positions.get(i - 1).y);
                positions.set(i, position);
            }
            
            Position thehead = positions.get(0);
            thehead.x++;
            positions.set(0, thehead);
            
        }
        if (direction.equals("LEFT")) { 
            for (int i = positions.size() - 1; i >= 1; i--) {
                Position position = new Position(positions.get(i - 1).x, positions.get(i - 1).y);
                positions.set(i, position);
            }
            
            Position thehead = positions.get(0);
            thehead.x--;
            positions.set(0, thehead);
            
        }
        if (direction.equals("UP")) { 
            for (int i = positions.size() - 1; i >= 1; i--) {
                Position position = new Position(positions.get(i - 1).x, positions.get(i - 1).y);
                positions.set(i, position);
            }
            
            Position thehead = positions.get(0);
            thehead.y--;
            positions.set(0, thehead);
        }
        if (direction.equals("DOWN")) { 
            for (int i = positions.size() - 1; i >= 1; i--) {
                Position position = new Position(positions.get(i - 1).x, positions.get(i - 1).y);
                positions.set(i, position);
            }
            
            Position thehead = positions.get(0);
            thehead.y++;
            positions.set(0, thehead);
        }// Add your code here 
    }
    
    public void grow() {
        Position more = positions.get(positions.size() - 1);
        positions.add(new Position(more.x, more.y));
    }
   
}
