package create_voucher;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/* 
 * 16자리 숫자 코드
 * YMMDD(5자리) + 랜덤번호 (11자리) 배치 조합
 * 랜덤번호 중복확인
 * YMMR - RRRR - RRRR - RRdd
 */

public class generator {

	public static void main(String[]args) {
		 int n = 11; // 11자리 랜덤 숫자
		 int gernerateSize = 3; //n개 생성
		 char[] chs = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'}; // 숫자조합format쿠폰
		 String[] couponArr = new String[gernerateSize];
		 int currentIndex = 0;
		
		 String YMM;
		 String dd;
		
		 String couponSerialnb;
		 String couponPrint;
		
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		String dateTemp = format.format(time).toString();
		YMM = dateTemp.substring(3,6);
		dd = dateTemp.substring(6,8);
		
		Random rd = new Random();
		while(currentIndex < gernerateSize) {
			StringBuilder sb = new StringBuilder();
			// n 자리 랜덤숫자생성
			for (int i = 0; i < n; i++) {
				char ch = chs[rd.nextInt(chs.length)];
				sb.append(ch);
				couponArr[currentIndex] = sb.toString();
			}
			//중복확인 코드 (300만개 돌려도 아직 중복 나온적없음)
			for(int j=0; j<currentIndex; j++) {
				if(couponArr[currentIndex] == couponArr[j]) {
					System.out.println("DUPLICATE OCCURED!! >>>>>>>>>");
					currentIndex--;
				}
			}
			couponSerialnb = YMM + sb.toString() + dd;
			couponPrint = couponSerialnb.substring(0,4) + " - " +
			couponSerialnb.substring(4,8) + " - " +
			couponSerialnb.substring(8,12) + " - " +
			couponSerialnb.substring(12,16);
//			couponArr[currentIndex] = couponSerialnb; //붙어있는 숫자형태
			couponArr[currentIndex] = couponPrint;  //대쉬있는 형태
			   currentIndex++;
		}
		System.out.println(Arrays.toString(couponArr));
		
	}
	
	
}
