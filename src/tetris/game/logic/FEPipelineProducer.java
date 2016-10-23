package tetris.game.logic;

public class FEPipelineProducer implements Runnable {
	
	FallingEntryPipeline line = null;
	
	public FEPipelineProducer() {
		// TODO Auto-generated constructor stub
		line = new FallingEntryPipeline();
	}
	
	public FEPipelineProducer(FallingEntryPipeline FEPipeline) {
		this.line = FEPipeline; 
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		 while (true) {
		   int lineSize = line.getFEPipelineSize();
		   System.out.println("Producer:" + lineSize);
  		   //System.out.println();
  		   if (lineSize < GameConstants.LENGTH_OF_FEPIPELINE) {
  			   line.FEOffer(1, 2, 3);
  		   } else {
  			   
  		   }
  	   }
	}

}
