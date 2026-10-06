package com.bank_management_system.bank_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bank_management_system.bank_project.dto.ResponseStructure;
import com.bank_management_system.bank_project.entity.Address;
import com.bank_management_system.bank_project.service.AddressService;

@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;

	//1. Get Address By Id
	@GetMapping("/id/{addressId}")
	public ResponseEntity<ResponseStructure<Address>> getAddressById(@PathVariable Integer addressId) {
		return new ResponseEntity<>(addressService.getAddressById(addressId), HttpStatus.OK);
	}
	
	//2. Update Address
	
	//3. Get Address By Bank
	@GetMapping("/bank/{bankId}")
	public ResponseEntity<ResponseStructure<Address>> getAddressByBank(@PathVariable Integer bankId) {
		return new ResponseEntity<>(addressService.getAddressByBank(bankId), HttpStatus.OK);
	}
	
	//4. Get Address By City
	@GetMapping("/city/{city}")
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByCity(@PathVariable String city) {
		return new ResponseEntity<>(addressService.getAddressByCity(city), HttpStatus.OK);
	}
	
	//5. Get Address By City and Street
	@GetMapping("/search")
	public ResponseEntity<ResponseStructure<List<Address>>> getAddressByCityAndStreet(@RequestParam String city, @RequestParam String street) {
		return new ResponseEntity<>(addressService.getAddressByCityAndStreet(city, street), HttpStatus.OK);
	}
}
