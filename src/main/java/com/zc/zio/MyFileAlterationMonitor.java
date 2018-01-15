package com.zc.zio;

import java.io.File;

import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;

public class MyFileAlterationMonitor
{
    FileAlterationMonitor monitor = null;
    
    public MyFileAlterationMonitor(long interval)
    {
        monitor = new FileAlterationMonitor(interval);
    }
    
    public void monitor(String path, MyFileAlterationListener listener)
    {
        FileAlterationObserver observer = new FileAlterationObserver(new File(path));
        monitor.addObserver(observer);
        observer.addListener(listener);
    }
    
    public void stop() throws Exception
    {
        monitor.stop();
    }
    
    public void start() throws Exception
    {
        monitor.start();
    }
    
    public static void main(String[] args) throws Exception
    {
        MyFileAlterationMonitor monitor = new MyFileAlterationMonitor(5000);
        monitor.monitor("E：\\", new MyFileAlterationListener());
        monitor.start();
    }
}
