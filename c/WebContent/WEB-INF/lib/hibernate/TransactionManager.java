package hibernate;

import java.lang.reflect.Method;

import hibernate.tx.TransactionManagerImpl;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class TransactionManager implements TransactionManagerImpl{

	void  callMethod(String className,String methodCall){
	/*	Method method = ((Class<?>.rollback();
			e.printStackTrace();
		}finally{
			System.out.println("LOGNIMC : transaction finally block : ");
			if(session != null){
				session.close();
			}
		}*/
	}
	@Override
	public boolean saveTransaction(Transaction tx) {
		try{
			tx.commit();
			System.out.println("LOGNIMC : saving transaction successfully ");
			return true;
		}catch(Exception e){
			System.out.println("LOGNIMC : getting error on commit transaction : wasRolledBAck ? " + tx.wasRolledBack());
			return false;
		}
	}
	@Override
	public void getTransaction() {
		// TODO Auto-generated method stub
		
	}

}
