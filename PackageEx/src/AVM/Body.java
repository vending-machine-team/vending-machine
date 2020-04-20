package AVM;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;
import javax.swing.JTextField;
import javax.swing.JPanel;
//전정원
public class Body {
	static JButton btn1,btn2;
	static JLabel imgLbl1,imgLbl2,imgLbl3;
	static JTextField field;
	static Food food[] = new Food[3];
	static int currentMoeny,TotalPrice=0; // <<< 실 계산용 값들 입력하는 현재값(내는 돈)? 음식 총 가격
	static final int MaxSize=100;
	public static void main(String[] args) {
		// 음식 실제 정보들 >> 알고리즘 사용용
		food[0]= new Food("너구리",0,2500);
		food[1]= new Food("코카콜라",0,1500);
		food[2]=new Food("트로피카나",0,1450);
		//

		
	    String foodSize[]= {"0","0","0"}; //인터페이스 수량 표시용
	    String FoodSum[]= {"0"}; //인터페이스 가격합 표시용
	    // 모든 글꼴 통일
		Enumeration<Object> keys = UIManager.getDefaults().keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);
			if (value instanceof FontUIResource)
				UIManager.put(key, new FontUIResource("굴림", Font.PLAIN, 14));
		}
		
		// [start] 프레임 설정
		JFrame frm = new JFrame();
		frm.setTitle("AVM");
		frm.setSize(500, 500);
		frm.setLocationRelativeTo(null);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.getContentPane().setLayout(null);
		// [end] 프레임 설정
		
		
		// [start] 수량조절버튼
		JButton btn1 = new JButton("↓"); 
		JButton btn2 = new JButton("↑"); 
		JButton btn3 = new JButton("↓"); 
		JButton btn4 = new JButton("↑"); 
		JButton btn5 = new JButton("↓"); 
		JButton btn6 = new JButton("↑"); 
		JButton btnSt= new JButton("시작");
		
		btn1.setBounds(120, 195, 45, 45);
		btn2.setBounds(120, 145, 45, 45);
		btn3.setBounds(270, 195, 45, 45);
		btn4.setBounds(270, 145, 45, 45);
		btn5.setBounds(420, 195, 45, 45);
		btn6.setBounds(420, 145, 45, 45);
		btnSt.setBounds(330, 295, 65, 35);
		
		frm.getContentPane().add(btn1);
		frm.getContentPane().add(btn2);
		frm.getContentPane().add(btn3);
		frm.getContentPane().add(btn4);
		frm.getContentPane().add(btn5);
		frm.getContentPane().add(btn6);
		frm.getContentPane().add(btnSt);
		// 프레임이 보이도록 설정
		// [end] 수량조절버튼
		
		// [start] 자바 텍스트필트 >> 현재 금액 및 최종 가격 관련 코드
		field= new JTextField(10);
		field.setText("");
		field.setHorizontalAlignment(JTextField.CENTER);
		field.setBounds(200, 300, 100, 25);
		frm.getContentPane().add(field);
		JLabel lbl4=new JLabel();
		lbl4.setBounds(120, 293, 80, 40);
		lbl4.setText("현재 금액");
		frm.getContentPane().add(lbl4);
		btnSt.addActionListener(event->{
			if(Integer.parseInt(field.getText())<0) {
				field.setEditable(false); //음수 입력 불가 에러메세지로 바꿀예정
			}
			else {
				currentMoeny = Integer.parseInt(field.getText());//입력한현재금액 currentMoney에 저장
			}
		});
		// [end] 자바 텍스트필드 >> 현재 금액 입력받아 거스름돈 받는.
		
		// [start] 물건의 합계 표시하는 곳
		JLabel lblSumText = new JLabel();
		lblSumText.setBounds(170,360, 80, 40);
		lblSumText.setText("합계는");
		frm.getContentPane().add(lblSumText);
		
		FoodSum[0]=Integer.toString(TotalPrice);
		JLabel lblSumNum=new JLabel();
		lblSumNum.setBounds(240, 355, 50, 50);
		lblSumNum.setText(FoodSum[0]);
		frm.getContentPane().add(lblSumNum);
		
		JButton btnPurchase= new JButton("구매");
		btnPurchase.setBounds(290, 363, 65, 35);
		frm.getContentPane().add(btnPurchase);
		
		/* 구매 버튼 누르면 계산하는 알고리즘으로 넘어가는 부분, 구현 예정
		btnPurchase.addActionListener(event->{
			Algorithm(TotalPrice,currentMoney); << 임시
		});*/
		// [end] 물건의 합계 표시하는 곳
		
		//Int형 >> String형 (인터페이스 표기위함)
		foodSize[0] = Integer.toString(food[0].size);
		foodSize[1] = Integer.toString(food[1].size);
		foodSize[2] = Integer.toString(food[2].size);
		//
		
		//[시작] 수량
		JLabel lbl = new JLabel();
		lbl.setBounds(70, 180, 200, 20);
		lbl.setText(foodSize[0]);
		frm.getContentPane().add(lbl);
		
		JLabel lbl2 = new JLabel();
		lbl2.setBounds(220, 180, 200, 20);
		lbl2.setText(foodSize[1]);
		frm.getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel();
		lbl3.setBounds(370, 180, 200, 20);
		lbl3.setText(foodSize[2]);
		frm.getContentPane().add(lbl3);
		//[끝] 수량
		
		//[시작] 가격표기
		JLabel lblPrice = new JLabel();
		lblPrice.setBounds(40, 10, 200, 20);
		lblPrice.setText("<"+food[0].price+"원"+">");
		frm.getContentPane().add(lblPrice);
		
		JLabel lblPrice2 = new JLabel();
		lblPrice2.setBounds(200, 10, 200, 20);
		lblPrice2.setText("<"+food[1].price+"원"+">");
		frm.getContentPane().add(lblPrice2);
		
		JLabel lblPrice3 = new JLabel();
		lblPrice3.setBounds(350, 10, 200, 20);
		lblPrice3.setText("<"+food[2].price+"원"+">");
		frm.getContentPane().add(lblPrice3);
		//[끝] 가격표기
		
		// [시작] 제품이미지
		//너구리
		imgLbl1 = new JLabel();
		ImageIcon NGIMg = new ImageIcon(Body.class.getResource("/AVM/img/너굴맨.jpg"));
		imgLbl1.setIcon(NGIMg);
		imgLbl1.setBounds(15, 35,125,100);
		imgLbl1.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl1);
        //사람너구리
        ImageIcon HumanNG = new ImageIcon(Body.class.getResource("/AVM/img/너구리입2.gif"));
        
        //콜라
        imgLbl2 = new JLabel();
		ImageIcon Coke = new ImageIcon(Body.class.getResource("/AVM/img/코카카코.jpg"));
		imgLbl2.setIcon(Coke);
		imgLbl2.setBounds(180, 35,100,100);
		imgLbl2.setHorizontalAlignment(JLabel.CENTER);
        frm.getContentPane().add(imgLbl2);
        //콜라곰
        ImageIcon Bear = new ImageIcon(Body.class.getResource("/AVM/img/콜라곰.gif"));
        
        //트로피카나
        imgLbl3 = new JLabel();
		ImageIcon Trop = new ImageIcon(Body.class.getResource("/AVM/img/트로피카나2.jpg"));
		imgLbl3.setIcon(Trop);
		imgLbl3.setBounds(330, 35,100,100);
		imgLbl3.setHorizontalAlignment(JLabel.CENTER);
		frm.getContentPane().add(imgLbl3);
        //주이
		ImageIcon JOO2 = new ImageIcon(Body.class.getResource("/AVM/img/주이움직2.gif"));
		
		// [끝] 제품이미지
		
		// [시작] 수량조절버튼
		btn1.addActionListener(event->{
			if(food[0].size>0) {  //0 밑으로는 못누르게 만들기
			food[0].size--;
			TotalPrice-=food[0].price;
			if(food[0].size==10) Body.imgLbl1.setIcon(HumanNG);
			else Body.imgLbl1.setIcon(NGIMg);
			foodSize[0]= Integer.toString(food[0].size);
			lbl.setText(foodSize[0]);//수량감소함수
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn2.addActionListener(event->{
			if(food[0].size<MaxSize) {
			food[0].size++;
			TotalPrice+=food[0].price;
			if(food[0].size==10) Body.imgLbl1.setIcon(HumanNG);
			else Body.imgLbl1.setIcon(NGIMg);
			foodSize[0]= Integer.toString(food[0].size);
			lbl.setText(foodSize[0]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});

		
		btn3.addActionListener(event->{
			if(food[1].size>0) {  //0 밑으로는 못누르게 만들기
			food[1].size--;
			TotalPrice-=food[1].price;
			if(food[1].size==10) Body.imgLbl2.setIcon(Bear);
			else Body.imgLbl2.setIcon(Coke);
			foodSize[1]= Integer.toString(food[1].size);
			lbl2.setText(foodSize[1]);//수량감소함수
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn4.addActionListener(event->{
			if(food[1].size<MaxSize) {
			food[1].size++;
			TotalPrice+=food[1].price;
			if(food[1].size==10) Body.imgLbl2.setIcon(Bear);
			else Body.imgLbl2.setIcon(Coke);
			foodSize[1]=Integer.toString(food[1].size);
			lbl2.setText(foodSize[1]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		
		
		btn5.addActionListener(event->{
			if(food[2].size>0) {  //0 밑으로는 못누르게 만들기
			food[2].size--;
			TotalPrice-=food[2].price;
			if(food[2].size==10) Body.imgLbl3.setIcon(JOO2);
			else Body.imgLbl3.setIcon(Trop);
			foodSize[2]= Integer.toString(food[2].size);
			lbl3.setText(foodSize[2]);//수량감소함수
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		btn6.addActionListener(event->{
			if(food[2].size<MaxSize) {
			food[2].size++;
			TotalPrice+=food[2].price;
			if(food[2].size==10) Body.imgLbl3.setIcon(JOO2);
			else Body.imgLbl3.setIcon(Trop);
			foodSize[2]= Integer.toString(food[2].size);
			lbl3.setText(foodSize[2]);
			
			FoodSum[0]=Integer.toString(TotalPrice);
			lblSumNum.setText(FoodSum[0]);
			}
		});
		
		//[시작] 수량조절버튼
        
		frm.setVisible(true);
		// [end]
		}
}
