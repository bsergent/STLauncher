
package com.challengercity.launcher;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 *
 * @author Ben Sergent V/ha1fBit
 */
public class DownloadWorker extends SwingWorker<Integer, Integer> {
    
    private Product product;
    private JProgressBar bar;
    private int userId;

    public DownloadWorker(Product product, JProgressBar bar, int userId) {
        this.product = product;
        this.bar = bar;
        this.userId = userId;
    }

    @Override
    protected Integer doInBackground() throws Exception {
        
        /* Set up progress bar */
        bar.setEnabled(true);
        bar.setMinimum(0);
        bar.setMaximum(100);
        bar.setValue(0);
        bar.setStringPainted(true);
        
        firePropertyChange("task", "", "Creating directories");
        product.createDirectory();
        
        firePropertyChange("task", "", "Downloading "+product);
        
        // Open connection
        URL mainUrl = new URL(product.file);
        int mainLength = mainUrl.openConnection().getContentLength();
        InputStream mainReader = mainUrl.openStream();
        FileOutputStream mainWriter = new FileOutputStream(STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/"+product.name+".zip");
        
        URL libUrl = new URL(product.libFile);
        int libLength = libUrl.openConnection().getContentLength();
        InputStream libReader = libUrl.openStream();
        FileOutputStream libWriter = new FileOutputStream(STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/"+product.name+"-lib.zip");
        
        
        int entireLength = mainLength;
        
        if (product.isLibOutdated()) {
            entireLength = entireLength + libLength;
        }
        STLauncher.debugMessage("Downloading "+entireLength+" bytes");
        

        // Download routine
        byte[] buffer = new byte[153600]; // 153600
        int totalBytesRead = 0;
        int bytesRead = 0;
        
        while ((bytesRead = mainReader.read(buffer)) > 0) {
            mainWriter.write(buffer, 0, bytesRead);
            buffer = new byte[153600];
            totalBytesRead += bytesRead;
            setProgress((int) (((float)totalBytesRead) / ((float)entireLength) * 100));
        }
        if (product.isLibOutdated()) {
            firePropertyChange("task", "", "Downloading libraries");
            while ((bytesRead = libReader.read(buffer)) > 0) {
                libWriter.write(buffer, 0, bytesRead);
                buffer = new byte[153600];
                totalBytesRead += bytesRead;
                setProgress((int) (((float)totalBytesRead) / ((float)entireLength) * 100));
            }
        }
        // TODO Make sure this actually overwrites files
        // TODO Load the track downloads page at http://challengercity.com/v4/trackDownload.php?product=datura
        // TODO Check if only updating
        URLConnection productsConnection = new URL("http://challengercity.com/v4/trackDownload.php?product="+product.name+"&userId="+userId).openConnection();
        BufferedReader productsIn = new BufferedReader(new InputStreamReader(productsConnection.getInputStream()));
        productsIn.close();
        
         
        mainWriter.close();
        mainReader.close();
        libWriter.close();
        libReader.close();
        
        firePropertyChange("task", "", "Unpacking files");
        unzipFile(STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/"+product.name+".zip", STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/");
        unzipFile(STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/"+product.name+"-lib.zip", STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/");
        File resFile = new File(STLauncher.getWorkingDirectory()+"/"+product.name+"/bin/resources");
        if (resFile.exists()) {
            Files.move(resFile.toPath(), new File(STLauncher.getWorkingDirectory()+"/"+product.name+"/resources").toPath(), REPLACE_EXISTING);
        }
        
        firePropertyChange("task", "", "Updating version file");
        product.updateVersionFile();

        setProgress(100);
        firePropertyChange("task", "", "Finished downloading "+product);
        
        return 42;
    }
    
    private void unzipFile(String zipFilePath, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        File zipFile = new File(zipFilePath);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        ZipInputStream zipIn = new ZipInputStream(new FileInputStream(zipFile));
        ZipEntry entry = zipIn.getNextEntry();
        // iterates over entries in the zip file
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                // if the entry is a file, extracts it
                BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
                byte[] bytesIn = new byte[4096];
                int read = 0;
                while ((read = zipIn.read(bytesIn)) != -1) {
                    bos.write(bytesIn, 0, read);
                }
                bos.close();
            } else {
                // if the entry is a directory, make the directory
                File dir = new File(filePath);
                dir.mkdir();
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
        zipFile.delete();
    }

}
