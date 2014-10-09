package hibernate.bean;
// Generated 7 Oct, 2014 5:35:30 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * AirportTransaction generated by hbm2java
 */
public class AirportTransaction  extends BaseBean {


     private Integer airportTransactionId;
     private TaxiDetails taxiDetails;
     private AreaMaster areaMasterByPickupAreaMasterId;
     private AreaMaster areaMasterByDropAreaMasterId;
     private PartnerDetails partnerDetails;
     private CustomerRegistration customerRegistration;
     private Date date;
     private Date pickupTime;
     private String pickupAddress;
     private String dropAddress;
     private String note;
     private double estimateCost;
     private Date estimateTime;
     private double estimateKm;
     private Set commitAirportTransactions = new HashSet(0);

    public AirportTransaction() {
    }

	
    public AirportTransaction(TaxiDetails taxiDetails, AreaMaster areaMasterByPickupAreaMasterId, AreaMaster areaMasterByDropAreaMasterId, PartnerDetails partnerDetails, CustomerRegistration customerRegistration, Date date, Date pickupTime, String pickupAddress, String dropAddress, String note, double estimateCost, Date estimateTime, double estimateKm) {
        this.taxiDetails = taxiDetails;
        this.areaMasterByPickupAreaMasterId = areaMasterByPickupAreaMasterId;
        this.areaMasterByDropAreaMasterId = areaMasterByDropAreaMasterId;
        this.partnerDetails = partnerDetails;
        this.customerRegistration = customerRegistration;
        this.date = date;
        this.pickupTime = pickupTime;
        this.pickupAddress = pickupAddress;
        this.dropAddress = dropAddress;
        this.note = note;
        this.estimateCost = estimateCost;
        this.estimateTime = estimateTime;
        this.estimateKm = estimateKm;
    }
    public AirportTransaction(TaxiDetails taxiDetails, AreaMaster areaMasterByPickupAreaMasterId, AreaMaster areaMasterByDropAreaMasterId, PartnerDetails partnerDetails, CustomerRegistration customerRegistration, Date date, Date pickupTime, String pickupAddress, String dropAddress, String note, double estimateCost, Date estimateTime, double estimateKm, Set commitAirportTransactions) {
       this.taxiDetails = taxiDetails;
       this.areaMasterByPickupAreaMasterId = areaMasterByPickupAreaMasterId;
       this.areaMasterByDropAreaMasterId = areaMasterByDropAreaMasterId;
       this.partnerDetails = partnerDetails;
       this.customerRegistration = customerRegistration;
       this.date = date;
       this.pickupTime = pickupTime;
       this.pickupAddress = pickupAddress;
       this.dropAddress = dropAddress;
       this.note = note;
       this.estimateCost = estimateCost;
       this.estimateTime = estimateTime;
       this.estimateKm = estimateKm;
       this.commitAirportTransactions = commitAirportTransactions;
    }
   
    public Integer getAirportTransactionId() {
        return this.airportTransactionId;
    }
    
    public void setAirportTransactionId(Integer airportTransactionId) {
        this.airportTransactionId = airportTransactionId;
    }
    public TaxiDetails getTaxiDetails() {
        return this.taxiDetails;
    }
    
    public void setTaxiDetails(TaxiDetails taxiDetails) {
        this.taxiDetails = taxiDetails;
    }
    public AreaMaster getAreaMasterByPickupAreaMasterId() {
        return this.areaMasterByPickupAreaMasterId;
    }
    
    public void setAreaMasterByPickupAreaMasterId(AreaMaster areaMasterByPickupAreaMasterId) {
        this.areaMasterByPickupAreaMasterId = areaMasterByPickupAreaMasterId;
    }
    public AreaMaster getAreaMasterByDropAreaMasterId() {
        return this.areaMasterByDropAreaMasterId;
    }
    
    public void setAreaMasterByDropAreaMasterId(AreaMaster areaMasterByDropAreaMasterId) {
        this.areaMasterByDropAreaMasterId = areaMasterByDropAreaMasterId;
    }
    public PartnerDetails getPartnerDetails() {
        return this.partnerDetails;
    }
    
    public void setPartnerDetails(PartnerDetails partnerDetails) {
        this.partnerDetails = partnerDetails;
    }
    public CustomerRegistration getCustomerRegistration() {
        return this.customerRegistration;
    }
    
    public void setCustomerRegistration(CustomerRegistration customerRegistration) {
        this.customerRegistration = customerRegistration;
    }
    public Date getDate() {
        return this.date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    public Date getPickupTime() {
        return this.pickupTime;
    }
    
    public void setPickupTime(Date pickupTime) {
        this.pickupTime = pickupTime;
    }
    public String getPickupAddress() {
        return this.pickupAddress;
    }
    
    public void setPickupAddress(String pickupAddress) {
        this.pickupAddress = pickupAddress;
    }
    public String getDropAddress() {
        return this.dropAddress;
    }
    
    public void setDropAddress(String dropAddress) {
        this.dropAddress = dropAddress;
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
    public Date getEstimateTime() {
        return this.estimateTime;
    }
    
    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }
    public double getEstimateKm() {
        return this.estimateKm;
    }
    
    public void setEstimateKm(double estimateKm) {
        this.estimateKm = estimateKm;
    }
    public Set getCommitAirportTransactions() {
        return this.commitAirportTransactions;
    }
    
    public void setCommitAirportTransactions(Set commitAirportTransactions) {
        this.commitAirportTransactions = commitAirportTransactions;
    }


	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}




}

