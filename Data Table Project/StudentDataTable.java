import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



class StudentDataTable extends JFrame implements ActionListener{


    private Font f;
    private Container c;
    private ImageIcon icon;
    private JTable tab;
    private DefaultTableModel model;
    private JScrollPane scroll;
    private JLabel titLabel,fnLabel,lnLabel,phnLabel,gpaJLabel;
    private JTextField fnField, lnField, phnField, gpaField;
    private JButton addButton,updateButton,deleteButton,clearButton;

    private String[] col = {"First Name", "Last Name", "GPA", "Phone"};
    private String[] row = new String[4];

      StudentDataTable(){
            components();
      }

      public void components(){
                  this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                  this.setBounds(50, 50, 850, 600);
                  this.setTitle("Student Data Table");

                  icon = new ImageIcon(getClass().getResource("DataSheet.png"));

                  this.setIconImage(icon.getImage());

                  f = new Font("Arial", Font.BOLD,18);

                  c = this.getContentPane();
                  c.setLayout(null);
                  c.setBackground(Color.PINK);


                  titLabel = new JLabel("<Student Registration>");
                  titLabel.setFont(f);
                  titLabel.setBounds(230, 10, 250, 50);
                  c.add(titLabel);

                  fnLabel = new JLabel("First Name: ");
                  fnLabel.setFont(f);
                  fnLabel.setBounds(10, 80, 140, 30);
                  c.add(fnLabel);

                  fnField = new JTextField();
                  fnField.setBounds(120, 80, 200, 30);
                  fnField.setFont(f);
                  c.add(fnField);

                  addButton = new JButton("Add");
                  addButton.setBounds(400, 80, 100, 30);
                  addButton.setFont(f);
                  c.add(addButton);

                  lnLabel = new JLabel("Last Name: ");
                  lnLabel.setFont(f);
                  lnLabel.setBounds(10, 120, 140, 30);
                  c.add(lnLabel);

                  lnField = new JTextField();
                  lnField.setBounds(120, 120, 200, 30);
                  lnField.setFont(f);
                  c.add(lnField);

                  updateButton = new JButton("Update");
                  updateButton.setBounds(400, 120, 100, 30);
                  updateButton.setFont(f);
                  c.add(updateButton);

                  gpaJLabel = new JLabel("GPA: ");
                  gpaJLabel.setFont(f);
                  gpaJLabel.setBounds(10, 160, 140, 30);
                  c.add(gpaJLabel);

                  gpaField = new JTextField();
                  gpaField.setBounds(120, 160, 200, 30);
                  gpaField.setFont(f);
                  c.add(gpaField);

                  deleteButton = new JButton("Delete");
                  deleteButton.setBounds(400, 160, 100, 30);
                  deleteButton.setFont(f);
                  c.add(deleteButton);

                  phnLabel = new JLabel("Phone: ");
                  phnLabel.setFont(f);
                  phnLabel.setBounds(10, 200, 140, 30);
                  c.add(phnLabel);

                  phnField = new JTextField();
                  phnField.setBounds(120, 200, 200, 30);
                  phnField.setFont(f);
                  c.add(phnField);

                  clearButton = new JButton("Clear");
                  clearButton.setBounds(400, 200, 100, 30);
                  clearButton.setFont(f);
                  c.add(clearButton);

                  tab = new JTable();

                  model = new DefaultTableModel();
                  model.setColumnIdentifiers(col);
                  tab.setModel(model);
                  tab.setSelectionBackground(Color.orange);
                  tab.setBackground(Color.white);
                  tab.setFont(f);
                  tab.setRowHeight(30);

                  scroll = new JScrollPane(tab);
                  scroll.setBounds(10,278,815,275);
                  c.add(scroll);

                  addButton.addActionListener(this);
                  clearButton.addActionListener(this);
                  deleteButton.addActionListener(this);
                  updateButton.addActionListener(this);

                  tab.addMouseListener(new MouseAdapter() {
                        public void mouseClicked(MouseEvent e){

                              int selectedRow = tab.getSelectedRow();

                              String fname = model.getValueAt(selectedRow,0).toString();
                              String lname = model.getValueAt(selectedRow,1).toString();
                              String gpa = model.getValueAt(selectedRow,2).toString();
                              String phone = model.getValueAt(selectedRow,3).toString();

                              fnField.setText(fname);
                              lnField.setText(lname);
                              gpaField.setText(gpa);
                              phnField.setText(phone);
                        }
                  });

      }

     public void actionPerformed(ActionEvent e){
                  if(e.getSource() == addButton){
                        row[0] = fnField.getText();
                        row[1] = lnField.getText();
                        row[2] = gpaField.getText();
                        row[3] = phnField.getText();
                        model.addRow(row);
                  }
                  else if(e.getSource() == clearButton){
                        fnField.setText("");
                        lnField.setText("");
                        gpaField.setText("");
                        phnField.setText("");
                  }
                  else if(e.getSource() == deleteButton){
                        int rowNumber = tab.getSelectedRow();
                        if(rowNumber>=0){
                              model.removeRow(rowNumber);
                        }
                        else{
                              JOptionPane.showMessageDialog(null, "Table is Empty or You did`t select any row.", "Warning", 2);
                        }
                  }
                  else if(e.getSource() == updateButton){

                          int rowNumber= tab.getSelectedRow();

                          String fname = fnField.getText();
                          String lname = lnField.getText();
                          String gpa = gpaField.getText();
                          String phone = phnField.getText();

                        model.setValueAt(fname,rowNumber,0);
                        model.setValueAt(lname,rowNumber,1);
                        model.setValueAt(gpa,rowNumber,2);
                        model.setValueAt(phone,rowNumber,3);

                  }
     }

      public static void main(String[] args) {
            
            StudentDataTable frame = new StudentDataTable();
            frame.setVisible(true);
            
      }
}