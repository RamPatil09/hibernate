package com.xworkz.hibernate.mobilerecharge1;

import com.xworkz.hibernate.mobilerecharge1.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.ServiceProvider;

import java.util.List;

import com.xworkz.hibernate.mobilerecharge1.dao.MobileRechDAO;
import com.xworkz.hibernate.mobilerecharge1.dao.MobileRechDAOImpl;
import com.xworkz.hibernate.mobilerecharge1.dto.MobileRechDTO;

public class MobileRechArrival {

	public static void main(String[] args) {
		
		MobileRechDTO dto = new MobileRechDTO(1, ServiceProvider.AIRTEL, 7849051346L, 799.0,
				RechargeType.PREPAID);
		MobileRechDTO dto2 = new MobileRechDTO(2, ServiceProvider.JIO, 6360307277L, 699.0,
				RechargeType.PREPAID);
		MobileRechDTO dto3 = new MobileRechDTO(3, ServiceProvider.BSNL, 9448876428L, 399.0,
				RechargeType.POSTPAID);
		MobileRechDTO dto4 = new MobileRechDTO(4, ServiceProvider.AIRTEL, 9448376428L, 399.0,
				RechargeType.PREPAID);
		MobileRechDTO dto5 = new MobileRechDTO(5, ServiceProvider.JIO, 6361336068L, 399.0,
				RechargeType.PREPAID);
		MobileRechDTO dto6 = new MobileRechDTO(6, ServiceProvider.JIO, 8217566973L, 699.0,
				RechargeType.PREPAID);
		MobileRechDTO dto7 = new MobileRechDTO(7, ServiceProvider.JIO, 6360307277L, 699.0,
				RechargeType.PREPAID);
		
		MobileRechDAO dao = new MobileRechDAOImpl();
		/*
		System.out.println(dao.createRecharge(dto5));
		System.out.println(dao.createRecharge(dto6));
		System.out.println(dao.createRecharge(dto7));
		
		System.out.println(dao.createRecharge(dto4));
		System.out.println(dao.deleteMobileRechDTO(7)); 
		System.out.println(dao.getServiceProviderByType(RechargeType.PREPAID));
		System.out.println(dao.getPlanByServiceProvider(ServiceProvider.AIRTEL));
		System.out.println(dao.getPhNumberById(1));
		System.out.println(dao.updatePlanById(799.0, 3));
		System.out.println(dao.updateTypeByPhNumber(7849051346L, RechargeType.POSTPAID));
		System.out.println(dao.updateServiceProviderByPhoneNumber( ServiceProvider.VI,6360307277L));
		System.out.println(dao.deleteByType(RechargeType.POSTPAID));
		System.out.println(dao.deleteByServiceprovider(ServiceProvider.VI));
		System.out.println(dao.getServiceProviderByType(RechargeType.POSTPAID));
		Object[] objects = dao.getServiceProviderAndPhNumberById(4);
		for (int i = 0; i < objects.length; i++) {
			System.out.println(objects[i]);
		}
		
		List<Object[]> list = dao.getAllServiceProviderAndAllPhNumber();
		for (Object[] objects : list) {
			for (Object objects2 : objects) {
				System.out.print(objects2+" ");
			}
			System.out.println();
		}
		
		System.out.println(dao.createRecharge(dto));
		System.out.println(dao.getPhNumberById(4));
		System.out.println(dao.createRecharge(dto2));
		System.out.println(dao.createRecharge(dto3));
		*/
		
		List<MobileRechDTO> dtos = dao.getAllDetails();
		for (MobileRechDTO mobileRechDTO : dtos) {
			System.out.println(mobileRechDTO);
		} 
	
	}
}
