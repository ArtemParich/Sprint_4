import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    public boolean checkNameToEmboss() {

        final Pattern pattern = Pattern.compile("^(?=.{3,19}$)([\\Sa-zA-Zа-яА-ЯеЁ]+)\\s{1}[a-zA-Zа-яА-ЯеЁ]+$", Pattern.DOTALL);
        final Matcher matcher = pattern.matcher(name);

        if (matcher.find())
            return true;
        else return false;

    }

}