package in.sandeep.dto;

public class AccountDto {

	 private Long accountNumber;
	 private String accountHolderName;
	 private Double balance;
	 private Long mobileNo;
	 
	 public AccountDto() {
		 
	 }
	 
	 public AccountDto(Long accountNumber, String accountHolderName, Double balance, Long mobileNo) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderName;
		this.balance = balance;
		this.mobileNo = mobileNo;
	}
	public Long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public Long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}
	 
	 
}
