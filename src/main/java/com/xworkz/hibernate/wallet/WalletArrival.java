package com.xworkz.hibernate.wallet;

import com.xworkz.hibernate.wallet.dao.WalletDAO;
import com.xworkz.hibernate.wallet.dao.WalletDAOImpl;
import com.xworkz.hibernate.wallet.dto.WalletDTO;
import com.xworkz.hibernate.wallet.enumFiles.WalletName;

public class WalletArrival {

	public static void main(String[] args) {

		WalletDTO dto = new WalletDTO(1, WalletName.PHONEPE, "7849051346@upi", 1450.0);
		WalletDTO dto2 = new WalletDTO(2, WalletName.GPAY, "9448876428@upi", 51450.0);
		WalletDTO dto3 = new WalletDTO(3, WalletName.PHONEPE, "9448376428@upi", 25450.0);
		WalletDTO dto4 = new WalletDTO(4, WalletName.PAYTM, "6360307277@upi", 950.0);
		WalletDTO dto5 = new WalletDTO(5, WalletName.AMAZONPAY, "9900599102@upi", 21450.0);
		WalletDTO dto6 = new WalletDTO(6, WalletName.EZETAP, "9110292315@upi", 750.0);
		WalletDTO dto7 = new WalletDTO(7, WalletName.GPAY, "7849051346@upi", 2950.0);

		WalletDAO dao = new WalletDAOImpl();
		/*dao.createWallet(dto7);
		dao.createWallet(dto6);
		dao.createWallet(dto5);
		dao.createWallet(dto4);
		dao.createWallet(dto3);
		dao.createWallet(dto2);
		dao.createWallet(dto);
		*/
		System.out.println(dao.getWalletDTO(1));
		//dao.deleteWalletDTO(7);
		dao.updateAmountById(3, 35124.0);
	}
}
