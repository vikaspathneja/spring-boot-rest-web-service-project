package com.example.springpropsdemo;

import java.util.List;
import java.util.function.Function;
import org.springframework.http.converter.json.MappingJacksonValue;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class DynamicResponeFilterFunction {
	public static Function<FilterPojo, MappingJacksonValue>filterFunction=x->{
		SimpleBeanPropertyFilter sbpf=SimpleBeanPropertyFilter.filterOutAllExcept("field3");
		return extracted(x, sbpf);
	};

	public static Function<List<FilterPojo>, MappingJacksonValue>filterlistFunction=x->{
		SimpleBeanPropertyFilter sbpf=SimpleBeanPropertyFilter.filterOutAllExcept("field1");
		return extracted(x, sbpf);
	};
	
	private static MappingJacksonValue extracted(Object x, SimpleBeanPropertyFilter sbpf) {
		MappingJacksonValue mjv=new MappingJacksonValue(x);
		SimpleFilterProvider fp=new SimpleFilterProvider();
		fp.addFilter("customerresponsefilter",sbpf);
		mjv.setFilters(fp);
		return mjv;
	}
}
