package in.sandeep.mapper;

import in.sandeep.dto.AccountDto;
import in.sandeep.entity.Account;

public class AccountMapper {

	public static Account MapToAccount(AccountDto accountDto) {
		
		Account account=new Account(accountDto.getAccountNumber(),accountDto.getAccountHolderName(),accountDto.getBalance(),accountDto.getMobileNo());
		return account;
	}
    public static AccountDto MapToAccountDto(Account account) {
		
		AccountDto accDto=new AccountDto(account.getAccountNumber(),account.getAccountHolderName(),account.getBalance(),account.getMobileNo());
		return accDto;
	}
}
