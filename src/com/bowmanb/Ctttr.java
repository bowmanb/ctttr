package com.bowmanb;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.fileEditor.impl.EditorWindow;
import com.intellij.openapi.util.Comparing;
import com.intellij.openapi.vfs.VirtualFile;

public class Ctttr extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent e) {
        final EditorWindow window = e.getData(EditorWindow.DATA_KEY);
        if (window != null) {
            VirtualFile selected = window.getSelectedFile();
            boolean tabHit = false;
            for (VirtualFile file : window.getFiles()) {
                if (tabHit) {
                    window.closeFile(file);
                } else if (Comparing.equal(selected, file)) {
                    tabHit = true;
                }
            }
        }
    }

}
