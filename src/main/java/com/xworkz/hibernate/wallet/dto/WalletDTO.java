package com.xworkz.hibernate.wallet.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.hibernate.wallet.enumFiles.WalletName;

@Entity
@Table(name = "wallet_details", schema = "hibernate")
public class WalletDTO {

	@Id
	@Column(name = "wallet_id")
	private int id;
	@Column(name = "wallet_name")
	@Enumerated(EnumType.STRING)
	private WalletName walletName;
	@Column(name = "upi_id")
	private String upiId;
	@Column(name = "wallet_amount")
	private double amount;

	public WalletDTO() {
		super();
	}

	public WalletDTO(int id, WalletName walletName, String upiId, double amount) {
		this.id = id;
		this.walletName = walletName;
		this.upiId = upiId;
		this.amount = amount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WalletName getWalletName() {
		return walletName;
	}

	public void setWalletName(WalletName walletName) {
		this.walletName = walletName;
	}

	public String getUpiId() {
		return upiId;
	}

	public void setUpiId(String upiId) {
		this.upiId = upiId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "WalletDTO [id=" + id + ", walletName=" + walletName + ", upiId=" + upiId + ", amount=" + amount + "]";
	}

}
