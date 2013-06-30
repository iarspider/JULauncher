/**
 * Copyright 2013 by ATLauncher and Contributors
 *
 * ATLauncher is licensed under CC BY-NC-ND 3.0 which allows others you to
 * share this software with others as long as you credit us by linking to our
 * website at http://www.atlauncher.com. You also cannot modify the application
 * in any way or make commercial use of this software.
 *
 * Link to license: http://creativecommons.org/licenses/by-nc-nd/3.0/
 */
package com.atlauncher.data;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import com.atlauncher.gui.LauncherFrame;
import com.atlauncher.gui.Utils;

public class Account implements Serializable {

    private static final long serialVersionUID = 525763616120118176L;
    private String username; // Username/Email used to login to minecraft
    private transient String password; // Users password to login to minecraft
    private String encryptedPassword; // users encrypted password
    private String minecraftUsername; // Users Minecraft Username
    private boolean remember; // Remember the users password or not
    private transient boolean isReal; // If this is a real user

    public Account(String username, String password, String minecraftUsername, boolean remember) {
        this.username = username;
        if (remember) {
            this.password = password;
            this.encryptedPassword = Utils.encrypt(password);
        }
        this.minecraftUsername = minecraftUsername;
        this.remember = remember;
        this.isReal = true;
    }

    public Account(String name) {
        this.username = "";
        this.minecraftUsername = name;
        this.remember = false;
        this.isReal = false;
    }

    public ImageIcon getMinecraftHead() {
        File file;
        if (isReal()) {
            file = new File(LauncherFrame.settings.getSkinsDir(), minecraftUsername + ".png");
            if (!file.exists()) {
                new Downloader("http://s3.amazonaws.com/MinecraftSkins/" + minecraftUsername
                        + ".png", file.getAbsolutePath()).runNoReturn();
            }
        } else {
            file = new File(LauncherFrame.settings.getSkinsDir(), "default.png");
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BufferedImage main = image.getSubimage(8, 8, 8, 8);
        BufferedImage helmet = image.getSubimage(40, 8, 8, 8);
        BufferedImage head = new BufferedImage(8, 8, BufferedImage.TYPE_INT_ARGB);

        Graphics g = head.getGraphics();
        g.drawImage(main, 0, 0, null);
        g.drawImage(helmet, 0, 0, null);

        ImageIcon icon = new ImageIcon(head.getScaledInstance(32, 32, Image.SCALE_SMOOTH));

        return icon;
    }

    public ImageIcon getMinecraftSkin() {
        File file;
        if (this.username.isEmpty()) {
            file = new File(LauncherFrame.settings.getSkinsDir(), "default.png");
        } else {
            file = new File(LauncherFrame.settings.getSkinsDir(), minecraftUsername + ".png");
        }
        if (!file.exists()) {
            new Downloader("http://s3.amazonaws.com/MinecraftSkins/" + minecraftUsername + ".png",
                    file.getAbsolutePath()).runNoReturn();
        }

        BufferedImage image = null;
        try {
            image = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Head - 8,8,8,8 > 4,0
        // Hat (Overlay) - 40,8,8,8 > 4,0
        // Arm - 44,20,4,12 > 0,8 > 12,8
        // Body - 20,20,8,12 > 4,8
        // Legs - 4,20,4,12 > 4,20 > 8,20
        //
        // Total Size - 16,32

        BufferedImage head = image.getSubimage(8, 8, 8, 8);
        BufferedImage helmet = image.getSubimage(40, 8, 8, 8);
        BufferedImage arm = image.getSubimage(44, 20, 4, 12);
        BufferedImage body = image.getSubimage(20, 20, 8, 12);
        BufferedImage leg = image.getSubimage(4, 20, 4, 12);
        BufferedImage skin = new BufferedImage(16, 32, BufferedImage.TYPE_INT_ARGB);

        Graphics g = skin.getGraphics();
        g.drawImage(head, 4, 0, null);
        g.drawImage(helmet, 4, 0, null);
        g.drawImage(arm, 0, 8, null);
        g.drawImage(arm, 12, 8, null);
        g.drawImage(body, 4, 8, null);
        g.drawImage(leg, 4, 20, null);
        g.drawImage(leg, 8, 20, null);

        ImageIcon icon = new ImageIcon(skin.getScaledInstance(128, 256, Image.SCALE_SMOOTH));

        return icon;
    }

    public boolean isReal() {
        return this.isReal;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setMinecraftUsername(String username) {
        this.minecraftUsername = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
        this.encryptedPassword = Utils.encrypt(password);
    }

    public boolean isRemembered() {
        return this.remember;
    }

    public void setRemember(boolean remember) {
        this.remember = remember;
        if (!remember) {
            this.password = "";
            this.encryptedPassword = "";
        }
    }

    public String getMinecraftUsername() {
        return this.minecraftUsername;
    }

    private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
        s.defaultReadObject(); // Read the object in
        if (encryptedPassword == null) {
            password = ""; // No password saved so don't set it
            remember = false; // And make sure remember is set to false
        } else {
            password = Utils.decrypt(encryptedPassword); // Encrypted password found so decrypt it
        }
        isReal = true;
    }

    public String toString() {
        return this.minecraftUsername;
    }

}