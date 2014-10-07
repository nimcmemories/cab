package hibernate.bean;
// Generated 7 Oct, 2014 5:35:30 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * BikeTransaction generated by hbm2java
 */
public class BikeTransaction  extends BaseBean {


     private Integer bikeTransactionId;
     private BikeDetails bikeDetails;
     private PartnerDetails partnerDetails;
     private CityMaster cityMaster;
     private CustomerRegistration customerRegistration;
     private AreaMaster areaMaster;
     private Date time;
     private String note;
     private double estimateCost;

    public BikeTransaction() {
    }

    public BikeTransaction(BikeDetails bikeDetails, PartnerDetails partnerDetails, CityMaster cityMaster, CustomerRegistration customerRegistration, AreaMaster areaMaster, Date time, String note, double estimateCost) {
       this.bikeDetails = bikeDetails;
       this.partnerDetails = partnerDetails;
       this.cityMaster = cityMaster;
       this.customerRegistration = customerRegistration;
       this.areaMaster = areaMaster;
       this.time = time;
       this.note = note;
       this.estimateCost = estimateCost;
    }
   
    public Integer getBikeTransactionId() {
        return this.bikeTransactionId;
    }
    
    public void setBikeTransactionId(Integer bikeTransactionId) {
        this.bikeTransactionId = bikeTransactionId;
    }
    public BikeDetails getBikeDetails() {
        return this.bikeDetails;
    }
    
    public void setBikeDetails(BikeDetails bikeDetails) {
        this.bikeDetails = bikeDetails;
    }
    public PartnerDetails getPartnerDetails() {
        return this.partnerDetails;
    }
    
    public void setPartnerDetails(PartnerDetails partnerDetails) {
        this.partnerDetails = partnerDetails;
    }
    public CityMaster getCityMaster() {
        return this.cityMaster;
    }
    
    public void setCityMaster(CityMaster cityMaster) {
        this.cityMaster = cityMaster;
    }
    public CustomerRegistration getCustomerRegistration() {
        return this.customerRegistration;
    }
    
    public void setCustomerRegistration(CustomerRegistration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }
    public AreaMaster getAreaMaster() {
        return this.areaMaster;
    }
    
    public void setAreaMaster(AreaMaster areaMaster) {
        this.areaMaster = areaMaster;
    }
    public Date getTime() {
        return this.time;
    }
    
    public void setTime(Date time) {
        this.time = time;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }
    public double getEstimateCost() {
        return this.estimateCost;
    }
    
    public void setEstimateCost(double estimateCost) {
        this.estimateCost = estimateCost;
    }

	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}




}


