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
        LoginService logservice;
        String[] loginsexistants = new String[2];

        loginsexistants = new String[2];
        loginsexistants[0] = "Test0";
        loginsexistants[0] = "Test1";

        //WHEN
        logservice = new LoginService(loginsexistants);
        boolean test0 = logservice.loginExists("Test0");
        boolean test1 = logservice.loginExists("Test1");
        boolean test2 = logservice.loginExists("Test2");

        //THEN

        assertTrue(test0 && test1 && (!test2));

    }

    @Test
    public void addLogin() throws Exception {

        //GIVEN
        String[] loginsexistants = new String[1];
        ArrayList<String> loginsExistants = new ArrayList<>();
        LoginService log = new LoginService(loginsexistants);


        final String login1 = "loginTest";

        //WHEN
        boolean logexist = log.loginExists(login1);

        //THEN
        assertTrue(logexist);

    }

    @Test
    public void findAllLoginsStartingWith() throws Exception {

        //GIVEN
        final String pref = "log";
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
        List<String> listeATester = log.findAllLoginsStartingWith(pref);

        //THEN

        for (String s : listeATester) {
            switch (s) {
                case log1:
                    assertTrue(true);
                    break;
                case log3:
                    assertTrue(true);
                    break;
                default:
                    assertTrue(false);
                    break;
            }

        }

        assertTrue(false);


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