/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package dev.navids.soottutorial;

import dev.navids.soottutorial.hellosoot.HelloSoot;
import org.junit.Test;
import soot.Body;
import soot.Scene;
import soot.SootClass;
import soot.SootMethod;
import soot.jimple.JimpleBody;

import java.io.File;

import static org.junit.Assert.*;

public class HelloSootTest {
    @Test public void testClassFilesExist() {
        File aClassFile = new File(HelloSoot.sourceDirectory+File.separator+ HelloSoot.clsName+".class");
        assertTrue(aClassFile.exists());
        File aJavaFile = new File(HelloSoot.sourceDirectory+File.separator+HelloSoot.clsName+".java");
        assertTrue(aJavaFile.exists());
    }

    @Test public void testMethodsExist() {
        HelloSoot.setupSoot();
        SootClass aClass = Scene.v().getSootClass(HelloSoot.clsName);
        assertFalse(aClass.isPhantom());
        SootMethod printFizzBuzzMethod = aClass.getMethodByName(HelloSoot.methodName);
        assertFalse(printFizzBuzzMethod.isPhantom());
        Body body = printFizzBuzzMethod.retrieveActiveBody();
        assertTrue(body instanceof JimpleBody);
    }
}
