import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class priceCalculatorTest {
    private PriceCalculator priceCalculator;

    @Before
    public void setUp() throws Exception {
        priceCalculator = new PriceCalculator();
    }

    @Test
    public void should_return_money_when_one_kilo(){
        assertEquals(6, priceCalculator.calculate(1, 0));
    }

    @Test
    public void should_return_7_when_wait_4_mins_within_2_km() {
        assertThat(7, equalTo(priceCalculator.calculate(2, 4)));
    }

    @Test
    public void should_round_when_price_is_not_int() {
        assertEquals(6, priceCalculator.round(6.1));
        assertEquals(7, priceCalculator.round(6.5));
    }

    @Test
    public void should_return_6_when_6_km_without_waiting() {
        assertEquals(9, priceCalculator.calculate(6, 0));
    }

    @Test
    public void should_return_11_when_8_km_without_waiting() {
        assertEquals(11, priceCalculator.calculate(8, 0));
    }

    @Test
    public void should_return_13_when_10_km_without_waiting(){
        assertEquals(13, priceCalculator.calculate(10, 0));

    }
    @Test
    public void should_return_14_when_10_km_with_waiting_4_mins(){
        assertEquals(14, priceCalculator.calculate(10, 4));

    }


}
