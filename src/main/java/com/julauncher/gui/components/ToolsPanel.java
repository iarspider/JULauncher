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

package com.julauncher.gui.components;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public final class ToolsPanel extends JPanel {
    /**
     * Auto generated serial.
     */
    private static final long serialVersionUID = 4409533883142880167L;

    public ToolsPanel() {
        super(new FlowLayout(FlowLayout.CENTER));
    }

    public ToolsPanel add(JButton button) {
        super.add(button);
        return this;
    }
}