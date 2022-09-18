import java.util.LinkedList;

public class Snake {
    private String headed = "w";
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

    public LinkedList<bodyCoor> getBody() {
        return body;
    }

    private LinkedList<bodyCoor> body = new LinkedList<>();
    Snake(Map m, int x, int y){
        body.add(new bodyCoor(x, y));
    }

    public void changeHeaded(int character){
        switch (character) {
            case 87, 38 -> this.headed = "w";
            case 83, 40 -> this.headed = "s";
            case 65, 37 -> this.headed = "a";
            case 68, 39 -> this.headed = "d";
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
        //向前移动
        switch (this.headed) {
            case "s" -> body.add(new bodyCoor(head.x, head.y + 1));
            case "w" -> body.add(new bodyCoor(head.x, head.y - 1));
            case "a" -> body.add(new bodyCoor(head.x - 1, head.y));
            case "d" -> body.add(new bodyCoor(head.x + 1, head.y));
        }
        //判断是否越地图边界
        if(head.x == m.getSize_x()){
            head.x = 0;
        }
        if(head.y == m.getSize_y()){
            head.y = 0;
        }
        //判断是否吃到食物
        if(!(head.x == f.getX() && head.y == f.getY())){
            body.removeFirst();
        }

    }
}