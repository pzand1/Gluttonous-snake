import java.util.Random;

public class food {
    private int x;
    private int y;
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public void creatFood(snake s, map m){
        Random r = new Random();
        this.x = r.nextInt(m.getSize_x());
        this.y = r.nextInt(m.getSize_y());
        for(int i = 0;i < s.getLength();i++){
            if(x == s.getX_body()[i] && y == s.getY_body()[i]){
                this.x = r.nextInt(m.getSize_x());
                this.y = r.nextInt(m.getSize_y());
                i = 0;
            }
        }
    }
    public void draw(){

    }
}
