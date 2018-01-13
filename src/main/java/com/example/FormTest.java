package com.example;



import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.databene.benerator.anno.Source;
import org.databene.feed4testng.FeedTest;
import org.testng.annotations.Test;

import junit.framework.Assert;



public class FormTest extends FeedTest {

	@Test(dataProvider="feeder")
	@Source("./data/add.csv")
	
	public static void doGet( String a,String b, String expected) throws Exception{
		CloseableHttpClient client = HttpClients.createDefault();
	
		HttpGet request =  new HttpGet("http://192.168.178.129:8080/demo/FormServlet?a=" + a + "&b=" + b);
		CloseableHttpResponse response = client.execute(request);
		HttpEntity responseEntity = response.getEntity();
		String actual = 	EntityUtils.toString(responseEntity);
		System.out.println(actual);
	
		Assert.assertEquals(actual, expected);
	}

}
