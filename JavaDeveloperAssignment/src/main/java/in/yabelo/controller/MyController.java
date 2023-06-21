package in.yabelo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.yabelo.entity.Category;
import in.yabelo.entity.JsonObject;
import in.yabelo.service.FetchNumberService;

@RestController
public class MyController {
	
	@Autowired
	private FetchNumberService service;
	
	@GetMapping("/")
	public ResponseEntity<JsonObject> findNextNumber(@RequestBody Category category){
		
		JsonObject result = service.fetchNextNumber(category.getCategoryCode());
		return new ResponseEntity<JsonObject> (result,HttpStatus.OK);
		
	
	}

}
