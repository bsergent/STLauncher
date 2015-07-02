/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.challengercity.launcher;

import java.awt.Desktop;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;

/**
 *
 * @author Ben Sergent V <bsergentv@gmail.com>
 */
public class STLauncher extends javax.swing.JFrame {

    /**
     * Creates new form STLauncher
     */
    public STLauncher() {
        initComponents();
        
        prefs = java.util.prefs.Preferences.userRoot();
        prefs = prefs.node("com.challengercity.launcher.prefs");
        usernameField.setText(prefs.get("username",""));
        if (!"".equals(prefs.get("username",""))) {
            rememLoginCheck.setSelected(true);
            passwordField.requestFocus(); // This doesn't really work
        }
        
        desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
        canOpenWebpages = desktop != null && desktop.isSupported(Desktop.Action.BROWSE);
        
        this.setTitle("Sergent-Tech Launcher - v"+VERSION);
        
        switchVisiblePanel(loginPanel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        loginPanel = new javax.swing.JPanel();
        usernameField = new javax.swing.JTextField();
        passwordField = new javax.swing.JPasswordField();
        loginButton = new javax.swing.JButton();
        createAcctButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        rememLoginCheck = new javax.swing.JCheckBox();
        offlineButton = new javax.swing.JButton();
        loginFeedbackLabel = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        updateButton = new javax.swing.JButton();
        playButton = new javax.swing.JButton();
        mainProgress = new javax.swing.JProgressBar();
        loginLogoutButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        productList = new javax.swing.JList();
        productPanel = new javax.swing.JPanel();
        productTitle = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        descriptionPane = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        newsEditorPane = new javax.swing.JEditorPane();
        websiteButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sergent-Tech Launcher");
        setLocationByPlatform(true);
        getContentPane().setLayout(new java.awt.CardLayout());

        loginPanel.setPreferredSize(new java.awt.Dimension(600, 350));
        loginPanel.setSize(new java.awt.Dimension(600, 350));

        usernameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                usernameFieldKeyPressed(evt);
            }
        });

        passwordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordFieldKeyPressed(evt);
            }
        });

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        createAcctButton.setText("Create Account");
        createAcctButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createAcctButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sergent-Tech Login");

        jLabel2.setLabelFor(usernameField);
        jLabel2.setText("Username/Email:");

        jLabel3.setLabelFor(passwordField);
        jLabel3.setText("Password:");

        rememLoginCheck.setText("Remember me");

        offlineButton.setText("Offline");
        offlineButton.setEnabled(false);
        offlineButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                offlineButtonActionPerformed(evt);
            }
        });

        loginFeedbackLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout loginPanelLayout = new javax.swing.GroupLayout(loginPanel);
        loginPanel.setLayout(loginPanelLayout);
        loginPanelLayout.setHorizontalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(loginPanelLayout.createSequentialGroup()
                        .addContainerGap(137, Short.MAX_VALUE)
                        .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, loginPanelLayout.createSequentialGroup()
                                    .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(rememLoginCheck)
                                        .addGroup(loginPanelLayout.createSequentialGroup()
                                            .addComponent(createAcctButton)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(offlineButton)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(loginButton))
                                .addComponent(passwordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(loginFeedbackLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 137, Short.MAX_VALUE)))
                .addContainerGap())
        );
        loginPanelLayout.setVerticalGroup(
            loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(loginPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rememLoginCheck)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(loginPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createAcctButton)
                    .addComponent(loginButton)
                    .addComponent(offlineButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginFeedbackLabel)
                .addGap(37, 37, 37))
        );

        getContentPane().add(loginPanel, "card2");

        mainPanel.setSize(new java.awt.Dimension(600, 350));

        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        playButton.setText("Play");
        playButton.setToolTipText("");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        mainProgress.setEnabled(false);

        loginLogoutButton.setText("Logout");
        loginLogoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginLogoutButtonActionPerformed(evt);
            }
        });

        productList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Datura", "Tanks", "Hedgehog", "ClickSpeed" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        productList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                productListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(productList);

        productPanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        productTitle.setFont(new java.awt.Font("Lucida Sans Typewriter", 0, 24)); // NOI18N
        productTitle.setText("Product");

        jLabel5.setText("Description");

        jLabel6.setText("News");

        descriptionPane.setEditable(false);
        jScrollPane4.setViewportView(descriptionPane);

        newsEditorPane.setEditable(false);
        jScrollPane5.setViewportView(newsEditorPane);

        websiteButton.setText("Website");
        websiteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                websiteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout productPanelLayout = new javax.swing.GroupLayout(productPanel);
        productPanel.setLayout(productPanelLayout);
        productPanelLayout.setHorizontalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addComponent(productTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(websiteButton)
                        .addContainerGap())
                    .addGroup(productPanelLayout.createSequentialGroup()
                        .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(productPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addContainerGap(213, Short.MAX_VALUE))
                            .addComponent(jScrollPane5)))))
        );
        productPanelLayout.setVerticalGroup(
            productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(productPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(productTitle)
                    .addComponent(websiteButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(productPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5)
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(loginLogoutButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mainProgress, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(playButton)))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addComponent(productPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(loginLogoutButton)
                    .addComponent(mainProgress, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playButton)
                        .addComponent(updateButton)))
                .addContainerGap())
        );

        getContentPane().add(mainPanel, "card3");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        try {
            Product prod = (Product) productList.getSelectedValue();
            String nativesPath = getWorkingDirectory()+"/"+prod.name+"/bin/natives/";
            if (prod.hasNatives()) {
                String OS = (System.getProperty("os.name")).toUpperCase();
                if (OS.contains("WIN")) {
                    nativesPath += "windows";
                } else if (OS.contains("MAC")) {
                    nativesPath += "macosx";
                } else {
                    nativesPath += "linux";
                }
                nativesPath += "/";
                debugMessage("Path: "+nativesPath);
            }
            
            Process proc = Runtime.getRuntime().exec(new String[]{"java",
                "-jar",
                "-Djava.library.path="+nativesPath,
                STLauncher.getWorkingDirectory()+"/"+prod.name+"/bin/"+prod+".jar",
                sessionID});
            // TODO Allow RAM selection -Xmx2048m
//            System.exit(0);
            
            proc.waitFor();
            
            InputStream in = proc.getInputStream();
            InputStream err = proc.getErrorStream();

            byte b[]=new byte[in.available()];
            in.read(b,0,b.length);
            System.out.println(new String(b));

            byte c[]=new byte[err.available()];
            err.read(c,0,c.length);
            System.out.println(new String(c));
            
        } catch (Exception ex) {
            Logger.getLogger(STLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_playButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        attemptLogin();
    }//GEN-LAST:event_loginButtonActionPerformed

    private void loginLogoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginLogoutButtonActionPerformed
        switchVisiblePanel(loginPanel);
        sessionID = "";
        username = "";
    }//GEN-LAST:event_loginLogoutButtonActionPerformed

    private void usernameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_usernameFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            passwordField.requestFocus();
        }
    }//GEN-LAST:event_usernameFieldKeyPressed

    private void passwordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordFieldKeyPressed
        if (evt.getKeyCode() == java.awt.event.KeyEvent.VK_ENTER) {
            attemptLogin();
        }
    }//GEN-LAST:event_passwordFieldKeyPressed

    private void offlineButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_offlineButtonActionPerformed
        loginLogoutButton.setText("Login");
        
        switchVisiblePanel(mainPanel);
        
        // TODO Show downloaded projects when offline
    }//GEN-LAST:event_offlineButtonActionPerformed

    private void productListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_productListValueChanged
        showProduct((Product) productList.getSelectedValue());
    }//GEN-LAST:event_productListValueChanged

    private void createAcctButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createAcctButtonActionPerformed
        if (canOpenWebpages) {
            try {
                desktop.browse(new URI("http://challengercity.com/v4/account/frontend/createAccount.php"));
                loginFeedbackLabel.setText("Login here after creating an account");
            } catch (URISyntaxException | IOException e) {
                loginFeedbackLabel.setText("Please visit http://challengercity.com/");
            }
        } else {
            loginFeedbackLabel.setText("Please visit http://challengercity.com/");
        }
    }//GEN-LAST:event_createAcctButtonActionPerformed

    private void websiteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_websiteButtonActionPerformed
        if (canOpenWebpages) {
            try {
                Product selProd = (Product) productList.getSelectedValue();
                desktop.browse(new URI(selProd.website));
            } catch (URISyntaxException | IOException e) {
                // Do nothing
            }
        } else {
            websiteButton.setEnabled(false);
        }
    }//GEN-LAST:event_websiteButtonActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed

        updateButton.setEnabled(false);
        
        currentDownload = new DownloadWorker((Product) productList.getSelectedValue(), mainProgress);
        currentDownload.addPropertyChangeListener(new DownloadProgressListener());
        currentDownload.execute();
        
    }//GEN-LAST:event_updateButtonActionPerformed

    private class DownloadProgressListener implements PropertyChangeListener {
        
        private String taskName = "";
        private int progress = 0;

        @Override
        public void propertyChange(PropertyChangeEvent evt) {
            if ("progress".equals(evt.getPropertyName()) && evt.getNewValue() instanceof Integer) {
                progress = (int) evt.getNewValue();
            } else if ("task".equals(evt.getPropertyName())) {
                taskName = (String) evt.getNewValue();
            } else if ("state".equals(evt.getPropertyName()) && evt.getNewValue() == DownloadWorker.StateValue.DONE) {
                currentDownload = null;
                playButton.setEnabled(true);
            }
            //debugMessage("Property "+evt.getPropertyName()+" changed to "+evt.getNewValue());
            
            mainProgress.setString(taskName+" - "+progress+"%");
            mainProgress.setValue(progress);
        }
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(STLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(STLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(STLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(STLauncher.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new STLauncher().setVisible(true);
            }
        });
    }
    
    
    public static void debugMessage(String msg) {
        if (DEBUG) {
            System.out.println("[DEBUG] "+msg);
        }
    }
    
    public void switchVisiblePanel(JPanel panel) {
        loginPanel.setVisible(false);
        mainPanel.setVisible(false);
        panel.setVisible(true);
    }
    
    public void attemptLogin() {
        loginFeedbackLabel.setText("");
        
        if (rememLoginCheck.isSelected()) {
            prefs.put("username", usernameField.getText());
        } else {
            prefs.put("username", "");
        }
        
        try {
            // Attempt Login
            String urlAddress = "http://challengercity.com/v4/account/login.php";
            String query = "usernameOrEmail="+usernameField.getText()+"&password="+passwordField.getText()+"&product=stLauncher&expiration=1day";
            debugMessage("URL: "+urlAddress);
            URLConnection connection = new URL(urlAddress).openConnection();
            connection.setDoOutput(true); // Triggers POST.
            //connection.setRequestProperty("Accept-Charset", charset);
            //connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=" + charset);
            
            OutputStream output = connection.getOutputStream();
            output.write(query.getBytes());
            
            BufferedReader postIn = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String postInputLine;
            String postResult = "";
            while ((postInputLine = postIn.readLine()) != null) 
                postResult = postResult + postInputLine;
            postIn.close();
            
            debugMessage("Post Result: "+postResult);
            
            String[] splitPostResult = postResult.split(Character.toString((char) 31));
            
            if (splitPostResult[0].equals("1")) {
                sessionID = splitPostResult[1];
                username = splitPostResult[3];
                loginLogoutButton.setText("Logout");
                
                updateProducts();
                
                switchVisiblePanel(mainPanel);
            } else {
                loginFeedbackLabel.setText("Incorrect username/password combination");
            }
        } catch (Exception ex) {
            loginFeedbackLabel.setText("Could not connect to login servers");
        }
        
        passwordField.setText("");
    }
    
    public void updateProducts() {
        try {
            URLConnection productsConnection = new URL("http://challengercity.com/v4/getProducts.php").openConnection();
            BufferedReader productsIn = new BufferedReader(new InputStreamReader(productsConnection.getInputStream()));
            String productsInputLine;
            String productsResult = "";
            while ((productsInputLine = productsIn.readLine()) != null)
                productsResult = productsResult+productsInputLine;
            productsIn.close();
            
            rawProductList.clear();
            String[] sa = productsResult.split(Character.toString((char) 29));
            if ("1".equals(sa[0])) {
                for (int i = 1; i < sa.length; i++) {
                    String[] saa = sa[i].split(Character.toString((char) 31));
                    Product prod = new Product(
                            Integer.parseInt(saa[0]),
                            saa[1],
                            saa[2],
                            saa[3], 
                            "1".equals(saa[4]),
                            "1".equals(saa[5]),
                            Float.parseFloat(saa[6]),
                            saa.length>7?saa[7]:null,
                            saa.length>8?saa[8]:null,
                            saa.length>9?saa[9]:null,
                            saa.length>10?saa[10]:null,
                            saa.length>11?saa[11]:null);
                    rawProductList.add(prod);
                    debugMessage(prod.toString()+" v"+prod.version);
                }
                
                for (Product prod : rawProductList) {
                    if ("stLauncher".equals(prod.name)) {
                        prod.downloadedVersion = VERSION;
                        if (prod.isOutdated()) {
                            this.setTitle("Sergent-Tech Launcher - v"+VERSION+" - Outdated");
                            STLauncher.debugMessage("Update for launcher avaliable");
                        } else {
                            STLauncher.debugMessage("Launcher up to date");
                        }
                        break;
                    }
                }
            } else {
                System.out.println("Failed to fetch product list from server");
            }
        } catch (IOException | NumberFormatException ex) {
            System.out.println("Failed to fetch product list from server");
        }
        
        Product prodToSel = null;
        
        DefaultListModel productModel = new DefaultListModel();
        for (Product rProd : rawProductList) {
            if (rProd.showInLauncher) {
                productModel.addElement(rProd);
                prodToSel = rProd;
            }
        }
        
        productList.setModel(productModel);
        
        if (prodToSel != null) {
            productList.setSelectedValue(prodToSel, true);
        }
    }
    
    public void showProduct(Product newProd) {
        productTitle.setText(newProd.toString() + " v" + newProd.version);
        descriptionPane.setText(newProd.desc);
        websiteButton.setEnabled(!"".equals(newProd.website));
        updateButton.setEnabled(newProd.isOutdated());
        playButton.setEnabled(!newProd.isOutdated() || (!newProd.forceLatest && !"".equals(newProd.downloadedVersion)));
        
        if ("".equals(newProd.downloadedVersion)) {
            updateButton.setText("Download");
        } else {
            updateButton.setText("Update");
        }
        
        if (currentDownload != null) {
            updateButton.setEnabled(false);
        }
    }
    
    public static String getWorkingDirectory() {
        String workingDirectory;
        String OS = (System.getProperty("os.name")).toUpperCase();
        if (OS.contains("WIN")) {
            workingDirectory = System.getenv("AppData");
        } else { // Linux or Mac
            workingDirectory = System.getProperty("user.home");
            workingDirectory += "/Library/Application Support";
        }
        return workingDirectory;
    }
    
    private static java.util.prefs.Preferences prefs;
    private static final boolean DEBUG = true;
    private static final String VERSION = "0.1.0A";
    private static boolean canOpenWebpages = true;
    private static Desktop desktop;
    private String sessionID = "";
    private String username = "";
    private ArrayList<Product> rawProductList = new ArrayList<>();
    private DownloadWorker currentDownload;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton createAcctButton;
    private javax.swing.JTextPane descriptionPane;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel loginFeedbackLabel;
    private javax.swing.JButton loginLogoutButton;
    private javax.swing.JPanel loginPanel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JProgressBar mainProgress;
    private javax.swing.JEditorPane newsEditorPane;
    private javax.swing.JButton offlineButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JButton playButton;
    private javax.swing.JList productList;
    private javax.swing.JPanel productPanel;
    private javax.swing.JLabel productTitle;
    private javax.swing.JCheckBox rememLoginCheck;
    private javax.swing.JButton updateButton;
    private javax.swing.JTextField usernameField;
    private javax.swing.JButton websiteButton;
    // End of variables declaration//GEN-END:variables
}
