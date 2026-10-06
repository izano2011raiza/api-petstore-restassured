package api_petstore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class GetUserLoginTest extends BaseTest{

    @Test
    public void fazerLoginDoUsuarioNoSistema(){

        //criar usuário
        String bodyUser = """
             
                  {
                    "id": 13,
                    "username": "Lucy",
                    "firstName": "Moreira",
                    "lastName": "Vasques",
                    "email": "lucy@test.com",
                    "password": "525252",
                    "phone": "222222222",
                    "userStatus": 13
                  }
               """;

        given()
                .spec(request())
                .body(bodyUser)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("13"));

        //Realizar ogin
        given()
                .spec(request())
                .queryParam("username", "Lucy")
                .queryParam("password", "525252")
                .when()
                .get("/user/login")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", matchesPattern("logged in user session:\\d+"));
    }
}
