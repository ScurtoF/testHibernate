package com.objis.demohibernate.test;

import com.objis.demohibernate.service.GestionnaireFormation;
import com.objis.demohibernate.simple.Formation;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class GestionnaireFormationTest extends TestCase {

    // Tester la création d'une Formation. Teste clé primaire retournée
    public void testCreerFormation() {
        Formation formation = new Formation( "EJB3" );
        GestionnaireFormation gestionnaire = new GestionnaireFormation();
        Long id = gestionnaire.creerFormation( formation );
        assertNotNull( id );
    }

    // Tester la recherche d'une Formation. Teste que l'objet retourné n'est pas
    // null
    public void testChercherFormationparTheme() {
        GestionnaireFormation gestionnaire = new GestionnaireFormation();
        Formation formation = gestionnaire.chercherFormationparTheme( "EJB3" );
        assertNotNull( formation );
    }

    // pour ordonner les 2 tests
    public GestionnaireFormationTest( String testName ) {
        super( testName );
    }

    public static junit.framework.Test suite() {
        TestSuite suite = new TestSuite( "Test GestionnaireFormation" );
        suite.addTest( new GestionnaireFormationTest( "testCreerFormation" ) );
        suite.addTest( new GestionnaireFormationTest( "testChercherFormationparTheme" ) );
        return suite;
    }
}
