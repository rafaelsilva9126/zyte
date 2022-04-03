package rs.rest.core;

import org.hamcrest.Matchers;
import org.junit.Before;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

public class BaseTest implements Constant  {

	@Before
	public  void setUp() {
		RestAssured.baseURI = APP_BASE_URL;
		RestAssured.basePath = APP_BASE_PATH;
	
		
		RequestSpecBuilder reqBuilder = new RequestSpecBuilder();
		reqBuilder.setContentType(APP_CONTENT_TYPE);
		RestAssured.requestSpecification = reqBuilder.build();
		
		ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
		resBuilder.expectResponseTime(Matchers.lessThan(MAX_TIMEOUT));
		RestAssured.responseSpecification = resBuilder.build();
		
		RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
		
		RestAssured.config=RestAssuredConfig.config().httpClient(HttpClientConfig.httpClientConfig().
		        setParam("http.connection.timeout",CONNECTION_TIMEOUT).
		        setParam("http.socket.timeout",SOCKET_TIMEOUT).
		        setParam("http.connection-manager.timeout",MANAGER_TIMEOUT));
	}
	
}
