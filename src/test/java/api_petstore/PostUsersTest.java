package api_petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostUsersTest extends BaseTest {

    @Test
    public void cadastrarListaDeUsuariosComSucesso() {
        String bodyUser = """
              [
              {
              "id": 76,
              "username": "Heli", 
              "firstName": "Cristhina", 
              "lastName": "Matos", 
              "email": "heli@test.com", 
              "password": "2905-0552", 
              "phone": "(91)2905-0552",
              "userStatus": 1
              },
                {
              "id": 77,
              "username": "Mariana", 
              "firstName": "Mari", 
              "lastName": "Amaral", 
              "email": "mari@test.com", 
              "password": "35605762", 
              "phone": "(91)3560-5762",
              "userStatus": 1
              },
                {
              "id": 78,
              "username": "Elias", 
              "firstName": "Emanuel", 
              "lastName": "Peixoto", 
              "email": "elias@test.com", 
              "password": "8612971", 
              "phone": "(61)8612-8971",
              "userStatus": 1
              },
                {
              "id": 79,
              "username": "Vanessa", 
              "firstName": "Luana", 
              "lastName": "Silva", 
              "email": "luana@test", 
              "password": "12451889", 
              "phone": "(23)8457-24615",
              "userStatus": 1
              },
                {
              "id": 80,
              "username": "Caleb", 
              "firstName": "Geraldo", 
              "lastName": "Nascimento", 
              "email": "gcaleb@test.com", 
              "password": "7846854", 
              "phone": "(87)4865-24583",
              "userStatus": 1
              },
                {
              "id": 81,
              "username": "Flávia", 
              "firstName": "Hadassa", 
              "lastName": "Mogno", 
              "email": "hmogno@test.com", 
              "password": "15145445", 
              "phone": "(31)165-54682",
              "userStatus": 1
              }
              ]
               """;

        given()
                .spec(request())
                .body(bodyUser)
                .when()
                .post("/user/createWithArray")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("ok"));
    }
}
