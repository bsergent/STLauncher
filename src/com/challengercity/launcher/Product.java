
package com.challengercity.launcher;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ben Sergent V/ha1fBit
 */
public class Product {
    
    public int id;
    public String name;
    public String version;
    public String desc;
    public boolean forceLatest;
    public boolean showInLauncher;
    public float price;
    public String file;
    public String news;
    public String website;
    
    public String downloadedVersion;

    public Product(int id, String name, String version, String desc, boolean forceLatest, boolean showInLauncher, float price, String file, String news, String website) {
        this.id = id;
        this.name = name;
        this.version = version;
        this.desc = desc;
        this.forceLatest = forceLatest;
        this.showInLauncher = showInLauncher;
        this.price = price;
        this.file = file;
        this.news = news;
        this.website = website;
        
        if (showInLauncher) {
            downloadedVersion = "";
            File versionFile = new File(STLauncher.getWorkingDirectory()+"/"+name+"/bin/version.yml");
            if (versionFile.exists()) {
                String line = null;
                try {
                    FileReader fileReader = new FileReader(versionFile);

                    BufferedReader bufferedReader = new BufferedReader(fileReader);

                    while((line = bufferedReader.readLine()) != null) {
                        String[] lineBits = line.split("=");
                        if (lineBits.length >= 2) {
                            if ("version".equals(lineBits[0])) {
                                downloadedVersion = lineBits[1];
                            }
                        }
                    }    

                    bufferedReader.close();            
                } catch(IOException ex) {
                    // Do nothing           
                }
            }
        }
    }
    
    public boolean createDirectory() {
        return true;
    }
    
    public boolean update() {
        return true;
    }
    
    public boolean isOutdated() {
        if (!"".equals(version) && "".equals(downloadedVersion)) {
            STLauncher.debugMessage("Outdated by no download");
            return true;
        }
        
        char cT = downloadedVersion.charAt(downloadedVersion.length()-1);
        char dT = version.charAt(version.length()-1);
        String cN = downloadedVersion.substring(0,downloadedVersion.length()-1);
        String dN = version.substring(0,version.length()-1);
        String[] cNA = downloadedVersion.split(".");
        String[] dNA = version.split(".");
        
        if (dT == 'R' && (cT == 'B' || cT == 'A') || // Database is release, current is beta or alpha
                dT == 'B' && cT == 'A') { // Database is beta, current is alpha
            STLauncher.debugMessage("Outdated by version type");
            return true;
        }
        
        int shorterLength = cNA.length>dNA.length?dNA.length:cNA.length;
        
        for (int i = 0; i < shorterLength; i++) {
            if (Integer.parseInt(cNA[i]) < Integer.parseInt(dNA[i])) {
                STLauncher.debugMessage("Outdated by "+i+"number");
                return true;
            }
        }
        
        if (cNA.length < dNA.length) {
            STLauncher.debugMessage("Outdated by shorter length");
            return true;
        }
        
        // Compare versions
        // Check ABR first _/
        // Take off ABR and split by . delimiter _/
        // Compare integers starting from the left and moving to the right
        
        return false;
    }

    @Override
    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
