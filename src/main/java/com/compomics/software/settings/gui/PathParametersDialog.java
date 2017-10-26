package com.compomics.software.settings.gui;

import com.compomics.util.Util;
import com.compomics.software.settings.PathKey;
import com.compomics.software.settings.UtilitiesPathParameters;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import no.uib.jsparklines.extra.TrueFalseIconRenderer;

/**
 * Dialog used to set paths.
 *
 * @author Marc Vaudel
 */
public class PathParametersDialog extends javax.swing.JDialog {

    /**
     * Boolean indicating whether the process was canceled by the user.
     */
    private boolean canceled = false;
    /**
     * Original map of the paths to set.
     */
    private HashMap<PathKey, String> originalKeyToPathMap = null;
    /**
     * Map of the paths to set.
     */
    private HashMap<PathKey, String> keyToPathMap = null;
    /**
     * List of paths.
     */
    private ArrayList<PathKey> keyList = null;
    /**
     * Name to key map.
     */
    private HashMap<String, PathKey> nameToKey = null;
    /**
     * The tool name.
     */
    private final String toolName;
    /**
     * Tooltips for the paths.
     */
    private final ArrayList<String> pathsToolTips;
    /**
     * The path table column header tooltips.
     */
    private ArrayList<String> pathTableToolTips;

    /**
     * Creates a new PathSettingsDialog.
     *
     * @param parent the parent frame
     * @param toolName the tool name
     * @param keyToPathMap the initial path settings
     */
    public PathParametersDialog(java.awt.Frame parent, String toolName, HashMap<PathKey, String> keyToPathMap) {
        super(parent, true);

        this.toolName = toolName;
        this.originalKeyToPathMap = keyToPathMap;
        this.keyToPathMap = (HashMap<PathKey, String>) keyToPathMap.clone();
        nameToKey = new HashMap<>(keyToPathMap.size());
        for (PathKey key : keyToPathMap.keySet()) {
            nameToKey.put(key.getId(), key);
        }
        ArrayList<String> names = new ArrayList<>(nameToKey.keySet());
        Collections.sort(names);
        keyList = new ArrayList<>(names.size());
        pathsToolTips = new ArrayList<>(names.size());
        for (String name : names) {
            PathKey pathKey = nameToKey.get(name);
            keyList.add(pathKey);
            pathsToolTips.add(pathKey.getDescription());
        }

        initComponents();
        setUpGUI(parent, toolName);
        setLocationRelativeTo(parent);
        setTitle("Resource Folders");
        setVisible(true);
    }

    /**
     * Sets up the GUI components.
     *
     * @param toolName the tool name
     * @param parent the parent frame
     */
    public void setUpGUI(java.awt.Frame parent, String toolName) {

        informationTxt.setText(toolName + " uses the following directories to store setting files.\n\nA warning sign indicates folders where " + toolName
                + " cannot write. Failing to save setting files can impair the tool functionality.");

        pathTable.getTableHeader().setReorderingAllowed(false);

        pathTable.getColumn(" ").setMaxWidth(30);
        pathTable.getColumn(" ").setMinWidth(30);

        pathTable.getColumn("  ").setMaxWidth(30);
        pathTable.getColumn("  ").setMinWidth(30);
        pathTable.getColumn("  ").setCellRenderer(new TrueFalseIconRenderer(
                new ImageIcon(parent.getClass().getResource("/icons/accept.png")),
                new ImageIcon(parent.getClass().getResource("/icons/warning.png")),
                "OK", "Warning"));

        // make sure that the scroll panes are see-through
        pathTableScrollPane.getViewport().setOpaque(false);

        pathTableToolTips = new ArrayList<>();
        pathTableToolTips.add(null);
        pathTableToolTips.add("Path Name");
        pathTableToolTips.add("Path");
        pathTableToolTips.add("Path Check");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pathSettingsPopupMenu = new javax.swing.JPopupMenu();
        editPathMenuItem = new javax.swing.JMenuItem();
        setDefaultPath = new javax.swing.JMenuItem();
        pathSettingsJPanel = new javax.swing.JPanel();
        cancelButton = new javax.swing.JButton();
        okButton = new javax.swing.JButton();
        tablePanel = new javax.swing.JPanel();
        pathTableScrollPane = new javax.swing.JScrollPane();
        pathTable = new JTable() {
            protected JTableHeader createDefaultTableHeader() {
                return new JTableHeader(columnModel) {
                    public String getToolTipText(MouseEvent e) {
                        java.awt.Point p = e.getPoint();
                        int index = columnModel.getColumnIndexAtX(p.x);
                        int realIndex = columnModel.getColumn(index).getModelIndex();
                        String tip = (String) pathTableToolTips.get(realIndex);
                        return tip;
                    }
                };
            }
        };
        helpLabel = new javax.swing.JLabel();
        informationPanel = new javax.swing.JPanel();
        informationScrollPane = new javax.swing.JScrollPane();
        informationTxt = new javax.swing.JTextArea();

        editPathMenuItem.setText("Edit Path");
        editPathMenuItem.setToolTipText("Edit Selected Path");
        editPathMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editPathMenuItemActionPerformed(evt);
            }
        });
        pathSettingsPopupMenu.add(editPathMenuItem);

        setDefaultPath.setText("Set Default Path");
        setDefaultPath.setToolTipText("Set a path for all files");
        setDefaultPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setDefaultPathActionPerformed(evt);
            }
        });
        pathSettingsPopupMenu.add(setDefaultPath);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pathSettingsJPanel.setBackground(new java.awt.Color(230, 230, 230));

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        okButton.setText("OK");
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        tablePanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Path Settings"));
        tablePanel.setOpaque(false);

        pathTableScrollPane.setOpaque(false);

        pathTable.setModel(new PathsTableModel());
        pathTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pathTableMouseReleased(evt);
            }
        });
        pathTableScrollPane.setViewportView(pathTable);

        javax.swing.GroupLayout tablePanelLayout = new javax.swing.GroupLayout(tablePanel);
        tablePanel.setLayout(tablePanelLayout);
        tablePanelLayout.setHorizontalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        tablePanelLayout.setVerticalGroup(
            tablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tablePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathTableScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                .addContainerGap())
        );

        helpLabel.setFont(new java.awt.Font("Tahoma", 2, 11)); // NOI18N
        helpLabel.setText("Right-click to edit the paths");

        informationPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Information"));
        informationPanel.setOpaque(false);

        informationTxt.setEditable(false);
        informationTxt.setColumns(20);
        informationTxt.setLineWrap(true);
        informationTxt.setRows(5);
        informationTxt.setWrapStyleWord(true);
        informationTxt.setOpaque(false);
        informationScrollPane.setViewportView(informationTxt);

        javax.swing.GroupLayout informationPanelLayout = new javax.swing.GroupLayout(informationPanel);
        informationPanel.setLayout(informationPanelLayout);
        informationPanelLayout.setHorizontalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationScrollPane)
                .addContainerGap())
        );
        informationPanelLayout.setVerticalGroup(
            informationPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(informationPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pathSettingsJPanelLayout = new javax.swing.GroupLayout(pathSettingsJPanel);
        pathSettingsJPanel.setLayout(pathSettingsJPanelLayout);
        pathSettingsJPanelLayout.setHorizontalGroup(
            pathSettingsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pathSettingsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pathSettingsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pathSettingsJPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(helpLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(okButton, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelButton))
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informationPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pathSettingsJPanelLayout.setVerticalGroup(
            pathSettingsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pathSettingsJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(informationPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pathSettingsJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cancelButton)
                    .addComponent(okButton)
                    .addComponent(helpLabel))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pathSettingsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pathSettingsJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Edit the selected path.
     *
     * @param evt
     */
    private void editPathMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editPathMenuItemActionPerformed
        editSelectedPath();
    }//GEN-LAST:event_editPathMenuItemActionPerformed

    /**
     * Set the default path.
     *
     * @param evt
     */
    private void setDefaultPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setDefaultPathActionPerformed
        setDefaultPath();
    }//GEN-LAST:event_setDefaultPathActionPerformed

    /**
     * Edit the selected path.
     *
     * @param evt
     */
    private void pathTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pathTableMouseReleased
        if (evt != null && pathTable.rowAtPoint(evt.getPoint()) != -1) {
            pathTable.setRowSelectionInterval(pathTable.rowAtPoint(evt.getPoint()), pathTable.rowAtPoint(evt.getPoint()));
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON3 && pathTable.getSelectedRow() != -1) {
            pathSettingsPopupMenu.show(pathTable, evt.getX(), evt.getY());
        }
        if (evt != null && evt.getButton() == MouseEvent.BUTTON1 && evt.getClickCount() == 2) {
            editSelectedPath();
        }
    }//GEN-LAST:event_pathTableMouseReleased

    /**
     * Save the paths and restart the tool if a change was detected.
     *
     * @param evt
     */
    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed

        boolean changed = false;
        for (PathKey pathKey : originalKeyToPathMap.keySet()) {
            String newPath = keyToPathMap.get(pathKey);
            String originalPath = originalKeyToPathMap.get(pathKey);
            if ((newPath != null && originalPath == null)
                    || (newPath == null && originalPath != null)
                    || (newPath != null && originalPath != null && !originalPath.equals(newPath))) {
                changed = true;
                break;
            }
        }

        if (changed) {
            int outcome = JOptionPane.showConfirmDialog(this,
                    toolName + " needs to restart in order to take the new settings into account. Restart now?",
                    "Restart Requested", JOptionPane.YES_NO_CANCEL_OPTION);
            if (outcome == JOptionPane.YES_OPTION) {
                dispose();
            } else if (outcome == JOptionPane.NO_OPTION) {
                canceled = true;
                dispose();
            } else { // cancel
                // do nothing
            }
        } else {
            canceled = true;
            dispose();
        }
    }//GEN-LAST:event_okButtonActionPerformed

    /**
     * Close the dialog without saving the changes.
     *
     * @param evt
     */
    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        canceled = true;
        dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * Close the dialog without saving the changes.
     *
     * @param evt
     */
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        canceled = true;
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JMenuItem editPathMenuItem;
    private javax.swing.JLabel helpLabel;
    private javax.swing.JPanel informationPanel;
    private javax.swing.JScrollPane informationScrollPane;
    private javax.swing.JTextArea informationTxt;
    private javax.swing.JButton okButton;
    private javax.swing.JPanel pathSettingsJPanel;
    private javax.swing.JPopupMenu pathSettingsPopupMenu;
    private javax.swing.JTable pathTable;
    private javax.swing.JScrollPane pathTableScrollPane;
    private javax.swing.JMenuItem setDefaultPath;
    private javax.swing.JPanel tablePanel;
    // End of variables declaration//GEN-END:variables

    /**
     * Edits the selected path.
     */
    private void editSelectedPath() {
        int selectedRow = pathTable.getSelectedRow();
        String name = (String) pathTable.getValueAt(selectedRow, 1);
        PathKey pathKey = nameToKey.get(name);
        File selectedFile = Util.getUserSelectedFolder(this, "Select " + pathKey.getId() + " Folder", keyToPathMap.get(pathKey), pathKey.getId() + " Folder", "Select", false);
        if (selectedFile != null) {
            keyToPathMap.put(pathKey, selectedFile.getAbsolutePath());
            ((DefaultTableModel) pathTable.getModel()).fireTableDataChanged();
        }
    }

    /**
     * Sets a default path.
     */
    private void setDefaultPath() {
        File selectedFile = Util.getUserSelectedFolder(this, "Select Default Folder", null, "Default Folder", "Select", false);
        if (selectedFile != null) {
            for (PathKey pathKey : keyToPathMap.keySet()) {
                keyToPathMap.put(pathKey, selectedFile.getAbsolutePath());
            }
            ((DefaultTableModel) pathTable.getModel()).fireTableDataChanged();
        }
    }

    /**
     * Indicates whether the action was canceled by the user. (Or if no changes
     * where made to the settings.)
     *
     * @return true if the action was canceled by the user
     */
    public boolean isCanceled() {
        return canceled;
    }

    /**
     * Returns the path settings in a map: key | path.
     *
     * @return the path settings in a map
     */
    public HashMap<PathKey, String> getKeyToPathMap() {
        return keyToPathMap;
    }

    /**
     * Table model for the Paths table.
     */
    private class PathsTableModel extends DefaultTableModel {

        /**
         * Creates a new table model.
         */
        public PathsTableModel() {
        }

        @Override
        public int getRowCount() {
            if (keyToPathMap == null) {
                return 0;
            }
            return keyToPathMap.size();
        }

        @Override
        public int getColumnCount() {
            return 4;
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return " ";
                case 1:
                    return "Name";
                case 2:
                    return "Path";
                case 3:
                    return "  ";
                default:
                    return "";
            }
        }

        @Override
        public Object getValueAt(int row, int column) {
            PathKey pathKey = keyList.get(row);
            switch (column) {
                case 0:
                    return row + 1;
                case 1:
                    return pathKey.getId();
                case 2:
                    String path = keyToPathMap.get(pathKey);
                    if (path != null) {
                        File file = new File(path);
                        return file.getAbsolutePath();
                    } else {
                        return "Default";
                    }
                case 3:
                    String folderPath = keyToPathMap.get(pathKey);
                    if (folderPath != null) {
                        return UtilitiesPathParameters.testPath(folderPath);
                    }
                    return true;
                default:
                    return "";
            }
        }

        @Override
        public Class getColumnClass(int columnIndex) {
            for (int i = 0; i < getRowCount(); i++) {
                if (getValueAt(i, columnIndex) != null) {
                    return getValueAt(i, columnIndex).getClass();
                }
            }
            return String.class;
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return false;
        }
    }
}