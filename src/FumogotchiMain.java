import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FumogotchiMain {
    int money;
    double hunger, happiness, health, energy;
    ImageIcon green = new ImageIcon("assets/green.png");
    JPanel timerPanel = new JPanel();
    JPanel itemList;
    JLabel moneyBox, banner, lock;

    Image image = Toolkit.getDefaultToolkit().createImage("src/assets/green.png");
    ImageIcon imageIcon = new ImageIcon(image);

    Image energyIm = Toolkit.getDefaultToolkit().createImage("src/assets/biceps.png");
    //ImageIcon energyIc = new ImageIcon(energyIm);
    Image happinessIm = Toolkit.getDefaultToolkit().createImage("src/assets/drama-masks.png");
    //ImageIcon happinessIc = new ImageIcon(happinessIm);
    Image hungerIm = Toolkit.getDefaultToolkit().createImage("src/assets/full-pizza.png");
    //ImageIcon hungerIc = new ImageIcon(hungerIm);
    Image healthIm = Toolkit.getDefaultToolkit().createImage("src/assets/heart-plus.png");
    //ImageIcon healthIc = new ImageIcon(healthIm);
    Image lockIm = Toolkit.getDefaultToolkit().createImage("src/assets/lock.png");



    Timer timer;
    Handler handler = new Handler();
    JFrame window, shopFrame;
    MyButton button1, button2, button3, button4;

    public static void main(String[] args) {
        new FumogotchiMain();
    }

    public FumogotchiMain(){
        //firstWindow();
        gameLoop();
    }

    public void firstWindow(){
        JFrame frame = new JFrame("Fumogotchi Settings");
        frame.setSize(480, 848);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setBounds(0,0,478,846);
        panel.setBackground(Color.green);
        panel.setToolTipText("ssss");
        frame.add(panel);
    }

    public int gameLoop(){
        Character player = createAllCharacters(0);
        hunger = player.getHungerMax();
        happiness = player.getHappinessMax();
        health = player.getHealthMax();
        energy = player.getEnergyMax();
        money = 99999;
        window = new JFrame("Fumogotchi " + System.currentTimeMillis());
        window.setSize(480, 848);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setLayout(null);

        lock = new JLabel();
        lock.setBounds(0,0,480,848);
        //lock.setBackground(Color.black);
        ImageIcon lockIc = new ImageIcon(lockIm);
        lock.setIcon(lockIc);
        window.add(lock);
        lock.setVisible(false);

        JPanel upperUI = new JPanel();
        upperUI.setBounds(0,0,480,140);
        upperUI.setBackground(Color.blue);


        timerPanel.setBounds(100, 300, 200, 100);
        timerPanel.setBackground(Color.green);
        timerPanel.setLayout(new GridLayout(2,1));

        hungerIm = hungerIm.getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon hungerIc = new ImageIcon(hungerIm);
        JLabel hungerB = new JLabel();
        hungerB.setIcon(hungerIc);
        hungerB.setBounds(75+20,0,100,100);
        window.add(hungerB);
        JLabel hungerBox = new JLabel();
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
        energyBox.setBackground(Color.green);
        energyBox.setIcon(imageIcon);
        window.add(energyBox);
        window.add(timerPanel);


        JPanel lowerUI = new JPanel();
        lowerUI.setBounds(0,848-140,480,140);
        lowerUI.setBackground(Color.blue);
        lowerUI.setLayout(new GridLayout(1,4));
        window.add(lowerUI);

        button1 = new MyButton("", "shop", handler);
        button2 = new MyButton("", "b2", handler);
        button3 = new MyButton("", "b3", handler);
        button4 = new MyButton("", "b4", handler);

        lowerUI.add(button1.getButton());
        lowerUI.add(button2.getButton());
        lowerUI.add(button3.getButton());
        lowerUI.add(button4.getButton());

        window.setVisible(true);

        shopFrame = new JFrame("Fumogotchi shop ^v^");
        shopFrame.setSize(480,848);
        shopFrame.setLayout(null);
        moneyBox = new JLabel(String.valueOf(money));
        moneyBox.setBounds(10,10,50,10);
        shopFrame.add(moneyBox);
        banner = new JLabel("Food Shop");
        banner.setBackground(Color.blue);
        banner.setIcon(green);
        banner.setBounds(0,0,480,200);
        shopFrame.add(banner);
        JButton mainButton1 = new JButton("Открой магазин");
        mainButton1.setBounds(200,600,50,50);
        mainButton1.setActionCommand("change to shop");
        mainButton1.addActionListener(handler);
        JButton mainButton2 = new JButton("Открой баннер");
        mainButton2.setBounds(250,400,50,50);
        mainButton2.setActionCommand("change to banner");
        mainButton2.addActionListener(handler);
        itemList = new JPanel();
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
        itemList.setVisible(false);
        banner.setVisible(false);
        shopFrame.add(itemList);
        shopFrame.add(mainButton1);
        shopFrame.add(mainButton2);
        shopFrame.setVisible(false);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(shopFrame.isVisible()){lockMenu();}
                else {unlockMenu();}
                moneyBox.setText(String.valueOf(money));
                hunger -= player.getHungerVel();
                if (hunger > player.getHungerMax()) {hunger = player.getHungerMax(); }
                else if (hunger < 0) { hunger = 0; }
                hungerB.setToolTipText(String.valueOf(hunger)  + " / " + String.valueOf(player.getHungerMax()));

                happiness -= player.getHappinessVel();
                if (happiness > player.getHappinessMax()) {happiness = player.getHappinessMax(); }
                else if (happiness < 0) { happiness = 0; }
                happinessB.setToolTipText(String.valueOf(happiness)  + " / " + String.valueOf(player.getHappinessMax()));

                health -= player.getHealthVel();
                if (health > player.getHealthMax()) {health = player.getHealthMax(); }
                else if (health < 0) { health = 0; }
                healthB.setToolTipText(String.valueOf(health)  + " / " + String.valueOf(player.getHealthMax()));

                energy -= player.getEnergyVel();
                if (energy > player.getEnergyMax()) {energy = player.getEnergyMax(); }
                else if (energy < 0) { energy = 0; }
                energyB.setToolTipText(String.valueOf(energy)  + " / " + String.valueOf(player.getEnergyMax()));

                hungerBox.setBounds(75+20, (int) (100-Math.round(hunger/player.getHungerMax()*100)), 50, (int) Math.round(hunger/player.getHungerMax()*100));
                happinessBox.setBounds(150+20,(int) (100-Math.round(happiness/player.getHappinessMax()*100)), 50,(int) Math.round(happiness/player.getHappinessMax()*100));
                healthBox.setBounds(225+20,(int) (100-Math.round(health/player.getHealthMax()*100)), 50,(int) Math.round(health/player.getHealthMax()*100));
                energyBox.setBounds(300+20,(int) (100-Math.round(energy/player.getEnergyMax()*100)), 50,(int) Math.round(energy/player.getEnergyMax()*100));
            }
        });
        timer.start();
        window.add(upperUI);
        return 0;
    }

    public void lockMenu(){
        button1.getButton().setEnabled(false);
        button2.getButton().setEnabled(false);
        button3.getButton().setEnabled(false);
        button4.getButton().setEnabled(false);
        lock.setVisible(true);
    }

    public void unlockMenu(){
        button1.getButton().setEnabled(true);
        button2.getButton().setEnabled(true);
        button3.getButton().setEnabled(true);
        button4.getButton().setEnabled(true);
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
                case "change to shop":
                    itemList.setVisible(true);
                    banner.setVisible(false);
                    break;
                case "change to banner":
                    itemList.setVisible(false);
                    banner.setVisible(true);
                    money-=100;
                    break;
            }
        }
    }
    public Character createAllCharacters(int choice) {
        switch (choice){
            case 0: //default to debugging
                return new Character(75,
                        100,
                        100,
                        100,
                        5,
                        1,
                        0.25,
                        1,
                        "");
            default:
                return new Character(125,
                        100,
                        125,
                        100,
                        1,
                        1,
                        1,
                        1,
                        "");

        }
    }
}
