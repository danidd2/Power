package Model.Archive;
import javax.persistence.*;
import java.math.BigInteger;
import Model.Calculator.Result;
import lombok.Builder;

@Entity
@Table(name = "Results")
public class Results
{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;

    private String Result;

    private String Base;

    private String Power;

    private String Modulo;

    public String getResult() {
        return Result;
    }

    public void setResult(String result) {
        Result = result;
    }

    public String getBase() {
        return Base;
    }

    public void setBase(String base) {
        Base = base;
    }

    public String getPower() {
        return Power;
    }

    public void setPower(String power) {
        Power = power;
    }

    public String getModulo() {
        return Modulo;
    }

    public void setModulo(String modulo) {
        Modulo = modulo;
    }

    public Results(Result result) {
        Result = String.valueOf(result.getDecimalForm());
        Base = String.valueOf(result.getBase().getDecimalForm());
        Power = String.valueOf(result.getPower().getDecimalForm());
        Modulo = String.valueOf(result.getModulo().getDecimalForm());
    }

    public Results() {
    }
}
