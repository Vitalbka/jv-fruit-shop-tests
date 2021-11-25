package core.basesyntax.service.impl;

import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.Parser;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ParserImplTest {
    private static Parser parser;
    private static int indexOfOperation;
    private static int indexOfFruitName;
    private static int indexOfAmount;

    @BeforeClass
    public static void beforeClass() {
        parser = new ParserImpl(new ValidatorCsvImpl());
        indexOfOperation = 0;
        indexOfFruitName = 1;
        indexOfAmount = 2;
    }

    @Test
    public void parseLine_ok() {
        String line = "b,banana,10";
        TransactionDto actual = parser.parseLine(line);
        TransactionDto expected = new TransactionDto("b", "banana", 10);
        Assert.assertEquals(expected.getFruitName(), actual.getFruitName());
    }

    @Test
    public void parseLine_notOk() {
        String line = "b,banana,1";
        TransactionDto actual = parser.parseLine(line);
        TransactionDto expected = new TransactionDto("b", "banana", 10);
        Assert.assertNotEquals(expected, actual);
    }
}
