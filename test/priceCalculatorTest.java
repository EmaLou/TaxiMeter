import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class priceCalculatorTest {
    @Test
    public void should_return_money_when_one_kilo(){
        PriceCalculator priceCalculator = new PriceCalculator();
        double price = priceCalculator.calculate(1);
        assertEquals(6.0, price);
    }
}
