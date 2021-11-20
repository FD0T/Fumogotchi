import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;

enum ItemType{
    medicine, food, clothes, car
}

public class Item {
    private Image image;
    private ItemType itemType;
    private int value;
    private String name;

    Item(String imagePath, ItemType itemType, int value, String name){
        this.image = Toolkit.getDefaultToolkit().createImage(imagePath);
        this.itemType = itemType;
        this.value = value;
        this.name = name;
    }

    public ImageIcon getImageIcon(){
        return new ImageIcon(this.image);
    }

    public ItemType getItemType() {
        return this.itemType;
    }

    public int getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
