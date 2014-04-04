/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eject.domain;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Tower
 */
public class ConfigurationManager {
    private static Properties properties=null;
    
    private static Properties getInstance(){
        if(properties==null){
            properties=new Properties();
        }
        try{
      properties.load(new FileInputStream("config.properties"));
      //  properties.load(ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties"));
        }catch(IOException e){
            e.printStackTrace();
            
            JOptionPane.showMessageDialog(null, "Failed to load configuration file,check config.properties in the root directory");
        }
        return properties;
    }
 
    public static String getConfigSettings(String xConfig){
        properties=getInstance();
        return properties.getProperty(xConfig);
    }
    
    public static void saveConfig(String xConfig,String xValue) throws IOException{
       properties=getInstance();
        properties.setProperty(xConfig, xValue);
      //  properties.store(ConfigurationManager.class.getClassLoader().getResourceAsStream("config.properties"),null);
       //   properties.store(g.class.getClassLoader().getResourceAsStream("config.properties"),null);
       properties.store(new FileOutputStream("config.properties"), null);
        
    }
}
