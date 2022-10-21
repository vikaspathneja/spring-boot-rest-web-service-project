package com.example.springpropsdemo;

import java.util.ArrayList;
import java.util.List;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/filter")
public class ResponseFilteringController {

	
	private static List<FilterPojo>list=new ArrayList<>();
	static {
		list.add(new FilterPojo("Value1", "password1", "Value3"));
		list.add(new FilterPojo("Value11", "password11", "Value33"));
	}
	
	@GetMapping
	public MappingJacksonValue getFilterList(){
		return DynamicResponeFilterFunction.filterlistFunction.apply(list);
	}
	
	@GetMapping(path="/{id}")
	public MappingJacksonValue getFilterByFirstFieldValue(@PathVariable(name = "id") String id){
		FilterPojo value = list.stream().filter(x->x.getField1().equals(id)).findFirst().get();
		return DynamicResponeFilterFunction.filterFunction.apply(value);
	}
	
}
