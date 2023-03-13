package com.example.practice.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.practice.model.Order;
import com.example.practice.model.RequestManager;
import com.example.practice.model.TiffinMenu;
import com.example.practice.model.TiffinProvider;
import com.example.practice.model.User;
import com.example.practice.repositories.MenuRepositry;
import com.example.practice.repositories.OrderRepositry;
import com.example.practice.repositories.RequestManagerRepositry;
import com.example.practice.service.TiffinProviderService;
import com.example.practice.service.UserService;

@RestController
public class PracticeController {
	private static final Logger log = LoggerFactory.getLogger(PracticeController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private TiffinProviderService providerService;
	
	@Autowired
	private OrderRepositry orderRepositry;
	
	@Autowired
	private MenuRepositry menuRepositry;
	
	@Autowired
	private RequestManagerRepositry managerRepositry;
//	@Autowired
//	public PracticeController(UserService userService) {
//		System.out.println("Inside practice controller "+userService);
//		this.userService = userService;
//	}
//	
	@RequestMapping("/home")
	@ResponseBody
	public String home() {
		System.out.println("Inside home");
		User u = new User();
		u.setUserFirstName("Yash");
		u.setUserLastName("sarda");
		u.setPhoneNumber("87879898729");
		System.out.println("ITs user service"+userService);
		userService.addUser(u);
		return "<h1>Welcome to home</h1>"+u;
	}
	
	//UserRepo
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userService.getAllUsers();
	}
	@PostMapping("/user")
	public User addUser(@RequestBody User user) {
		log.error("Adding user "+user);
		return userService.addUser(user);	
	}
	
	@GetMapping("/user/order/{userid}")
	public List<Order> getOrders( @PathVariable ("userid") String userId) {
		return orderRepositry.findByUserId(userId);
	}
	
	//providerRepo
	@GetMapping("/provider")
	public List<TiffinProvider> getProvider() {
		return providerService.getProvider();
	}
	@PostMapping("/provider")
	public TiffinProvider addTiffinProvider(@RequestBody TiffinProvider provider) {
		TiffinProvider prov = providerService.addProvider(provider);
		if(prov==null) {
			log.error("Unable to add provider");
			return null;
		}
		RequestManager req = new RequestManager();
		List<RequestManager> reqList = managerRepositry.findByproviderId(Objects.toString(prov.getProvider_id()));
		if(reqList.size()>0)
			req = reqList.get(0);
		if(req==null)
			req = new RequestManager();
		req.setComments("");
		req.setProviderId(Objects.toString(prov.getProvider_id()));
		log.error(prov.getProviderName());
		req.setProviderName(prov.getProviderName());
		req.setRequestStatus("N");
		req.setLatestRequestedDate(Timestamp.valueOf(LocalDateTime.now()));
		managerRepositry.save(req);
		return prov;
		
	}
	
	@GetMapping("/provider/order/{providerid}")
	public List<Order> getOrderbyProvider( @PathVariable ("providerid") String providerId){
		return orderRepositry.findByProviderId(providerId);
	}
	
	
	//MenuRepo
	@GetMapping("/menu")
	public List<TiffinMenu> getMenu() {
		return menuRepositry.findAll();
	}
	
	@GetMapping("/menu/issweet/{issweet}")
	public List<TiffinMenu> getMenuByIsSweet(@PathVariable ("issweet") boolean issweet){
		return menuRepositry.findByisSweet(issweet);

	}
	
	@PostMapping("/menu")
	public TiffinMenu addMenu(@RequestBody TiffinMenu menu) {
		try{
			String providerid = menu.getTiifinProviderId();
		Optional<TiffinProvider> prov = providerService.getProviderById(Integer.parseInt(providerid));
		if("Y".equalsIgnoreCase(prov.get().getIsApproved())) {
			return menuRepositry.save(menu);
		}
//		{
//		    "tiifinProviderId": "2",
//		    "sweet": true,
//		    "menuItemJson": "{\"chapati\" : 3,\"others\": [\"pannerbhaji\",\"rice\",\"daal\"]}",
//		    "menuPrice": "50.0"
//		    }
		
		 
		}catch(Exception e) {
			log.error("Unable to add menu as you are not approved from our side",e);
		}
		return null;
	}
	
	@GetMapping("/admin/get")
	public List<RequestManager> getAllRequest(){
		log.info("Inside getAll request");
		return managerRepositry.findAll();
	}
	
	@PutMapping("/admin/{id}/{status}")
	public TiffinProvider updateTiffinProvider(@PathVariable ("status") String status, @PathVariable ("id") String providerId) {
		Optional<TiffinProvider> provider = providerService.getProviderById(Integer.parseInt(providerId));
		TiffinProvider pr = provider.get();
		pr.setIsApproved(status);
		TiffinProvider fg = providerService.addProvider(pr);
		
		return fg;
	}
}
