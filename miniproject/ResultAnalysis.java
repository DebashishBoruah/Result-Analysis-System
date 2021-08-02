/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniproject;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javafx.scene.paint.Color.color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author THE COMPUTERS
 */
public class ResultAnalysis extends javax.swing.JFrame {
    Connection conn = null;
    ResultSet rs = null;
    PreparedStatement pst = null;
    String id,id1;
    public ResultAnalysis(String store,String store1) {
         conn = DbConnection1.ConnectDb();
        initComponents();
        id=store;
        id1=store1;
        stuResult();
    }
    public ResultAnalysis() {
         conn = DbConnection1.ConnectDb();
        initComponents();
         stuResult();
    }
    public void stuResult()
    {
        try
        {
           pst=conn.prepareStatement("SELECT * FROM student_marks"); 
           rs=pst.executeQuery();
           while(rs.next())
           {
               String s_id=rs.getString("sid");
               String b=rs.getString("branch");
               String t=rs.getString("total");
               String p=rs.getString("percentage");
               String c=rs.getString("cgpa");
                 String tbData[] = {s_id,b,t,p,c};
    DefaultTableModel tbModel =(DefaultTableModel)jTable1.getModel();
    tbModel.addRow(tbData);
           }
        }catch(Exception e)
        {
            
        }
    }
    public void disPieChart()
    {
     String s1=sem1.getText();
     String s2=sem2.getText();
     String s3=sem3.getText();
     String s4=sem4.getText();
     String s5=sem5.getText();
     String s6=sem6.getText();
     if(s2.isEmpty())
     {
     JOptionPane.showMessageDialog(null,"Result Analysis cannot be done for only one semester");
     }
     if(s3.isEmpty() && s4.isEmpty() && s5.isEmpty() && s6.isEmpty())
        {
     DefaultPieDataset pieDataset=new DefaultPieDataset();
     pieDataset.setValue("Sem1",new Double(s1));
     pieDataset.setValue("Sem2",new Double(s2));
     //pieDataset.setValue("Sem3",new Integer(s3));
     //pieDataset.setValue("Sem4",new Integer(s4));
     //pieDataset.setValue("Sem5",new Integer(s5));
     //pieDataset.setValue("Sem6",new Integer(s6));
     JFreeChart chart=ChartFactory.createPieChart("Pie Chart",pieDataset,true,true,true);
     PiePlot p=(PiePlot)chart.getPlot();
     //P.setForegroundAlpha(TOP_ALIGNMENT);
     ChartFrame frame= new ChartFrame("Pie Chart",chart);
     frame.setVisible(true);
     frame.setSize(550,600);   
    }else if(s4.isEmpty() && s5.isEmpty() && s6.isEmpty())
    {
         DefaultPieDataset pieDataset=new DefaultPieDataset();
     pieDataset.setValue("Sem1",new Double(s1));
     pieDataset.setValue("Sem2",new Double(s2));
     pieDataset.setValue("Sem3",new Double(s3));
    // pieDataset.setValue("Sem4",new Integer(s4));
     //pieDataset.setValue("Sem5",new Integer(s5));
     //pieDataset.setValue("Sem6",new Integer(s6));
     JFreeChart chart=ChartFactory.createPieChart("Pie Chart",pieDataset,true,true,true);
     PiePlot p=(PiePlot)chart.getPlot();
     //P.setForegroundAlpha(TOP_ALIGNMENT);
     ChartFrame frame= new ChartFrame("Pie Chart",chart);
     frame.setVisible(true);
     frame.setSize(550,600);  
    }
    else if(s5.isEmpty() && s6.isEmpty())
    {
      
         DefaultPieDataset pieDataset=new DefaultPieDataset();
     pieDataset.setValue("Sem1",new Double(s1));
     pieDataset.setValue("Sem2",new Double(s2));
     pieDataset.setValue("Sem3",new Double(s3));
     pieDataset.setValue("Sem4",new Double(s4));
     //pieDataset.setValue("Sem5",new Integer(s5));
     //pieDataset.setValue("Sem6",new Integer(s6));
     JFreeChart chart=ChartFactory.createPieChart("Pie Chart",pieDataset,true,true,true);
     PiePlot p=(PiePlot)chart.getPlot();
     //P.setForegroundAlpha(TOP_ALIGNMENT);
     ChartFrame frame= new ChartFrame("Pie Chart",chart);
     frame.setVisible(true);
     frame.setSize(550,600);    
    }
        else if(s6.isEmpty())
    {
      
         DefaultPieDataset pieDataset=new DefaultPieDataset();
     pieDataset.setValue("Sem1",new Double(s1));
     pieDataset.setValue("Sem2",new Double(s2));
     pieDataset.setValue("Sem3",new Double(s3));
     pieDataset.setValue("Sem4",new Double(s4));
     pieDataset.setValue("Sem5",new Double(s5));
     //pieDataset.setValue("Sem6",new Integer(s6));
     JFreeChart chart=ChartFactory.createPieChart("Pie Chart",pieDataset,true,true,true);
     PiePlot p=(PiePlot)chart.getPlot();
     //P.setForegroundAlpha(TOP_ALIGNMENT);
     ChartFrame frame= new ChartFrame("Pie Chart",chart);
     frame.setVisible(true);
     frame.setSize(550,600);    
    }
    else 
    {
      
         DefaultPieDataset pieDataset=new DefaultPieDataset();
     pieDataset.setValue("Sem1",new Double(s1));
     pieDataset.setValue("Sem2",new Double(s2));
     pieDataset.setValue("Sem3",new Double(s3));
     pieDataset.setValue("Sem4",new Double(s4));
     pieDataset.setValue("Sem5",new Double(s5));
     pieDataset.setValue("Sem6",new Double(s6));
     JFreeChart chart=ChartFactory.createPieChart("Pie Chart",pieDataset,true,true,true);
     PiePlot p=(PiePlot)chart.getPlot();
     //P.setForegroundAlpha(TOP_ALIGNMENT);
     ChartFrame frame= new ChartFrame("Pie Chart",chart);
     frame.setVisible(true);
     frame.setSize(550,600);    
    }
}
    public void disBarChart()       
    {
     String s1=sem1.getText();
     String s2=sem2.getText();
     String s3=sem3.getText();
     String s4=sem4.getText();
     String s5=sem5.getText();
     String s6=sem6.getText();
     if(s2.isEmpty())
     {
     JOptionPane.showMessageDialog(null,"Result Analysis cannot be done for only one semester");
     }
     else if(s3.isEmpty() && s4.isEmpty() && s5.isEmpty() && s6.isEmpty())
     {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      dataset.setValue(new Double(s1),"Marks","Sem1");
      dataset.setValue(new Double(s2),"Marks","Sem2");
     // dataset.setValue(new Double(s3),"Marks","Sem3");
      //dataset.setValue(new Double(s4),"Marks","Sem4");
      //dataset.setValue(new Double(s5),"Marks","Sem5");
      //dataset.setValue(new Double(s6),"Marks","Sem6");
      JFreeChart chart=ChartFactory.createBarChart3D("Student score","student name","Marks", dataset, PlotOrientation.VERTICAL, false,true,false);
      chart.setBackgroundPaint(Color.gray);
      chart.getTitle().setPaint(Color.getHSBColor(158,68,66));
      
      CategoryPlot p=chart.getCategoryPlot();
      p.setRangeGridlinePaint(Color.black);
      ChartFrame frame=new ChartFrame("Bar Chart For student",chart);
      frame.setVisible(true);
      frame.setSize(650,700); 
    }
     else if(s4.isEmpty() && s5.isEmpty() && s6.isEmpty())
     {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      dataset.setValue(new Double(s1),"Marks","Sem1");
      dataset.setValue(new Double(s2),"Marks","Sem2");
      dataset.setValue(new Double(s3),"Marks","Sem3");
     // dataset.setValue(new Double(s4),"Marks","Sem4");
     // dataset.setValue(new Double(s5),"Marks","Sem5");
      //dataset.setValue(new Double(s6),"Marks","Sem6");
      JFreeChart chart=ChartFactory.createBarChart3D("Student score","student name","Marks", dataset, PlotOrientation.VERTICAL, false,true,false);
      chart.setBackgroundPaint(Color.gray);
      chart.getTitle().setPaint(Color.getHSBColor(158,68,66));
      
      CategoryPlot p=chart.getCategoryPlot();
      p.setRangeGridlinePaint(Color.black);
      ChartFrame frame=new ChartFrame("Bar Chart For student",chart);
      frame.setVisible(true);
      frame.setSize(950,850); 
    }
    else if(s5.isEmpty() && s6.isEmpty())
     {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      dataset.setValue(new Double(s1),"Marks","Sem1");
      dataset.setValue(new Double(s2),"Marks","Sem2");
      dataset.setValue(new Double(s3),"Marks","Sem3");
      dataset.setValue(new Double(s4),"Marks","Sem4");
     // dataset.setValue(new Double(s5),"Marks","Sem5");
      //dataset.setValue(new Double(s6),"Marks","Sem6");
      JFreeChart chart=ChartFactory.createBarChart3D("Student score","student name","Marks", dataset, PlotOrientation.VERTICAL, false,true,false);
      chart.setBackgroundPaint(Color.gray);
      chart.getTitle().setPaint(Color.getHSBColor(158,68,66));
      
      CategoryPlot p=chart.getCategoryPlot();
      p.setRangeGridlinePaint(Color.black);
      ChartFrame frame=new ChartFrame("Bar Chart For student",chart);
      frame.setVisible(true);
      frame.setSize(950,850); 
    }
    else if(s6.isEmpty())
     {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      dataset.setValue(new Double(s1),"Marks","Sem1");
      dataset.setValue(new Double(s2),"Marks","Sem2");
      dataset.setValue(new Double(s3),"Marks","Sem3");
      dataset.setValue(new Double(s4),"Marks","Sem4");
      dataset.setValue(new Double(s5),"Marks","Sem5");
      //dataset.setValue(new Double(s6),"Marks","Sem6");
      JFreeChart chart=ChartFactory.createBarChart3D("Student score","student name","Marks", dataset, PlotOrientation.VERTICAL, false,true,false);
      chart.setBackgroundPaint(Color.gray);
      chart.getTitle().setPaint(Color.getHSBColor(158,68,66));
      
      CategoryPlot p=chart.getCategoryPlot();
      p.setRangeGridlinePaint(Color.black);
      ChartFrame frame=new ChartFrame("Bar Chart For student",chart);
      frame.setVisible(true);
      frame.setSize(950,850); 
    }
     else
     {
        DefaultCategoryDataset dataset=new DefaultCategoryDataset();
      dataset.setValue(new Double(s1),"Marks","Sem1");
      dataset.setValue(new Double(s2),"Marks","Sem2");
      dataset.setValue(new Double(s3),"Marks","Sem3");
      dataset.setValue(new Double(s4),"Marks","Sem4");
      dataset.setValue(new Double(s5),"Marks","Sem5");
      //dataset.setValue(new Double(s6),"Marks","Sem6");
      JFreeChart chart=ChartFactory.createBarChart3D("Student score","student name","Marks", dataset, PlotOrientation.VERTICAL, false,true,false);
      chart.setBackgroundPaint(Color.gray);
      chart.getTitle().setPaint(Color.getHSBColor(158,68,66));
      
      CategoryPlot p=chart.getCategoryPlot();
      p.setRangeGridlinePaint(Color.black);
      ChartFrame frame=new ChartFrame("Bar Chart For student",chart);
      frame.setVisible(true);
      frame.setSize(950,850); 
    }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sid = new javax.swing.JTextField();
        sname = new javax.swing.JTextField();
        branc = new javax.swing.JTextField();
        sem1 = new javax.swing.JTextField();
        sem2 = new javax.swing.JTextField();
        sem3 = new javax.swing.JTextField();
        sem4 = new javax.swing.JTextField();
        sem5 = new javax.swing.JTextField();
        sem6 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        check = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Sylfaen", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Result Analysis");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-back-arrow-40 (1).png"))); // NOI18N
        jLabel11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel11MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(20, 20, 20))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Student Id:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Student Name:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Branch:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Semester1:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Semester2:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Semester3:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Semester4:");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Semester5:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Semester6:");

        sid.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sname.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        branc.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sem1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sem2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        sem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sem2ActionPerformed(evt);
            }
        });

        sem3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sem4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sem5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        sem6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Analyse");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(102, 153, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8-search-20 (3).png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(sem5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
                    .addComponent(sem4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sem3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(branc, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sname, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sem1)
                    .addComponent(sem2)
                    .addComponent(sem6)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(sid)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(271, 271, 271))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(sid, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(sname, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(branc, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(sem1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(sem2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(sem3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(sem4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(sem5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(sem6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Stu Id", "Branch", "Total", "percentage", "cgpa"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        check.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(102, 153, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Search\n");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(check)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_checkActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
       disPieChart();
      disBarChart();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void sem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sem2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sem2ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        DefaultTableModel model=(DefaultTableModel) jTable1.getModel();
      int i=jTable1.getSelectedRow();
     sid.setText(model.getValueAt(i,0).toString());
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
 String search=check.getText();
 if(search.isEmpty())
 {
     JOptionPane.showMessageDialog(null,"Please insert the branch");
 }
        try
 {
           pst=conn.prepareStatement("SELECT * FROM `student_marks` WHERE branch='"+search+"'"); 
           rs=pst.executeQuery();
           DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
           model.setRowCount(0);
           while(rs.next())
           {
               String s_id=rs.getString("sid");
               String b=rs.getString("branch");
               String t=rs.getString("total");
               String p=rs.getString("percentage");
               String c=rs.getString("cgpa");
               String tbData[] = {s_id,b,t,p,c};
    DefaultTableModel tbModel =(DefaultTableModel)jTable1.getModel();
    tbModel.addRow(tbData);
           }
        }catch(Exception e)
        {
            
        }     
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     String search=sid.getText();
     if(search.isEmpty())
     {
         JOptionPane.showMessageDialog(null,"Select a Student id first from the Table");
     }
     else{
      int i=1;
        try
 {
           pst=conn.prepareStatement("SELECT T.sid,T.name,T.branch,S.percentage FROM student_info T JOIN student_marks S ON S.sid=T.sid WHERE T.sid='"+search+"'"); 
           rs=pst.executeQuery();
           while(rs.next())
           {
              String name=rs.getString("T.name");
              String branch=rs.getString("T.branch");
              String percen=rs.getString("S.percentage");
               sname.setText(name);
              branc.setText(branch);
              if(i==1)
              {
               sem1.setText(percen);   
              }
              else if(i==2)
              {
               sem2.setText(percen);   
              }
              else if(i==3)
              {
               sem3.setText(percen);   
              }
              else if(i==4)
              {
               sem4.setText(percen);   
              }
              else if(i==5)
              {
               sem5.setText(percen);   
              }
              else if(i==6)
              {
               sem6.setText(percen);   
              }
              i++;
           }
        }catch(Exception e)
        {
            
        } 
     }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel11MouseClicked
       new UserHome(id,id1).setVisible(true);
     dispose();
    }//GEN-LAST:event_jLabel11MouseClicked

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
            java.util.logging.Logger.getLogger(ResultAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResultAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResultAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResultAnalysis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResultAnalysis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField branc;
    private javax.swing.JTextField check;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField sem1;
    private javax.swing.JTextField sem2;
    private javax.swing.JTextField sem3;
    private javax.swing.JTextField sem4;
    private javax.swing.JTextField sem5;
    private javax.swing.JTextField sem6;
    private javax.swing.JTextField sid;
    private javax.swing.JTextField sname;
    // End of variables declaration//GEN-END:variables
}
