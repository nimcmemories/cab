package hibernate.bean;

import java.util.Date;

/**
 * PackageTransaction generated by hbm2java
 */
public class PackageTransaction  implements java.io.Serializable {


     private Integer packageTransactionId;
     private TaxiDetails taxiDetails;
     private PackageDetails packageDetails;
     private AreaMaster areaMaster;
     private PartnerDetails partnerDetails;
     private CustomerRegistration customerRegistration;
     private Date date;
     private Date pickupTime;
     private String pickupAddress;
     private String note;
     private double estimateCost;
     private double estimateKm;
     private Date estimateTime;

    public PackageTransaction() {
    }

    public PackageTransaction(TaxiDetails taxiDetails, PackageDetails packageDetails, AreaMaster areaMaster, PartnerDetails partnerDetails, CustomerRegistration customerRegistration, Date date, Date pickupTime, String pickupAddress, String note, double estimateCost, double estimateKm, Date estimateTime) {
       this.taxiDetails = taxiDetails;
       this.packageDetails = packageDetails;
       this.areaMaster = areaMaster;
       this.partnerDetails = partnerDetails;
       this.customerRegistration = customerRegistration;
       this.date = date;
       this.pickupTime = pickupTime;
       this.pickupAddress = pickupAddress;
       this.note = note;
       this.estimateCost = estimateCost;
       this.estimateKm = estimateKm;
       this.estimateTime = estimateTime;
    }
   
    public Integer getPackageTransactionId() {
        return this.packageTransactionId;
    }
    
    public void setPackageTransactionId(Integer packageTransactionId) {
        this.packageTransactionId = packageTransactionId;
    }
    public TaxiDetails getTaxiDetails() {
        return this.taxiDetails;
    }
    
    public void setTaxiDetails(TaxiDetails taxiDetails) {
        this.taxiDetails = taxiDetails;
    }
    public PackageDetails getPackageDetails() {
        return this.packageDetails;
    }
    
    public void setPackageDetails(PackageDetails packageDetails) {
        this.packageDetails = packageDetails;
    }
    public AreaMaster getAreaMaster() {
        return this.areaMaster;
    }
    
    public void setAreaMaster(AreaMaster areaMaster) {
        this.areaMaster = areaMaster;
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
    public double getEstimateKm() {
        return this.estimateKm;
    }
    
    public void setEstimateKm(double estimateKm) {
        this.estimateKm = estimateKm;
    }
    public Date getEstimateTime() {
        return this.estimateTime;
    }
    
    public void setEstimateTime(Date estimateTime) {
        this.estimateTime = estimateTime;
    }
}