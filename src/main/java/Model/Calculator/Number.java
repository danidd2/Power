package Model.Calculator;

import java.math.BigInteger;

public interface Number
{
    public BigInteger DecimalForm=BigInteger.valueOf(0);
    public String BinaryForm = "";

     String toBinary(BigInteger number);
}
