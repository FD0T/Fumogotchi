import java.awt.*;

public class Character {
    private int money;
    private int hungerMax, happinessMax, healthMax, energyMax;
    private double hungerVel, happinessVel, healthVel, energyVel;
    private Image image;
    private Item head, face, makeup, body, hands, legs, feet;

    Character(int hungerMax,
              int happinessMax,
              int healthMax,
              int energyMax,
              double hungerVel,
              double happinessVel,
              double healthVel,
              double energyVel,
              String imagePath){
        this.hungerMax = hungerMax;
        this.happinessMax = happinessMax;
        this.healthMax = healthMax;
        this.energyMax = energyMax;
        this.hungerVel = hungerVel;
        this.happinessVel = happinessVel;
        this.healthVel = healthVel;
        this.energyVel = energyVel;
        this.image = Toolkit.getDefaultToolkit().createImage(imagePath);
    }

    public void setHead(Item head) {
        this.head = head;
    }

    public void setFace(Item face) {
        this.face = face;
    }

    public void setMakeup(Item makeup) {
        this.makeup = makeup;
    }

    public void setBody(Item body) {
        this.body = body;
    }

    public void setHands(Item hands) {
        this.hands = hands;
    }

    public void setLegs(Item legs) {
        this.legs = legs;
    }

    public void setFeet(Item feet) {
        this.feet = feet;
    }

    public int getMoney() {
        return this.money;
    }

    public int getHungerMax() {
        return this.hungerMax;
    }

    public int getHappinessMax() {
        return this.happinessMax;
    }

    public int getHealthMax() { return this.healthMax; }

    public int getEnergyMax() {
        return this.energyMax;
    }

    public double getHungerVel() {
        return this.hungerVel;
    }

    public double getHappinessVel() { return this.happinessVel; }

    public double getHealthVel() {
        return this.healthVel;
    }

    public double getEnergyVel() {
        return this.energyVel;
    }

    public Image getImage() {
        return this.image;
    }

    public Item getHead() {
        return this.head;
    }

    public Item getFace() {
        return this.face;
    }

    public Item getMakeup() {
        return this.makeup;
    }

    public Item getBody() {
        return this.body;
    }

    public Item getHands() {
        return this.hands;
    }

    public Item getLegs() {
        return this.legs;
    }

    public Item getFeet() {
        return this.feet;
    }
}
