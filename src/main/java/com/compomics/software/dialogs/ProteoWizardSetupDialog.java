package com.compomics.software.dialogs;

import com.compomics.util.Util;
import com.compomics.util.examples.BareBonesBrowserLaunch;
import com.compomics.util.preferences.UtilitiesUserPreferences;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * A dialog used to set up the connection to ProteoWizard.
 *
 * @author Marc Vaudel
 * @author Harald Barsnes
 */
public class ProteoWizardSetupDialog extends javax.swing.JDialog {

    /**
     * The utilities preferences.
     */
    private UtilitiesUserPreferences utilitiesUserPreferences;
    /**
     * The selected folder.
     */
    private String lastSelectedFolder = "";
    /**
     * Set to true if the dialog was canceled.
     */
    private boolean dialogCanceled = true;

    /**
     * Creates a new ProteoWizardSetupDialog.
     *
     * @param parent the parent dialog
     * @param modal if the dialog is to be modal or not
     *
     * @throws FileNotFoundException if a FileNotFoundException occurs
     * @throws IOException if an IOException occurs
     * @throws ClassNotFoundException if a ClassNotFoundException occurs
     */
    public ProteoWizardSetupDialog(JFrame parent, boolean modal) throws FileNotFoundException, IOException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setUpGUI();
    }

    /**
     * Creates a new ProteoWizardSetupDialog.
     *
     * @param parent the parent dialog
     * @param modal if the dialog is to be modal or not
     * @throws FileNotFoundException if a FileNotFoundException occurs
     * @throws IOException if an IOException occurs
     * @throws ClassNotFoundException if a ClassNotFoundException occurs
     */
    public ProteoWizardSetupDialog(JDialog parent, boolean modal) throws FileNotFoundException, IOException, ClassNotFoundException {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setUpGUI();
    }

    /**
     * Set up the GUI.
     */
    private void setUpGUI() {

        utilitiesUserPreferences = UtilitiesUserPreferences.loadUserPreferences();

        if (utilitiesUserPreferences.getProteoWizardPath() == null) {
            int option = JOptionPane.showConfirmDialog(this, "Cannot find ProteoWizard. Do you want to download it now?", "Download ProteoWizard?", JOptionPane.YES_NO_OPTION);

            if (option == JOptionPane.YES_OPTION) {
                openWebPage();
            }
        }

        // display the current path
        if (utilitiesUserPreferences != null) {
            installationJTextField.setText(utilitiesUserPreferences.getProteoWizardPath());
            lastSelectedFolder = utilitiesUserPreferences.getProteoWizardPath();
        }

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        backgroundPanel = new javax.swing.JPanel();
        installationPanel = new javax.swing.JPanel();
        installationJTextField = new javax.swing.JTextField();
        browseButton = new javax.swing.JButton();
        folderHelpLabel = new javax.swing.JLabel();
        downloadPanel = new javax.swing.JPanel();
        infoLabel = new javax.swing.JLabel();
        downloadLinkLabel = new javax.swing.JLabel();
        iconButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("ProteoWizard Settings");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        backgroundPanel.setBackground(new java.awt.Color(230, 230, 230));

        installationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("ProteoWizard Installation"));
        installationPanel.setOpaque(false);

        installationJTextField.setEditable(false);
        installationJTextField.setToolTipText("The folder containing the PeptideShaker jar file.");

        browseButton.setText("Browse");
        browseButton.setToolTipText("The folder containing the PeptideShaker jar file.");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        folderHelpLabel.setFont(folderHelpLabel.getFont().deriveFont((folderHelpLabel.getFont().getStyle() | java.awt.Font.ITALIC)));
        folderHelpLabel.setText("Please locate the ProteoWizard installation folder.");

        javax.swing.GroupLayout installationPanelLayout = new javax.swing.GroupLayout(installationPanel);
        installationPanel.setLayout(installationPanelLayout);
        installationPanelLayout.setHorizontalGroup(
            installationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, installationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(installationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(installationPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(folderHelpLabel))
                    .addComponent(installationJTextField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(browseButton)
                .addContainerGap())
        );
        installationPanelLayout.setVerticalGroup(
            installationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(installationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(installationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(installationJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(folderHelpLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        downloadPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Download ProteoWizard"));
        downloadPanel.setOpaque(false);

        infoLabel.setFont(infoLabel.getFont().deriveFont(infoLabel.getFont().getStyle() | java.awt.Font.BOLD));
        infoLabel.setText("ProteoWizard - open-source and cross-platform proteomics data analysis");

        downloadLinkLabel.setText("<html>Download here: <a href> http://proteowizard.sourceforge.net</a></html>");
        downloadLinkLabel.setToolTipText("Go to http://proteowizard.sourceforge.net");
        downloadLinkLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                downloadLinkLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                downloadLinkLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                downloadLinkLabelMouseExited(evt);
            }
        });

        iconButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/pwiz_purple_logo.png"))); // NOI18N
        iconButton.setToolTipText("Go to http://proteowizard.sourceforge.net");
        iconButton.setBorderPainted(false);
        iconButton.setContentAreaFilled(false);
        iconButton.setFocusPainted(false);
        iconButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iconButtonMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                iconButtonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                iconButtonMouseExited(evt);
            }
        });

        javax.swing.GroupLayout downloadPanelLayout = new javax.swing.GroupLayout(downloadPanel);
        downloadPanel.setLayout(downloadPanelLayout);
        downloadPanelLayout.setHorizontalGroup(
            downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downloadPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(infoLabel)
                    .addComponent(downloadLinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 96, Short.MAX_VALUE)
                .addComponent(iconButton)
                .addContainerGap())
        );
        downloadPanelLayout.setVerticalGroup(
            downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(downloadPanelLayout.createSequentialGroup()
                .addGroup(downloadPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(downloadPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(infoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(downloadLinkLabel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(iconButton))
                .addGap(4, 4, 4))
        );

        okButton.setText("OK");
        okButton.setEnabled(false);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout backgroundPanelLayout = new javax.swing.GroupLayout(backgroundPanel);
        backgroundPanel.setLayout(backgroundPanelLayout);
        backgroundPanelLayout.setHorizontalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downloadPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(okButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(installationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        backgroundPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelButton, okButton});

        backgroundPanelLayout.setVerticalGroup(
            backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(installationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downloadPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(backgroundPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Close the dialog without saving.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Open a file chooser were the user can select the installation folder.
     *
     * @param evt
     */
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed

        File selectedFile = Util.getUserSelectedFolder(this, "ProteoWizard Installation Folder", lastSelectedFolder, "ProteoWizard installation folder", "OK", true);

        if (selectedFile != null) {
            // check if it is a valid folder
            if (!new File(selectedFile, "msconvert.exe").exists()) {
                JOptionPane.showMessageDialog(this, "The selected folder is not a valid ProteoWizard folder!", "Wrong Folder Selected", JOptionPane.WARNING_MESSAGE);
                okButton.setEnabled(false);
            } else {
                // assumed to be valid folder
                lastSelectedFolder = selectedFile.getPath();
                installationJTextField.setText(lastSelectedFolder);
                okButton.setEnabled(true);
            }
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    /**
     * Save the folder in the preferences and close the dialog.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        utilitiesUserPreferences.setProteoWizardPath(installationJTextField.getText());
        try {
            UtilitiesUserPreferences.saveUserPreferences(utilitiesUserPreferences);
            dialogCanceled = false;
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "An error occurred while saving the preferences.", "Error", JOptionPane.WARNING_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Change the cursor to a hand cursor.
     *
     * @param evt
     */
    private void downloadLinkLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadLinkLabelMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_downloadLinkLabelMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void downloadLinkLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadLinkLabelMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_downloadLinkLabelMouseExited

    /**
     * Opens the web page.
     *
     * @param evt
     */
    private void downloadLinkLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_downloadLinkLabelMouseClicked
        openWebPage();
    }//GEN-LAST:event_downloadLinkLabelMouseClicked

    /**
     * Change the cursor to a hand cursor.
     *
     * @param evt
     */
    private void iconButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButtonMouseEntered
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
    }//GEN-LAST:event_iconButtonMouseEntered

    /**
     * Change the cursor back to the default cursor.
     *
     * @param evt
     */
    private void iconButtonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButtonMouseExited
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_iconButtonMouseExited

    /**
     * Opens the web page.
     *
     * @param evt
     */
    private void iconButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iconButtonMouseClicked
        openWebPage();
    }//GEN-LAST:event_iconButtonMouseClicked

    /**
     * Close the dialog without saving.
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        cancelButtonActionPerformed(null);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel backgroundPanel;
    private javax.swing.JButton browseButton;
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel downloadLinkLabel;
    private javax.swing.JPanel downloadPanel;
    private javax.swing.JLabel folderHelpLabel;
    private javax.swing.JButton iconButton;
    private javax.swing.JLabel infoLabel;
    private javax.swing.JTextField installationJTextField;
    private javax.swing.JPanel installationPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton okButton;
    // End of variables declaration//GEN-END:variables

    /**
     * Opens the ProteoWizard web page.
     */
    private void openWebPage() {
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        BareBonesBrowserLaunch.openURL("http://proteowizard.sourceforge.net");
        this.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
    }

    /**
     * Returns true of the dialog was canceled by the user.
     *
     * @return the dialogCanceled
     */
    public boolean isDialogCanceled() {
        return dialogCanceled;
    }
}