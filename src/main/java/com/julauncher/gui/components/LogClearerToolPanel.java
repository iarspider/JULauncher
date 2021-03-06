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

import com.julauncher.App;
import com.julauncher.data.Language;
import com.julauncher.utils.HTMLUtils;
import com.julauncher.utils.Utils;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogClearerToolPanel extends AbstractToolPanel implements ActionListener {
    /**
     * Auto generated serial.
     */
    private static final long serialVersionUID = 1964636496849129267L;

    private final JLabel TITLE_LABEL = new JLabel(Language.INSTANCE.localize("tools.logclearer"));

    private final JLabel INFO_LABEL = new JLabel(HTMLUtils.centerParagraph(Utils.splitMultilinedString(Language
            .INSTANCE.localize("tools.logclearer.info"), 60, "<br>")));

    public LogClearerToolPanel() {
        TITLE_LABEL.setFont(BOLD_FONT);
        TOP_PANEL.add(TITLE_LABEL);
        MIDDLE_PANEL.add(INFO_LABEL);
        BOTTOM_PANEL.add(LAUNCH_BUTTON);
        LAUNCH_BUTTON.addActionListener(this);
        setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == LAUNCH_BUTTON) {
            App.settings.clearAllLogs();
        }
    }
}