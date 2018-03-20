/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busterbox;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author VIKAS
 */

public class AvailableMoviesFinder {
    private static String Formates[]={".avi",".mkv",".mp4",".flv","3gp"};
    private static String s[]=new String[1000000];
    private static String finalNames[]=new String[100];
    private static String FileName[]=new String[1000000];
    private static int i=0,fi=0;
    public static String[] find(String fileLocation) {
        File dir = new File(fileLocation);
        //File dir = new File("F:\\F\\Entertainment\\Movies");
        dirs(dir);
        int j=0;
        while(s[j]!=null){
            j++;
        }
        
        for (int i = 0; i< j; i++) {
            for(int k = s[i].length()-1 ; k >= 0 ; k--){
                if(s[i].charAt(k)=='\\'){
                    //s[i] = s[i].substring(k+1);
                    for(int l= s[i].length()-1 ; l >= 0 ; l--){
                        if(s[i].charAt(l)=='.'){
                            for (int f=0;f<Formates.length;f++){
                                if( s[i].substring(l).equals(Formates[f])){
                                    //System.out.println(s[i]);
                                    //s[i] = s[i].substring(0, l);
                                    finalNames[fi]=s[i];
                                    fi++;
                                }
                            }
                            break;
                        }
                    }
                    break;
                }
            }
        }
        return finalNames;
   }
   
   public static void dirs(File dir){
        File[] files = dir.listFiles();

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File file) {
                String dirName="";
                if(file.isDirectory()){
                    dirName=file.toString();
                    //System.out.println(file.toString());
                }
                if(file.isFile()){
                    s[i]=file.getAbsolutePath();
                    //System.out.println(s[i]);
                    //FileName[i]=s[i];
                    i++;
                }
                
                return file.isDirectory();
             }
        };
        files = dir.listFiles(fileFilter);
        if (files.length != 0) {
            for (int i = 0; i<files.length ; i++) {
                File filename = files[i];
                dirs(filename);
            }
        }
   }
}

