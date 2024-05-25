package Tests;

import Pages.magento;
import Utils.baseClass;
import org.testng.annotations.Test;

public class proceedToCheckout extends baseClass{
@Test
    public void ProceedToCheckout() throws InterruptedException{
    magento magento = new magento(driver);

    magento.getTextValue("KQF70K8");
}

}
