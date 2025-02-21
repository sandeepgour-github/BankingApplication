package in.sandeep.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.sandeep.dto.AccountDto;
import in.sandeep.entity.Account;
import in.sandeep.mapper.AccountMapper;
import in.sandeep.repository.AccountRepository;
import in.sandeep.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AccountRepository accRepo;
	
	public AccountServiceImpl(AccountRepository accRepo) {
		this.accRepo=accRepo;
	}
	
	@Override
	public AccountDto createAccount(AccountDto accountDto) {
		Account account=accRepo.save(AccountMapper.MapToAccount(accountDto));
		return AccountMapper.MapToAccountDto(account);
	}

	@Override
	public AccountDto getAccountById(Long accNumber) {
		Optional<Account> res = accRepo.findById(accNumber);
		if(res.isPresent()) {
			return AccountMapper.MapToAccountDto(res.get());
		}
			
		return null;
	}

	@Override
	public AccountDto deposit(Long accNumber, Double amount) {
		
		if(amount<=0) {
			throw new RuntimeException("Please enter valid amount");
		}
		AccountDto accountDto=getAccountById(accNumber);
		if(accountDto==null) return null;
		
		accountDto.setBalance(accountDto.getBalance()+amount);
		Account account = accRepo.save(AccountMapper.MapToAccount(accountDto));
		return AccountMapper.MapToAccountDto(account);
	}

	@Override
	public AccountDto widthdraw(Long accNumber, Double amount) {
		
		Optional<Account> result = accRepo.findById(accNumber);
		
		if(result.isEmpty() || !result.isPresent()) return null;
		
		Account account=result.get();
		if(account.getBalance()>=amount) {
		  account.setBalance(account.getBalance()-amount);
		  accRepo.save(account);
		  return AccountMapper.MapToAccountDto(account);
		}else {
			throw new RuntimeException("Insufficient Amount");
		}
	}

	@Override
	public List<AccountDto> getAllAccount() {
	
		List<Account> accounts=accRepo.findAll();
		List<AccountDto> accountDtos=new ArrayList<>();
		for(Account account:accounts) {
			accountDtos.add(AccountMapper.MapToAccountDto(account));
		}
		return accountDtos;
	}

	@Override
	public AccountDto deleteAccountById(Long accNumber) {
		
		Optional<Account> result = accRepo.findById(accNumber);
		
		if(result.isEmpty() || !result.isPresent()) return null;
		
		accRepo.deleteById(accNumber);
		return AccountMapper.MapToAccountDto(result.get());
	}

	@Override
	public AccountDto updateMobileNo(Long accNumber, Long updatedMobileNo) {
		
	  Optional<Account> result=accRepo.findById(accNumber);
	  
	  if(result.isEmpty() || !result.isPresent()) return null;
	  
	  Account account=result.get();
	  account.setMobileNo(updatedMobileNo);
	  return  AccountMapper.MapToAccountDto(accRepo.save(account));
	}

}
