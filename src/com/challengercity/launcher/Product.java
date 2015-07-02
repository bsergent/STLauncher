
package com.challengercity.launcher;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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
    public String libChangeVersion;
    public String libFile;
    public String downloadedVersion;

    public Product(int id, String name, String version, String desc, boolean forceLatest, boolean showInLauncher, float price, String file, String news, String website, String libChangeVersion, String libFile) {
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
        this.libChangeVersion = libChangeVersion;
        this.libFile = libFile;
        
        if (showInLauncher) {
            downloadedVersion = "";
            File versionFile = new File(STLauncher.getWorkingDirectory()+"/"+name+"/bin/version.cfg");
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
        try {
            File baseFile = new File(STLauncher.getWorkingDirectory()+"/"+name);
            baseFile.mkdir();
            new File(baseFile+"/bin").mkdir();
            new File(baseFile+"/bin/natives").mkdir();
            new File(baseFile+"/bin/lib").mkdir();
            new File(baseFile+"/resources").mkdir();
            
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    
    public boolean isOutdated() {
        if (!"".equals(version) && "".equals(downloadedVersion)) {
            //STLauncher.debugMessage("Outdated by no download");
            return true;
        }
        if (version == null) {
            return true;
        }
        return compareVersions(downloadedVersion, version);
    }
    
    public boolean isLibOutdated() {
        if (!"".equals(libChangeVersion) && "".equals(downloadedVersion)) {
            //STLauncher.debugMessage("Outdated by no download");
            return true;
        }
        if (libChangeVersion == null) {
            return true;
        }
        return compareVersions(downloadedVersion, libChangeVersion);
    }
    
    private boolean compareVersions(String current, String published) { // Returns true if current is outdated
        
        char cT = current.charAt(current.length()-1);
        char dT = published.charAt(published.length()-1);
        String cN = current.substring(0,current.length()-1);
        String dN = published.substring(0,published.length()-1);
        String[] cNA = cN.split("\\.");
        String[] dNA = dN.split("\\.");
        
        if (dT == 'R' && (cT == 'B' || cT == 'A') || // Database is release, current is beta or alpha
                dT == 'B' && cT == 'A') { // Database is beta, current is alpha
            //STLauncher.debugMessage("Outdated by version type");
            return true;
        }
        
        int shorterLength = cNA.length>dNA.length?dNA.length:cNA.length;
        
        for (int i = 0; i < shorterLength; i++) {
            if (Integer.parseInt(cNA[i]) < Integer.parseInt(dNA[i])) {
                //STLauncher.debugMessage("Outdated by "+i+"number");
                return true;
            }
        }
        
        if (cNA.length < dNA.length) {
            //STLauncher.debugMessage("Outdated by shorter length");
            return true;
        }
        
        return false;
    }
    
    public void updateVersionFile() throws IOException {
        File versionFile = new File(STLauncher.getWorkingDirectory()+"/"+name+"/bin/version.cfg");
        BufferedWriter versionWriter = new BufferedWriter(new FileWriter(versionFile));
        versionWriter.write("version="+version);
        versionWriter.close();
        downloadedVersion = version;
    }
    
    public boolean hasNatives() {
        File nativesFolder = new File(STLauncher.getWorkingDirectory()+"/"+name+"/bin/natives");
        return nativesFolder.listFiles().length > 0;
    }

    @Override
    public String toString() {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

}
