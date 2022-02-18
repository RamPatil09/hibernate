package com.xworkz.hibernate.mobilerecharge1.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.xworkz.hibernate.mobilerecharge1.dto.MobileRechDTO;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.RechargeType;
import com.xworkz.hibernate.mobilerecharge1.enumfiles.ServiceProvider;
import com.xworkz.singleton.HibernateUtil;

public class MobileRechDAOImpl implements MobileRechDAO {

	@Override
	public boolean createRecharge(MobileRechDTO dto) {
		if (dto != null) {
			
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				try {
				session.save(dto);
				} catch (Exception e) {
					e.printStackTrace();
				}
				transaction.commit();
				session.close();
				factory.close();
				System.out.println("DTO Added Successfully...");
				return true;
		}
		return false;
	}

	@Override
	public Object getMobileRechDTO(int id) {
		if (id != 0) {
			try {
				MobileRechDTO dto = (MobileRechDTO) HibernateUtil.getSessionFactory().openSession()
						.getNamedQuery("getMobileRechDTO").setParameter("id", id).uniqueResult();
				return dto != null ? dto : "Id not found";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public boolean deleteMobileRechDTO(int id) {
		if (id != 0) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("deleteMobileRechDTO");
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateServiceProviderByPhoneNumber(ServiceProvider provider, long phNumber) {
		if (provider != null && phNumber != 0) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updateServiceProviderByPhoneNumber");
				query.setParameter("provider", provider);
				query.setParameter("number", phNumber);
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<MobileRechDTO> getServiceProviderByType(RechargeType rechargeType) {
		if (rechargeType != null) {
			try {
				List<MobileRechDTO> list = HibernateUtil.getSessionFactory().openSession()
						.getNamedQuery("getServiceProviderByType").setParameter("type", rechargeType).list();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<MobileRechDTO> getPlanByServiceProvider(ServiceProvider provider) {
		if (provider != null) {
			try {
				List<MobileRechDTO> list = HibernateUtil.getSessionFactory().openSession()
						.getNamedQuery("getPlanByServiceProvider").setParameter("provider", provider).list();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public Object getPhNumberById(int id) {
		if (id != 0) {
			try {
				Object list = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getPhNumberById")
						.setParameter("id", id).uniqueResult();
				return list;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;

	}

	@Override
	public boolean updatePlanById(double plan, int id) {
		if (plan != 0 && id != 0) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updatePlanById");
				query.setParameter("plan", plan);
				query.setParameter("id", id);
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateTypeByPhNumber(long phnumber, RechargeType rechargeType) {
		if (phnumber != 0 && rechargeType != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("updateTypeByPhNumber");
				query.setParameter("type", rechargeType);
				query.setParameter("num", phnumber);
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteByServiceprovider(ServiceProvider provider) {
		if (provider != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("deleteByServiceprovider");
				query.setParameter("provider", provider);
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean deleteByType(RechargeType rechargeType) {
		if (rechargeType != null) {
			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session = factory.openSession();
				Transaction transaction = session.beginTransaction();
				Query query = session.getNamedQuery("deleteByType");
				query.setParameter("type", rechargeType);
				query.executeUpdate();
				transaction.commit();
				session.close();
				factory.close();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public List<MobileRechDTO> getAllDetails() {
		try {
			List<MobileRechDTO> list = HibernateUtil.getSessionFactory().openSession().getNamedQuery("getAllDetails")
					.list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object[] getServiceProviderAndPhNumberById(int id) {
		if (id != 0) {
			try {
				Object[] object = (Object[]) HibernateUtil.getSessionFactory().openSession()
						.getNamedQuery("getServiceProviderAndPhNumberById").setParameter("id", id).uniqueResult();
				// named query means setting parameter for named parameter
				return object;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Object[]> getAllServiceProviderAndAllPhNumber() {
		try {
			List<Object[]> list = HibernateUtil.getSessionFactory().openSession()
					.getNamedQuery("getAllServiceProviderAndAllPhNumber").list();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
