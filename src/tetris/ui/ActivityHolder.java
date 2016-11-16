package tetris.ui;

import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.Stack;

public class ActivityHolder {
	private static ActivityHolder instance = null;
	
	private Stack<Activity> stack;
	
	private Activity[] resActivity;
	
	private ActivityHolder(){
		stack = new Stack<Activity>();
		
		resActivity = new Activity[Constants.TOTAL_ACTIVITY];
		for (int i = 0; i<resActivity.length; i++)
			resActivity[i] = null;
		
	}
	
	
	public static ActivityHolder getInstance() {
		if(instance==null){
			instance = new ActivityHolder();
		}
		return instance;
	}
	
	public Activity getActivityByIndex(int index){
		return resActivity[index];
	}
	
	public Activity turnToLastActivity(){
		if (!stack.isEmpty()) {
			Activity activity = stack.pop();
			activity.RestoreUI();
			return activity;
		}
		return null;
	}
	
	public void pushActivityByIndex(int index) {
		
		stack.push(resActivity[index]);
	}
	
	public Activity turnToNextActivity(int index){
		if(index<Constants.TOTAL_ACTIVITY){
			if(resActivity[index]==null)
				resActivity[index] = ActivityFactory.produceActivity(index);
			//else resActivity[index].ChangeUerInterfaces();
			else resActivity[index].InitUI();
			return resActivity[index];
		}
		return null;
	}
	
	
}
