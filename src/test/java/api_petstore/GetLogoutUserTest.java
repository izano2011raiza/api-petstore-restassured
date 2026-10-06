package api_petstore;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetLogoutUserTest extends BaseTest {

    @Test
    public void encerrarSessaoDoUsuarioAtualmenteConectado(){
        given()
                .spec(request())
                .when()
                .get("/user/logout")
                .then()
                .statusCode(200)
                .body("code", equalTo(200))
                .body("message", equalTo("ok"));
    }
}
