package eu.trentorise.smartcampus.services.ou.test;

import it.sayservice.platform.servicebus.test.XSSTestHelper;
import it.sayservice.xss.api.data.XSSData;

import java.io.FileReader;
import java.nio.charset.Charset;



public class TestXSS {

	public static void main(String[] args) throws Exception {

		XSSTestHelper helper = new XSSTestHelper();
		
		XSSData data = helper.processXHTMLFromHTTP("http://www.operauni.tn.it/cms-01.00/articolo.asp?IDcms=8581&s=39&l=IT", new FileReader("src/main/resources/service/ou/locations.xml"), "CP1252");
		String d1 = new String(data.toString().getBytes(),Charset.forName("UTF-8"));
		System.err.println(d1);
		
		
//		XSSData data = helper.processXHTMLFromHTTP("http://www.operauni.tn.it/cms-01.00/articolo.asp?idcms=361&s=39",  new FileReader(
//				"src/main/resources/service/ou/detail.xml"),"UTF-8");
//		System.err.println(data);

	}
}

//http://www.operauni.tn.it/cms-01.00/articolo.asp?idcms=123&s=39
