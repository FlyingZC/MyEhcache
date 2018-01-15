package com.zc.zmd5;

import java.io.IOException;
import java.util.Properties;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;

public class T01
{
    public static void main(String[] args) throws Exception
    {
        new Thread(new Runnable(){

            @Override
            public void run()
            {
                //获取MD5值
                String str=null;
                try
                {
                    long begin = System.currentTimeMillis();
                    for(int i=0;i<100;i++){
                        str = DigestUtils.md5Hex(T01.class.getResourceAsStream("/jdbc.properties"));
                    }
                    long end=System.currentTimeMillis();
                    System.out.println(end-begin);
                    System.out.println(str);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                
            }
            
        }).start();
    }
    
    @Test
    public void testRead() throws Exception{
        Properties prop=new Properties();
        long begin = System.currentTimeMillis();
        for(int i=0;i<100;i++){
            prop.load(T01.class.getResourceAsStream("/jdbc.properties"));
        }
        long end=System.currentTimeMillis();
        System.out.println(end-begin);
    }
}
