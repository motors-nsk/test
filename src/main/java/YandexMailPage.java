import org.openqa.selenium.By;

import java.net.MalformedURLException;

/**
 *
 */
public class YandexMailPage extends BasePage {

    YandexMailPage() {
        driver.get("https://mail.yandex.ru");
    }

    YandexLoginPage login() {
        driver.findElement(By.xpath("//span[text()=\"Войти в Яндекс.Почту\"]")).click();
        return new YandexLoginPage();
    }

    YandexMailPage writeMail(String to, String theme) {
        return this;
    }

    void close() {
        driver.quit();
    }

    public static void main(String[] args) throws InterruptedException, MalformedURLException {

        driver.findElement(By.xpath("//span[@class=\"mail-ComposeButton-Text\"]")).click();

        driver.findElement(By.xpath(
                "//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/div[1]/label/div[3]/div"))
                .sendKeys("alexanderk@adjuggler.ru");

        driver.findElement(By.xpath(
                "//*[@id=\"nb-1\"]/body/div[2]/div[4]/div/div[2]/div[3]/div[2]/div[5]/div/div[1]/div[2]/div[1]/div/label/div[3]/input"))
                .sendKeys("test automation mail");

        driver.findElement(By.xpath("//*[@id=\"cke_1_contents\"]/textarea")).sendKeys("test message");

        driver.findElement(By.xpath("//span[text()=\"Отправить\"]")).click();

        driver.findElement(By.xpath("//div[text()=\"Письмо отправлено.\"]")).getText();

        driver.findElement(By.xpath("//a[@data-click-action=\"mailbox.check\"]")).click();

        driver.findElement(By.xpath(
                "//div[@class=\"ns-view-container-desc mail-MessagesList js-messages-list mail-MessagesList_height_small\"]/div[1]//span[@class=\"_nb-checkbox-flag _nb-checkbox-normal-flag\"]"))
                .click();

        driver.findElement(By.xpath("//span[text()=\"Удалить\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.id("nb-6")).click();

        driver.findElement(By.xpath("//span[text()=\"Папки и метки\"]")).click();

        driver.findElement(By.xpath("//span[text()=\"По алфавиту\"]")).click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()=\"По количеству писем\"]")).click();

        Thread.sleep(2000);


    }
}
