import org.junit.Test;
import java.util.ArrayList;
import org.junit.Assert;

public class BooleanActions_test {
    ArrayList<String> lispCode;
    Conditions cond = new Conditions();

    public BooleanActions_test() {
        lispCode = new ArrayList<>();
        lispCode.add("(cond");
        lispCode.add("((> 3 10) 'x es mayor que 10')");
        lispCode.add("((= 8 5) 'x es igual a 5')");
        lispCode.add("((< 1 0) 'x es menor que 0')");
        lispCode.add("(t 'x es mayor o igual a 0, pero menor o igual que 10'))");
    }

    @Test
    public void Conditions_testing() {
        cond.COND(lispCode);
    }
}
