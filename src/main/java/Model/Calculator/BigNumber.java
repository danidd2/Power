package Model.Calculator;

import java.math.BigInteger;
import java.util.Random;

public class BigNumber implements SuperNumber
{
    BigInteger DecimalForm=BigInteger.ZERO;
    String BinaryForm="";
    byte[] Generator;

    public BigNumber()
    {
        Generate();
        ToDecimal();
        StringBuild();
    }

    /**
     * Generates a random array of bytes made out of ones and zeroes.
      */
    @Override
    public void Generate()
    {
        Generator = new byte[4096];
        Random rand = new Random();
        for (int i=0;i<1024;i++)
        {
            Generator[i] =(byte) rand.nextInt(2);
        }
    }

    /**
     * Converts the generated array in the {@link #Generate()}
     */
    @Override
    public void ToDecimal()
    {
        for (int i=0;i<4096;i++)
        {
            if (Generator[i] == 1)
            {
                BigInteger temp = BigInteger.TWO.pow(i);
                DecimalForm = DecimalForm.add(temp);
            }
        }
    }

    /**
     * Converts the array in {@link #Generator} to a string.
     * The string is saved in the {@link #BinaryForm} element.
     */
    public void StringBuild()
    {
        for (int i=0;i<4096;i++)
        {
            BinaryForm = Generator[i] + BinaryForm;
        }
    }

    public BigInteger getDecimalForm() {
        return DecimalForm;
    }

    public void setDecimalForm(BigInteger decimalForm) {
        DecimalForm = decimalForm;
    }

    public String getBinaryForm() {
        return BinaryForm;
    }

    public void setBinaryForm(String binaryForm) {
        BinaryForm = binaryForm;
    }

    public byte[] getGenerator() {
        return Generator;
    }

    public void setGenerator(byte[] generator) {
        Generator = generator;
    }

}
