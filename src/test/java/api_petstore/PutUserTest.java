package api_petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutUserTest extends BaseTest {
    @Test
    public void atualizarUsuarioComSucesso(){

        //Criar usuário
        String bodyInitialUser = """
              {
              "id": 999,
              "username": "UserPutTest",
              "firstName": "Maria", 
              "lastName": "Test", 
              "email": "usuario.put@test.com", 
              "password": "20222023", 
              "phone": "400215463",
              "userStatus": 9
              }
               """;

                given()
                        .spec(request())
                .body(bodyInitialUser)
                .when()
                .post("/user")
                .then()
                .statusCode(200);

                //Atualizar usuário
        String bodyUpdateUser = """
              {
              "id": 999,
              "username": "UserPutTest",
              "firstName": "MariaAtualizada", 
              "lastName": "TestAtualizado", 
              "email": "usuario.atualizado@test.com", 
              "password": "891011", 
              "phone": "999999999",
              "userStatus": 9
              }
               """;

                given()
                        .spec(request())
                        .body(bodyUpdateUser)
                        .when()
                        .put("/user/UserPutTest")
                        .then()
                        .statusCode(200)
                        .body("code", equalTo(200))
                        .body("type", equalTo("unknown"))
                        .body("message", equalTo("999"));

                //Consultar usuário depois da atualização
                            given()
                                    .spec(request())
                                    .when()
                                    .get("/user/UserPutTest")
                                    .then()
                                    .statusCode(200)
                        .body("id", equalTo(999))
                        .body("username", equalTo("UserPutTest"))
                        .body("firstName", equalTo("MariaAtualizada"))
                        .body("lastName", equalTo("TestAtualizado"))
                        .body("email", equalTo("usuario.atualizado@test.com"))
                        .body("phone", equalTo("999999999"))
                        .body("userStatus", equalTo(9));
    }
}
