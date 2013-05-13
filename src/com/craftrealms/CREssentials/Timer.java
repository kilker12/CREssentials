package com.craftrealms.CREssentials;

public class Timer implements Runnable {
	CREssentials p;
	public Timer(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public void run() {
		while(true) {
			for(String key : p.tempbans.keySet()) {
				int old = p.tempbans.get(key);
				p.tempbans.remove(key);
				p.tempbans.put(key, old - 1);
			}
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
