import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {
        if (name != null) {
            String regex = "^(?=.{3,19}$)([\\Sa-zA-Zа-яА-ЯеЁ]+)\\s{1}[a-zA-Zа-яА-ЯеЁ]+$";
            final Pattern pattern = Pattern.compile(regex, Pattern.DOTALL);
            final Matcher matcher = pattern.matcher(name);

            return matcher.find();
        } else return false;
    }
}