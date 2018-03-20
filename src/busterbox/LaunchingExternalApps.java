/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busterbox;

/**
 *
 * @author VIKAS
 */
import java.io.IOException;

public class LaunchingExternalApps
{
    public static void runMedia(String FileName){
        
        Runtime runtime = Runtime.getRuntime();     //getting Runtime object
        //String s=" F:\\Documents\\Anime\\dbs\\dbs108_HD.MP4";
        try
        {
            runtime.exec("C:\\Program Files (x86)\\K-Lite Codec Pack\\MPC-HC64\\mpc-hc64.exe "+"Media Player Classic "+FileName);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}