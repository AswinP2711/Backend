package com.springboot.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.api.model.Customer;
import com.springboot.api.model.Policy;
import com.springboot.api.model.User;
import com.springboot.api.repository.CustomerRepository;
import com.springboot.api.repository.PolicyRepository;
import com.springboot.api.repository.UserRepository;

@RestController
public class CustomerController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private PolicyRepository policyRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	
	@PostMapping("/customer/add")
	public void addCustomer(@RequestBody Customer customer) {
		User user=customer.getUser();
		if (user==null) {
			throw new RuntimeException("User data not present");
		}
		user.setRole("CUSTOMER");
		String encryptedPassword=encoder.encode(user.getPassword());
		user.setPassword(encryptedPassword); 
		
		user=userRepository.save(user);
		
		customer.setUser(user);
		
		customerRepository.save(customer);
	}
	
	@GetMapping("/customer/policy/{cid}/{pid}")
	public Customer buyPolicy(@PathVariable("cid") Long cid, @PathVariable("pid") Long pid) {
	
		Optional<Customer> optionalC =  customerRepository.findById(cid);
		if(!optionalC.isPresent()) {
			throw new RuntimeException("Customer ID Invalid"); 
		}
		Customer customer = optionalC.get();

		
		Optional<Policy> optionalP =  policyRepository.findById(pid);
		if(!optionalP.isPresent()) {
			throw new RuntimeException("Policy ID Invalid"); 
		}
		Policy policy = optionalP.get();

		List<Policy> list = customer.getPolicy(); 
		list.add(policy);
		customer.setPolicy(list);
		return customerRepository.save(customer);

	}
	
	@PostMapping("/policy/add")
	public Policy postPolicy(@RequestBody Policy policy) {
		return policyRepository.save(policy);
	}
}
