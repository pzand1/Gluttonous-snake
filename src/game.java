import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.*;

public class game {
    //[0]地图宽度 [1]地图高度 [2]dt
    public static void main(String[] args) throws InterruptedException {
        map Map = new map(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        snake Snake = new snake(Map, Map.getSize_x() / 2, Map.getSize_y() / 2);
        food Food = new food(Snake, Map);
        int dt = Integer.parseInt(args[2]);
        new gui(Snake);
        while(!Snake.ifDied()) {
            Snake.move(Food, Map);
            Food.draw();
            Map.draw();
            Snake.draw();
            Thread.sleep(dt);

        }
    }
}
class gui extends Frame{
    public gui(snake s) {
        setTitle("gluttonous snake");
        setBounds(300, 400, 400, 400);
        setVisible(true);
        // 添加键盘监听
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                s.changeHeaded(e.getKeyCode());
            }
        });
    }
}
