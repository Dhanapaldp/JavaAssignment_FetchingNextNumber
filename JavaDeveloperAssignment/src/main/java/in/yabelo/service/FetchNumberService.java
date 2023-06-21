package in.yabelo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.yabelo.entity.Category;
import in.yabelo.entity.JsonObject;
import in.yabelo.repo.IFetchNumberRepo;

@Service
public class FetchNumberService {
	
	@Autowired
	private IFetchNumberRepo repo;
	
	public JsonObject fetchNextNumber(Integer categoryCode) {
		Category category=null;
		JsonObject result=new JsonObject();
		
		Optional<Category> value = repo.findById(categoryCode);
		if(value.isPresent())
			category=value.get();
		
		int oldValue=category.getValue();
		int newValue = calculateNextNumber(oldValue);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		result.setOldValue(oldValue);
		result.setNewValue(newValue);
		
		category.setValue(newValue);
		
		repo.save(category);
		
		return result;
	}

	private int calculateNextNumber(Integer oldValue) {
		int newValue=oldValue+1;
		
		while(sumOfTwoDigits(newValue)!=1) {
			newValue++;
		}
		
		return newValue;
	}
	
	 private static int sumOfTwoDigits(int number) {
	        int sum = 0;
	        while (number != 0) {
	            sum += number % 10;
	            number /= 10;
	        }
	        if(sum>9) {
				int temp = sumOfTwoDigits(sum);
				return temp;
			}
	        
	        return sum;
	 }
	

}
