package hibernate.bean;
// Generated 7 Oct, 2014 5:35:30 PM by Hibernate Tools 3.6.0



/**
 * PackageTaxi generated by hbm2java
 */
public class PackageTaxi  extends BaseBean {


     private Integer packageTaxiId;
     private PerKmRate perKmRate;

    public PackageTaxi() {
    }

    public PackageTaxi(PerKmRate perKmRate) {
       this.perKmRate = perKmRate;
    }
   
    public Integer getPackageTaxiId() {
        return this.packageTaxiId;
    }
    
    public void setPackageTaxiId(Integer packageTaxiId) {
        this.packageTaxiId = packageTaxiId;
    }
    public PerKmRate getPerKmRate() {
        return this.perKmRate;
    }
    
    public void setPerKmRate(PerKmRate perKmRate) {
        this.perKmRate = perKmRate;
    }

	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}




}


