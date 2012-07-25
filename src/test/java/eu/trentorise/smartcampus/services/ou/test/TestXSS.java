package eu.trentorise.smartcampus.services.ou.test;

import it.sayservice.platform.servicebus.test.XSSTestHelper;
import it.sayservice.xss.api.data.XSSData;

import java.io.FileReader;

public class TestXSS {

	public static void main(String[] args) throws Exception {

		XSSTestHelper helper = new XSSTestHelper();
		XSSData data = helper.processXHTMLFromReader(new FileReader(
				"src/test/resources/locations.html"), new FileReader(
				"src/main/resources/service/ou/locations.xml"));
		System.err.println(data);
		
//		data = helper.processXHTMLFromReader(new FileReader(
//				"src/test/resources/detail.html"), new FileReader(
//				"src/main/resources/service/ou/detail.xml"));
//		System.err.println(data);

	}
}
