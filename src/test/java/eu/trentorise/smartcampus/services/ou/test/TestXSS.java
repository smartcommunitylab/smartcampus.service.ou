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
