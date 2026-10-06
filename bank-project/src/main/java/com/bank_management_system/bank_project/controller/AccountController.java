package com.bank_management_system.bank_project.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bank_management_system.bank_project.dto.ResponseStructure;
import com.bank_management_system.bank_project.dto.TransferBody;
import com.bank_management_system.bank_project.entity.Account;
import com.bank_management_system.bank_project.entity.AccountType;
import com.bank_management_system.bank_project.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	//1. Create Account
	@PostMapping("/save")
	public ResponseEntity<ResponseStructure<Account>> createAccount(@RequestBody Account account) {
		return new ResponseEntity<>(accountService.createAccount(account), HttpStatus.CREATED);
	}
	
	//2. Get All Accounts
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Account>>> getAllAccounts() {
		return new ResponseEntity<>(accountService.getAllAccounts(), HttpStatus.OK);
	}
	
	//3. Get Account By Id
	@GetMapping("/{accountId}")
	public ResponseEntity<ResponseStructure<Account>> getAccountById(@PathVariable Integer accountId) {
		return new ResponseEntity<>(accountService.getAccountById(accountId), HttpStatus.OK);
	}
	
	//4. Delete Account
	@DeleteMapping("/{accountId}")
	public ResponseEntity<ResponseStructure<Account>> deleteAccountById(@PathVariable Integer accountId) {
		return new ResponseEntity<>(accountService.deleteAccountById(accountId), HttpStatus.ACCEPTED);
	}
	
	//5. Update AccountType and HolderName (PatchMapping)
	
	//6. Deposit Amount
	@PutMapping("/deposit/{accountId}")
	public ResponseEntity<ResponseStructure<Account>> depositAmount(@PathVariable Integer accountId,
																		@RequestParam BigDecimal amount ) {
		return new ResponseEntity<>(accountService.depositAmount(accountId, amount), HttpStatus.ACCEPTED);
	}
	
	//7. Withdraw Amount "/api/account/withdraw/{accountId}?amount=value"
	@PutMapping("/withdraw/{accountId}")
	public ResponseEntity<ResponseStructure<Account>> withdrawAmount(@PathVariable Integer accountId, 
																		@RequestParam BigDecimal amount) {
		return new ResponseEntity<>(accountService.withdrawAmount(accountId, amount), HttpStatus.ACCEPTED);
	}
	
	//8. Transfer Amount "/api/account/transfer?senderAccountId=value&recieverAccountId=value&amount=value"
	@PutMapping("/transfer")
	public ResponseEntity<ResponseStructure<Account>> transferAmount(@RequestParam Integer senderAccountId, @RequestParam Integer recieverAccountId, @RequestParam BigDecimal amount) {
		return new ResponseEntity<>(accountService.transferAmount(senderAccountId, recieverAccountId, amount), HttpStatus.ACCEPTED);
	}
	
	//8.1 Transfer Amount "/api/account/transfer" here we use TransferBody object to pass transfer details 
	@PostMapping("/transfer")
	public ResponseEntity<ResponseStructure<Account>> transferAmount1(@RequestBody TransferBody transferBody) {
		return new ResponseEntity<>(accountService.transferAmount1(transferBody), HttpStatus.ACCEPTED);
	}
	
	//9. Get Account by Bank
	@GetMapping("/bank")
	public ResponseEntity<ResponseStructure<List<Account>>> getAccountByBank(@RequestParam Integer bankId) {
		return new ResponseEntity<>(accountService.getAccountByBank(bankId), HttpStatus.OK);
	}
	
	//10. Get Account By Type
	@GetMapping("/type")
	public ResponseEntity<ResponseStructure<List<Account>>> getAccountByType(@RequestParam AccountType accountType) {
		return new ResponseEntity<>(accountService.getAccountByType(accountType), HttpStatus.OK);
	}
	
	
	//11. Get Accounts with Balance Greater than a Value
	@GetMapping("/greater")
	public ResponseEntity<ResponseStructure<List<Account>>> getAccountBalanceGreaterThanValue(@RequestParam BigDecimal value) {
		return new ResponseEntity<>(accountService.getAccountBalanceGreaterThanValue(value), HttpStatus.OK);
	}
	
	//12. Get account By Pagination & Sorting
	@GetMapping("/pagesort")
	public ResponseEntity<ResponseStructure<Page<Account>>> getAccountsByPaginationAndSorting(@RequestParam Integer PageNumber, @RequestParam Integer pageSize, @RequestParam String fieldName) {
		return new ResponseEntity<> (accountService.getAccountsByPaginationAndSorting(PageNumber, pageSize, fieldName), HttpStatus.OK);
	}
	
	
	
	
}









