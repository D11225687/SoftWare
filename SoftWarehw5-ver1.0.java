import java.util.Scanner;
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
		System.out.println(adult);
		System.out.println(child);		
		AdCh[0]=adult;
		AdCh[1]=child;
	}
	public int totalPrice(){
		return AdCh[0]*adultPrice+AdCh[1]*childPrice;
	}
}

public class SoftWarehw5  {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("�п�J�j�H�H�ơG");
		int num1 = scanner.nextInt();
		System.out.print("�п�J�p�ĤH�ơG");
		int num2 = scanner.nextInt();
		System.out.print("�ߤW��J0�h�դ�1�G");
		int num3 = scanner.nextInt();
		consumption c= new consumption(num1, num2, num3);
	}
}