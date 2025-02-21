package in.sandeep.service;

import java.util.List;

import in.sandeep.dto.AccountDto;

public interface AccountService {

	AccountDto createAccount(AccountDto accountDto);
	AccountDto getAccountById(Long accNumber);
	AccountDto deposit(Long accNumber,Double amount);
	AccountDto widthdraw(Long accNumber,Double amount);
	List<AccountDto> getAllAccount();
	AccountDto deleteAccountById(Long accNumber);
	AccountDto updateMobileNo(Long accNumber,Long updatedMobileNo);
}
