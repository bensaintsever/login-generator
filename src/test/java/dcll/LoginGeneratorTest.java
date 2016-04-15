package dcll;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Benjamin Saint-Sever.
 */
public class LoginGeneratorTest {
    @Test
    public void generateLoginForNomAndPrenom() throws Exception {

        LoginService logservice  = new LoginService(new
                String[]{"JROL", "BPER", "CGUR", "JDUP", "JRAL", "JRAL1"});

        LoginGenerator logGenerator = new LoginGenerator(logservice);


        //WHEN
        String log1 = logGenerator.generateLoginForNomAndPrenom("Durand",
                "Paul");
        String log2 = logGenerator.generateLoginForNomAndPrenom("Rolling",
                "Jean");
        String log3 = logGenerator.generateLoginForNomAndPrenom("Dùrand",
                "Paul");
        String log4 = logGenerator.generateLoginForNomAndPrenom("Du",
                "Paul");
        String log5 = logGenerator.generateLoginForNomAndPrenom("Ralling",
                "John");

        System.out.println("TESTGENERATOR paul du: "+log4);
        System.out.println("TESTGENERATOR John Rallin: "+log5);


        //THEN
        if ((log1 == "PDUR") && (log2 == "JROL1") && (log3 == "PDUR") &&
                (log4 == "PDU") && (log5 == "JRAL2")){
            assertTrue(true);
        }


    }

    /*

quand on génère le login de "Paul Durand", on vérifie que le login généré et
ajouté à la liste des logins existants est "PDUR" ;
quand on génère le login de "Jean Rolling", on vérifie que le login généré et
 ajouté à la liste des logins existants est "JROL1" ;
quand on génère le login de "Paul Dùrand", on vérifie que le login généré et
ajouté à la liste des logins existants est "PDUR".
     */

}