import javax.swing.*;
import javax.swing.event.CaretListener;
import java.awt.*;
import java.awt.event.*; //�ޥγB�z�ƥ�event�M��
import java.io.File;

class consumption{
	private  int adult,child,adultPrice,childPrice,allPrice;
	int []AdCh = new int[2];
	public consumption(int adult,int child,int night){
		this.adult=adult;
		this.child=child;
		if(night==1){ 
			adultPrice=368;
			childPrice=150;
		}
		else{
			adultPrice=268;
			childPrice=120;
		}
		threeDiscount();
		allPrice=tenDiscount(serviceCharges(totalPrice()),adult+child);
		System.out.println(allPrice);
	}
	public int getallprice(){
		return allPrice;
	}
	public  int serviceCharges(int in){
		int out;
		out=(int) (in*1.1);
		return out;
	}
	public int tenDiscount(int in,int nubmerPeople){ //�Q�H�P�楴��
		int out ;
		if(nubmerPeople>10){
			out=(int) (in*0.95);
		}
		else 
			out=in;
		return out;
	}
	public void threeDiscount(){ //�T�H�P�楲���K�O�j
		int allNumber,freeNumber;
		allNumber=adult+child;
		if(allNumber>=3){
			freeNumber=allNumber/3;
			if(freeNumber>child){
				freeNumber=freeNumber-child;
				child=0;
				adult=adult-freeNumber;
			}
			else{
				child=child-freeNumber;
			}
		}		
		AdCh[0]=adult;
		AdCh[1]=child;
	}
	public int totalPrice(){
		return AdCh[0]*adultPrice+AdCh[1]*childPrice;
	}
}

public class SoftWarehw5  {
	JFrame frame= new JFrame("�a�x�饻�Ʋz�\�U�л����p�⾹");
	Container cp = frame.getContentPane(); //���o���e����
	JLabel label[] = new JLabel[5];
	JButton button = new JButton("�}�l�p��");
	JTextField []textField= new JTextField[2];
	JRadioButton []radioButton = new JRadioButton[2];
	ButtonGroup bG = new ButtonGroup();
	int adultnumber=0,childnumber=0;
	FocusListener fl=new FocusAdapter (){
		public void focusLost(FocusEvent e) {
			System.out.println(((JTextField)e.getSource()).getText());
			if(((JTextField)e.getSource()).getText().matches("[1-9][0-9]*") ){//�P�_�O�_�¼Ʀr
				adultnumber=Integer.parseInt(((JTextField)e.getSource()).getText());
			}
		}
	};
	FocusListener fl1=new FocusAdapter (){
		public void focusLost(FocusEvent e) {
			System.out.println(((JTextField)e.getSource()).getText());
			if(((JTextField)e.getSource()).getText().matches("[1-9][0-9]*") ){//�P�_�O�_�¼Ʀr
				childnumber=Integer.parseInt(((JTextField)e.getSource()).getText());
			}
		}
	};
	ActionListener al=new ActionListener (){
		public void actionPerformed(ActionEvent e) {
			int flag=0;
			if(radioButton[0].isSelected()==true){
				flag=0;
			}
			else{
				flag=1;
			}
			consumption c= new consumption(adultnumber, childnumber,flag );
			label[4].setText("�`�����G"+Integer.toString(c.getallprice()));
		}
	};
	
	SoftWarehw5(){
		
		cp.setLayout(null);
		
		label[0]=new JLabel("�j�H");
		label[0].setHorizontalAlignment(SwingConstants.CENTER);
		label[0].setBounds(51, 27, 46, 15);
		label[1]=new JLabel("�p��");
		label[1].setHorizontalAlignment(SwingConstants.CENTER);
		label[1].setBounds(185, 27, 46, 15);
		label[2]=new JLabel("�դ�");
		label[2].setHorizontalAlignment(SwingConstants.RIGHT);
		label[2].setBounds(185, 92, 51, 15);
		label[3]=new JLabel("�ߤW");
		label[3].setHorizontalAlignment(SwingConstants.RIGHT);
		label[3].setBounds(185, 121, 51, 15);
		label[4]=new JLabel("�`�����G");
		label[4].setBounds(10, 121, 200, 15);
		button.setBounds(95, 80, 87, 23);
		textField[0]= new JTextField();
		textField[0].setBounds(26, 52, 96, 21);
		textField[1]= new JTextField();
		textField[1].setBounds(160, 52, 96, 21);
		radioButton[0]=new JRadioButton();
		radioButton[0].setSelected(true);
		radioButton[0].setBounds(235, 86, 21, 23);
		radioButton[1] = new JRadioButton();
		radioButton[1].setBounds(235, 117, 21, 23);
		
		for (int i=0;i<5;i++){
			cp.add(label[i]);
		}
		cp.add(button);
		
		
		
		
		for (int i=0;i<2;i++){
			cp.add(textField[i]);
			bG.add(radioButton[i]);
			cp.add(radioButton[i]);
		}
		
		button.addActionListener(al);
		radioButton[0].addActionListener(al);
		radioButton[1].addActionListener(al);
		textField[0].addFocusListener(fl);
		textField[1].addFocusListener(fl1);
		//�]�w�����w�]�������ʧ@�B�����j�p, ����ܵ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(320, 200);
		frame.setVisible(true);
		Dimension dim = frame.getToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getWidth()/2, dim.height/2-frame.getHeight()/2);
		
		
	}
	
	
	public static void main(String args[]) {
		new SoftWarehw5(); //�ŧi�����ج[����
	}
}