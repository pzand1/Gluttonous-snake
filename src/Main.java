import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Main extends JFrame {
    private Timer timer;//������ʱ��
    private JPanel jPanel;//������Ϸ����
    private Map map = new Map(610/15,600/15);
    private Snake snake = new Snake(map, 0 ,39);//������
    private Food food = new Food(snake, map);
    public Main(){
        initFrame();//��ʼ������
        initPanel();//��ʼ�����
        initTime();//��ʼ����ʱ��
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
                //���»�����Ϸ����
                jPanel.repaint();
            }
        };
        timer.scheduleAtFixedRate(timerTask,0,100);//0����һ��ʼ��ִ��û���ӳ�
    }

    private void initPanel(){
        jPanel = new JPanel(){
            //���������������
            @Override
            public void paint(Graphics g) {// g��һ������,�����û��ķ���
                //������
                g.clearRect(0,0,600,600);

                //���ƺ���
                for(int i = 0 ;i < 40;i++){
                    g.drawLine(0,i*15,600,i*15);
                }

                //��������
                for(int i = 0 ;i < 40;i++){
                    g.drawLine(i*15,0,i*15,600);
                }

                //������
                LinkedList<Snake.bodyCoor> body = snake.getBody();
                for (Snake.bodyCoor bodyCoor : body) {//��ȡ������ĺ�������,Ȼ�����
                    g.fillRect(bodyCoor.getX()*15, bodyCoor.getY()*15,15,15);
                }

                //����ʳ��
                g.setColor(Color.BLUE);
                g.fillRect(food.getX()*15,food.getY()*15,15,15);
                g.setColor(Color.BLACK);
                }
            };

        add(jPanel);//add�������������������
    }


    private void initFrame() {//throws HeadlessException
        setTitle("̰���ߴ���ս");
        setSize(610,640);//�����С
        setLocation(600,300);//�������λ��
        setResizable(false);//���ɸ��Ĵ����С
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�����˳���ť
    }



    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}
