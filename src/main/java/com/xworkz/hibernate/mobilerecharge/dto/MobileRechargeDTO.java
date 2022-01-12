package com.xworkz.hibernate.mobilerecharge.dto;

import com.xworkz.hibernate.mobilerecharge.enumfiles.ServiceProvider;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import com.xworkz.hibernate.mobilerecharge.enumfiles.RechargeType;

@Entity
@Table(name = "mobile_recharge_details", schema = "hibernate")
public class MobileRechargeDTO {

	@Id
	@Column(name = "recharge_id")
	private int id;
	@Column(name = "service_provider")
	@Enumerated(EnumType.STRING)
	private ServiceProvider serviceProvider;
	@Column(name = "number")
	private long number;
	@Column(name = "recharge_plan")
	private double plan;
	@Column(name = "recharge_type")
	@Enumerated(EnumType.STRING)
	private RechargeType rechargeType;

	public MobileRechargeDTO() {
		super();
	}

	public MobileRechargeDTO(int id, ServiceProvider serviceProvider, long number, double plan,
			RechargeType rechargeType) {
		this.id = id;
		this.serviceProvider = serviceProvider;
		this.number = number;
		this.plan = plan;
		this.rechargeType = rechargeType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public double getPlan() {
		return plan;
	}

	public void setPlan(double plan) {
		this.plan = plan;
	}

	public RechargeType getRechargeType() {
		return rechargeType;
	}

	public void setRechargeType(RechargeType rechargeType) {
		this.rechargeType = rechargeType;
	}

	@Override
	public String toString() {
		return "MobileRechargeDTO [id=" + id + ", serviceProvider=" + serviceProvider + ", number=" + number + ", plan="
				+ plan + ", rechargeType=" + rechargeType + "]";
	}

}
