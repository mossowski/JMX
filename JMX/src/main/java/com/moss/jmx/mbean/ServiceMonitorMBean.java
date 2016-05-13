package com.moss.jmx.mbean;

public interface ServiceMonitorMBean {
	
	public int getSize();
	
    public int getMaxSize();
	
	public void clear();

    public void setSize(int size);

}
