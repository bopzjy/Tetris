package tetris.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import tetris.utils.ImageProcesser;

public class MainContainer extends JFrame{
	private static MainContainer instance = new MainContainer();
	
	private int width;
	private int height;
	public MouseAdapter mouseAdapter;
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
	    this.setSize(width + (this.getWidth() - this.getContentPane().getWidth()), 
	    		height + (this.getHeight() - this.getContentPane().getHeight()));
	    
	    //让窗口居中显示 
	    this.setLocation(screenSize.width/2 - this.getWidth()/2, screenSize.height/2 - this.getHeight()/2);
	    
	    keyAdapter = null;
	    
	    mouseAdapter = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		System.out.println("main");
				MainContainer.getInstance().requestFocusInWindow();
			}
	    }; 
	    this.addMouseListener(mouseAdapter);
	    
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setVisible(true);
	    
	}
	
	public int getInterWidth(){
		return this.width;
	}
	
	public int getInterHeight(){
		return this.height;
	}
	
	public void setKeyBoardAdapter(KeyAdapter newAdapter) {
		
		if(keyAdapter!=null)
			this.removeKeyListener(keyAdapter);
		
		if(newAdapter!=null){
			keyAdapter = newAdapter;
			this.addKeyListener(newAdapter);
		}
	}
	
	public void removeMouseAdapter(){
		this.removeMouseListener(mouseAdapter);
	}
	
	public void setMouseAdapter(){
		if(mouseAdapter!=null && this.getMouseListeners().length==0)
			this.addMouseListener(mouseAdapter);
	}
}
