/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.netbeans.modules.cpplite.debugger.test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import org.netbeans.modules.cpplite.debugger.CPPLiteDebugger;
import org.netbeans.modules.cpplite.debugger.CPPLiteDebuggerConfig;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Debug",
        id = "org.netbeans.modules.cpplite.debugger.test.TestDebug"
)
@ActionRegistration(
        displayName = "#CTL_TestDebug"
)
@ActionReference(path = "Menu/RunProject", position = 100)
@Messages("CTL_TestDebug=TestDebug")
public final class TestDebug implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            CPPLiteDebugger.startDebugging(new CPPLiteDebuggerConfig(Arrays.asList("/home/lahvac/src/nb/cpplite-debugger/debugger/test/unit/data/step-test/main")));
        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}
