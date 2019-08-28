package ru.stqa.training.selenium.tests.litecart;

import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.training.selenium.base.TestBase;
import ru.stqa.training.selenium.base.objects.LiteCartProduct;
import ru.stqa.training.selenium.pages.LiteCartPage;
import ru.stqa.training.selenium.pages.LiteCartSubcategoryPage;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckProductDetails extends TestBase {

    private LiteCartPage liteCartPage;
    private LiteCartSubcategoryPage liteCartSubcategoryPage;

    @BeforeMethod
    public void start() {
        openHomePage();
        liteCartPage = new LiteCartPage();
        liteCartSubcategoryPage = new LiteCartSubcategoryPage();
    }

    @Test
    public void CheckProductDetails() {

        //starting with 0
        int PRODUCT_INDEX = 0;
        LiteCartProduct productObjectFromHomePage = liteCartPage.getProductObjectFromHomePage("Campaigns", PRODUCT_INDEX);
        liteCartPage.clickOnItemInSectionByIndex("Campaigns", PRODUCT_INDEX);
        LiteCartProduct productObjectFromSubcategory = liteCartSubcategoryPage.getProductObjectFromSubcategoryPage();

        SoftAssertions.assertSoftly(softly -> {
            softly.assertThat(productObjectFromHomePage.getProductName().equals(productObjectFromSubcategory.getProductName()));
            softly.assertThat(productObjectFromHomePage.getProductPrice().equals(productObjectFromSubcategory.getProductPrice()));
            softly.assertThat(productObjectFromHomePage.getProductDiscountedPrice().equals(productObjectFromSubcategory.getProductDiscountedPrice()));

            softly.assertThat(isGrey(productObjectFromHomePage.getProductPriceColor()));
            softly.assertThat(productObjectFromHomePage.getProductPriceStrikethrough());
            softly.assertThat(productObjectFromHomePage.getProductDiscountedPriceBold());
            softly.assertThat(isRed(productObjectFromHomePage.getProductDiscountedPriceColor()));
            softly.assertThat(isFontLargerThan(productObjectFromHomePage.getProductDiscountedPriceSize(), productObjectFromHomePage.getProductPriceSize()));
        });
    }

    private boolean isGrey(String rgbaColorString) {
        Color rgbaColor = parse(rgbaColorString);
        return rgbaColor.getRed() == rgbaColor.getBlue() && rgbaColor.getRed() == rgbaColor.getGreen();
    }

    private boolean isRed(String rgbaColorString) {
        Color rgbaColor = parse(rgbaColorString);
        return rgbaColor.getGreen() == 0 && rgbaColor.getBlue() == 0;
    }

    private boolean isFontLargerThan(String firstFont, String secondFont) {
        return firstFont.compareTo(secondFont) > 0;
    }

    private static Color parse(String draftInput) {
        String input;
        if (draftInput.contains("rgb(")){
            input=draftInput.replaceAll("rgb\\(","rgba(");
            input=input.replaceAll("\\)",",1\\)");
        } else input=draftInput;
                Pattern c = Pattern.compile("rgba *\\( *([0-9]+), *([0-9]+), *([0-9]+), *([0-9]+) *\\)");
        Matcher m = c.matcher(input);

        if (m.matches()) {
            return new Color(Integer.valueOf(m.group(1)),  // r
                    Integer.valueOf(m.group(2)),  // g
                    Integer.valueOf(m.group(3)), // g
                    Integer.valueOf(m.group(4))); // b
        }
        return null;
    }
}
