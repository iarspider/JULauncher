/*
 * JULauncher - https://github.com/iarspider/JULauncher
 * Copyright (C) 2015 JULauncher
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.julauncher.gui.tabs;

import com.julauncher.data.Language;
import com.julauncher.gui.components.BlankToolPanel;
import com.julauncher.gui.components.LogClearerToolPanel;
import com.julauncher.gui.components.NetworkCheckerToolPanel;
import com.julauncher.gui.components.ServerCheckerToolPanel;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class ToolsTab extends JPanel implements Tab {
    private JPanel mainPanel;

    public ToolsTab() {
        setLayout(new BorderLayout());

        mainPanel = new JPanel();

        mainPanel.setLayout(new GridLayout(3, 2));

        mainPanel.add(new NetworkCheckerToolPanel());
        mainPanel.add(new ServerCheckerToolPanel());
        mainPanel.add(new LogClearerToolPanel());
        mainPanel.add(new BlankToolPanel());
        mainPanel.add(new BlankToolPanel());
        mainPanel.add(new BlankToolPanel());

        add(mainPanel, BorderLayout.CENTER);
    }

    @Override
    public String getTitle() {
        return Language.INSTANCE.localize("tabs.tools");
    }
}