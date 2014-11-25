package hibernate.bean;

public class AirportDetails  implements java.io.Serializable {


    private Integer airportId;
    private CityMaster cityMaster;
    private String airportName;
    private int isEnable;

   public AirportDetails() {
   }

   public AirportDetails(CityMaster cityMaster, String airportName, int isEnable) {
      this.cityMaster = cityMaster;
      this.airportName = airportName;
      this.isEnable = isEnable;
   }
  
   public Integer getAirportId() {
       return this.airportId;
   }
   
   public void setAirportId(Integer airportId) {
       this.airportId = airportId;
   }
   public CityMaster getCityMaster() {
       return this.cityMaster;
   }
   
   public void setCityMaster(CityMaster cityMaster) {
       this.cityMaster = cityMaster;
   }
   public String getAirportName() {
       return this.airportName;
   }
   
   public void setAirportName(String airportName) {
       this.airportName = airportName;
   }
   public int getIsEnable() {
       return this.isEnable;
   }
   
   public void setIsEnable(int isEnable) {
       this.isEnable = isEnable;
   }
}
