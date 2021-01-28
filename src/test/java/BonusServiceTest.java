import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateRegisterAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        int amount = 1000_60;
        boolean registered = true;
        int expected = 30;
        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateRegisterAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        int amount = 26_000_60;
        boolean registered = true;
        int expected = 500;
        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateNotRegisterAndUnderLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        int amount = 1000_60;
        boolean registered = false;
        int expected = 10;
        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
    @Test
    void shouldCalculateNotRegisterAndOverLimit() {
        BonusService service = new BonusService();
        // подготавливаем данные:
        int amount = 26_000_60;
        boolean registered = false;
        int expected = 260;
        // вызываем целевой метод:
        int actual = service.calculate(amount, registered);
        assertEquals(expected, actual);
    }
}