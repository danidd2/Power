package Model.Calculator;

import lombok.extern.slf4j.Slf4j;

import java.math.BigInteger;

@Slf4j
public class Result
{
    private String BinaryForm;
    private BigInteger DecimalForm = BigInteger.ONE;
    private Element base;
    private Element power;
    private Element modulo;
    private BigInteger[] powers;

    public Result(Element base, Element power, Element modulo) {
        this.base = base;
        this.power = power;
        this.modulo = modulo;
        GeneratePowers();
        GenerateResult();
    }


    /**
     * Generates every power of the base between 1 and 2 on the power n, where n is the highest required
     * power based on the binary form
     */
    private void GeneratePowers()
    {
        powers = new BigInteger[power.getBinaryForm().length()];
        powers[0] = base.getDecimalForm();
        for (int i=1;i<power.getBinaryForm().length();i++)
        {
           powers[i] = (powers[i-1].multiply(powers[i-1])).mod(modulo.getDecimalForm());
        }
    }

    /**
     * Generates the result using the premade powers {@link #powers}. It will multiply the
     * the specific powers based on there location in the {@link #powers} array.
     * If the n-th element of the {@link #power} binary form is a 1 than the n-th element of the {@link #powers}
     * array will be added to the multiplication, this way generating the result of the exponentiation.
     * At the and we must do one more mod operation for the correct result.
     */
    private void GenerateResult()
    {
        for(int i=0;i<power.getBinaryForm().length();i++)
        {
            if (power.getBinaryForm().charAt(i) == '1')
            {
                DecimalForm = DecimalForm.multiply(powers[i]);
            }
        }
        DecimalForm = DecimalForm.mod(modulo.getDecimalForm());
        log.info("The result hase been made");
    }

    public String getBinaryForm() {
        return BinaryForm;
    }

    public void setBinaryForm(String binaryForm) {
        BinaryForm = binaryForm;
    }

    public BigInteger getDecimalForm() {
        return DecimalForm;
    }

    public void setDecimalForm(BigInteger decimalForm) {
        DecimalForm = decimalForm;
    }

    public Element getBase() {
        return base;
    }

    public void setBase(Element base) {
        this.base = base;
    }

    public Element getPower() {
        return power;
    }

    public void setPower(Element power) {
        this.power = power;
    }

    public Element getModulo() {
        return modulo;
    }

    public void setModulo(Element modulo) {
        this.modulo = modulo;
    }

    public BigInteger[] getPowers() {
        return powers;
    }

    public void setPowers(BigInteger[] powers) {
        this.powers = powers;
    }
}
