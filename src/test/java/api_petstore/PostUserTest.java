package api_petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostUserTest extends BaseTest {

    @Test
    public void cadastrarUsuarioComSucesso(){
        String bodyUser = """
                  {
                    "id": 12,
                    "username": "Luna",
                    "firstName": "Moreira",
                    "lastName": "Vasques",
                    "email": "luna@test.com",
                    "password": "654321",
                    "phone": "40028922",
                    "userStatus": 12
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
               .body("message", equalTo("12"));
    }

    @Test
    public void cadastrarUsuarioComBodyInvalido(){
        String bodyUser = """ 
                {
                 "id": 0, 
                 "username":
                  } 
                """;

        given()
                .spec(request())
                .body(bodyUser)
                .when()
                .post("/user")
                .then()
                .statusCode(400)
                .body("code", equalTo(400))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("bad input"));
    }

    @Test
    public void cadastrarUsuarioComBodyVazio(){
        String bodyUser = "{}";

        given()
                .spec(request())
                .body(bodyUser)
                .when()
                .post("/user")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("0"));
    }

    @Test
    public void cadastrarUsuarioComDadosInvalidos(){
        String bodyUser = """
              {
              "id": 1,
              "username": "", 
              "firstName": "", 
              "lastName": "", 
              "email": "email-invalido", 
              "password": "", 
              "phone": "",
              "userStatus": 1
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
                .body("message", equalTo("1"));
    }
}
