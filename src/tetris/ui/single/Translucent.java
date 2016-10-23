package tetris.ui.single;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Transparency;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import tetris.utils.ImageProcesser;
import tetris.utils.LoadFont;

public class Translucent extends JButton{
	private int width;
	private int height;
	
	private ImageIcon imgIcon;
	
	public Translucent() {
		
	}
	
	/*public Translucent(Image img) {
		// TODO Auto-generated constructor stub
		this.image = img;
	}*/
	
	public void setImage(ImageIcon img){
		this.imgIcon = img;
	}
	
	/*public void paintComponent(Graphics g) {
		super.paintComponent(g);
		setBackground(null);
		
		Image img = imgIcon.getImage();
		width = img.getWidth(this);//读取图片长度
        height = img.getHeight(this);//读取图片宽度
        
        g.
        
        GraphicsConfiguration gc = new JFrame().getGraphicsConfiguration();
        Image image = gc.createCompatibleImage(width,height,Transparency.TRANSLUCENT);//建立透明画布
        Graphics2D g = (Graphics2D)image.getGraphics(); //在画布上创建画笔
        
        Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency); //指定透明度
        g.setComposite(alpha);
        g.drawImage(img,0,0,this); //注意是,将image画到g画笔所在的画布上
	}*/
	
	protected void setBGTranslucent(ImageIcon imgIcon, float transparency) {
		// TODO Auto-generated constructor stub
		
		Image img = imgIcon.getImage();
		width = img.getWidth(this);//读取图片长度
        height = img.getHeight(this);//读取图片宽度
        
        GraphicsConfiguration gc = new JFrame().getGraphicsConfiguration();
        Image image = gc.createCompatibleImage(width,height,Transparency.TRANSLUCENT);//建立透明画布
        Graphics2D g = (Graphics2D)image.getGraphics(); //在画布上创建画笔
        
        Composite alpha = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, transparency); //指定透明度
        g.setComposite(alpha);
        g.drawImage(img,0,0,this); //注意是,将image画到g画笔所在的画布上
        //g.setFont(LoadFont.loadFont("resources\\font\\font.ttf", 20));
        //g.setFont(new Font("Tahoma", Font.BOLD, 24));
        //g.setColor(Color.black);//设置颜色为黑色
        //g.drawString("nimei", 0, 0);
        g.dispose(); //释放内存
        
        this.setIgnoreRepaint(true);
        this.setFocusable(false);//设置没有焦点
        this.setBorder(null);//设置不画按钮边框
        this.setContentAreaFilled(false);//设置不画按钮背景
        this.setIcon(new ImageIcon(image)); 
        //this.setBounds(0, 0, 600, 500);

	}
	
	/*public void setLocation(int x, int y){
		this.setBounds(x, y, width, height);
	}*/
}
