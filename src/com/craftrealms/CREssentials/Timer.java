package com.craftrealms.CREssentials;

public class Timer implements Runnable {
	private CREssentials p;
	public Timer(CREssentials plugin) {
		p = plugin;
	}
	@Override
	public void run() {
		while(true) {
			for(String key : p.tempbans.keySet()) {
				int old = p.tempbans.get(key);
				p.tempbans.remove(key);
				if(!(old - 1 <= 0)) {
					p.tempbans.put(key, old - 1);
				}
			}
			Utils.SaveTempBans(p);
			try {
				Thread.sleep(60000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
