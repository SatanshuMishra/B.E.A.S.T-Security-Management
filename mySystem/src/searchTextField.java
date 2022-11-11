// package guidesign;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

/**
 *
 * @author satan
 */
public class searchTextField extends JTextField {

    public Icon getPrefixIcon() {
        return prefixIcon;
    }

    public void setPrefixIcon(Icon prefixIcon) {
        this.prefixIcon = prefixIcon;
        initBorder();
    }
    
    private Icon prefixIcon;
    
    public searchTextField(){
        setBackground(new java.awt.Color(247, 248, 252));
        setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        setForeground(new java.awt.Color(0, 0, 0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        paintIcon(g);
//        PAINT BORDER
        if(isFocusOwner()){
            g.setColor(new Color(43, 124, 220));
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
            g.drawRect(1, 1, getWidth() - 1, getHeight() - 1);
        } else {
//            g.setColor(new Color(105, 122, 143));
            g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
        }
    }
    
    private void paintIcon(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        if(prefixIcon != null){
            Image prefix = ((ImageIcon)prefixIcon).getImage();
            int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
            g2.drawImage(prefix, 10, y, this);
        }
        
    }
    
    private void initBorder(){
        int left = 5;
        int right = 5;
        if(prefixIcon != null){
            left = prefixIcon.getIconWidth() + 5;
        }
        setBorder(javax.swing.BorderFactory.createMatteBorder(0, left, 0, right, new java.awt.Color(0, 0, 0)));
//        setBorder(javax.swing.BorderFactory.createEmptyBorder(0, left, 0, right));
    }
    
}
