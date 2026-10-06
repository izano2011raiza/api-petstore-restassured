package api_petstore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetUserTest extends BaseTest {

    @Test
    public void pegarUsuarioValido (){

        //Criando usuário
        String bodyUser = """
              {
              "id": 26,
              "username": "HeliPostTest",
              "firstName": "Heli",
              "lastName": "Bnog", 
              "email": "bnog.pst@test.com", 
              "password": "555848", 
              "phone": "222224584",
              "userStatus": 26
              }
               """;

        given()
                .spec(request())
                .body(bodyUser)
                .when()
                .post("/user")
                .then()
                .statusCode(200);

        //Pegando usuário
        given()
                .spec(request())
                .when()
                .get("/user/HeliPostTest")
                .then()
                .statusCode(200)
                .body("id", equalTo(26))
                .body("username", equalTo("HeliPostTest"))
                .body("firstName", equalTo("Heli"))
                .body("lastName", equalTo("Bnog"))
                .body("email", equalTo("bnog.pst@test.com"))
                .body("phone", equalTo("222224584"))
                .body("userStatus", equalTo(26));
    }

    @Test
    public void pegarUsuarioComUsernameInexistente (){
        given()
                .spec(request())
                .when()
                .get("/user/usuarioInexistente")
                .then()
                .statusCode(404)
                .body("code", equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("User not found"));
    }
}
