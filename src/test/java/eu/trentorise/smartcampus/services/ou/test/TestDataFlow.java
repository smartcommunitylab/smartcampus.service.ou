package eu.trentorise.smartcampus.services.ou.test;

import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.servicebus.test.DataFlowTestHelper;

import java.util.HashMap;
import java.util.Map;

import eu.trentorise.smartcampus.services.ou.impl.GetLocationsDataFlow;

public class TestDataFlow {

	public static void main(String[] args) throws ServiceException {
		DataFlowTestHelper helper = new DataFlowTestHelper();
		Map<String, Object> out = helper.executeDataFlow(
				"eu.trentorise.smartcampus.services.ou.OperaUniService", 
				"GetLocations", 
				new GetLocationsDataFlow(), 
				new HashMap<String, Object>());
		System.err.println(out);
	}
}
