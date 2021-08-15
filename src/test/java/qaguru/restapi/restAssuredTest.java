package qaguru.restapi;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;


import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.core.Is.is;

public class restAssuredTest {

    @Test
    public void makePurchase() {
        step("Get cookie by api and make a purchase", ( ) -> {
            String authorizationCookie =
                    given()
                            .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                            .body("product_attribute_72_5_18=53&product_attribute_72_6_19=54&product_attribute_72_3_20=57&product_attribute_72_8_30=94&addtocart_72.EnteredQuantity=1")
                            .cookie("Nop.customer=073dae87-eb25-49eb-b364-fb55db40ed47; __utma=78382081.959225197.1627915031.1627915031.1627915031.1; __utmc=78382081; __utmz=78382081.1627915031.1.1.utmcsr=google|utmccn=(organic)|utmcmd=organic|utmctr=(not%20provided); __utmt=1; __RequestVerificationToken=qFQ-xedEFpGrFSRsL01b95HsSgvuRKJH53fA4dHy0EqrAskzQgE2QUEZPq1_fVwdqn4na07HMKLT1c6X1KIEBcu1XNaD_mj2JfPsf_DiwPo1; NopCommerce.RecentlyViewedProducts=RecentlyViewedProductIds=72; __atuvc=1%7C31; __atuvs=6108035cd411cfa5000; __utmb=78382081.7.10.1627915031")
                            .when()
                            .post("http://demowebshop.tricentis.com/addproducttocart/details/72/1")
                            .then()
                            .statusCode(200)
                            .body("success", is(true))
                            .body("message", is("The product has been added to your <a href=\"/cart\">shopping cart</a>"))
                            .extract()
                            .cookie("Nop.customer");

            step("Open site", ( ) ->
                    open("http://demowebshop.tricentis.com/"));

            step("Set cookie to to browser", ( ) ->
                    getWebDriver().manage().addCookie(
                            new Cookie("Nop.customer", authorizationCookie)));
                    refresh();
            step("Verify successful purchase ", ( ) ->
                    $(".cart-qty").shouldHave(text("(9)")));
        });
    }
}
