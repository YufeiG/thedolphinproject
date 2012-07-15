package controller;

import javax.servlet.http.HttpServlet;

import scheduler.MainScheduler;

public class SchedulerInitializationAction extends HttpServlet {
	
	@Override
	public void init(){
		MainScheduler scheduler = MainScheduler.getInstance();
		scheduler.createSchedulerThread();
	}
}
