package hibernate.tx;

import org.hibernate.Transaction;

public interface TransactionManagerImpl {
	public void  getTransaction();
	public boolean saveTransaction(Transaction tx);
}
