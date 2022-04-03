package rs.rest.test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers. *;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import rs.rest.core.BaseTest;


public class ZyteTest extends BaseTest {

	
	
	@Test
	public void mustinsertAnUser() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("name", "ssss");
		RestAssured.given()
		.log().all()
		.body(params)
		.when()
			.post("/profiles")
		.then()
			.log().all()
			.statusCode(201)
			.body("name", Matchers.is("ssss"));
		
	}
	
	@Test
	public void mustinsertPosts() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("title", "dwdwdwderfe");
		params.put("author", "author");
		RestAssured.given()
		.log().all()
		.body(params)
		.when()
			.post("/posts")
		.then()
			.log().all()
			.statusCode(201)	
			.body("title", Matchers.is("dwdwdwderfe"))
			.body("author", Matchers.is("author"));
		
	}
	
	@Test
	public void mustInsertComments() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("body", "dwdwdw");
		params.put("postId", 2);
		RestAssured.given()
		.log().all()
		.body(params)
		.when()
			.post("/comments")
		.then()
			.log().all()
			.statusCode(201)	
			.body("body", Matchers.is("dwdwdw"))
			.body("postId", Matchers.is(2));
		
	}
	
	@Test
	public void mustSeePostById() {
		RestAssured.given()
		.log().all()
		.when()
			.get("/posts?id=1")
		.then()
			.log().all()
			.statusCode(200)	
			.body("author", Matchers.hasItem("typicode"))
			.body("title", Matchers.hasItem("json-server"));
		
	}
	
	@Test
	public void mustSeeCommentsByPostId() {
		RestAssured.given()
		.log().all()
		.when()
			.get("/comments?postId=1")
		.then()
			.log().all()
			.statusCode(200)	
			.body("body", Matchers.hasItem("some comment"));
		
	}
	
	@Test
	public void mustSeeProfiles() {
		ArrayList<String> names = RestAssured.given()
		.log().all()
		.when()
			.get("/profiles")
		.then()
			.log().all()
			.statusCode(200)
			.extract().path("");
		Assert.assertThat(names, notNullValue());
		
		
	}

	@Test
	public void mustSeeInvalidRoute() {
		RestAssured.given()
		.log().all()
		.when()
			.get("/test")
		.then()
			.log().all()
			.statusCode(404);
		
	}

}	