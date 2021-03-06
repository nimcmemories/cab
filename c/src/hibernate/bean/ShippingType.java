package hibernate.bean;
// Generated 7 Oct, 2014 5:35:30 PM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * ShippingType generated by hbm2java
 */
public class ShippingType  extends BaseBean {


     private Integer shippingTypeId;
     private String shippingType;
     private Set moversTransactions = new HashSet(0);

    public ShippingType() {
    }

	
    public ShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
    public ShippingType(String shippingType, Set moversTransactions) {
       this.shippingType = shippingType;
       this.moversTransactions = moversTransactions;
    }
   
    public Integer getShippingTypeId() {
        return this.shippingTypeId;
    }
    
    public void setShippingTypeId(Integer shippingTypeId) {
        this.shippingTypeId = shippingTypeId;
    }
    public String getShippingType() {
        return this.shippingType;
    }
    
    public void setShippingType(String shippingType) {
        this.shippingType = shippingType;
    }
    public Set getMoversTransactions() {
        return this.moversTransactions;
    }
    
    public void setMoversTransactions(Set moversTransactions) {
        this.moversTransactions = moversTransactions;
    }


	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}




}


