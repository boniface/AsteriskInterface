/*
 * AgiApp.java
 */
package me.dayler.ai.agi;

/**
 *
 */
public interface AgiApp {

    String getName();

    public void run(AgiVars vars, AgiCmdExec cmd) throws Exception;
}
