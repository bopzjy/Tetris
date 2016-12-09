package tetris.ui;

import java.io.ObjectInputStream.GetField;
import java.util.Iterator;
import java.util.Stack;

public class ActivityHolder {
	//饿汉模式
	private static ActivityHolder instance = new ActivityHolder();
	
	private Stack<Activity> stack;
	
	private Activity[] resActivity;
	
	private ActivityHolder(){
		stack = new Stack<Activity>();
		
		resActivity = new Activity[Constants.TOTAL_ACTIVITY];	
	}
	
	public static ActivityHolder getInstance() {
		return instance;
	}
	
	public Activity getActivityByIndex(int index){
		return resActivity[index];
	}
	
	public Activity turnToLastActivity(){
		if (!stack.isEmpty()) {
			Activity activity = stack.pop();
			activity.InitUI();
			return activity;
		}
		return null;
	}
	
	public void pushActivityByIndex(int index) {
		stack.push(resActivity[index]);
	}
	
	public Activity turnToNextActivity(int index){
		if(index<Constants.TOTAL_ACTIVITY){
			resActivity[index].InitUI();
			return resActivity[index];
		}
		return null;
	}
	
	public void reserveActivity(Activity activity, int index){
		resActivity[index] = activity;
	}
	
}
