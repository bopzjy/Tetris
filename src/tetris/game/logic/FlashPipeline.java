package tetris.game.logic;

import java.awt.Color;
import java.util.LinkedList;
import java.util.Queue;

public class FlashPipeline {
	// 产生下落物的队列
		Queue<FlashEntity> FEPipeline = null;

		public FlashPipeline() {
			FEPipeline = new LinkedList<FlashEntity>();
		}

		public boolean FEOffer(int x, int y, Color color) {
			return FEPipeline.offer(new FlashEntity(x,y,color));
		}

		public boolean FEOffer(FlashEntity fe) {
			return FEPipeline.offer(fe);
		}

		public FlashEntity FEPoll() {
			return FEPipeline.poll();
		}

		public int getFEPipelineSize() {
			return FEPipeline.size();
		}


}
