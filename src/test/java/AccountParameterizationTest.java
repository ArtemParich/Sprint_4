import org.junit.Test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AccountParameterizationTest {
    public final String name;
    boolean expected;

    public AccountParameterizationTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    @Parameterized.Parameters (name = " \"{0}\" - {1}")
    public static Object[][] getName() {

        return new Object[][]{
                {null, false}, //null
                {"", false}, // 0 символов
                {"А", false}, // 1 символ
                {"АП", false}, // 2 символа
                {"а т", true}, // 3 символа
                {"Тё м", true}, // 4 символа
                {"тёма Парич", true}, // 10 символов
                {"Иващенко Корннелий", true}, //18 символов
                {"Агафонов Зигмундров", true}, //19 символов
                {"Калашников Ростислав", false}, //20 символов
                {"Федоренко Брониславец", false}, //21 символов
                {"Оченьдлинноеимячеловека Идлинннаяфамилия", false}, //40 символов
                {"АртемПарич", false}, // без пробела
                {"Иван Николаевич Иванов", false}, // 2 пробела
                {" ПрохорЖук", false}, // пробел в начале
                {"ФедорЕрмаков ", false}, // пробел в конце

        };
    }

    @Test
    public void canPrintNameTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        assertEquals("Ошибка в обработке имени: " + name, expected, actual);
    }
}
