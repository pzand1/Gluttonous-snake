import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    private Timer timer;//创建定时器
    private JPanel jPanel;//创建游戏棋盘
    private Map map = new Map(610/15,600/15);
    private Snake snake = new Snake(map, 0 ,39);//创建蛇
    private Food food = new Food(snake, map);
    public Main(){
        initFrame();//初始化窗体
        initPanel();//初始化面板
        initTime();//初始化定时器
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                snake.changeHeaded(e.getKeyCode());
            }
        });
    }

    private void initTime(){
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                snake.move(food, map);
                //重新绘制游戏棋盘
                jPanel.repaint();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);//0代表一开始就执行没有延迟
    }

    private void initPanel(){
        jPanel = new JPanel(){
            //绘制棋盘里的内容
            @Override
            public void paint(Graphics g) {// g是一个画笔,有内置画的方法
                //清空面板
                g.clearRect(0,0,600,600);

                //绘制横线
                for(int i = 0 ;i < 40;i++){
                    g.drawLine(0,i*15,600,i*15);
                }

                //绘制竖线
                for(int i = 0 ;i < 40;i++){
                    g.drawLine(i*15,0,i*15,600);
                }

                //绘制蛇
                LinkedList<Snake.bodyCoor> body = snake.getBody();
                for (Snake.bodyCoor bodyCoor : body) {//获取蛇身本身的横纵坐标,然后绘制
                    g.fillRect(bodyCoor.getX()*15, bodyCoor.getY()*15,15,15);
                }

                //绘制食物
                g.setColor(Color.BLUE);
                g.fillRect(food.getX()*15,food.getY()*15,15,15);
                g.setColor(Color.BLACK);
                }
            };

        add(jPanel);//add方法是在面板上添加组件
    }


    private void initFrame() {//throws HeadlessException
        setTitle("贪吃蛇大作战");
        setSize(610,640);//窗体大小
        setLocation(600,300);//窗体出现位置
        setResizable(false);//不可更改窗体大小
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置退出按钮
    }



    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
