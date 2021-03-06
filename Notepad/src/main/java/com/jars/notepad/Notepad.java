/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jars.notepad;

import java.awt.FileDialog;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;

/**
 *
 * @author JARS
 */
public class Notepad extends javax.swing.JFrame {

    private String file = "";
    private String stringTime="";
    private String directory = "";
    private int gposdel = 0,hour=0;
    private String text="",flag = "n",textToSearch="";
   
    private final Date d = new Date();
    private final GregorianCalendar g = new GregorianCalendar();
    private final PrinterJob printme = PrinterJob.getPrinterJob();
    private final FileDialog openFileDialogue = new FileDialog(this,"Open",FileDialog.LOAD);
    private final FileDialog saveFileDialogue = new FileDialog(this,"Save",FileDialog.SAVE);
    
    /**
     * Creates new form Notepad
     */
    
    public Notepad() {
        initComponents();
        date();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        File = new javax.swing.JMenu();
        newFile = new javax.swing.JMenuItem();
        open = new javax.swing.JMenuItem();
        save = new javax.swing.JMenuItem();
        saveAs = new javax.swing.JMenuItem();
        pageSetup = new javax.swing.JMenuItem();
        print = new javax.swing.JMenuItem();
        exit = new javax.swing.JMenuItem();
        Edit = new javax.swing.JMenu();
        cut = new javax.swing.JMenuItem();
        copy = new javax.swing.JMenuItem();
        paste = new javax.swing.JMenuItem();
        delete = new javax.swing.JMenuItem();
        selectAll = new javax.swing.JMenuItem();
        find = new javax.swing.JMenuItem();
        dateTime = new javax.swing.JMenuItem();
        wordRap = new javax.swing.JCheckBoxMenuItem();
        help = new javax.swing.JMenu();
        about = new javax.swing.JMenuItem();
        featureUpdate = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Lucida Bright", 0, 18)); // NOI18N
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        File.setText("File");

        newFile.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFile.setText("New");
        newFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileActionPerformed(evt);
            }
        });
        File.add(newFile);

        open.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        open.setText("Open");
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionPerformed(evt);
            }
        });
        File.add(open);

        save.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        File.add(save);

        saveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F12, 0));
        saveAs.setText("Save As");
        saveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsActionPerformed(evt);
            }
        });
        File.add(saveAs);

        pageSetup.setText("Page Setup");
        pageSetup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pageSetupActionPerformed(evt);
            }
        });
        File.add(pageSetup);

        print.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        print.setText("Print");
        print.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printActionPerformed(evt);
            }
        });
        File.add(print);

        exit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        exit.setText("Exit");
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        File.add(exit);

        jMenuBar1.add(File);

        Edit.setText("Edit");

        cut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cut.setText("Cut");
        cut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cutActionPerformed(evt);
            }
        });
        Edit.add(cut);

        copy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        copy.setText("Copy");
        copy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copyActionPerformed(evt);
            }
        });
        Edit.add(copy);

        paste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        paste.setText("Paste");
        paste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pasteActionPerformed(evt);
            }
        });
        Edit.add(paste);

        delete.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_DELETE, 0));
        delete.setText("Delete");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        Edit.add(delete);

        selectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selectAll.setText("Select All");
        selectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectAllActionPerformed(evt);
            }
        });
        Edit.add(selectAll);

        find.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        find.setText("Find");
        find.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                findActionPerformed(evt);
            }
        });
        Edit.add(find);

        dateTime.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        dateTime.setText("Date/Time");
        dateTime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dateTimeActionPerformed(evt);
            }
        });
        Edit.add(dateTime);

        wordRap.setSelected(true);
        wordRap.setText("Word Rap");
        wordRap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wordRapActionPerformed(evt);
            }
        });
        Edit.add(wordRap);

        jMenuBar1.add(Edit);

        help.setText("Help");

        about.setText("About");
        about.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutActionPerformed(evt);
            }
        });
        help.add(about);

        featureUpdate.setText("Features and Update");
        featureUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                featureUpdateActionPerformed(evt);
            }
        });
        help.add(featureUpdate);

        jMenuBar1.add(help);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private String date()
    {
	hour = g.get(Calendar.HOUR);
	if (hour == 0)
        {
            hour = 12;
        }
	g.setTime(d);	
	if ( g.get(Calendar.AM_PM) == 0 )
	{
            stringTime = hour + ":" + g.get(Calendar.MINUTE) + " AM " + (g.get(Calendar.MONTH)+1) + "/" + g.get(Calendar.DATE) + "/" + g.get(Calendar.YEAR);
	}
	if ( g.get(Calendar.AM_PM) == 1 )
	{
            stringTime = hour + ":" + g.get(Calendar.MINUTE) + " PM " + (g.get(Calendar.MONTH)+1) + "/" + g.get(Calendar.DATE) + "/" + g.get(Calendar.YEAR);
	}
	return stringTime;
		
    }
    private void newFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileActionPerformed
        // TODO add your handling code here:
        jTextArea1.setText("");
    }//GEN-LAST:event_newFileActionPerformed

    private void openActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openActionPerformed
        // TODO add your handling code here:
        flag = "y";
	openFileDialogue.setVisible(true);
	file = openFileDialogue.getFile();
	directory = openFileDialogue.getDirectory();
	File openfile = new File(directory,file);
	try
	{
            RandomAccessFile raf = new RandomAccessFile(openfile,"rw");
            long size = raf.length();
            String msg = "";		
            for(int i=0;i<size;i++)
            {
                char words = (char)raf.read();
		msg = msg + words;
            }
            jTextArea1.setText(msg);
				
	}
	catch(Exception ex)
	{
            System.out.println(ex);
	}
        
    }//GEN-LAST:event_openActionPerformed

    private void saveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsActionPerformed
        // TODO add your handling code here:
        saveFileDialogue.setVisible(true);
	String directory = saveFileDialogue.getDirectory();
	String filee = saveFileDialogue.getFile();
	File filesave = new File(directory,filee);
	try
	{
            RandomAccessFile raf = new RandomAccessFile(saveFileDialogue.getDirectory()+saveFileDialogue.getFile()+".txt","rw");
            raf.seek(raf.length());
            String msh = jTextArea1.getText();
            raf.writeBytes(msh);
            raf.close();
	}
	catch(Exception ex)
	{
            System.out.println(ex);
	}
    }//GEN-LAST:event_saveAsActionPerformed

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitActionPerformed
        // TODO add your handling code here:
        jTextArea1.append("\n\nThanks for Using Notepad by JARS");
        System.exit(0);
    }//GEN-LAST:event_exitActionPerformed

    private void copyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_copyActionPerformed
        // TODO add your handling code here:
        text = jTextArea1.getSelectedText();
    }//GEN-LAST:event_copyActionPerformed

    private void selectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectAllActionPerformed
        // TODO add your handling code here:
        jTextArea1.selectAll();
    }//GEN-LAST:event_selectAllActionPerformed

    private void dateTimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dateTimeActionPerformed
        // TODO add your handling code here:
        String text2=""+jTextArea1.getSelectedText();		
	if (text2.equals(""))
	{
            gposdel = jTextArea1.getCaretPosition();
            jTextArea1.insert(stringTime,gposdel);
        }
        else
        {
            gposdel = jTextArea1.getCaretPosition();
            int hg = jTextArea1.getSelectionStart();
            int gh = jTextArea1.getSelectionEnd();
            jTextArea1.replaceRange(stringTime,hg,gh);
        }
    }//GEN-LAST:event_dateTimeActionPerformed

    private void printActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printActionPerformed
        // TODO add your handling code here:
        try
	{
            printme.print();
        }
        catch(Exception ex)
        {
            
        }
    }//GEN-LAST:event_printActionPerformed

    private void pageSetupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pageSetupActionPerformed
        // TODO add your handling code here:
        printme.printDialog();
    }//GEN-LAST:event_pageSetupActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        if (flag.equals("y"))
	{ 
            File delme = new File(directory,file);
            String a = directory;
            String b = file;
            try
            {
                delme.delete();
            }
            catch(SecurityException eeme)
            {
                System.out.println(eeme);
            }
            File filesave = new File(a,b);		
            try
            {
                RandomAccessFile raf = new RandomAccessFile(a+b,"rw");
                String msh = jTextArea1.getText();
		raf.writeBytes(msh);
                raf.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
		
        if (flag.equals("n"))
        {
            saveFileDialogue.setVisible(true);
            String dir = saveFileDialogue.getDirectory();
            String fil = saveFileDialogue.getFile();
            File filesave = new File(dir,fil);
            try
            {
                RandomAccessFile raf = new RandomAccessFile(saveFileDialogue.getDirectory()+saveFileDialogue.getFile()+".txt","rw");
		raf.seek(raf.length());
                String msh = jTextArea1.getText();
		raf.writeBytes(msh);
                raf.close();
            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }
        }
        
    }//GEN-LAST:event_saveActionPerformed

    private void pasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pasteActionPerformed
        // TODO add your handling code here:
        if (text.equals(""))
	{
            gposdel = jTextArea1.getCaretPosition();
            jTextArea1.insert(text,gposdel);
	}
	else
        {
            gposdel = jTextArea1.getCaretPosition();
            int hg = jTextArea1.getSelectionStart();
            int gh = jTextArea1.getSelectionEnd();
            jTextArea1.replaceRange(text,hg,gh);
	}
    }//GEN-LAST:event_pasteActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
	text = jTextArea1.getSelectedText();
	gposdel = jTextArea1.getCaretPosition();
	jTextArea1.replaceRange("",gposdel,gposdel+text.length());
			
    }//GEN-LAST:event_deleteActionPerformed

    private void findActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_findActionPerformed
        // TODO add your handling code here:
        textToSearch = JOptionPane.showInputDialog("Enter The Word You Want To Search");
        if(textToSearch!=null)
        {
            text=jTextArea1.getText();
            int sindex=text.indexOf(textToSearch);
            jTextArea1.select(sindex, sindex+textToSearch.length());
        }
    }//GEN-LAST:event_findActionPerformed

    private void cutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cutActionPerformed
        // TODO add your handling code here:
	text = jTextArea1.getSelectedText();
	gposdel = jTextArea1.getCaretPosition();
	jTextArea1.replaceRange("",gposdel,gposdel+text.length());
    }//GEN-LAST:event_cutActionPerformed

    private void wordRapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wordRapActionPerformed
        // TODO add your handling code here:
        jTextArea1.setWrapStyleWord(wordRap.getState());
    }//GEN-LAST:event_wordRapActionPerformed

    private void aboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "This Notepad is Created by JARS");
    }//GEN-LAST:event_aboutActionPerformed

    private void featureUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_featureUpdateActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "It's not complete the Freatures will be\n added soon by JARS. Wait for Update");
    }//GEN-LAST:event_featureUpdateActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Notepad().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Edit;
    private javax.swing.JMenu File;
    private javax.swing.JMenuItem about;
    private javax.swing.JMenuItem copy;
    private javax.swing.JMenuItem cut;
    private javax.swing.JMenuItem dateTime;
    private javax.swing.JMenuItem delete;
    private javax.swing.JMenuItem exit;
    private javax.swing.JMenuItem featureUpdate;
    private javax.swing.JMenuItem find;
    private javax.swing.JMenu help;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JMenuItem newFile;
    private javax.swing.JMenuItem open;
    private javax.swing.JMenuItem pageSetup;
    private javax.swing.JMenuItem paste;
    private javax.swing.JMenuItem print;
    private javax.swing.JMenuItem save;
    private javax.swing.JMenuItem saveAs;
    private javax.swing.JMenuItem selectAll;
    private javax.swing.JCheckBoxMenuItem wordRap;
    // End of variables declaration//GEN-END:variables
}
