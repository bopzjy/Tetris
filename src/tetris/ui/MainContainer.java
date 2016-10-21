package tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.utils.ImageProcesser;

public class MainContainer extends JFrame{
	private static MainContainer instance = null;
	
	private int width;
	private int height;
	// 屏占比
	private final double screenOfWhole = 0.85;
	// 宽高比
	private final double widthOfHeight = 1.19998; 
	
	private KeyAdapter keyAdapter;
	
	private MainContainer(){
		super("Tetris");
		init();
		
	}
	
	public static MainContainer getInstance(){
		if(instance == null){	
			instance = new MainContainer();	
		}
		return instance;
	}
	
	private void init() {		
		// 获取屏幕大小
	    Dimension screenSize =Toolkit.getDefaultToolkit().getScreenSize();
	    
	    this.setResizable(false);
	    this.pack();
	    
	    // 占比总是固定的
	    height = (int) (screenSize.height * screenOfWhole);
	    width = (int) (height * widthOfHeight);
	    System.out.println(this.getContentPane().getSize());
	    System.out.println(this.getSize());
	    this.setSize(width + (this.getWidth() - this.getContentPane().getWidth()), 
	    		height + (this.getHeight() - this.getContentPane().getHeight()));
	    
	    //让窗口居中显示 
	    this.setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
	    
	    keyAdapter = null;
	    
	    //缩放图片
	    /*ImageIcon image = new ImageIcon("resources\\image\\begin_bg.jpg");
	    System.out.println(image.getIconHeight());
	    image = ImageProcesser.imageScale(image, width, height);
	    
	    JPanel bgPanel = new JPanel();
	    bgPanel.setBounds(0, 0, width, height);
	    JLabel bgJLabel = new JLabel();//new JLabel(image);
	    bgJLabel.setIcon(image);
	    //bgJLabel.setBackground(Color.blue);
	    bgJLabel.setBounds(0, 0, width, height);
	    bgPanel.add(bgJLabel);
	    bgPanel.setBorder(new EmptyBorder(-5, 0, -5, 0));
	   // bgPanel.setBackground(Color.yellow);
	    
	    JLayeredPane jlayeredPane = new JLayeredPane();
	    jlayeredPane.add(bgPanel, 100);
	    
	    ImageIcon arrowIcon = new ImageIcon("resources\\image\\arrow.png");
		//System.out.println((int)(arrowIcon.getIconHeight() * arrow_heightOfBG));
		arrowIcon = ImageProcesser.imageScale(arrowIcon, 
				60, 
				51);
		JPanel arrow = new JPanel();//(arrowIcon);
		//arrow
		//System.out.println(arrowIcon.getIconHeight());
		//arrow.setBounds(0, 0, arrowIcon.getIconWidth(), arrowIcon.getIconHeight());
		arrow.setBounds(50, 50, 200, 200);
		//arrow.setVisible(true);
		arrow.add(new JButton("nimabi"));
		arrow.setBackground(Color.black);
		arrow.setOpaque(true);
		//jlayeredPane.add(arrow, 101);
	    
	    //jlayeredPane.getComponentsInLayer(1)
	    
	    //...
	    this.setLayeredPane(jlayeredPane);*/
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    //System.out.println("heheda:" + getContentPane().getSize());
	    
//	    keyAdapter = new Adapter_1();
//	    this.addKeyListener(keyAdapter);
//	    this.removeKeyListener();
//	    this.chan
//	    System.out.println(height);
	}
	
	/*public void setMCLayer(JLayeredPane layer) {
		this.setLayeredPane(layer);
	}*/
	
//	public static void main(String[] args){
//		new MainContainer();
//	}
	
	public int getInterWidth(){
		return this.width;
	}
	
	public int getInterHeight(){
		return this.height;
	}
	
	public void setKeyBoardAdapter(KeyAdapter newAdapter) {
		
		if(keyAdapter!=null)
			this.removeKeyListener(keyAdapter);
		keyAdapter = newAdapter;
		this.addKeyListener(newAdapter);
		//else
			
		
	}
	
/*	class Adapter_1 extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_A){
				MainContainer abc = (MainContainer) e.getSource();
				abc.jPanel.setBackground(Color.GRAY);
				System.out.println("print a");
				abc.removeKeyListener(abc.keyAdapter);
				abc.addKeyListener(new Adapter_2());
			}
		}
	}
	
	class Adapter_2 extends KeyAdapter{
		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			super.keyPressed(e);
			if(e.getKeyCode()==KeyEvent.VK_A){
				MainContainer abc = (MainContainer) e.getSource();
				abc.jPanel.setBackground(Color.red);
				System.out.println("print heheda");
				//abc.addKeyListener(new Adapter_2());
			}
		}
	}*/
}
