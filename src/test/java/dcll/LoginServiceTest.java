package dcll;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * @author Benjamin Saint-Sever.
 */
public class LoginServiceTest {


    @Test
    public void loginExists() throws Exception {
        //GIVEN


        LoginService logservice = new LoginService(new
                String[]{"Test0","Test1"});

        //WHEN

        boolean test0 = logservice.loginExists("Test0");
        boolean test1 = logservice.loginExists("Test1");
        boolean test2 = logservice.loginExists("Test2");

        //THEN

        assertTrue(test0 && test1 && (!test2));

    }

    @Test
    public void addLogin() throws Exception {

        //GIVEN
        LoginService log = new LoginService(new
                String[]{"loginTest"});



        //WHEN
        boolean logexist = log.loginExists("loginTest");

        //THEN
        assertTrue(logexist);

    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {

        //GIVEN
        final String pref = "log";

        LoginService log = new LoginService(new
                String[]{"log1","testlog","log2","Etudiant"});

        //WHEN
        List<String> listeATester = log.findAllLoginsStartingWith(pref);

        //THEN
        int nbtestReussi = 0;
        for (String s : listeATester) {
            if (s.startsWith(pref)) {
                nbtestReussi++;
            }

        }
        assertTrue(nbtestReussi == 2);


    }

    @Test
    public void findAllLogins() throws Exception {

        //GIVEN
        String[] listeLoginsExistant = new String[4];
        final String log1 = "log1";
        final String log2 = "testlog";
        final String log3 = "log2";
        final String log4 = "Etudiant";

        listeLoginsExistant[0] = log1;
        listeLoginsExistant[1] = log2;
        listeLoginsExistant[2] = log3;
        listeLoginsExistant[3] = log4;

        LoginService log = new LoginService(listeLoginsExistant);

        //WHEN
        List<String> listeATester = log.findAllLogins();


        //THEN
        boolean test1 = false;
        boolean test2 = false;
        boolean test3 = false;
        boolean test4 = false;

        for (String s : listeATester) {
            switch (s) {
                case log1:
                    test1 = true;
                    break;
                case log2:
                    test2 = true;
                    break;
                case log3:
                    test3 = true;
                    break;
                case log4:
                    test4 = true;
                    break;
                default:
                    assertTrue(false);
                    break;
            }

        }
        assertTrue(test1 && test2 && test3 && test4);

    }

}