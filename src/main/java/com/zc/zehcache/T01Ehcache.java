package com.zc.zehcache;

import org.junit.Test;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class T01Ehcache
{
    public static void main(String[] args)
    {
        //创建CacheManager
       CacheManager manager = CacheManager.create(T01Ehcache.class.getResourceAsStream("/ehcache-failsafe2.xml"));
       //添加新cache
       manager.addCache("newCache");
       //获取配置cache
       Cache cache1=manager.getCache("newCache");
       //添加新cache并定义其属性
       Cache newCache2=new Cache("cache2",1,true,false,5,2);
       manager.addCache(newCache2);
       //移除cache
       manager.removeCache("cache2");
       
       //3.使用cache
       //向cache中添加元素,若该Element的key已在cache中存在,则put为更新该element
       Element element=new Element("k1","v1");
       cache1.put(element);
       //从cache中取得元素
       Element getElem=cache1.get("k1");
       //从取出的element中获取value
       Object value = getElem.getObjectValue();
       System.out.println(getElem+"里的"+value);
       //从cache中删除元素
       cache1.remove("k1");
       
       //卸载CacheManager,关闭cache
       manager.shutdown();
    }
    
    @Test
    public void testCacheManager(){
        //默认配置的 CacheManager
        CacheManager manager =new CacheManager();
        String txt = manager.getActiveConfigurationText();
        System.out.println(txt);
    }
}
