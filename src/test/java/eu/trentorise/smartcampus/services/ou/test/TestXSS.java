package eu.trentorise.smartcampus.services.ou.test;

import it.sayservice.platform.servicebus.test.XSSTestHelper;
import it.sayservice.xss.api.data.XSSData;

import java.io.FileReader;

public class TestXSS {

	public static void main(String[] args) throws Exception {

		XSSTestHelper helper = new XSSTestHelper();
		XSSData 
		data = helper.processXHTMLFromHTTP("http://www.operauni.tn.it/cms-01.00/articolo.asp?IDcms=8581&s=39&l=IT", new FileReader(
				"src/main/resources/service/ou/locations.xml"));
		System.err.println(data);
		
//		data = helper.processXHTMLFromHTTP("http://www.operauni.tn.it/cms-01.00/articolo.asp?idcms=353&s=39",  new FileReader(
//				"src/main/resources/service/ou/detail.xml"));
//		System.err.println(data);

	}
}
