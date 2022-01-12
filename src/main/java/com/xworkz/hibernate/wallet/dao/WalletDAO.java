package com.xworkz.hibernate.wallet.dao;

import com.xworkz.hibernate.wallet.dto.WalletDTO;

public interface WalletDAO {

	public boolean createWallet(WalletDTO dto);

	public WalletDTO getWalletDTO(int id);

	public boolean deleteWalletDTO(int id);

	public boolean updateAmountById(int id, double amount);
}
