import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Interpreter
 * 
 * @param <T>
 */
public class Interpreter<T> {
    Conditions condition = new Conditions();
    Operations operations = new Operations<>();
    Predicados predicados = new Predicados<>();
    static DEFUN def_funciones = new DEFUN();
    static Variables variables = new Variables<>();
    Functions funciones = new Functions();
    SintaxScann ss = new SintaxScann();

    public void Interp(ArrayList<ArrayList<String>> lisp_code) {
        for (ArrayList<String> function : lisp_code) {
            int a = ss.Decide_action(function.get(0));
            switch (a) {
                case 1:
                    def_funciones.create(function);
                    break;
                case 2:
                    COND(function);
                    break;
                case 3:
                    SetQ(function);
                    break;
                case 4:
                    QUOTE(function.get(0));
                    break;
                case 5:
                    predicados.start(5, null, null);
                    break;
                case 6:
                    predicados.start(6, null, null);
                    break;
                case 7:
                    predicados.start(7, null, null);
                    break;
                case 8:
                    predicados.start(8, null, null);
                    break;
                case 9:
                    predicados.start(9, null, null);
                    break;
                case 10:
                    for (String tokens : function) {

                        if (containsOnlyNumbers(tokens)) {
                            evaluateOnlyNumbers(function.get(0));

                        } else {
                            evaluateWithVar(function.get(0), variables.getVariables());

                        }

                    }
                case 11:
                    def_funciones.used_SavedFunction("", null, null);
                    break;
                case 0:
                    System.out.println("Existe un error en el código");
                    break;

                default:
                    break;
            }
        }
    }

    public void Read_COND(ArrayList<String> aa) {
        condition.Read_COND(aa);
    }

    public void COND(ArrayList<String> ab) {
        condition.COND(ab);
    }

    public void getExpressions(String bb) {
        condition.getExpressions(bb);
    }

    public void evaluateOnlyNumbers(String c) {
        operations.evaluateOnlyNumbers(c);
    }

    public void evaluateWithVar(String aa, HashMap<String, Double> variables) {
        operations.evaluateWithVar(aa, variables);
    }

    public void SetQ(ArrayList<String> c) {
        variables.SetQ(c, " ", variables.getVariables());
    }

    public void QUOTE(String a) {
    }

    public boolean containsOnlyNumbers(String expressions) {

        Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");
        Matcher matcher = pattern.matcher(expressions);

        return matcher.find();
    }

}