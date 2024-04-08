package www.other;

import org.BitwiseOperation;
import org.junit.Test;

public class BitwiseOperationTest {

    @Test
    public void test_rightSymbol() {
        System.out.println(BitwiseOperation.rightSymbol(-10, 1));
        System.out.println(BitwiseOperation.rightSymbol(10, 1));
        System.out.println(BitwiseOperation.rightSymbol(10, 2));
        System.out.println(BitwiseOperation.right(-10, 1));
    }

    @Test
    public void test_left() {
        System.out.println(BitwiseOperation.left(-10, 1));
        System.out.println(BitwiseOperation.left(10, 1));
        System.out.println(BitwiseOperation.left(10, 2));
    }
}
