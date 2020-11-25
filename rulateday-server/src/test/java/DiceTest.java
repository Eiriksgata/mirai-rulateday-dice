import indi.eiriksgata.dice.callback.SanCheckCallback;
import indi.eiriksgata.dice.exception.DiceInstructException;
import indi.eiriksgata.dice.message.handle.InstructHandle;
import indi.eiriksgata.dice.operation.impl.SanCheckImpl;
import indi.eiriksgata.dice.vo.MessageData;
import indi.eiriksgata.rulateday.utlis.LoadDatabaseFile;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

/**
 * @author: create by Keith
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/10/12
 **/
public class DiceTest {

    @Test
    void test1() {
        LoadDatabaseFile.init();

    }


    @Test
    void stringFormatTest() {
        String result = MessageFormat.format("a:{0},b:{1}", 1, 2);
        System.out.println(result);
    }

    @Test
    void stringArrTest() {
        String[] test = {"123", "345"};
        System.out.println(test[1]);
    }


    @Test
    void instructTest() {

    }


    @Test
    void rollTest() {


    }


    @Test
    void setDiceFace() throws DiceInstructException, InvocationTargetException, InstantiationException, IllegalAccessException {
        MessageData messageData = new MessageData();
        messageData.setQqID(123456789L);


        InstructHandle instruct = new InstructHandle();

        messageData.setMessage(".set20");
        System.out.println(instruct.instructCheck(messageData));

        messageData.setMessage(".sc1d5/2d3");
        System.out.println(instruct.instructCheck(messageData));

        messageData.setMessage(".stsan50");
        System.out.println(instruct.instructCheck(messageData));
    }


    @Test
    void callbackTest() {

        for (int i = 0; i < 1000; i++) {
            System.out.println(new SanCheckImpl().sanCheck("1d5/1d100+5d4", "san30", new SanCheckCallback() {
                @Override
                public void getResultData(String attribute, int random, int sanValue, String calculationProcess, int surplus) {

                }
            }));
        }
    }

    @Test
    void rb() throws Exception {
        MessageData messageData = new MessageData();
        messageData.setQqID(123456789L);
        InstructHandle instruct = new InstructHandle();

        messageData.setMessage(".rp3 san 30");
        System.out.println(instruct.instructCheck(messageData));

    }

}
