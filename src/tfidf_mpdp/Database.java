/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tfidf_mpdp;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class Database {
    public Properties mypanel,myLanguage;
    private String strNamaPanel;
    public Database(){
        
    }
    public String SettingPanel(String nmPanel){
        try{
            mypanel = new Properties();
            mypanel.load(new FileInputStream("C:/Users/Eri/Desktop/kodingan/tfidf_mpdp/src/tfidf_mpdp"));
            strNamaPanel = mypanel.getProperty(nmPanel);
        }catch(IOException e){
            JOptionPane.showMessageDialog(null, "Tidak ada koneksi","Error", JOptionPane.INFORMATION_MESSAGE); 
            System.err.println(e.getMessage());
            System.exit(0);
        }
      return strNamaPanel;
    }
   
}
