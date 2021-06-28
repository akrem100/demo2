package com.example.demo2;

import com.example.demo2.model.Categories;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;

import java.sql.Timestamp;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo2Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo2ApplicationTests {

  @Autowired
  private TestRestTemplate restTemplate;






  @Test
   void testDeletec() {
String c="http://localhost:8088/categories/ll/9";
    Categories categories = restTemplate.getForObject( c, Categories.class);
    assertNotNull(categories);

    restTemplate.delete( c );

    try {
      categories = restTemplate.getForObject( c , Categories.class);
    } catch (final HttpClientErrorException e) {
      assertEquals( HttpStatus.NOT_FOUND,e.getStatusCode());
    }
  }
  @Test
    void testGetcategorieseById() {

    Categories categories = restTemplate.getForObject( "http://localhost:8088/categories/ll/7", Categories.class);
    System.out.println(categories.getName());
    assertNotNull(categories);
  }
  @Test
    void testGetAllC() {
    HttpHeaders headers = new HttpHeaders();
    HttpEntity<String> entity = new HttpEntity<>(null, headers);

    ResponseEntity<String> response = restTemplate.exchange("http://localhost:8088/categories/ll/",
      HttpMethod.GET, entity, String.class);

    assertNotNull(response.getBody());
  }
  @Test
    void testCreateC() {
    Timestamp t=new Timestamp(System.currentTimeMillis());
    Categories categories = new Categories();
    categories.setName("NEWS");
    categories.setQuatite(5);
    categories.setDatec(t);

String g="http://localhost:8088";
    ResponseEntity<Categories> postResponse = restTemplate.postForEntity(g + "/categories/add", categories, Categories.class);
    assertNotNull(postResponse);
    assertNotNull(postResponse.getBody());
  }
  @Test
    void testUpdateC() {
    int id = 12;
    String a="http://localhost:8088/categories/edit/";
    Categories categories = restTemplate.getForObject(a + id, Categories.class);
    categories.setName("LG");
    categories.setQuatite(9);

    restTemplate.put( a + id, categories);

    Categories updatedc = restTemplate.getForObject( a + id, Categories.class);
    assertNotNull(updatedc);
  }

}
