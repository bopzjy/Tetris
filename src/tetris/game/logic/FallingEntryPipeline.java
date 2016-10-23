package tetris.game.logic;

import java.util.LinkedList;
import java.util.Queue;

public class FallingEntryPipeline  {
       Queue<FallingEntry> FEPipeline = null;
       
       public FallingEntryPipeline () {
    	   FEPipeline = new LinkedList<FallingEntry>();
       }
       
       public boolean FEOffer(int patternNum, int colorNum, int speedRank) {
    	   return FEPipeline.offer(new FallingEntry(patternNum, colorNum, speedRank));
       }
       
       public boolean FEOffer(FallingEntry fe) {
    	   return FEPipeline.offer(fe);
       }
       
       public FallingEntry FEPoll () {
    	   return FEPipeline.poll();
       }
       
       public int getFEPipelineSize () {
    	   return FEPipeline.size();
       }
       
       public void printFallingEntryPipeline () {
    	    Queue<FallingEntry> FEPTemp = new LinkedList<FallingEntry>();
    	    FallingEntry FETemp = FEPoll();
    	    while (FETemp != null) {
    	    	FETemp.printFallingEntry();
    	    	FEPTemp.offer(FETemp);
    	    	FETemp = FEPoll();
    	    }    	    
    	    FEPipeline = FEPTemp;
       }
       
       public static void main (String args []) throws InterruptedException {
    	   FallingEntry fe0 = new FallingEntry();
    	   FallingEntry fe1 = new FallingEntry(1, 2, 3);
    	   //fe0.printFallingEntry();
    	   //fe1.printFallingEntry();
    	   FallingEntryPipeline fep0 = new FallingEntryPipeline();
//    	   fep0.FEOffer(fe0);
//    	   fep0.FEOffer(fe1);
//    	   fep0.FEOffer(2, 3, 3);
//    	   fep0.printFallingEntryPipeline();
    	   Thread Producer = new Thread(new FEPipelineProducer(fep0));
    	   Thread Consumer = new Thread(new FEPipelineConsumer(fep0));
    	   Producer.start();
    	   Thread.sleep(2);
    	   Consumer.start();
       }

}
