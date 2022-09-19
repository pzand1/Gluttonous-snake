import java.util.LinkedList;
import java.util.Objects;

public class Snake {
    private String headed = "d";
    private String current_headed = "d";
    class bodyCoor{
        private int x;
        private int y;
        public bodyCoor(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int getX() {
            return x;
        }
        public int getY() {
            return y;
        }
    }

    private LinkedList<bodyCoor> body = new LinkedList<>();
    public LinkedList<bodyCoor> getBody() {
        return body;
    }

    Snake(Map m, int x, int y){
        body.add(new bodyCoor(x, y));
        body.add(new bodyCoor(x, y));
        body.add(new bodyCoor(x, y));
    }
    //测试方法
    Snake(){
        body.add(new bodyCoor(5, 5));
        body.add(new bodyCoor(5, 6));
        body.add(new bodyCoor(5, 7));
        body.add(new bodyCoor(5, 8));
        body.add(new bodyCoor(5, 9));
        body.add(new bodyCoor(5, 10));
        body.add(new bodyCoor(5, 11));
        body.add(new bodyCoor(5, 12));
    }
    public void changeHeaded(int character){
        switch (character) {
            case 87, 38 -> {
                if(!Objects.equals(this.current_headed, "s"))
                    this.headed = "w";
            }
            case 83, 40 -> {
                if(!Objects.equals(this.current_headed, "w"))
                    this.headed = "s";
            }
            case 65, 37 -> {
                if(!Objects.equals(this.current_headed, "d"))
                    this.headed = "a";
            }
            case 68, 39 -> {
                if(!Objects.equals(this.current_headed, "a"))
                    this.headed = "d";
            }
            default -> {
            }
        }
    }
    //判断是否死亡
    public boolean ifDied(){
        bodyCoor head = body.peekLast();
        for(bodyCoor b : body){
            if(b.x == head.x && b.y == head.y && !b.equals(head))
                return true;
        }
        return false;
    }
    //移动
    public void move(Food f, Map m){
        bodyCoor head = body.getLast();
        this.current_headed = this.headed;
        //向前移动
        switch (this.headed) {
            case "s" -> body.add(new bodyCoor(head.x, head.y + 1));
            case "w" -> body.add(new bodyCoor(head.x, head.y - 1));
            case "a" -> body.add(new bodyCoor(head.x - 1, head.y));
            case "d" -> body.add(new bodyCoor(head.x + 1, head.y));
            default -> {
            }
        }
        head = body.getLast();
        //判断是否越地图边界
        if(head.x == m.getSize_x() || head.x == -1){
            head.x = m.getSize_x() - Math.abs(head.x);
        }
        if(head.y == m.getSize_y() || head.y == -1){
            head.y = m.getSize_y() - Math.abs(head.y);
        }
        //判断是否吃到食物
        if(!(head.x == f.getX() && head.y == f.getY())){
            body.removeFirst();
        }else{
            f.createFood(this, m);
        }

    }
}