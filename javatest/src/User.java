
public class User {
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Integer getVersion() {
		return version;
	}
	public void setVersion(Integer version) {
		this.version = version;
	}
	public String getInsuranceCompany() {
		return insuranceCompany;
	}
	public void setInsuranceCompany(String insuranceCompany) {
		this.insuranceCompany = insuranceCompany;
	}
	String userId;
	String firstName;
	String lastName;
	Integer version;
	String insuranceCompany;
	
	@Override
	public String toString() {
		
		return this.getUserId()+","+this.getFirstName()+","+this.getLastName()+","+
		this.getVersion()+","+this.getInsuranceCompany();
	}

}
