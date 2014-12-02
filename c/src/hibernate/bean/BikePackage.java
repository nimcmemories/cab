package hibernate.bean;

public class BikePackage extends BaseBean{

	private int bikePackageId;
	private int bikeDetailsId;
	private String name;
	
	public BikePackage(){
	}
	public int getBikePackageId() {
		return bikePackageId;
	}
	public void setBikePackageId(int bikePackageId) {
		this.bikePackageId = bikePackageId;
	}
	public int getBikeDetailsId() {
		return bikeDetailsId;
	}
	public void setBikeDetailsId(int bikeDetailsId) {
		this.bikeDetailsId = bikeDetailsId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public boolean validateBean(StringBuffer messageOfValidation) {
		// TODO Auto-generated method stub
		return false;
	}
}
