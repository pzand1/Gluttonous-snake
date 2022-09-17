import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class snake {
    private String head;
    private int[] x_body;
    private int[] y_body;
    private int length;
    snake(map m, int x, int y){
        this.x_body = new int[m.getSize_x()];
        this.y_body = new int[m.getSize_y()];
        this.x_body[0] = x;
        this.y_body[0] = y;
        this.length++;
    }
    public int getLength(){
        return length;
    }
    public int[] getX_body(){
        return x_body;
    }
    public int[] getY_body(){
        return y_body;
    }

    //判断是否死亡
    public boolean ifDied(){
        for(int i = 1;i < this.length; i++){
            if(x_body[0] == x_body[i] && y_body[0] == y_body[i])
                return true;
        }
        return false;
    }
    //移动
    public void move(food f, map m){
        int tail_x = x_body[length - 1];
        int tail_y = y_body[length - 1];

        for(int i = 0; i < this.length - 1; i++){
            x_body[i + 1] = x_body[i];
            y_body[i + 1] = y_body[i];
        }
        switch (this.head) {
            case "w" -> {
                x_body[0] = x_body[1];
                y_body[0] = y_body[1] + 1;
            }
            case "s" -> {
                x_body[0] = x_body[1];
                y_body[0] = y_body[1] - 1;
            }
            case "a" -> {
                x_body[0] = x_body[1] - 1;
                y_body[0] = y_body[1];
            }
            case "d" -> {
                x_body[0] = x_body[1] + 1;
                y_body[0] = y_body[1];
            }
        }
        if(x_body[0] == m.getSize_x()){
            x_body[0] = 0;
        }
        if (y_body[0] == m.getSize_y())

        if(x_body[0] == f.getX() && y_body[0] == f.getY()){
            length++;
            x_body[length] = tail_x;
            y_body[length] = tail_y;
        }

    }

    public void draw(){

    }
}
