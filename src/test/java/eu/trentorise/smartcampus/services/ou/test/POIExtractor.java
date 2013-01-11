/*******************************************************************************
 * Copyright 2012-2013 Trento RISE
 * 
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 * 
 *        http://www.apache.org/licenses/LICENSE-2.0
 * 
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 ******************************************************************************/
package eu.trentorise.smartcampus.services.ou.test;

import it.sayservice.platform.core.common.exception.ServiceException;
import it.sayservice.platform.servicebus.test.DataFlowTestHelper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.protobuf.Message;

import eu.trentorise.smartcampus.services.ou.data.message.Ou.Location;
import eu.trentorise.smartcampus.services.ou.impl.GetLocationsDataFlow;

public class POIExtractor {

	private final static String SERVICE = "eu.trentorise.smartcampus.services.ou.OperaUniService";
	private final static String SEP = ";";
	
	public static void main(String[] args) throws Exception {
		DataFlowTestHelper helper = new DataFlowTestHelper();
		Map<String, Object> out = helper.executeDataFlow(
				SERVICE, 
				"GetLocations", 
				new GetLocationsDataFlow(), 
				new HashMap<String, Object>());
		List<Location> data = (List<Location>) out.get("data");
		BufferedWriter writer = new BufferedWriter(new FileWriter("src/test/resources/sayCommandLoadPOIFromCSV_ou_poi.csv")); 
		if (data != null) {
			for (Location m : data) {
				String result = "";
				result += m.getLocalId()+"@"+SERVICE + SEP;// POIID
				result += "smart" + SEP; //DATASET
				result += SEP; //REFERTO
				result += m.getLat()+SEP;
				result += m.getLng()+SEP;
				result += "0" + SEP; //ALTITUDE
				result += "WGS84" + SEP; // SRSCODE 
				result += "ITA"+SEP; // COUNTRY
				result += "Italy"+SEP; // STATE
				result += "TN"+SEP; // REGION
				result += "Trento"+SEP; // CITY
				result += "38100"+SEP; //POSTALCODE
				result += m.getAddress()+SEP; // STREET
				result += "en"+SEP; // LANG
				result += "ou"; // TAGS
				writer.write(result);
				writer.write('\n');
			}
		}
		writer.flush();
		writer.close();
	}
}
