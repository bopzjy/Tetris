package tetris.ui.single;
/*
 *重写这个类来实现半透明的JPanel 
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.utils.ImageProcesser;

//import Logic.CastImage;

public class TranslucenceJPanel extends JPanel {
	
	//protected BufferedImage background;
	
	protected float transparency;
	protected ImageIcon bgImage;
	
	
	public TranslucenceJPanel(){
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);

	}
	
	public void setBgImage(ImageIcon bg){
		this.bgImage = bg;
	}
	
	public void setTransparent(float transparency) {
		this.transparency = transparency;
	}
	
	@Override
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		
		
		Graphics2D graphics2d = (Graphics2D) g.create();
		graphics2d.setComposite(AlphaComposite.SrcOver.derive(transparency));			
      	//graphics2d.drawImage(background, 0, 0, this);
		graphics2d.drawImage(bgImage.getImage(), 0, 0, this);
		graphics2d.dispose();
	}
	
}
