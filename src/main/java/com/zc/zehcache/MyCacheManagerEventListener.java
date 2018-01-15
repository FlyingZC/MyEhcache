package com.zc.zehcache;

import net.sf.ehcache.CacheException;
import net.sf.ehcache.Status;
import net.sf.ehcache.event.CacheManagerEventListener;

public class MyCacheManagerEventListener implements CacheManagerEventListener
{

    @Override
    public void init() throws CacheException
    {
           System.out.println("--init--");
    }

    @Override
    public Status getStatus()
    {
        return null;
    }

    @Override
    public void dispose() throws CacheException
    {
        System.out.println("--dispose--");
    }

    @Override
    public void notifyCacheAdded(String cacheName)
    {
        System.out.println("--notifyCacheAdded--");        
    }

    @Override
    public void notifyCacheRemoved(String cacheName)
    {
        System.out.println("--notifyCacheRemoved--");        
    }

}
