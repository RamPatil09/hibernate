package com.xworkz.hibernate.mobilerecharge1.dao;

import java.util.List;

import com.xworkz.hibernate.mobilerecharge1.dto.MobileRechDTO;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.ServiceProvider;

public interface MobileRechDAO {

	boolean createRecharge(MobileRechDTO dto);

	Object getMobileRechDTO(int id);

	boolean deleteMobileRechDTO(int id);

	boolean updateServiceProviderByPhoneNumber(ServiceProvider provider, long phNumber);

	List<MobileRechDTO> getServiceProviderByType(RechargeType rechargeType);

	List<MobileRechDTO> getPlanByServiceProvider(ServiceProvider provider);

	Object getPhNumberById(int id);

	boolean updatePlanById(double plan, int id);

	boolean updateTypeByPhNumber(long phnumber, RechargeType rechargeType);

	boolean deleteByServiceprovider(ServiceProvider provider);

	boolean deleteByType(RechargeType rechargeType);

	List<MobileRechDTO> getAllDetails();

	Object[] getServiceProviderAndPhNumberById(int id);

	List<Object[]> getAllServiceProviderAndAllPhNumber();
}
