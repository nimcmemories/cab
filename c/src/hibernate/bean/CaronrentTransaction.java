package hibernate.bean;
// Generated 7 Oct, 2014 5:35:30 PM by Hibernate Tools 3.6.0


import java.util.Date;

/**
 * CaronrentTransaction generated by hbm2java
 */
public class CaronrentTransaction  extends BaseBean {


     private Integer carOnRentId;
     private TaxiDetails taxiDetails;
     private AreaMaster areaMaster;
     private PerHourRate perHourRate;
     private PerKmRate perKmRate;
     private PartnerDetails partnerDetails;
     private PerDayRate perDayRate;
     private CustomerRegistration customerRegistration;
     private String pickupAddress;
     private Date pickupTime;
     private Date date;
     private double estimateKm;
     private double estimateCost;
     private String note;

    public CaronrentTransaction() {
    }

    public CaronrentTransaction(TaxiDetails taxiDetails, AreaMaster areaMaster, PerHourRate perHourRate, PerKmRate perKmRate, PartnerDetails partnerDetails, PerDayRate perDayRate, CustomerRegistration customerRegistration, String pickupAddress, Date pickupTime, Date date, double estimateKm, double estimateCost, String note) {
       this.taxiDetails = taxiDetails;
       this.areaMaster = areaMaster;
       this.perHourRate = perHourRate;
       this.perKmRate = perKmRate;
       this.partnerDetails = partnerDetails;
       this.perDayRate = perDayRate;
       this.customerRegistration = customerRegistration;
       this.pickupAddress = pickupAddress;
       this.pickupTime = pickupTime;
       this.date = date;
       this.estimateKm = estimateKm;
       this.estimateCost = estimateCost;
       this.note = note;
    }
   
    public Integer getCarOnRentId() {
        return this.carOnRentId;
    }
    
    public void setCarOnRentId(Integer carOnRentId) {
        this.carOnRentId = carOnRentId;
    }
    public TaxiDetails getTaxiDetails() {
        return this.taxiDetails;
    }
    
    public void setTaxiDetails(TaxiDetails taxiDetails) {
        this.taxiDetails = taxiDetails;
    }
    public AreaMaster getAreaMaster() {
        return this.areaMaster;
    }
    
    public void setAreaMaster(AreaMaster areaMaster) {
        this.areaMaster = areaMaster;
    }
    public PerHourRate getPerHourRate() {
        return this.perHourRate;
    }
    
    public void setPerHourRate(PerHourRate perHourRate) {
        this.perHourRate = perHourRate;
    }
    public PerKmRate getPerKmRate() {
        return this.perKmRate;
    }
    
    public void setPerKmRate(PerKmRate perKmRate) {
        this.perKmRate = perKmRate;
    }
    public PartnerDetails getPartnerDetails() {
        return this.partnerDetails;
    }
    
    public void setPartnerDetails(PartnerDetails partnerDetails) {
        this.partnerDetails = partnerDetails;
    }
    public PerDayRate getPerDayRate() {
        return this.perDayRate;
    }
    
    public void setPerDayRate(PerDayRate perDayRate) {
        this.perDayRate = perDayRate;
    }
    public CustomerRegistration getCustomerRegistration() {
        return this.customerRegistration;
    }
    
    public void setCustomerRegistration(CustomerRegistration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }
    public String getPickupAddress() {
        return this.pickupAddress;
    }
    
    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
    public Date getPickupTime() {
        return this.pickupTime;
    }
    
    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public double getEstimateKm() {
        return this.estimateKm;
    }
    
    public void setEstimateKm(double estimateKm) {
        this.estimateKm = estimateKm;
    }
    public double getEstimateCost() {
        return this.estimateCost;
    }
    
    public void setEstimateCost(double estimateCost) {
        this.estimateCost = estimateCost;
    }
    public String getNote() {
        return this.note;
    }
    
    public void setNote(String note) {
        this.note = note;
    }

	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}




}


