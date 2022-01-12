package com.xworkz.hibernate.mobilerecharge.dao;

import com.xworkz.hibernate.mobilerecharge.dto.MobileRechargeDTO;
import com.xworkz.hibernate.mobilerecharge.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge.enumfiles.ServiceProvider;

public interface MobileRechargeDAO {

	public boolean createRecharge(MobileRechargeDTO dto);

	public MobileRechargeDTO getMobileRechargeDTO(int id);

	public boolean deleteMobileRechargeDTO(int id);

	public boolean updateServiceProviderByPhoneNumber(int id, long phNumber, ServiceProvider provider);

	public ServiceProvider getServiceProviderByType(int id, RechargeType rechargeType);

	public double getPlanByServiceProvider(int id, ServiceProvider provider);

	public long getPhNumberById(int id);

	public boolean updatePlanById(int id, double plan);

	public boolean updateTypeByPhNumber(int id, long phnumber, RechargeType rechargeType);

	public boolean deleteByServiceprovider(int id, ServiceProvider provider);

	public boolean deleteByType(int Id, RechargeType rechargeType);
}