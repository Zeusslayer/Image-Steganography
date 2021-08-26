package steganography;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	private BufferedImage image;
    
    public void setImage(BufferedImage image) {
    	this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
       
        g.drawImage(image, 0, 0, this);           
    }
}