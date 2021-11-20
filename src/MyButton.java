import javax.swing.*;
import java.awt.*;

public class MyButton {
    private JButton button;
    private String actionCommand;
    private Image image;

    MyButton(String imagePath, String actionCommand, FumogotchiMain.Handler handler){
        this.image = Toolkit.getDefaultToolkit().createImage(imagePath);
        this.actionCommand = actionCommand;
        this.button = new JButton();
        this.button.setIcon(getImageIcon());
        this.button.addActionListener(handler);
        this.button.setActionCommand(this.actionCommand);
    }
    MyButton(String imagePath, int x, int y, int width, int height, String actionCommand, FumogotchiMain.Handler handler){
        this.image = Toolkit.getDefaultToolkit().createImage(imagePath);
        this.actionCommand = actionCommand;
        this.button = new JButton();
        this.button.setBounds(x,y,width,height);
        this.button.setIcon(getImageIcon());
        this.button.addActionListener(handler);
        this.button.setActionCommand(this.actionCommand);
    }

    public String getActionCommand() {
        return actionCommand;
    }

    public ImageIcon getImageIcon() {
        return new ImageIcon(this.image);
    }

    public JButton getButton(){
        return this.button;
    }
}
