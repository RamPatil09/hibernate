package com.xworkz.hibernate.mobilerecharge1.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.xworkz.hibernate.mobilerecharge1.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.ServiceProvider;

@Entity
@Table(name = "mobile_recharge_details", schema = "hibernate")
@NamedQueries({ @NamedQuery(name = "getMobileRechDTO", query = "from MobileRechDTO where id =:id"),
		@NamedQuery(name = "getServiceProviderByType", query = "select serviceProvider from MobileRechDTO where rechargeType=:type"),
		@NamedQuery(name = "getPlanByServiceProvider", query = "select plan from MobileRechDTO Where serviceProvider= :provider"),
		@NamedQuery(name = "getPhNumberById", query = "select number from MobileRechDTO Where id=:id"),
		@NamedQuery(name = "getAllDetails", query = "from MobileRechDTO"),
		@NamedQuery(name = "getServiceProviderAndPhNumberById", query = "select serviceProvider,number from MobileRechDTO where id=:id"),
		@NamedQuery(name = "getAllServiceProviderAndAllPhNumber", query = "select serviceProvider,number from MobileRechDTO"),
		@NamedQuery(name = "deleteByServiceprovider", query = "delete from MobileRechDTO where serviceProvider=:provider"),
		@NamedQuery(name = "deleteMobileRechDTO", query = "delete from MobileRechDTO where id =:id"),
		@NamedQuery(name = "updateServiceProviderByPhoneNumber", query = "update MobileRechDTO set serviceProvider= :provider where number = :number"),
		@NamedQuery(name = "updatePlanById", query = "update MobileRechDTO set plan=:plan Where id=:id"),
		@NamedQuery(name = "updateTypeByPhNumber", query = "update MobileRechDTO set rechargeType=:type where number=:num"),
		@NamedQuery(name = "deleteByType", query = "delete from MobileRechDTO where rechargeType=:type ") })

public class MobileRechDTO {

	@Id
	@GenericGenerator(name = "ref", strategy = "increment")
	@GeneratedValue(generator = "ref")
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

	public MobileRechDTO() {

	}

	public MobileRechDTO(int id, ServiceProvider serviceProvider, long number, double plan, RechargeType rechargeType) {
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
