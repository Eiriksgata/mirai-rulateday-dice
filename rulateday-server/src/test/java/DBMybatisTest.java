
import indi.eiriksgata.rulateday.mapper.CrazyOverDescribeMapper;
import indi.eiriksgata.rulateday.mapper.SpeakersGroupListMapper;
import indi.eiriksgata.rulateday.pojo.CrazyOverDescribe;
import indi.eiriksgata.rulateday.pojo.UserInitiativeData;
import indi.eiriksgata.rulateday.service.impl.UserInitiativeServerImpl;
import indi.eiriksgata.rulateday.utlis.LoadDatabaseFile;
import indi.eiriksgata.rulateday.utlis.MyBatisUtil;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.List;


/**
 * @author: create by Keith
 * @version: v1.0
 * @description: PACKAGE_NAME
 * @date:2020/10/20
 **/
public class DBMybatisTest {

    @Test
    void dbTest() {
        CrazyOverDescribeMapper mapper = MyBatisUtil.getSqlSession().getMapper(CrazyOverDescribeMapper.class);
        List<CrazyOverDescribe> list = mapper.selectAll();

        list.forEach((temp) -> {
            System.out.println(temp.getDescribe());
        });

    }


    @Test
    void dnd5eSkill() {
        SpeakersGroupListMapper mapper = MyBatisUtil.getSqlSession().getMapper(SpeakersGroupListMapper.class);
        mapper.createTable();
        MyBatisUtil.getSqlSession().commit();

    }

    @Test
    void create() {


    }

    @Test
    void file() throws IOException {

        LoadDatabaseFile.createDatabaseFile();


    }

    @Test
    void testInitiativeListShow() {
        System.out.println(
                new UserInitiativeServerImpl().showInitiativeList("1000")

        );

    }


}
