package in.sandeep.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.sandeep.dto.AccountDto;
import in.sandeep.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {

	private AccountService accServ;
	
	public AccountController(AccountService accServ) {
		this.accServ=accServ;
	}
	
	@PostMapping("/create")
	public ResponseEntity<AccountDto> createAccount(@RequestBody AccountDto accountDto) {	
		AccountDto dto=accServ.createAccount(accountDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getAccountById(@PathVariable("id") Long accNumber){
		AccountDto accountDto=accServ.getAccountById(accNumber);
		if(accountDto ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		return ResponseEntity.ok(accountDto);
	}
	
	@PatchMapping("/deposit/{id}")
	public ResponseEntity<?> deposit(@PathVariable("id") Long accNumber,@RequestBody Map<String, Double> map){
		
		
		AccountDto accountDto=accServ.deposit(accNumber,map.get("deposit"));
		if(accountDto ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		return ResponseEntity.ok(accountDto);
	}
	@PatchMapping("/widthdraw/{id}")
	public ResponseEntity<?> widthdraw(@PathVariable("id") Long accNumber,@RequestBody Map<String, Double> map){
		
		AccountDto accountDto=accServ.widthdraw(accNumber,map.get("widthdraw"));
		if(accountDto ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		return ResponseEntity.ok(accountDto);
	}
	@GetMapping()
	public ResponseEntity<?> getAllAccount(){
		List<AccountDto> accounts=accServ.getAllAccount();
		
		if(accounts.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No Record");
		}
		return ResponseEntity.ok(accounts);
	}
	
	@DeleteMapping("/close/{id}")
	public ResponseEntity<?> deleteAccountById(@PathVariable("id") Long accNumber){
		AccountDto accountDto=accServ.deleteAccountById(accNumber);
		if(accountDto ==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		return ResponseEntity.ok(accountDto);
	}
	
	@PutMapping("/updateMobile/{id}")
	public ResponseEntity<?> updateMobileNoById(@PathVariable("id") Long accNumber,@RequestBody  Map<String,Long> map){
	    Long mobileNo=map.get("mobileNo");
		AccountDto accountDto=accServ.updateMobileNo(accNumber, mobileNo);
		if(accountDto==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Record not found");
		}
		return ResponseEntity.ok(accountDto);
	}
}
