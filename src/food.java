import javax.swing.*;
import java.util.Random;

public class food {
    private static ImageIcon foodImage = new ImageIcon(snake.class.getResource("../images/food.png"));
    public static ImageIcon getFoodImage() {
        return foodImage;
    }
    private int x;
    private int y;
    food(snake s, map m){
        creatFood(s, m);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void creatFood(snake s, map m) {
        Random r = new Random();
        this.x = r.nextInt(m.getSize_x());
        this.y = r.nextInt(m.getSize_y());
        boolean temp = true;
        while (temp) {
            temp = false;
            for (snake.bodyCoor body : s.body) {
                if (body.x == this.x && body.y == this.y) {
                    this.x = r.nextInt(m.getSize_x());
                    this.y = r.nextInt(m.getSize_y());
                    temp = true;
                    break;
                }
            }

        }
    }

    public void draw() {

    }
}
