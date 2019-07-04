package com.objis.demohibernate;

import com.objis.demohibernate.service.GestionnaireFormation;
import com.objis.demohibernate.simple.Formation;
import com.objis.demohibernate.test.GestionnaireFormationTest;

public class DemoHibernate {

    public static void main( String[] args ) {

        // 1 : instanciation objet couche service
        GestionnaireFormation serviceGestionnaire = new GestionnaireFormation();

        // 2 : Instanciation Objet couche métier
        Formation formation = new Formation( "Hibernate" );

        // 3 : Utilisation du service
        serviceGestionnaire.creerFormation( formation );

        GestionnaireFormationTest test = new GestionnaireFormationTest( "Hibernate" );
        test.testChercherFormationparTheme();
    }

}
