package ���ټ�;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class MainClass extends JFrame implements ActionListener {
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();
	
	JPanel lpanel, llpanel, lllpanel;
	JTextField tf1, tf2, tf3;
	JRadioButton r1, r2;
	JButton bt1, bt2, bt3, bt4;
	JTextArea ta;
	ButtonGroup rgroup = new ButtonGroup();
	
	MainClass() {
		super("���α׷��־��Ȱ����");
		setLayout(new FlowLayout());
		
		Box hBox = Box.createHorizontalBox();
		JLabel lb1 = new JLabel("ȸ��ID:");
		hBox.add(lb1);
		tf1 = new JTextField(10);
		hBox.add(tf1);
		hBox.add(Box.createHorizontalStrut(10));
		JLabel lb2 = new JLabel("ȸ���̸�:");
		hBox.add(lb2);
		tf2 = new JTextField(10);
		hBox.add(tf2);
		hBox.add(Box.createHorizontalStrut(10));
		JLabel lb3 = new JLabel("��ȭ��ȣ:");
		hBox.add(lb3);
		tf3 = new JTextField(10);
		hBox.add(tf3);
		hBox.add(Box.createHorizontalStrut(10));
		JLabel lb4 = new JLabel("����:");
		hBox.add(lb4);
		rgroup.add(r1=new JRadioButton("��"));
		hBox.add(r1);
		rgroup.add(r2=new JRadioButton("��"));
		hBox.add(r2);
		hBox.add(Box.createGlue());
		

		Box hBox1 = Box.createHorizontalBox();
		bt1=new JButton("ȸ�����");
		bt2=new JButton("ȸ������");
		bt3=new JButton("��üȸ����ȸ");
		hBox1.add(bt1);
		hBox1.add(Box.createHorizontalStrut(10));
		hBox1.add(bt2);
		hBox1.add(Box.createHorizontalStrut(10));
		hBox1.add(bt3);	
		add(hBox1);
		
		Box vBox1 = Box.createVerticalBox();
		
		vBox1.add(hBox);
		vBox1.add(hBox1);
		
			
		
		lpanel = new JPanel(new BorderLayout());
		lpanel.setBorder(new TitledBorder(new EtchedBorder(), "ȸ�����,����,��ȸ"));
		lpanel.add(vBox1);
		
		Box hhBox = Box.createHorizontalBox();
		hhBox.add(Box.createVerticalStrut(20));
		bt4 = new JButton("�����ܺ���");
		hhBox.add(bt4);
		hhBox.add(Box.createGlue());
		llpanel = new JPanel(new BorderLayout());
		llpanel.setBorder(new TitledBorder(new EtchedBorder(), "������"));
		llpanel.add(hhBox);
		
		Box hhhBox = Box.createHorizontalBox();
		ta = new JTextArea(10,20);
		hhhBox.add(ta);
		Box cBox = Box.createVerticalBox();
		lllpanel = new JPanel(new BorderLayout());
		lllpanel.setBorder(new TitledBorder(new EtchedBorder(), "���"));
		lllpanel.add(hhhBox);
		
		cBox.add(lpanel);
		cBox.add(llpanel);
		cBox.add(lllpanel);
		add(cBox);
		
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
	}
	
	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mc.setSize(800, 400);
		mc.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == bt1) {
			String rad = "";
			Enumeration<AbstractButton> er = rgroup.getElements();
			while(er.hasMoreElements()) {
				AbstractButton abt = er.nextElement();
				if (abt.isSelected()) {
					rad = abt.getText();
				} 
			}		
			int con = JOptionPane.showConfirmDialog(this, "ȸ���� ����Ͻðڽ��ϱ�?","ȸ�����",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(con == JOptionPane.YES_NO_OPTION) {
				pt2.mapListAdd(tf1.getText(), tf2.getText(), tf3.getText(), rad);
				
			}
		}
		if(e.getSource() == bt2) {
			int con = JOptionPane.showConfirmDialog(this, "ȸ���� �����Ͻðڽ��ϱ�?","ȸ������",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			if(con==JOptionPane.YES_NO_OPTION) {
				pt2.mapListRemove(tf1.getText());
			}
		}
		if(e.getSource() == bt3) {
			String a = "ȸ��ID\tȸ���̸�\t��ȭ��ȣ\t����\n";
			String res = "";
			ArrayList<MemberData> at = new ArrayList<MemberData>();
			at = pt2.getMapList();
			Iterator<MemberData> it = at.iterator();
			
			while (it.hasNext()) {
				MemberData memb = it.next();
				res = res + memb.getMemberID() + "\t" + memb.getName() + "\t" + memb.getTel() + "\t" + memb.getGender() + "\n";
			}
			ta.setText(a + res);
		}
		
		if(e.getSource() == bt4) {			
			String gugu = JOptionPane.showInputDialog("����� ���ðڽ��ϱ�?");
			if(gugu != null)
				ta.setText(pt1.getGuGudan(Integer.parseInt(gugu)));
					
			
		}
	}
}
