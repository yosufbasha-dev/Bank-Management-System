package com.bank_management_system.bank_project.controller;

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
import com.bank_management_system.bank_project.entity.Bank;
import com.bank_management_system.bank_project.service.BankService;

@RestController
@RequestMapping("/bank")
public class BankController {

	@Autowired
	private BankService bankService;
	
	//1. Create Bank
	@PostMapping
	public ResponseEntity<ResponseStructure<Bank>> createBank(@RequestBody Bank bank) {
		return new ResponseEntity<>(bankService.createBank(bank), HttpStatus.CREATED);
	}
	
	//2. Get All Bank
	@GetMapping("/all")
	public ResponseEntity<ResponseStructure<List<Bank>>> getAllBank() {
		return new ResponseEntity<>(bankService.getAllBank(), HttpStatus.OK); 
	}
	
	//3. Get Bank By Id
	@GetMapping("/{bankId}")
	public ResponseEntity<ResponseStructure<Bank>> getBankById(@PathVariable Integer bankId) {
		return new ResponseEntity<>(bankService.getBankById(bankId), HttpStatus.OK);
	}
	
	//4. Delete Bank
	@DeleteMapping("/{bankId}")
	public ResponseEntity<ResponseStructure<Bank>> deleteBankRecordById(@PathVariable Integer bankId) {
		return new ResponseEntity<>(bankService.deleteBankById(bankId), HttpStatus.ACCEPTED);
	}
	
	//5.1 Update Bank -> PutMapping
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Bank>> updateBankRecord(@RequestBody Bank bank) {
		return new ResponseEntity<>(bankService.updateBankRecord(bank), HttpStatus.ACCEPTED);
	}
	
//	5.2 Update Bank -> PatchMapping
//	@PatchMapping("/update")
//	public ResponseEntity<ResponseStructure<Bank>> updateBankRecord(@RequestBody Map<String,Object> map) {
//		return bankService.upadateBankRecord1(map);
//	}
	
	//6. Get Bank by pagination and sorting
	@GetMapping("/pagesort")
	public ResponseEntity<ResponseStructure<Page<Bank>>> getBankByPaginationAndSorting(@RequestParam Integer pageNumber, @RequestParam Integer pageSize, @RequestParam String fieldName) {
		return new ResponseEntity<ResponseStructure<Page<Bank>>>(bankService.getBankByPaginationAndSorting(pageNumber, pageSize, fieldName), HttpStatus.OK);
	}
	
	
	//7. Get By IFSC
	@GetMapping("/ifsc/{ifsc}")
	public ResponseEntity<ResponseStructure<Bank>> getBankByIfsc(@PathVariable String ifsc) {
		return new ResponseEntity<>(bankService.getBankByIfsc(ifsc), HttpStatus.OK);
	}
	
	
	//8. Get Bank By Address Id
	@GetMapping("/address/{addressId}")
	public ResponseEntity<ResponseStructure<Bank>> getBankByAddressId(@PathVariable Integer addressId) {
		return new ResponseEntity<>(bankService.getBankByAddressId(addressId), HttpStatus.OK);
		
	}
	
	//9. Get Bank By Address
	
	//10. Get Bank By City
	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseStructure<List<Bank>>> getBankByCity(@PathVariable String city) {
		return new ResponseEntity<>(bankService.getBankByCity(city), HttpStatus.OK);
	}
	
	//11. Get Bank By Contact Number
	@GetMapping("/contact/{contactNo}")
	public ResponseEntity<ResponseStructure<Bank>> getBankByContactNo(@PathVariable String contactNo) {
		return new ResponseEntity<>(bankService.getBankByContactNo(contactNo), HttpStatus.OK);
	}
}
