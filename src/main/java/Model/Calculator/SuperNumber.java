package Model.Calculator;

import java.math.BigInteger;

public interface SuperNumber
{
    byte[] Generator = null;
    BigInteger Decimal = BigInteger.ZERO;
    String BinaryForm = "";

    void Generate();
    void ToDecimal();
}
