package com.syb.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 * @author ShiYabin
 * @create 2021-12-05 14:37
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——游戏界面类
 */

//游戏界面类GameFrame
public class GameFrame implements BasicInfo {

    //定义主界面宽度 WindowWidth为570，定义为常量，便于修改
    private static final int WindowWidth = 570;
    //定义主界面宽度 WindowWidth为650，定义为常量，便于修改
    private static final int WindowHeight = 650;
    //定义插入数据库成功标志
    public boolean c=true;

    //创建窗口对象（整体窗口）
    private JFrame frame = new JFrame();
    //创建面板对象（整体面板）
    private JPanel panel = new JPanel();
    //创建标题标签（游戏标题）
    private JLabel labelOne = new JLabel("2048无尽版", JLabel.CENTER);
    //创建规则标签1（游戏规则第一段）
    private JLabel labelRuleOne = new JLabel(" 游戏规则:你需要通过控制键盘上的↑ ↓ ← →进行移动");
    //创建规则标签2（游戏规则第二段）
    private JLabel labelRuleTwo = new JLabel(" 使得所有方块朝同一个方向运动。两个相同数字方块相撞");
    //创建规则标签3（游戏规则第三段）
    private JLabel labelRuleThree = new JLabel(" 合并为两数之和，每次进行移动操作之后会随机生成一个");
    //创建规则标签4（游戏规则第四段）
    private JLabel labelRuleFour = new JLabel(" 数为2或4的方块。利用道具让数字尽可能大吧！");
    //创建成绩显示
    private JLabel labelMarkReminder = new JLabel(" 您的得分：", JLabel.CENTER);
    //创建成绩分数
    private JLabel labelMark = new JLabel("0", JLabel.CENTER);
    //创建道具说明语句1
    private JLabel labelToolOne = new JLabel(" 说明：爆竹可清除首行(Enter键)，炸弹可清除首列(Space键)，", JLabel.LEFT);
    //创建道具说明语句2
    private JLabel labelToolTwo = new JLabel(" 魔方可扰乱所有方块位置(Ctrl键)，按esc键可重开游戏。",JLabel.LEFT);
    //创建游戏板对象
    GamePanel gamePanel = new GamePanel();
    //创建背景对象
    Background bg = new Background();
    //创建爆竹对象
    FireCrackers fireCrackers = new FireCrackers();
    //创建魔方对象
    Cubes cubes = new Cubes();
    //创建炸弹对象
    Bombs bombs = new Bombs();

    //构造器
    public GameFrame(){
        Game();
    }

    //game方法进行初始化
    @Override
    public void Game(){
        //frame部分
        //游戏窗体大小
        frame.setSize(WindowWidth, WindowHeight);
        //设置窗体相对于指定组件的位置，默认在中央
        frame.setLocationRelativeTo(null);
        //用户在此窗体上发起 "close" 时默认执行的操作,使用 System exit 方法退出应用程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设定主界面标题
        frame.setTitle("2048无尽版");
        //设置窗体不可由用户调整大小
        frame.setResizable(false);
        //窗体不设布局管理器
        frame.setLayout(null);

        //panel部分
        //游戏面板大小
        panel.setSize(WindowWidth, WindowHeight);
        //面板不设布局管理器
        panel.setLayout(null);
        //设定面板背景颜色
        panel.setBackground(Color.black);
        //将面板将入窗体
        frame.add(panel);

        //labelOne部分
        //设置标题字体
        labelOne.setFont(reminderFont);
        //设置标题字体前景色
        labelOne.setForeground(colorLabelOne);
        //设置标题字体的位置
        labelOne.setBounds(100, 0, 300, 60);
        //将标题加入面板
        panel.add(labelOne);

        //labelRule部分
        //设置规则字体
        labelRuleOne.setFont(ruleFont);
        //设置规则字体前景色
        labelRuleOne.setForeground(colorLabelRule);
        //设置规则字体的位置
        labelRuleOne.setBounds(0, 60, 590, 20);
        //将规则加入面板
        panel.add(labelRuleOne);

        //设置规则字体
        labelRuleTwo.setFont(ruleFont);
        //设置规则字体前景色
        labelRuleTwo.setForeground(colorLabelRule);
        //设置规则字体的位置
        labelRuleTwo.setBounds(0, 80, 590, 20);
        //将规则加入面板
        panel.add(labelRuleTwo);

        //设置规则字体
        labelRuleThree.setFont(ruleFont);
        //设置规则字体前景色
        labelRuleThree.setForeground(colorLabelRule);
        //设置规则字体的位置
        labelRuleThree.setBounds(0, 100, 590, 20);
        //将规则加入面板
        panel.add(labelRuleThree);

        //设置规则字体
        labelRuleFour.setFont(ruleFont);
        //设置规则字体前景色
        labelRuleFour.setForeground(colorLabelRule);
        //设置规则字体的位置
        labelRuleFour.setBounds(0, 120, 590, 20);
        //将规则加入面板
        panel.add(labelRuleFour);

        //labelMarkReminder部分
        //设置“得分”字体
        labelMarkReminder.setFont(markFont);
        //设置“得分”字体颜色
        labelMarkReminder.setForeground(Color.WHITE);
        //原样显示组件中的每个像素,便于显示背景色
        labelMarkReminder.setOpaque(true);
        //设置“得分”字体背景色
        labelMarkReminder.setBackground(colorReminderMarkBg);
        //设置“得分”字体的位置
        labelMarkReminder.setBounds(425, 0, 120, 30);
        //将“得分”加入面板
        panel.add(labelMarkReminder);

        //labelMark部分
        //设置分数字体
        labelMark.setFont(markFont);
        //设置分数字体颜色
        labelMark.setForeground(Color.WHITE);
        //原样显示组件中的每个像素,便于显示背景色
        labelMark.setOpaque(true);
        //设置分数字体背景色
        labelMark.setBackground(colorReminderMarkBg);
        //设置分数字体的位置
        labelMark.setBounds(425, 30, 120, 30);
        //将分数加入面板
        panel.add(labelMark);

        //labelToolOne部分
        //设置分数字体
        labelToolOne.setFont(suggestFont);
        //设置分数字体颜色
        labelToolOne.setForeground(colorSuggestRule);
        //原样显示组件中的每个像素,便于显示背景色
        labelToolOne.setOpaque(true);
        //设置分数字体背景色
        labelToolOne.setBackground(Color.black);
        //设置分数字体的位置
        labelToolOne.setBounds(0, 150, 590, 20);
        //将分数加入面板
        panel.add(labelToolOne);

        //labelToolTwo部分
        //设置分数字体
        labelToolTwo.setFont(suggestFont);
        //设置分数字体颜色
        labelToolTwo.setForeground(colorSuggestRule);
        //原样显示组件中的每个像素,便于显示背景色
        labelToolTwo.setOpaque(true);
        //设置分数字体背景色
        labelToolTwo.setBackground(Color.black);
        //设置分数字体的位置
        labelToolTwo.setBounds(0, 170, 590, 20);
        //将分数加入面板
        panel.add(labelToolTwo);

        //gamePanel部分
        //设置游戏板的位置
        gamePanel.setBounds(35, 200, 485, 500);
        //原样显示组件中的每个像素,便于显示背景色
        gamePanel.setOpaque(true);
        //设置控制键盘获得这个按钮的焦点
        gamePanel.setFocusable(true);
        //设置一个新的流式布局管理器对象
        gamePanel.setLayout(new FlowLayout());
        //将游戏板加入窗体
        panel.add(gamePanel);

    }

    //游戏板类GamePanel
    @SuppressWarnings("serial")
    class GamePanel extends JPanel implements KeyListener {

        //定义方块间距 Interval为10，定义为常量，便于修改
        private static final int Interval = 10;
        //定义方块圆角 Angel为10，定义为常量，便于修改
        private static final int Angel = 10;
        //定义方块大小 Size为86，定义为常量，便于修改
        private static final int Size = 86;

        //创建4*4游戏方块对象
        private Block[][] blocks = new Block[4][4];
        //定义标志
        private boolean flag = true;
        //定义游戏成绩
        private static int mark = 0;

        //构造器
        public GamePanel() {
            initGame();
            addKeyListener(this);
        }

        //重写键盘键入方法
        @Override
        public void keyTyped(KeyEvent e) {

        }
        //重写键盘释放方法
         @Override
        public void keyReleased(KeyEvent e) {

        }
        //重写键盘按下方法
        @Override
        public void keyPressed(KeyEvent e) {
            //对于按下的不同键盘按键，执行不同方法
            switch (e.getKeyCode()) {
                //按esc键 开始新的游戏
                case KeyEvent.VK_ESCAPE:
                    initGame();
                    //复原道具数量
                    fireCrackers.setFirecrackersNum(1);
                    bombs.setBombsNum(1);
                    cubes.setCubesNum(1);
                    break;
                //按←键 方块整体左移进行可能的合并 产生随机新块 并判断是否游戏结束
                case KeyEvent.VK_LEFT:
                    goLeft();
                    newBlock();
                    judgeEnd();
                    break;
                //按→键 方块整体右移进行可能的合并 产生随机新块 并判断是否游戏结束
                case KeyEvent.VK_RIGHT:
                    goRight();
                    newBlock();
                    judgeEnd();
                    break;
                //按↑键 方块整体上移进行可能的合并 产生随机新块 并判断是否游戏结束
                case KeyEvent.VK_UP:
                    goUp();
                    newBlock();
                    judgeEnd();
                    break;
                //按↓键 方块整体下移进行可能的合并 产生随机新块 并判断是否游戏结束
                case KeyEvent.VK_DOWN:
                    goDown();
                    newBlock();
                    judgeEnd();
                    break;
                //按Enter键 使用爆竹道具消除游戏板中最上面一行
                case KeyEvent.VK_ENTER:
                    boom();
                    newBlock();
                    judgeEnd();
                    break;
                //按Ctrl键 使用魔方道具随机化游戏板上方块
                case KeyEvent.VK_CONTROL:
                    change();
                    newBlock();
                    judgeEnd();
                    break;
                //按Space键 使用炸弹道具消除游戏板中最左面一列
                case KeyEvent.VK_SPACE:
                    fire();
                    newBlock();
                    judgeEnd();
                    break;
                default:
                    break;
            }
            //重绘组件
            repaint();
        }

        //新的游戏
        private void initGame() {
            mark = 0;
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    blocks[i][j] = new Block();
                }
            }
            //生成两个数方块（随机值为2或4）
            flag = true;
            newBlock();
            flag = true;
            newBlock();
        }

        //产生随机新方块
        private void newBlock() {
            //获取游戏板上的空白方块
            ArrayList<Block> list = findBlankBlocks();

            //游戏板上有空白方块
            if (!list.isEmpty() && flag) {
                //创建Random对象
                Random random = new Random();
                //随机获取一个空白方块
                Block randomSelected = list.get(random.nextInt(list.size()));
                //随机获取一个方块数值，2和 4出现概率比为4:1
                randomSelected.value = (random.nextInt(5) / 4 == 1) ? 4 : 2;
                //获取结束后，将flag标志改为false
                flag = false;
            }
        }

        //获取游戏界面的空白方格
        private ArrayList<Block> findBlankBlocks() {
            //建立列表
            ArrayList<Block> blockArrayList = new ArrayList<>();
            //两层循环获取所有值为0的空块
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (blocks[i][j].value == 0) {
                        blockArrayList.add(blocks[i][j]);
                    }
                }
            }
            //返回列表
            return blockArrayList;
        }

        //判断游戏是否结束
        private boolean judgeEnd() {
            //将分数同步到分数栏
            labelMark.setText(mark + "");
            //获取游戏板上的所有空白方格
            ArrayList <Block> One = findBlankBlocks();
            //建立插入数据库对象
            InsertData insertData= new InsertData();
            //建立获取当前时间对象
            SimpleDateFormat sdf = new SimpleDateFormat();
            //获取日期参数
            String dateNow = sdf.format(new Date());
            String date=dateNow.split(" ")[0];
            //获取游戏终止分数
            String score=mark+"";

            //游戏板中全是空白方格（只有可能是利用道具达成） 游戏结束
            if (One.size()==16) {
            //将成绩插入数据库
                if(c){
                    insertData.insertInfo(date,score);
                    c=false;
                }
                return true;
            }

            //游戏板中存在空白方格，游戏必然没有结束
            if (One.size()!=0){
                return false;
            }

            //游戏板中不存在空白方格
            //通过两层循环判断游戏板中是否存在可以合并的方格
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    //对于左上角的3*3方格的合并判断
                    if (i < 3 && j < 3) {
                        //同行合并、同列合并
                        if (blocks[i][j].value == blocks[i][j + 1].value || blocks[i][j].value == blocks[i + 1][j].value) {
                            //可以合并
                            return false;
                        }
                    } else {
                        //对于靠下的1*3的方格的合并判断
                        if (i == 3 && j != 3) {
                            //同行合并
                            if (blocks[i][j].value == blocks[i][j + 1].value) {
                                //可以合并
                                return false;
                            }
                        }
                        //对于靠右的3*1的方格的合并判断
                        if (j == 3 && i != 3) {
                            //同列合并
                            if (blocks[i][j].value == blocks[i + 1][j].value) {
                                //可以合并
                                return false;
                            }
                        }
                    }

                }
            }
            //无法合并

            //游戏结束，将成绩插入数据库
            if(c){
                insertData.insertInfo(date,score);
                c=false;
            }
            return true;
        }

        //左移操作
        private boolean goLeft() {
            //双层循环判断
            for (int i = 0; i < 4; i++) {
                for (int j = 1, k = 0; j < 4; j++) {
                    //当前方块不为空白方块则可进行移动
                    if (blocks[i][j].value > 0) {
                        //当前方块可以和左边方块合并
                        if (blocks[i][j].value == blocks[i][k].value) {
                            //左边方块值翻倍，分数增加
                            mark += blocks[i][k++].value <<= 1;
                            //当前方块归为空白方块
                            blocks[i][j].value = 0;
                            //将flag标志改为true
                            flag = true;
                        }
                        //左边为空白方块
                        else if (blocks[i][k].value == 0) {
                            //当前方块移至左边
                            blocks[i][k].value = blocks[i][j].value;
                            //当前方块归为空白方块
                            blocks[i][j].value = 0;
                            //将flag标志改为true
                            flag = true;
                        } else if (blocks[i][++k].value == 0) {
                            blocks[i][k].value = blocks[i][j].value;
                            blocks[i][j].value = 0;
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        //右移操作
        private boolean goRight() {
            //双层循环判断
            for (int i = 0; i < 4; i++) {
                for (int j = 2, k = 3; j >= 0; j--) {
                    //当前方块不为空白方块则可进行移动
                    if (blocks[i][j].value > 0) {
                        //当前方块可以和右边方块合并
                        if (blocks[i][j].value == blocks[i][k].value) {
                            //右边方块值翻倍，分数增加
                            mark += blocks[i][k--].value <<= 1;
                            //当前方块归为空白方块
                            blocks[i][j].value = 0;
                            //将flag标志改为true
                            flag = true;
                        }
                        //右边为空白方块
                        else if (blocks[i][k].value == 0) {
                            //当前方块移至右边
                            blocks[i][k].value = blocks[i][j].value;
                            //当前方块归为空白方块
                            blocks[i][j].value = 0;
                            //将flag标志改为true
                            flag = true;
                        } else if (blocks[i][--k].value == 0) {
                            blocks[i][k].value = blocks[i][j].value;
                            blocks[i][j].value = 0;
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        //上移操作
        private boolean goUp() {
            //双层循环判断
            for (int i = 0; i < 4; i++) {
                for (int j = 1, k = 0; j < 4; j++) {
                    //当前方块不为空白方块则可进行移动
                    if (blocks[j][i].value > 0) {
                        //当前方块可以和上边方块合并
                        if (blocks[j][i].value == blocks[k][i].value) {
                            //上边方块值翻倍,分数增加
                            mark += blocks[k++][i].value <<= 1;
                            //当前方块归为空白方块
                            blocks[j][i].value = 0;

                            flag = true;
                        }
                        //上边为空白方块
                        else if (blocks[k][i].value == 0) {
                            //当前方块移至上边
                            blocks[k][i].value = blocks[j][i].value;
                            //当前方块归为空白方块
                            blocks[j][i].value = 0;
                            //将flag标志改为true
                            flag = true;
                        } else if (blocks[++k][i].value == 0) {
                            blocks[k][i].value = blocks[j][i].value;
                            blocks[j][i].value = 0;
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        //下移操作
        private boolean goDown() {
            //双层循环判断
            for (int i = 0; i < 4; i++) {
                for (int j = 2, k = 3; j >= 0; j--) {
                    //当前方块不为空白方块则可进行移动
                    if (blocks[j][i].value > 0) {
                        //当前方块可以和下边方块合并
                        if (blocks[j][i].value == blocks[k][i].value) {
                            //下边方块值翻倍,分数增加
                            mark += blocks[k--][i].value <<= 1;
                            //当前方块归为空白方块
                            blocks[j][i].value = 0;
                            //将flag标志改为true
                            flag = true;
                        }
                        //下边为空白方块
                        else if (blocks[k][i].value == 0) {
                            //当前方块移至下边
                            blocks[k][i].value = blocks[j][i].value;
                            //当前方块归为空白方块
                            blocks[j][i].value = 0;
                            //将flag标志改为true
                            flag = true;
                        } else if (blocks[--k][i].value == 0) {
                            blocks[k][i].value = blocks[j][i].value;
                            blocks[j][i].value = 0;
                            flag = true;
                        }
                    }
                }
            }
            return flag;
        }

        //使用爆竹
        private boolean boom() {
            //爆竹道具暂未使用，可以使用
            if(fireCrackers.getFirecrackersNum()>0){
                //调用方法清除第一行
                clearFirstRow();
                //修改爆竹数量
                fireCrackers.setFirecrackersNum(fireCrackers.getFirecrackersNum()-1);
            }
            return flag;
        }

        //清除首行
        private void clearFirstRow() {
            //游戏没有结束
            if(!judgeEnd()){
                for (int i = 0; i < 4; i++) {
                    //清空首行方格值
                    blocks[0][i].value=0;
                }
            }
        }

        //使用魔方
        private boolean change() {
            //魔方道具暂未使用，可以使用
            if(cubes.getCubesNum()>0){
                //调用方法使所有方格乱序
                changeOrder();
                //修改魔方数量
                cubes.setCubesNum(cubes.getCubesNum()-1);
            }
            return flag;
        }

        //方格乱序
        private void changeOrder() {
            //用于记录储存进度
            int cnt=0;
            //产生随机数对象
            Random random=new Random();
            //用于储存当前所有方格值
            int[] num = new int[16];
            //用于记录并判断随机数是否已经产生过
            boolean[] symbol = new boolean[16];
            //初始化判断数组均为false
            for (int i = 0; i < 15; i++) {
                symbol[i]=false;
            }
            //游戏没有结束
            if(!judgeEnd()){
                //储存所有方块值
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        num[cnt++]=blocks[i][j].value;
                    }
                }
                //清空所有方格值
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        blocks[i][j].value=0;
                    }
                }
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        //将不重复的随机值作为索引获取原方块值以使游戏板中方块乱序
                        int k=random.nextInt(16);
                        while(true){
                            if(!symbol[k]){
                                break;
                            }else{
                                k=random.nextInt(16);
                            }
                        }
                        blocks[i][j].value=num[k];
                        //用过的随机值进行标记
                        symbol[k]=true;
                        }
                    }
                }
            }

        //使用炸弹
        private boolean fire() {
            //炸弹道具暂未使用，可以使用
            if(bombs.getBombsNum()>0){
                //调用方法清除第一列
                clearFirstColumn();
                //修改炸弹数量
                bombs.setBombsNum(bombs.getBombsNum()-1);
            }
            return flag;
        }

        //清空首列方格值
        private void clearFirstColumn() {
            //游戏没有结束
            if(!judgeEnd()){
                //清空首列方格值
                for (int i = 0; i < 4; i++) {
                    blocks[i][0].value=0;
                }
            }
        }

        //整体绘制
        @Override
        public void paint(Graphics g) {
            //画背景
            bg.BackgroundPaint(g);
            //画爆竹
            fireCrackers.ToolPaint(g);
            //画魔方
            cubes.CubePaint(g);
            //画炸弹
            bombs.BombPaint(g);
            //画方块
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    paintBlocks(g, i, j);
                }
            }

            //如果游戏结束，出现游戏结束的提示语
            if (judgeEnd()) {
                //设定整体背景色
                g.setColor(new Color(0, 0, 0, 197));
                //填充矩形范围
                g.fillRect(0, 0, getWidth(), getHeight());
                //设定字体颜色
                g.setColor(Color.RED);
                //设定字体
                g.setFont(topicFont);
                //游戏结束提示语
                String words = "游戏结束!";
                //显示提示语
                g.drawString(words, 100, 200);
            }
        }

        //绘制方格
        private void paintBlocks(Graphics g, int i, int j) {
            //对象转换为二维图对象
            Graphics2D gg = (Graphics2D) g;
            //获取单个待绘制方块
            Block blockWillBePainted = blocks[i][j];
            //渲染抗锯齿，使数字形状更加光滑
            gg.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            gg.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
            //设定颜色
            gg.setColor(blockWillBePainted.getScreenColor());

            //填充圆角
            gg.fillRoundRect(Interval + (Interval + Size) * j, Interval + (Interval + Size) * i, Size, Size, Angel, Angel);
            //设定颜色
            gg.setColor(blockWillBePainted.getFontColor());
            //设定字体
            gg.setFont(blockWillBePainted.getBlockFont());

            //对文字的长宽高测量
            FontMetrics fontMetricsms = getFontMetrics(blockWillBePainted.getBlockFont());
            //获取文字
            String value = String.valueOf(blockWillBePainted.value);
            //绘制文字
            gg.drawString(value, Interval + (Interval + Size) * j + (Size - fontMetricsms.stringWidth(value)) / 2, Interval + (Interval + Size) * i + (Size - fontMetricsms.getAscent() - fontMetricsms.getDescent()) / 2 + fontMetricsms.getAscent());
        }
    }

    //重写用于展示界面，使Frame可视的方法
    @Override
    public void showView() {
        //设定界面可视
        frame.setVisible(true);
    }

}