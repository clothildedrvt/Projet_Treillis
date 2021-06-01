module treillis {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.base;

    opens fr.insa.drevet.projet.interfacejavafx to javafx.graphics;

    exports fr.insa.drevet.projet.interfacejavafx;
}
