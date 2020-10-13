package javaapplication1;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileWriter;
import java.time.LocalDate;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class FitnessTrackerGUI
{
    private JFrame frame;
    private JButton jButton1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JComboBox<String> jComboBox1;
    private JLabel jLabel1;
    private JLabel jLabel2;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JMenu jMenu1;
    private JMenu jMenu2;
    private JMenuBar jMenuBar1;
    private JMenuItem jMenuItem1;
    private JMenuItem jMenuItem2;
    private JMenuItem jMenuItem3;
    private JPanel jPanel1;
    private JScrollPane jScrollPane1;
    private JTextArea jTextArea1;
    private FitnessTracker fitnessTracker;
    ActionEvent evt=null;
    private String path;
    private LocalDate lc;
    private int day=0;
    public FitnessTrackerGUI()
    {
       // this.evt = new ActionEvent();
//        jMenuItem3ActionPerformed(evt);
        initComponents();
    }
    private void initComponents() 
    {
        frame=new JFrame("Fitness Traceker");
        frame.setVisible(true);
        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jScrollPane1 = new JScrollPane();
        jTextArea1 = new JTextArea();
        jButton1 = new JButton();
        jLabel5 = new JLabel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jLabel6 = new JLabel();
        jComboBox1 = new JComboBox<>();
        jMenuBar1 = new JMenuBar();
        jMenu1 = new JMenu();
        jMenuItem3 = new JMenuItem();
        jMenuItem1 = new JMenuItem();
        jMenu2 = new JMenu();
        jMenuItem2 = new JMenuItem();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jLabel1.setFont(new Font("Arial", 1, 36)); 
        jLabel1.setText("Fitness Tracker");

        jLabel2.setFont(new Font("Arial", 1, 18));
        jLabel2.setText("This Year:");

        jLabel3.setFont(new Font("Arial", 1, 18));
        jLabel3.setText("This Week:");

        jLabel4.setFont(new Font("Arial", 1, 16)); 
        jLabel4.setText("Today is ");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setEditable(false);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setFont(new Font("Arial", 1, 18)); 
        jButton1.setText("Add New Activity");
         jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new Font("Arial", 1, 18));
        jLabel5.setText("Display by week");

        jButton2.setFont(new Font("Arial", 1, 18)); 
        jButton2.setText("<<");
         jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                day=day-7;
                jTextArea1.setText(fitnessTracker.getWeekActivities(lc,day));
                 if(jTextArea1.getText().equals(""))
                    jButton2.setEnabled(false);
                else
                 {
                     jButton2.setEnabled(true);
                     jButton4.setEnabled(true);
                 }
                    
            }
        });

        jButton3.setFont(new Font("Arial", 1, 18)); 
        jButton3.setText("Display This Week");
        jButton3.setToolTipText("");
         jButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {
                jTextArea1.setText(fitnessTracker.getWeekActivities(lc,0));
                 if(jTextArea1.getText().equals(""))
                    jButton3.setEnabled(false);
                else
                 {
                     jButton2.setEnabled(true);
                     jButton3.setEnabled(true);
                     jButton4.setEnabled(true);
                 }
                    
            }
        });

        jButton4.setFont(new Font("Arial", 1, 18)); 
        jButton4.setText(">>");
         jButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) 
            {
                day=day+7;
                jTextArea1.setText(fitnessTracker.getWeekActivities(lc, day));
                if(jTextArea1.getText().equals(""))
                    jButton4.setEnabled(false);
                else
                {
                    jButton2.setEnabled(true);
                    jButton4.setEnabled(true);
                    
                }   
            }
        });

        jLabel6.setFont(new Font("Arial", 1, 18)); 
        jLabel6.setText("Display by Selected Activity");

        jComboBox1.setFont(new java.awt.Font("Arial", 1, 18));
        jComboBox1.setModel(new DefaultComboBoxModel<>(new String[] { "Select Category","Bike","Sports","Swim","Steps","Run" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt)
            {
                jTextArea1.setText("");
                String item=(String)jComboBox1.getSelectedItem();
                if(item.equalsIgnoreCase("bike"))
                {
                    List list=fitnessTracker.getBikeList();
                     for(int i=0;i<list.size();i++)
                     {
                         jTextArea1.setText(jTextArea1.getText()+list.get(i).toString());
                     }
               
                }
                else if(item.equalsIgnoreCase("run"))
                {
                    List list=fitnessTracker.getRunList();
                     for(int i=0;i<list.size();i++)
                     {
                         jTextArea1.setText(jTextArea1.getText()+list.get(i).toString());
                     }
                }
                else if(item.equalsIgnoreCase("swim"))
                {
                    List list=fitnessTracker.getSwimList();
                     for(int i=0;i<list.size();i++)
                     {
                         jTextArea1.setText(jTextArea1.getText()+list.get(i).toString());
                     }
                }
                else if(item.equalsIgnoreCase("sports"))
                {
                    List list=fitnessTracker.getSportList();
                     for(int i=0;i<list.size();i++)
                     {
                         jTextArea1.setText(jTextArea1.getText()+list.get(i).toString());
                     }
                }
                else if(item.equalsIgnoreCase("steps"))
                {
                    List list=fitnessTracker.getDailyStepsList();
                     for(int i=0;i<list.size();i++)
                     {
                         jTextArea1.setText(jTextArea1.getText()+list.get(i).toString());
                     }
                }
                else
                {
                        JOptionPane.showMessageDialog(frame, "Select a valid Category");
                }
                 
                 
            }
        });
        javax.swing.GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 284, Short.MAX_VALUE)
                            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel4, GroupLayout.PREFERRED_SIZE, 303, GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 600, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton3, GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton4))
                                    .addComponent(jLabel6, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(62, 62, 62)))
                .addContainerGap())
        );
        
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 323, GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton4)
                            .addComponent(jButton2))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jMenu1.setText("File");
        
        jMenuItem3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt) 
            {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
        jMenuItem1.setText("Exit");
        jMenuItem1.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent evt)
            {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Help");

        jMenuItem2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.SHIFT_MASK | InputEvent.CTRL_MASK));
        jMenuItem2.setText("About");
        jMenuItem2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        frame.setJMenuBar(jMenuBar1);
        
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        frame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        
        frame.pack();
    }
    
    private void jMenuItem3ActionPerformed(ActionEvent evt) 
    {   
        boolean isReady=false;
        do
        {
            try
            {
                JFileChooser fileChooser=new JFileChooser();
                fileChooser.showOpenDialog(null);
                File file=fileChooser.getSelectedFile();
                String fileName=file.getAbsolutePath();
                if(fileName.endsWith(".txt"))
                {
                    isReady=true;
                    fitnessTracker=FitnessTracker.getFitnessTracker(file.getParent());
                    path=file.getParent()+"\\";
                }
                else
                {
                    JOptionPane.showMessageDialog(frame,"Please Select a .txt File");
                }
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(frame, "Select the File Properly!");
            }
        }
        while(!isReady); 
        int sumMinutes=0;
        double sumDistance=0.0;
        ActiveDay[] activeDays=fitnessTracker.getActiveDays();
        lc=FitnessTracker.getLc();
        jLabel4.setText("Today is "+lc+", "+fitnessTracker.getYearDay(lc)+" day of Year");
        for(int i=0;i<activeDays.length;i++)
        {
              
                jTextArea1.setText(jTextArea1.getText()+"\n"+activeDays[i].dailySummary());
                sumMinutes+=activeDays[i].totalIntensityMinutes();
                sumDistance+=activeDays[i].totalSumDistance();
 
        }
        String year="This Year Total "+sumDistance+" Miles, Total "+sumMinutes+" Mins";
        String week="This Week Total "+sumDistance+" Miles, Total "+sumMinutes+" Mins"; 
        
        jLabel2.setText(year);
        jLabel3.setText(week);
                   
    }  
    private void jButton1ActionPerformed(ActionEvent evt) 
    {                                         
        JFrame miniFrame=new JFrame("New Activity");
        JButton jButton5;
        JButton jButton6;
        JComboBox<String> jComboBox2;
        JLabel miniJFrameLabel1;
        JLabel miniJFrameLabel2;
        JTextField jTextField1;
        miniFrame.setVisible(true);
        miniFrame.setResizable(false);
        miniJFrameLabel1 = new JLabel();
        jComboBox2 = new JComboBox<>();
        miniJFrameLabel2 = new JLabel();
        jTextField1 = new JTextField();
        jButton5 = new JButton();
        jButton6 = new JButton();
        
        miniFrame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        miniJFrameLabel1.setFont(new java.awt.Font("Arial", 1, 18)); 
        miniJFrameLabel1.setText("Activity Type");

        jComboBox2.setFont(new java.awt.Font("Arial", 1, 18)); 
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Activity", "Sports", "Bike", "Run", "Step", "Swim"}));

        miniJFrameLabel2.setFont(new java.awt.Font("Arial", 1, 18));
        miniJFrameLabel2.setText("Activity Description");

        jTextField1.setFont(new java.awt.Font("Arial", 1, 18)); 

        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); 
        jButton5.setText("Add Activity");
         jButton5.addActionListener(new ActionListener() 
         {
            public void actionPerformed(ActionEvent evt) 
            {
                String item=(String)jComboBox2.getSelectedItem();
                if(item.equalsIgnoreCase("bike"))
                {
                    try
                    {
                        FileWriter fw=new FileWriter(path+"bike.txt");
                        fw.write(jTextField1.getText());
                        JOptionPane.showMessageDialog(miniFrame, "Added Sucessfully!");
                        fw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                    
                }
                else if(item.equalsIgnoreCase("swim"))
                {
                   try
                    {
                        FileWriter fw=new FileWriter(path+"swim.txt");
                        fw.write(jTextField1.getText());
                        JOptionPane.showMessageDialog(miniFrame, "Added Sucessfully!");
                        fw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }   
                }
                else if(item.equalsIgnoreCase("run"))
                {
                    try
                    {
                        FileWriter fw=new FileWriter(path+"run.txt");
                        fw.write(jTextField1.getText());
                        JOptionPane.showMessageDialog(miniFrame, "Added Sucessfully!");
                        fw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else if(item.equalsIgnoreCase("step"))
                {
                      try
                    {
                        FileWriter fw=new FileWriter(path+"step.txt");
                        fw.write(jTextField1.getText());
                        JOptionPane.showMessageDialog(miniFrame, "Added Sucessfully!");
                        fw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                   else if(item.equalsIgnoreCase("sports"))
                {
                      try
                    {
                        FileWriter fw=new FileWriter(path+"sports.txt");
                        fw.write(jTextField1.getText());
                        JOptionPane.showMessageDialog(miniFrame, "Added Sucessfully!");
                        fw.close();
                    }
                    catch(Exception e)
                    {
                        System.out.println(e);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(miniFrame,"Please Select a valid Category");
                }
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); 
        jButton6.setText("Discard Activity");
         jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //jButton6ActionPerformed(evt);
                miniFrame.dispose();
            }
        });

        javax.swing.GroupLayout layout = new GroupLayout(miniFrame.getContentPane());
        miniFrame.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(miniJFrameLabel2, GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                    .addComponent(miniJFrameLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBox2, 0, 398, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton6)
                .addContainerGap(140, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(miniJFrameLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(miniJFrameLabel2)
                    .addComponent(jTextField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton6))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        miniFrame.pack();
      

    } 

    private void jMenuItem1ActionPerformed(ActionEvent evt) 
    {                                           
        System.exit(0);
    }
    private void jMenuItem2ActionPerformed(ActionEvent evt)
    {                                           
        JOptionPane.showMessageDialog(frame, "This is the Fitness Tracker App Kindly go to File Menu and Open Your Activity File");
    }    
    public static void main(String args[])
    {
            
        try 
        {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
            {
                if ("Nimbus".equals(info.getName())) 
                {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) 
        {
            java.util.logging.Logger.getLogger(FitnessTrackerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        EventQueue.invokeLater(() -> 
        {
            FitnessTrackerGUI ftg=new FitnessTrackerGUI();
        });
        }
}
