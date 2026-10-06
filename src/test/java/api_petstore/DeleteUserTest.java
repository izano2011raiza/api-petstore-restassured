package api_petstore;

import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeleteUserTest extends BaseTest{

    @Test
    public void deletarUsuarioExistente(){

        //Criar usuário
        String bodyUser = """
             
                  {
                    "id": 14,
                    "username": "Maju",
                    "firstName": "BF",
                    "lastName": "BF",
                    "email": "maju@test.com",
                    "password": "141414",
                    "phone": "444444444",
                    "userStatus": 14
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
                .body("message", equalTo("14"));

        //Excluir usuário
        given()
                .spec(request())
                .when()
                .delete("/user/Maju")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("type", equalTo("unknown"))
                .body("message", equalTo("Maju"));

       //Validar que o usuário foi excluído
        given()
                .spec(request())
                .when()
                .get("/user/Maju")
                .then()
                .statusCode(404)
                .body("code",equalTo(1))
                .body("type", equalTo("error"))
                .body("message", equalTo("User not found"));
    }

    @Test
    public void deletarUsuarioInexistente() {
        given()
                .when()
                .spec(request())
                .delete("/user/inexistente")
                .then()
                .statusCode(404);
    }
}
