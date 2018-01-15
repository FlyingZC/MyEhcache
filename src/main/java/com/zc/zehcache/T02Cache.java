package com.zc.zehcache;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class T02Cache
{
    public static void main(String[] args)
    {
        //创建CacheManager
        CacheManager manager = CacheManager.create(T02Cache.class.getResourceAsStream("/ehcache-new.xml"));
        //添加新cache
        manager.addCache("newCache");
        //获取配置cache
        Cache cache1=manager.getCache("newCache");
        System.out.println(cache1.get("k1999"));//可以得到value
        for(int i=0;i<20000;i++){
            Element e=new Element("k"+i,"k"+i); 
            cache1.put(e);
        }
        cache1.flush();
        System.out.println(cache1.get("k1"));//只能存50个,此时get出来为Null
        System.out.println(cache1.get("k1999"));//可以得到value
    }
}
