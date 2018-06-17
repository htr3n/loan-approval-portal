package westbank.mvc.customer.model;

import java.util.Date;

import westbank.db.entity.EstateType;
import westbank.db.entity.MaritalStatus;
import westbank.db.entity.ResidenceType;

public class ApplicationForm {

	public ApplicationForm() {
	}

	double loanAmount;
	String loanReason;
	int loanTerm;
	double interestRate;
	Date startDate;

	double totalPurchasePrice;
	double personalCapitalContribution;

	ResidenceType residenceType;
	EstateType estateType;
	String estateAddress;

	String borrowerTitle;
	String borrowerCustomerId;
	String borrowerFirstName;
	String borrowerLastName;

	String borrowerPersonalId;

	Date borrowerDateOfBirth;

	String borrowerStreet;
	String borrowerCity;
	String borrowerState;
	String borrowerZipcode;
	String borrowerCountry;
	String borrowerPhone;
	String borrowerMobilePhone;
	String borrowerEmail;
	MaritalStatus borrowerMaritalStatus;
	int borrowerNumberOfChildren;
	String borrowerOccupation;
	int borrowerLengthOfService;
	double borrowerIncome;

	String newPin;
	String newPinAgain;

	boolean hasCoborrower;
	String coborrowerCustomerId;
	String coborrowerTitle;
	String coborrowerFirstName;
	String coborrowerLastName;
	String coborrowerEmail;

	String coborrowerPersonalId;

	Date coborrowerDateOfBirth;

	String coborrowerOccupation;
	int coborrowerLengthOfService;
	double coborrowerIncome;

	boolean accessSensitiveData;

	public boolean isAccessSensitiveData() {
		return accessSensitiveData;
	}

	public void setAccessSensitiveData(boolean accessSensitiveData) {
		this.accessSensitiveData = accessSensitiveData;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getLoanReason() {
		return loanReason;
	}

	public void setLoanReason(String loanReason) {
		this.loanReason = loanReason;
	}

	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getTotalPurchasePrice() {
		return totalPurchasePrice;
	}

	public void setTotalPurchasePrice(double totalPurchasePrice) {
		this.totalPurchasePrice = totalPurchasePrice;
	}

	public double getPersonalCapitalContribution() {
		return personalCapitalContribution;
	}

	public void setPersonalCapitalContribution(double personalCapitalContribution) {
		this.personalCapitalContribution = personalCapitalContribution;
	}

	public ResidenceType getResidenceType() {
		return residenceType;
	}

	public void setResidenceType(ResidenceType residenceType) {
		this.residenceType = residenceType;
	}

	public EstateType getEstateType() {
		return estateType;
	}

	public void setEstateType(EstateType estateType) {
		this.estateType = estateType;
	}

	public String getEstateAddress() {
		return estateAddress;
	}

	public void setEstateAddress(String estateAddress) {
		this.estateAddress = estateAddress;
	}

	public String getBorrowerTitle() {
		return borrowerTitle;
	}

	public void setBorrowerTitle(String borrowerTitle) {
		this.borrowerTitle = borrowerTitle;
	}

	public String getBorrowerCustomerId() {
		return borrowerCustomerId;
	}

	public void setBorrowerCustomerId(String borrowerCustomerId) {
		this.borrowerCustomerId = borrowerCustomerId;
	}

	public String getBorrowerFirstName() {
		return borrowerFirstName;
	}

	public void setBorrowerFirstName(String borrowerFirstName) {
		this.borrowerFirstName = borrowerFirstName;
	}

	public String getBorrowerLastName() {
		return borrowerLastName;
	}

	public void setBorrowerLastName(String borrowerLastName) {
		this.borrowerLastName = borrowerLastName;
	}

	public String getBorrowerStreet() {
		return borrowerStreet;
	}

	public void setBorrowerStreet(String borrowerStreet) {
		this.borrowerStreet = borrowerStreet;
	}

	public String getBorrowerCity() {
		return borrowerCity;
	}

	public void setBorrowerCity(String borrowerCity) {
		this.borrowerCity = borrowerCity;
	}

	public String getBorrowerState() {
		return borrowerState;
	}

	public void setBorrowerState(String borrowerState) {
		this.borrowerState = borrowerState;
	}

	public String getBorrowerZipcode() {
		return borrowerZipcode;
	}

	public void setBorrowerZipcode(String borrowerZipcode) {
		this.borrowerZipcode = borrowerZipcode;
	}

	public String getBorrowerCountry() {
		return borrowerCountry;
	}

	public void setBorrowerCountry(String borrowerCountry) {
		this.borrowerCountry = borrowerCountry;
	}

	public String getBorrowerPhone() {
		return borrowerPhone;
	}

	public void setBorrowerPhone(String borrowerPhone) {
		this.borrowerPhone = borrowerPhone;
	}

	public String getBorrowerMobilePhone() {
		return borrowerMobilePhone;
	}

	public void setBorrowerMobilePhone(String borrowerMobilePhone) {
		this.borrowerMobilePhone = borrowerMobilePhone;
	}

	public String getBorrowerEmail() {
		return borrowerEmail;
	}

	public void setBorrowerEmail(String borrowerEmail) {
		this.borrowerEmail = borrowerEmail;
	}

	public MaritalStatus getBorrowerMaritalStatus() {
		return borrowerMaritalStatus;
	}

	public void setBorrowerMaritalStatus(MaritalStatus borrowerMaritalStatus) {
		this.borrowerMaritalStatus = borrowerMaritalStatus;
	}

	public int getBorrowerNumberOfChildren() {
		return borrowerNumberOfChildren;
	}

	public void setBorrowerNumberOfChildren(int borrowerNumberOfChildren) {
		this.borrowerNumberOfChildren = borrowerNumberOfChildren;
	}

	public String getBorrowerOccupation() {
		return borrowerOccupation;
	}

	public void setBorrowerOccupation(String borrowerOccupation) {
		this.borrowerOccupation = borrowerOccupation;
	}

	public int getBorrowerLengthOfService() {
		return borrowerLengthOfService;
	}

	public void setBorrowerLengthOfService(int borrowerLengthOfService) {
		this.borrowerLengthOfService = borrowerLengthOfService;
	}

	public double getBorrowerIncome() {
		return borrowerIncome;
	}

	public void setBorrowerIncome(double borrowerIncome) {
		this.borrowerIncome = borrowerIncome;
	}

	public String getCoborrowerTitle() {
		return coborrowerTitle;
	}

	public void setCoborrowerTitle(String coborrowerTitle) {
		this.coborrowerTitle = coborrowerTitle;
	}

	public String getCoborrowerFirstName() {
		return coborrowerFirstName;
	}

	public void setCoborrowerFirstName(String coborrowerFirstName) {
		this.coborrowerFirstName = coborrowerFirstName;
	}

	public String getCoborrowerLastName() {
		return coborrowerLastName;
	}

	public void setCoborrowerLastName(String coborrowerLastName) {
		this.coborrowerLastName = coborrowerLastName;
	}

	public String getCoborrowerOccupation() {
		return coborrowerOccupation;
	}

	public void setCoborrowerOccupation(String coborrowerOccupation) {
		this.coborrowerOccupation = coborrowerOccupation;
	}

	public int getCoborrowerLengthOfService() {
		return coborrowerLengthOfService;
	}

	public void setCoborrowerLengthOfService(int coborrowerLengthOfService) {
		this.coborrowerLengthOfService = coborrowerLengthOfService;
	}

	public double getCoborrowerIncome() {
		return coborrowerIncome;
	}

	public void setCoborrowerIncome(double coborrowerIncome) {
		this.coborrowerIncome = coborrowerIncome;
	}

	public boolean isHasCoborrower() {
		return hasCoborrower;
	}

	public void setHasCoborrower(boolean hasCoborrower) {
		this.hasCoborrower = hasCoborrower;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getBorrowerDateOfBirth() {
		return borrowerDateOfBirth;
	}

	public void setBorrowerDateOfBirth(Date borrowerDateOfBirth) {
		this.borrowerDateOfBirth = borrowerDateOfBirth;
	}

	public Date getCoborrowerDateOfBirth() {
		return coborrowerDateOfBirth;
	}

	public void setCoborrowerDateOfBirth(Date coborrowerDateOfBirth) {
		this.coborrowerDateOfBirth = coborrowerDateOfBirth;
	}

	public String getCoborrowerCustomerId() {
		return coborrowerCustomerId;
	}

	public void setCoborrowerCustomerId(String coborrowerCustomerId) {
		this.coborrowerCustomerId = coborrowerCustomerId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationForm [borrowerCity=").append(borrowerCity).append(", borrowerCountry=")
				.append(borrowerCountry).append(", borrowerCustomerId=").append(borrowerCustomerId)
				.append(", borrowerDateOfBirth=").append(borrowerDateOfBirth).append(", borrowerEmail=")
				.append(borrowerEmail).append(", borrowerFirstName=").append(borrowerFirstName)
				.append(", borrowerIncome=").append(borrowerIncome).append(", borrowerLastName=")
				.append(borrowerLastName).append(", borrowerLengthOfService=").append(borrowerLengthOfService)
				.append(", borrowerMaritalStatus=").append(borrowerMaritalStatus).append(", borrowerMobilePhone=")
				.append(borrowerMobilePhone).append(", borrowerNumberOfChildren=").append(borrowerNumberOfChildren)
				.append(", borrowerOccupation=").append(borrowerOccupation).append(", borrowerPersonalId=")
				.append(borrowerPersonalId).append(", borrowerPhone=").append(borrowerPhone).append(", borrowerState=")
				.append(borrowerState).append(", borrowerStreet=").append(borrowerStreet).append(", borrowerTitle=")
				.append(borrowerTitle).append(", borrowerZipcode=").append(borrowerZipcode)
				.append(", coborrowerCustomerId=").append(coborrowerCustomerId).append(", coborrowerDateOfBirth=")
				.append(coborrowerDateOfBirth).append(", coborrowerEmail=").append(coborrowerEmail)
				.append(", coborrowerFirstName=").append(coborrowerFirstName).append(", coborrowerIncome=")
				.append(coborrowerIncome).append(", coborrowerLastName=").append(coborrowerLastName)
				.append(", coborrowerLengthOfService=").append(coborrowerLengthOfService)
				.append(", coborrowerOccupation=").append(coborrowerOccupation).append(", coborrowerPersonalId=")
				.append(coborrowerPersonalId).append(", coborrowerTitle=").append(coborrowerTitle)
				.append(", estateAddress=").append(estateAddress).append(", estateType=").append(estateType)
				.append(", hasCoborrower=").append(hasCoborrower).append(", interestRate=").append(interestRate)
				.append(", loanAmount=").append(loanAmount).append(", loanReason=").append(loanReason)
				.append(", loanTerm=").append(loanTerm).append(", newPin=").append(newPin).append(", newPinAgain=")
				.append(newPinAgain).append(", personalCapitalContribution=").append(personalCapitalContribution)
				.append(", residenceType=").append(residenceType).append(", startDate=").append(startDate)
				.append(", totalPurchasePrice=").append(totalPurchasePrice).append(", accessSensitiveData=")
				.append(accessSensitiveData).append("]");
		return builder.toString();
	}

	public String getCoborrowerEmail() {
		return coborrowerEmail;
	}

	public void setCoborrowerEmail(String coborrowerEmail) {
		this.coborrowerEmail = coborrowerEmail;
	}

	public String getBorrowerPersonalId() {
		return borrowerPersonalId;
	}

	public void setBorrowerPersonalId(String borrowerPersonalId) {
		this.borrowerPersonalId = borrowerPersonalId;
	}

	public String getCoborrowerPersonalId() {
		return coborrowerPersonalId;
	}

	public void setCoborrowerPersonalId(String coborrowerPersonalId) {
		this.coborrowerPersonalId = coborrowerPersonalId;
	}

	public String getNewPin() {
		return newPin;
	}

	public void setNewPin(String newPin) {
		this.newPin = newPin;
	}

	public String getNewPinAgain() {
		return newPinAgain;
	}

	public void setNewPinAgain(String newPinAgain) {
		this.newPinAgain = newPinAgain;
	}

}
