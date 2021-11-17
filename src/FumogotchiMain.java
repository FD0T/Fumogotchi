import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FumogotchiMain {
    int money;
    double hunger, happiness, health, energy;
    ImageIcon green = new ImageIcon("assets/green.png");
    JPanel timerPanel = new JPanel();
    JPanel lock;
    JLabel hitbox;

    Image image = Toolkit.getDefaultToolkit().createImage("src/assets/green.png");
    ImageIcon imageIcon = new ImageIcon(image);

    Image energyIm = Toolkit.getDefaultToolkit().createImage("src/assets/biceps.png");
    //ImageIcon energyIc = new ImageIcon(energyIm);
    Image happinessIm = Toolkit.getDefaultToolkit().createImage("src/assets/drama-masks.png");
    //ImageIcon happinesIc = new ImageIcon(happinessIm);
    Image hungerIm = Toolkit.getDefaultToolkit().createImage("src/assets/full-pizza.png");
    //ImageIcon hungerIc = new ImageIcon(hungerIm);
    Image healthIm = Toolkit.getDefaultToolkit().createImage("src/assets/heart-plus.png");
    //ImageIcon healthIc = new ImageIcon(healthIm);



    Timer timer;
    Handler handler = new Handler();
    JFrame window, shopFrame;
    JButton button1, button2, button3, button4;

    public static void main(String[] args) {
        new FumogotchiMain();
    }

    public FumogotchiMain(){
        hunger = 100;
        money = 99999;
        createUI();
    }

    public void createUI(){
        window = new JFrame("Fumogotchi " + System.currentTimeMillis());
        window.setSize(480, 848);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        lock = new JPanel();
        lock.setBounds(0,0,480,848);
        lock.setBackground(Color.black);
        window.add(lock);
        lock.setVisible(false);

        JPanel upperUI = new JPanel();
        upperUI.setBounds(0,0,480,140);
        upperUI.setBackground(Color.blue);


        timerPanel.setBounds(100, 300, 200, 100);
        timerPanel.setBackground(Color.green);
        timerPanel.setLayout(new GridLayout(2,1));

        hitbox = new JLabel(String.valueOf(hunger));
        hitbox.setBackground(Color.pink);

        timerPanel.add(hitbox);

        hungerIm = hungerIm.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon hungerIc = new ImageIcon(hungerIm);
        JLabel hungerB = new JLabel();
        hungerB.setIcon(hungerIc);
        hungerB.setBounds(75+20,0,100,100);
        window.add(hungerB);
        JLabel hungerBox = new JLabel();
        hungerBox.setBounds(100,100, 10,(int)hunger);
        hungerBox.setBackground(Color.green);
        hungerBox.setIcon(imageIcon);
        window.add(hungerBox);
        window.add(timerPanel);

        happinessIm = happinessIm.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon happinessIc = new ImageIcon(happinessIm);
        JLabel happinessB = new JLabel();
        happinessB.setIcon(happinessIc);
        happinessB.setBounds(150+20,0,100,100);
        window.add(happinessB);
        JLabel happinessBox = new JLabel();
        happinessBox.setBounds(100,100, 10,(int)hunger);
        happinessBox.setBackground(Color.green);
        happinessBox.setIcon(imageIcon);
        window.add(happinessBox);
        window.add(timerPanel);

        healthIm = healthIm.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon healthIc = new ImageIcon(healthIm);
        JLabel healthB = new JLabel();
        healthB.setIcon(healthIc);
        healthB.setBounds(225+20,0,100,100);
        window.add(healthB);
        JLabel healthBox = new JLabel();
        healthBox.setBounds(100,100, 10,(int)hunger);
        healthBox.setBackground(Color.green);
        healthBox.setIcon(imageIcon);
        window.add(healthBox);
        window.add(timerPanel);

        energyIm = energyIm.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon energyIc = new ImageIcon(energyIm);
        JLabel energyB = new JLabel();
        energyB.setIcon(energyIc);
        energyB.setBounds(300+20,0,100,100);
        window.add(energyB);
        JLabel energyBox = new JLabel();
        energyBox.setBounds(100,100, 10,(int)hunger);
        energyBox.setBackground(Color.green);
        energyBox.setIcon(imageIcon);
        window.add(energyBox);
        window.add(timerPanel);


        JPanel lowerUI = new JPanel();
        lowerUI.setBounds(0,848-140,480,140);
        lowerUI.setBackground(Color.blue);
        lowerUI.setLayout(new GridLayout(1,4));
        window.add(lowerUI);

        button1 = new JButton("shop");
        button1.addActionListener(handler);
        button1.setActionCommand("shop");
        button2 = new JButton();
        button2.addActionListener(handler);
        button2.setActionCommand("b2");
        button3 = new JButton();
        button3.addActionListener(handler);
        button3.setActionCommand("b3");
        button4 = new JButton();
        button4.addActionListener(handler);
        button4.setActionCommand("b4");
        lowerUI.add(button1);
        lowerUI.add(button2);
        lowerUI.add(button3);
        lowerUI.add(button4);

        window.setVisible(true);

        shopFrame = new JFrame("Fumogotchi shop ^v^");
        shopFrame.setSize(480,848);
        shopFrame.setLayout(null);
        JLabel banner = new JLabel("Food Shop");
        banner.setBackground(Color.blue);
        banner.setIcon(green);
        banner.setBounds(0,0,480,200);
        shopFrame.add(banner);
        JPanel itemList = new JPanel();
        itemList.setLayout(new GridLayout(5,2));
        itemList.setBackground(Color.black);
        itemList.setBounds(40,100,400,400);
        JButton item1 = new JButton();
        JButton item2 = new JButton();
        JButton item3 = new JButton();
        JButton item4 = new JButton();
        JButton item5 = new JButton();
        JButton item6 = new JButton();
        JButton item7 = new JButton();
        JButton item8 = new JButton();
        JButton item9 = new JButton();
        JButton item10 = new JButton();
        JButton item11 = new JButton();
        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);
        itemList.add(item5);
        itemList.add(item6);
        itemList.add(item7);
        itemList.add(item8);
        itemList.add(item9);
        itemList.add(item10);
        itemList.add(item11);

        shopFrame.add(itemList);
        /*
        JButton panel1 = new JButton();
        panel1.setBounds(100,100,100,100);
        panel1.setBackground(Color.red);
        shopFrame.add(panel1);
        JPanel panel2 = new JPanel();
        panel2.setBounds(200,200,100,100);
        panel2.setBackground(Color.yellow);
        shopFrame.add(panel2);
        JPanel panel3 = new JPanel();

        panel3.setBackground(Color.magenta);
        shopFrame.add(panel3);
        JPanel panel4 = new JPanel();
        panel4.setBackground(Color.red);
        shopFrame.add(panel4);
         */
        shopFrame.setVisible(false);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shopFrame.isVisible()){lockMenu();}
                else {unlockMenu();}

                hunger = hunger - 5;
                hitbox.setText(String.valueOf(hunger));
                hungerBox.setBounds(75+20,100-(int)hunger, 50,(int)hunger);
                happinessBox.setBounds(150+20,100-(int)hunger, 50,(int)hunger);
                healthBox.setBounds(225+20,100-(int)hunger, 50,(int)hunger);
                energyBox.setBounds(300+20,100-(int)hunger, 50,(int)hunger);
            }
        });
        timer.start();
        window.add(upperUI);
    }

    public void lockMenu(){
        button1.setEnabled(false);
        button2.setEnabled(false);
        button3.setEnabled(false);
        button4.setEnabled(false);
        lock.setVisible(true);
    }

    public void unlockMenu(){
        button1.setEnabled(true);
        button2.setEnabled(true);
        button3.setEnabled(true);
        button4.setEnabled(true);
        lock.setVisible(false);
    }
    public void shopMenu(){

        shopFrame.setVisible(true);

    }
    public class Handler implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String action = e.getActionCommand();
            switch(action){
                case "shop":
                    shopMenu();
                    break;
            }
        }
    }
}
