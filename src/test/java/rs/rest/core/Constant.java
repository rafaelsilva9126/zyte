package rs.rest.core;

import io.restassured.http.ContentType;

public interface Constant {

	String APP_BASE_URL = "http://localhost:3000/";
	String APP_BASE_PATH = "";

	
	ContentType APP_CONTENT_TYPE = ContentType.JSON;
	
	Long MAX_TIMEOUT = 10000L;
	Integer CONNECTION_TIMEOUT = 10000;
	Integer SOCKET_TIMEOUT = 10000;
	Integer MANAGER_TIMEOUT = 10000;
	
}
