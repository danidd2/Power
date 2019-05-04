package Model.Calculator;

import java.math.BigInteger;

public class Element implements Number{
    private String BinaryForm="";
    private BigInteger DecimalForm;

    public Element(String number)
    {
        DecimalForm = new BigInteger(number);
        BinaryForm = toBinary(DecimalForm);
    }

    /**
     * Converts a BigInteger to it`s reversed binary form
     * @param number This parameter is the value to be converted
     * @return Returns the binary form in a string
     */
    @Override
    public String toBinary(BigInteger number)
    {
        String ret="";
        BigInteger temp;

        while (!number.equals(BigInteger.ZERO))
        {
            temp = number.mod(BigInteger.valueOf(2));
            number = number.divide(BigInteger.TWO);
            ret =ret + temp;
        }
        return ret;
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
}
