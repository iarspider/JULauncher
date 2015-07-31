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

package com.julauncher.evnt.manager;

import com.julauncher.evnt.listener.ConsoleOpenListener;

import javax.swing.SwingUtilities;
import java.util.LinkedList;
import java.util.List;

public final class ConsoleOpenManager {
    private static final List<ConsoleOpenListener> listeners = new LinkedList<ConsoleOpenListener>();

    public static synchronized void addListener(ConsoleOpenListener listener) {
        listeners.add(listener);
    }

    public static synchronized void removeListener(ConsoleOpenListener listener) {
        listeners.remove(listener);
    }

    public static synchronized void post() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (ConsoleOpenListener listener : listeners) {
                    listener.onConsoleOpen();
                }
            }
        });
    }
}