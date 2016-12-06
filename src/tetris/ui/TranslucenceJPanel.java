package tetris.ui;
/*
 *重写这个类来实现半透明的JPanel 
 */
import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import tetris.utils.ImageProcesser;

//import Logic.CastImage;

public class TranslucenceJPanel extends MWidget {
	
	//protected BufferedImage background;
	
	protected float transparency;
	protected ImageIcon bgImage;
	protected double[][] fshape;
	
	
	public TranslucenceJPanel(double[][] shape){
		super(shape);
		this.setBorder(null);
		this.setBackground(null);
		this.setOpaque(false);
		this.fshape = shape;

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
	
	protected void setBackGroud(String path) {
		MainContainer mainContainer = MainContainer.getInstance();
		bgImage = ImageProcesser.imageScale(new ImageIcon(path),
				(int)(mainContainer.getInterWidth() * fshape[1][0]),
				(int)(mainContainer.getInterHeight() * fshape[1][1]));
	}
}
