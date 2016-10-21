package tetris.utils;

import java.awt.Image;
import javax.swing.ImageIcon;

public class ImageProcesser {
	public static ImageIcon imageScale(ImageIcon src, int width, int height){
		/*int width = src.getIconWidth();
		int height = src.getIconHeight();
		width *= scale;
		height *= scale;*/
		
		Image image = src.getImage();
		image = image.getScaledInstance(width, height, Image.SCALE_DEFAULT);  
		
		return new ImageIcon(image);
        /*BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);      
		Graphics g = tag.getGraphics();
		g.drawi*/
	}
}
