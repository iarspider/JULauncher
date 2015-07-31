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

import com.julauncher.LogManager;
import com.julauncher.utils.Utils;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class BottomBar extends JPanel {
    private static final long serialVersionUID = -7488195680365431776L;

    protected final JButton nodeCraftIcon = new SMButton("/assets/image/NodeCraftIcon.png", "NodeCraft - Setup a " +
            "Minecraft server with an ATL modpack in less than 60 seconds");
    protected final JButton facebookIcon = new SMButton("/assets/image/FacebookIcon.png", "Facebook");
    protected final JButton githubIcon = new SMButton("/assets/image/GitHubIcon.png", "GitHub");
    protected final JButton twitterIcon = new SMButton("/assets/image/TwitterIcon.png", "Twitter");
    protected final JButton redditIcon = new SMButton("/assets/image/RedditIcon.png", "Reddit");

    protected final JPanel rightSide = new JPanel(new FlowLayout());

    public BottomBar() {
        super(new BorderLayout());
        this.setBorder(BorderFactory.createEtchedBorder());
        this.setPreferredSize(new Dimension(0, 50));
        this.add(this.rightSide, BorderLayout.EAST);
        this.setupSocialButtonListeners();
        this.rightSide.add(this.nodeCraftIcon);
        this.rightSide.add(this.facebookIcon);
        this.rightSide.add(this.githubIcon);
        this.rightSide.add(this.redditIcon);
        this.rightSide.add(this.twitterIcon);
    }

    private void setupSocialButtonListeners() {
        nodeCraftIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogManager.info("Opening Up NodeCraft");
                Utils.openBrowser("https://nodecraft.com/?ref=atl&utm_source=ATL&utm_medium=launcher");
            }
        });
        facebookIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogManager.info("Opening Up JULauncher Facebook Page");
                Utils.openBrowser("http://www.facebook.com/ATLauncher");
            }
        });
        githubIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogManager.info("Opening Up JULauncher GitHub Page");
                Utils.openBrowser("https://github.com/iarspider/JULauncher");
            }
        });
        redditIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogManager.info("Opening Up JULauncher Reddit Page");
                Utils.openBrowser("http://www.reddit.com/r/ATLauncher");
            }
        });
        twitterIcon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LogManager.info("Opening Up JULauncher Twitter Page");
                Utils.openBrowser("http://www.twitter.com/ATLauncher");
            }
        });
    }
}