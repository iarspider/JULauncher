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
package com.julauncher.data.json;

import com.julauncher.App;
import com.julauncher.annot.Json;
import com.julauncher.data.Downloadable;

import java.io.File;

@Json
public class LauncherLibrary {
    private String name;
    private String filename;
    private String url;
    private String version;
    private String md5;
    private boolean julauncherDownload;
    private boolean autoLoad;
    private boolean exitOnFail;

    public String getName() {
        return this.name;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getUrl() {
        return this.url;
    }

    public String getVersion() {
        return this.version;
    }

    public File getFile() {
        return new File(App.settings.getLauncherLibrariesDir(), this.filename);
    }

    public Downloadable getDownloadable() {
        return new Downloadable(this.url, new File(App.settings.getLauncherLibrariesDir(), this.filename), this.md5,
                null, this.julauncherDownload);
    }

    public String getMd5() {
        return this.md5;
    }

    public boolean isJULauncherDownload() {
        return this.julauncherDownload;
    }

    public boolean shouldAutoLoad() {
        return this.autoLoad;
    }

    public boolean shouldExitOnFail() {
        return this.exitOnFail;
    }
}
