package tetris.game.logic;

import java.awt.event.KeyEvent;

import tetris.ui.ActivityHolder;
import tetris.ui.Constants;

public class FallingEntry {
      int patternNum;
      int colorNum;
      int speedRank;
      
      public FallingEntry () {
    	  patternNum = 0;
    	  colorNum = 0;
    	  speedRank = 0;
      }
      
      public FallingEntry (int patternNum , int colorNum , int speedRank) {
    	  this.patternNum = patternNum;
    	  this.colorNum = colorNum;
    	  this.speedRank = speedRank;
      }
      
      public void NextPattern () {
    	  switch (patternNum) {
			case 0:
				patternNum++;
				break;				
			case 1:
				patternNum = 0;
				break;

			case 2:
				patternNum++;
				break;
			case 3:
				patternNum++;
				break;
			case 4:
				patternNum++;
				break;			
			case 5:
				patternNum = 2;
				
			case 6:
				patternNum++;
				break;				
			case 7:
				patternNum = 6;
				break;
				
			case 8:
				patternNum++;
				break;				
			case 9:
				patternNum = 8;
				break;
				
			default:
				break;
			}
      }
      
      public void printFallingEntry () {
    	  System.out.println(patternNum + " " + colorNum + " " + speedRank);
      }
}


