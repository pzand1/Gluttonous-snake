import java.util.Random;

public class Food {
    private int x;
    private int y;
    Food(Snake s, Map m){
        creatFood(s, m);
    }
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public void creatFood(Snake s, Map m) {
        Random r = new Random();
        this.x = r.nextInt(m.getSize_x());
        this.y = r.nextInt(m.getSize_y());
        boolean temp = true;
        while (temp) {
            temp = false;
            for (Snake.bodyCoor body : s.getBody()) {
                if (body.getX() == this.x && body.getY() == this.y) {
                    this.x = r.nextInt(m.getSize_x());
                    this.y = r.nextInt(m.getSize_y());
                    temp = true;
                    break;
                }
            }

        }
    }
}
