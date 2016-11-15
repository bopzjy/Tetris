package tetris.game.logic;

public class FEPipelineConsumer implements Runnable{
	
	FallingEntryPipeline line = null;
	
	public FEPipelineConsumer() {
		// TODO Auto-generated constructor stub
	    line = new FallingEntryPipeline();
	}
	
	public FEPipelineConsumer(FallingEntryPipeline line) {
		this.line = line;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			FallingEntry temp = line.FEPoll();
			if (temp != null) {
				System.out.println("Poll success" );
			} else {
				System.out.println("Poll fail");
			}
			
		}
	}

}
