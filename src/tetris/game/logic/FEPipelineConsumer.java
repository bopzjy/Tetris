package tetris.game.logic;

public class FEPipelineConsumer implements Runnable{
	
	FallingEntityPipeline line = null;
	
	public FEPipelineConsumer() {
		// TODO Auto-generated constructor stub
	    line = new FallingEntityPipeline();
	}
	
	public FEPipelineConsumer(FallingEntityPipeline line) {
		this.line = line;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			FallingEntity temp = line.FEPoll();
			if (temp != null) {
				System.out.println("Poll success" );
			} else {
				System.out.println("Poll fail");
			}
			
		}
	}

}
